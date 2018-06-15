package com.skf.scheduler.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.scheduler.common.Constant;
import com.skf.scheduler.entity.Alarm;
import com.skf.scheduler.entity.MysqlRequestData;
import com.skf.scheduler.entity.ResponseData;
import com.skf.scheduler.entity.Score;
import com.skf.scheduler.entity.SqlServerRequestData;
import com.skf.scheduler.mapper.mysql.MysqlMapper;
import com.skf.scheduler.service.MysqlService;

/**
 * @author P0088589
 *
 */
@Service
public class MysqlServiceImpl implements MysqlService {

	private static Logger log = LoggerFactory.getLogger(MysqlServiceImpl.class);

	@Autowired
	private MysqlMapper mysql;

	@Override
	public List<String> getMysqlDBs() {
		return mysql.getSchemas();
	}

	@Override
	public void mysqlCreateSchema(String schema) {
		mysql.createSchema(schema);
		mysql.createAlarmOriginalTable(schema);
		mysql.initSign(schema);
	}

	@Override
	public int getScanSign(String schema) {
		return mysql.getScanSign(schema);
	}

	@Override
	public void updateSign(String schema, int sign) {
		mysql.updateSign(schema, sign);
	}

	@Override
	public List<MysqlRequestData> getRequestDatas(String schema, int idNode) {
		return mysql.getRequestDatas(schema, idNode);
	}

	@Override
	public void saveAlarm(ResponseData responseData, MysqlRequestData msrequest, SqlServerRequestData ssrequest) {
		try {
			if (responseData != null) {
				responseData.setBpType(getBPType(responseData.getDefectFreqOrder(), msrequest.getBpfi(),
						msrequest.getBpfo(), msrequest.getBsf()));
				Score score = new Score();
				score.setComponentCode(msrequest.getComponentCode());
				score.setTime(ssrequest.getMeasDate());
				score.setScore(responseData.getScore());
				score.setClas(responseData.getClas());
				score.setTotalValue(responseData.getBearingTotalValue());
				score.setDangerLevel(msrequest.getDangerLevel());
				score.setBpType(responseData.getBpType());
				mysql.updateScore(score);
				if (responseData.getIfBearingTotalValueAlarm() == 1) {
					Alarm bearingAlarm = mysql.getAlarm(msrequest.getComponentCode(), Constant.ALARM_TYPE_BEARING);
					if (bearingAlarm == null) {
						bearingAlarm = new Alarm();
						bearingAlarm.setComponentCode(msrequest.getComponentCode());
						bearingAlarm.setAlarmType(Constant.ALARM_TYPE_BEARING);
						bearingAlarm.setAlarmTime(ssrequest.getMeasDate());
						bearingAlarm.setStatus(Constant.ALARM_STATUS_UNPROCESSED);
						bearingAlarm.setTotalValue(responseData.getBearingTotalValue());
						bearingAlarm.setDangerLevel(msrequest.getDangerLevel());
						bearingAlarm.setScore(responseData.getScore());
						bearingAlarm.setClas(responseData.getClas());
						bearingAlarm.setDefectFreqOrder(responseData.getDefectFreqOrder());
						bearingAlarm.setBpType(responseData.getBpType());
						mysql.saveAlarm(bearingAlarm);
					} else {
						if (bearingAlarm.getStatus() == Constant.ALARM_STATUS_PROCESSED) {
							bearingAlarm.setStatus(Constant.ALARM_STATUS_UNPROCESSED);
							bearingAlarm.setAlarmTime(ssrequest.getMeasDate());
							bearingAlarm.setTotalValue(responseData.getBearingTotalValue());
							bearingAlarm.setDangerLevel(msrequest.getDangerLevel());
							bearingAlarm.setScore(responseData.getScore());
							bearingAlarm.setClas(responseData.getClas());
							bearingAlarm.setDefectFreqOrder(responseData.getDefectFreqOrder());
							bearingAlarm.setBpType(responseData.getBpType());
							mysql.updateAlarm(bearingAlarm);
						} else if (responseData.getScore() < bearingAlarm.getScore()) {
							bearingAlarm.setAlarmTime(ssrequest.getMeasDate());
							bearingAlarm.setTotalValue(responseData.getBearingTotalValue());
							bearingAlarm.setDangerLevel(msrequest.getDangerLevel());
							bearingAlarm.setScore(responseData.getScore());
							bearingAlarm.setClas(responseData.getClas());
							bearingAlarm.setDefectFreqOrder(responseData.getDefectFreqOrder());
							bearingAlarm.setBpType(responseData.getBpType());
							mysql.updateAlarm(bearingAlarm);
						}
					}
				}
			}
			mysql.saveOriginalAlarm(ssrequest, msrequest, responseData);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	private String getBPType(float defectFreqOrder, float bpfi, float bpfo, float bsf) {
		float mbpfi = defectFreqOrder > bpfi ? defectFreqOrder - bpfi : bpfi - defectFreqOrder;
		float mbpfo = defectFreqOrder > bpfo ? defectFreqOrder - bpfo : bpfo - defectFreqOrder;
		float mbsf = defectFreqOrder > bsf ? defectFreqOrder - bsf : bsf - defectFreqOrder;
		if (mbpfi <= mbpfo && mbpfi <= mbsf) {
			return Constant.BP_TYPE_BPFI;
		} else if (mbpfo <= mbpfi && mbpfo <= mbsf) {
			return Constant.BP_TYPE_BPFO;
		} else if (mbsf <= mbpfi && mbsf <= mbpfo) {
			return Constant.BP_TYPE_BSF;
		}
		return Constant.BP_TYPE_BPFI;
	}

}
