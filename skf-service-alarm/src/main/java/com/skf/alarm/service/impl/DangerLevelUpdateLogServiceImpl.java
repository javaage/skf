package com.skf.alarm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.alarm.entity.DangerLevelUpdateLog;
import com.skf.alarm.mapper.DangerLevelUpdateLogMapper;
import com.skf.alarm.service.DangerLevelUpdateLogService;

/**
 * @author P0088589
 *
 */
@Service
public class DangerLevelUpdateLogServiceImpl implements DangerLevelUpdateLogService {

	@Autowired
	private DangerLevelUpdateLogMapper mapper;

	@Override
	public void Save(String componentCode, float dangerLevel, float totalValueDangerLevel, String userCode) {
		DangerLevelUpdateLog log = new DangerLevelUpdateLog();
		log.setComponentCode(componentCode);
		log.setDangerLevel(dangerLevel);
		log.setTotalValueDangerLevel(totalValueDangerLevel);
		log.setUserCode(userCode);
		mapper.save(log);
	}

}
