package com.skf.alarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skf.alarm.entity.AlarmComment;
import com.skf.alarm.model.AlarmCommentModel;

/**
 * @author P0088589
 *
 */
@Mapper
public interface AlarmCommentMapper {

	List<AlarmCommentModel> list(@Param("componentCode") String componentCode, @Param("alarmType") int alarmType);

	void save(@Param("comment") AlarmComment comment);

	void delete(@Param("componentCode") String componentCode, @Param("alarmType") int alarmType);

}
