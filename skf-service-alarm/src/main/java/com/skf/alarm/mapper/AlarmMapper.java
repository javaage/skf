package com.skf.alarm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skf.alarm.model.Alarm;
import com.skf.alarm.model.AlarmDetailRequest;
import com.skf.alarm.model.AlarmPoint;
import com.skf.alarm.model.AlarmQueryRequest;
import com.skf.alarm.model.Node;

/**
 * @author P0088589
 *
 */
@Mapper
public interface AlarmMapper {

	int getAlarmCount(@Param("param") AlarmQueryRequest param);

	List<Node> getDevice(@Param("userCode") String userCode);

	List<Alarm> getAlarms(@Param("param") AlarmQueryRequest param);

	String getSchema(@Param("componentCode") String componentCode);

	int getCountAlarmPoint(@Param("schemaName") String schema, @Param("param") AlarmDetailRequest param);

	List<AlarmPoint> getTrendPoints(@Param("schemaName") String schema, @Param("freq") int freq,
			@Param("param") AlarmDetailRequest param);

	List<AlarmPoint> getALarmPoint(@Param("componentCode") String componentCode);

	List<AlarmPoint> getFreqData(@Param("schemaName") String schema, @Param("time") Date measDate,
			@Param("componentCode") String componentCode);

	void updateAlarmStatus(@Param("componentCode") String componentCode, @Param("alarmType") int alarmType,
			@Param("status") int status);

	void deleteAlarm(@Param("componentCode") String componentCode, @Param("alarmType") int alarmType);
}
