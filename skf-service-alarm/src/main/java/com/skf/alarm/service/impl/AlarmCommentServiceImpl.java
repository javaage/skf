package com.skf.alarm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.alarm.entity.AlarmComment;
import com.skf.alarm.mapper.AlarmCommentMapper;
import com.skf.alarm.model.AlarmCommentModel;
import com.skf.alarm.service.AlarmCommentService;

/**
 * @author P0088589
 *
 */
@Service
public class AlarmCommentServiceImpl implements AlarmCommentService {

	@Autowired
	private AlarmCommentMapper mapper;

	@Override
	public List<AlarmCommentModel> list(String componentCode, int alarmType) {
		return mapper.list(componentCode, alarmType);
	}

	@Override
	public void save(String userCode, String componentCode, int alarmType, String comments, int type) {
		AlarmComment comment = new AlarmComment();
		comment.setComponentCode(componentCode);
		comment.setAlarmType(alarmType);
		comment.setComment(comments);
		comment.setTime(new Date());
		comment.setType(type);
		comment.setUserCode(userCode);
		mapper.save(comment);
	}

	@Override
	public void remove(String componentCode, int alarmType) {
		mapper.delete(componentCode, alarmType);
	}

}
