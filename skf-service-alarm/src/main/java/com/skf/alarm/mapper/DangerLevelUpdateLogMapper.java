package com.skf.alarm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skf.alarm.entity.DangerLevelUpdateLog;

/**
 * @author P0088589
 *
 */
@Mapper
public interface DangerLevelUpdateLogMapper {

	void save(@Param("log") DangerLevelUpdateLog log);

}
