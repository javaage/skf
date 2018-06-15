package com.skf.alarm.service;

import java.util.List;
import java.util.Map;

import com.skf.alarm.model.AlarmCount;
import com.skf.alarm.model.AlarmDetailRequest;
import com.skf.alarm.model.AlarmQueryRequest;
import com.skf.alarm.model.AlarmRequest;
import com.skf.alarm.model.DropDownList;

/**
 * @author P0088589
 *
 */
public interface AlarmService {

	List<AlarmCount> getAlarmCounts(String userCode);

	DropDownList getDropDownList(String userCode);

	Map<String, Object> getAlarms(AlarmQueryRequest request);

	Map<String, Object> getAlarmDetail(AlarmDetailRequest request);

	Map<String, Object> getFreqData(AlarmRequest request);

	void updateAlarmStatus(String componentCode, int alarmType, int status);

	void removeAlarm(String componentCode, int alarmType);

}
