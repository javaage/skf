package com.skf.scheduler.service;

import java.util.List;

import com.skf.scheduler.entity.MysqlRequestData;
import com.skf.scheduler.entity.ResponseData;
import com.skf.scheduler.entity.SqlServerRequestData;

/**
 * @author P0088589
 *
 */
public interface MysqlService {

	List<String> getMysqlDBs();

	void mysqlCreateSchema(String schema);

	int getScanSign(String schema);

	void updateSign(String schema, int sign);

	List<MysqlRequestData> getRequestDatas(String schema, int idNode);

	void saveAlarm(ResponseData responseData, MysqlRequestData msrequest, SqlServerRequestData ssrequest);

}
