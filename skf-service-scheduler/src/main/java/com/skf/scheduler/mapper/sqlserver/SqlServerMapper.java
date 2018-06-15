package com.skf.scheduler.mapper.sqlserver;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skf.scheduler.entity.SqlServerRequestData;

@Mapper
public interface SqlServerMapper {

	List<String> getSchemas();

	int getCountMeasurementTable(@Param("schema") String schema);

	List<SqlServerRequestData> getRequestDatas(@Param("schema") String schema,
			@Param("idMeasurement") int idMeasurement);

	Float getFreqRotation(@Param("schema") String schema, @Param("idNode") int idNode);

}
