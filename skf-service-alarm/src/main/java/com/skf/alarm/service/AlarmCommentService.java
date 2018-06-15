package com.skf.alarm.service;

import java.util.List;

import com.skf.alarm.model.AlarmCommentModel;

/**
 * @author P0088589
 *
 */
public interface AlarmCommentService {

	List<AlarmCommentModel> list(String componentCode, int alarmType);

	void save(String userCode, String componentCode, int alarmType, String comments, int type);
	
	void remove(String componentCode, int alarmType);

}
