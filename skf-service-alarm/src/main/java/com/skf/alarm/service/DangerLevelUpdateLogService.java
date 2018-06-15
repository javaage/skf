package com.skf.alarm.service;

/**
 * @author P0088589
 *
 */
public interface DangerLevelUpdateLogService {

	void Save(String componentCode, float dangerLevel, float totalValueDangerLevel, String userCode);

}
