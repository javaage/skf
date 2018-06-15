package com.skf.scheduler.mapper.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skf.scheduler.entity.Alarm;
import com.skf.scheduler.entity.MysqlRequestData;
import com.skf.scheduler.entity.ResponseData;
import com.skf.scheduler.entity.Score;
import com.skf.scheduler.entity.SqlServerRequestData;

/**
 * 
 * @author P0088589
 *
 */
@Mapper
public interface MysqlMapper {

	List<String> getSchemas();

	List<String> getTables(@Param("schema") String schema);

	void createSchema(@Param("schema") String schema);

	void createAlarmOriginalTable(@Param("schema") String schema);

	int getScanSign(@Param("schema") String schema);

	void initSign(@Param("schema") String schema);

	void updateSign(@Param("schema") String schema, @Param("sign") int sign);

	List<MysqlRequestData> getRequestDatas(@Param("schema") String schema, @Param("idNode") int idNode);

	void saveOriginalAlarm(@Param("ssreq") SqlServerRequestData ssreq, @Param("msreq") MysqlRequestData msreq,
			@Param("resp") ResponseData resp);

	Alarm getAlarm(@Param("componentCode") String componentCode, @Param("alarmType") int alarmType);

	void updateAlarm(@Param("alarm")Alarm alarm);

	void saveAlarm(@Param("alarm")Alarm alarm);
	
	void updateScore(@Param("score")Score score);
}
