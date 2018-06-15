package com.skf.scheduler.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.skf.scheduler.common.Constant;
import com.skf.scheduler.entity.MysqlRequestData;
import com.skf.scheduler.entity.ResponseData;
import com.skf.scheduler.entity.SqlServerRequestData;
import com.skf.scheduler.service.MysqlService;
import com.skf.scheduler.service.SqlServerService;
import com.skf.scheduler.util.HttpUtil;

@Component
public class Jobs {

	private static Logger log = LoggerFactory.getLogger(Jobs.class);

	@Value("${pythonServerURL}")
	private String pythonServerURL;
	@Autowired
	private MysqlService mysqlService;
	@Autowired
	private SqlServerService sqlServerService;
	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	private boolean isinitialized = false;
	private Queue<SqlServerRequestData> requestQueue = null;
	private Map<String, ScheduledFuture<?>> futures = null;

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(Constant.TASK_SCHEDULER_CORE_POOL_SIZE);
		threadPoolTaskScheduler.initialize();
		isinitialized = true;
		requestQueue = new ConcurrentLinkedQueue<SqlServerRequestData>();
		futures = new HashMap<String, ScheduledFuture<?>>();
		createQueueListener();
		return threadPoolTaskScheduler;
	}

	@Scheduled(fixedDelay = Constant.DATABASE_FIXED_DELAY)
	public void databaseScan() {
		log.debug("databaseScan start!");
		if (Constant.STOP_FLAG) {
			for (String sc : futures.keySet()) {
				futures.get(sc).cancel(true);
				futures.remove(sc);
			}
			log.debug("databaseScan end!");
			return;
		}
		if (!isinitialized) {
			threadPoolTaskScheduler();
		}
		List<String> sqlserverDBs = sqlServerService.getSqlserverDBs();
		List<String> mysqlDBs = mysqlService.getMysqlDBs();

		if (!CollectionUtils.isEmpty(sqlserverDBs)) {
			for (String schema : sqlserverDBs) {
				try {
					if (sqlServerService.checkPermission(schema) > 0) {
						if (!mysqlDBs.contains(Constant.PRE_SCHEMA + schema.toLowerCase())) {
							mysqlService.mysqlCreateSchema(Constant.PRE_SCHEMA + schema);
							createDatabaseListener(schema);
						} else {
							if (!futures.containsKey(schema)) {
								createDatabaseListener(schema);
							}
						}
					}
				} catch (Exception e) {
					log.debug("schema: " + schema + " : " + e.getMessage());
				}
			}
		}
		log.debug("databaseScan end!");
	}

	// 创建监听数据库任务
	private void createDatabaseListener(String schema) {
		futures.put(schema, threadPoolTaskScheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				if (!Constant.STOP_FLAG) {
					List<SqlServerRequestData> requests = sqlServerService.getSqlserverRequestData(schema,
							mysqlService.getScanSign(Constant.PRE_SCHEMA + schema));
					if (!CollectionUtils.isEmpty(requests)) {
						requestQueue.addAll(requests);
						mysqlService.updateSign(Constant.PRE_SCHEMA + schema,
								requests.get(requests.size() - 1).getIdMeasurement());
					}
				}
			}
		}, Constant.ALARM_FIXED_DELAY));
	}

	// 创建监听Queue线程
	private void createQueueListener() {
		for (int i = 0; i < 50; i++) {
			threadPoolTaskScheduler.createThread(new Runnable() {
				@Override
				public void run() {
					while (!Constant.STOP_FLAG || !requestQueue.isEmpty()) {
						if (!requestQueue.isEmpty()) {
							SqlServerRequestData ssrequest = requestQueue.poll();
							if (ssrequest != null) {
								List<MysqlRequestData> msrequests = mysqlService.getRequestDatas(ssrequest.getSchema(),
										ssrequest.getIdNode());
								if (!CollectionUtils.isEmpty(msrequests)) {
									for (MysqlRequestData msrequest : msrequests) {
										try {
											if (Constant.ROTATION_SPEED_TYPE_SQLSERVER == msrequest
													.getFreqRotationType()) {
												msrequest.setFreqRotation(sqlServerService
														.getFreqRotation(msrequest.getSchema(), msrequest.getIdNode()));
											}
											ResponseData response = HttpUtil.jsonPost(pythonServerURL, msrequest,
													ssrequest);
											mysqlService.saveAlarm(response, msrequest, ssrequest);
										} catch (Exception e) {
											log.debug(ssrequest.toString());
											log.debug(msrequest.toString());
											log.debug(e.getMessage());
										}
									}
								}
							}
						}
						try {
							// 防止CPU占满
							Thread.sleep(1);
						} catch (InterruptedException e) {
							log.debug(e.getMessage());
						}
					}
				}
			}).start();
		}
	}

}
