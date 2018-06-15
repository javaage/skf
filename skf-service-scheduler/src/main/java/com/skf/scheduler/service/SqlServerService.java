package com.skf.scheduler.service;

import java.util.List;

import com.skf.scheduler.entity.SqlServerRequestData;

/**
 * @author P0088589
 *
 */
public interface SqlServerService {

	List<String> getSqlserverDBs();
	
	int checkPermission(String schema);

	List<SqlServerRequestData> getSqlserverRequestData(String schema, int sign);
	
	Float getFreqRotation(String schema, int idNode);

}
