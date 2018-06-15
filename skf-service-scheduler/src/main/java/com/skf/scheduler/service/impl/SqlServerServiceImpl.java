package com.skf.scheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.scheduler.entity.SqlServerRequestData;
import com.skf.scheduler.mapper.sqlserver.SqlServerMapper;
import com.skf.scheduler.service.SqlServerService;

/**
 * @author P0088589
 *
 */
@Service
public class SqlServerServiceImpl implements SqlServerService {

	@Autowired
	private SqlServerMapper sqlserver;

	@Override
	public List<String> getSqlserverDBs() {
		return sqlserver.getSchemas();
	}

	@Override
	public int checkPermission(String schema) {
		return sqlserver.getCountMeasurementTable(schema);
	}

	@Override
	public List<SqlServerRequestData> getSqlserverRequestData(String schema, int sign) {
		return sqlserver.getRequestDatas(schema, sign);
	}

	@Override
	public Float getFreqRotation(String schema, int idNode) {
		return sqlserver.getFreqRotation(schema, idNode);
	}

}
