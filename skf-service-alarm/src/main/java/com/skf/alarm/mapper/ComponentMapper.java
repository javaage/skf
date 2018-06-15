package com.skf.alarm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author P0088589
 *
 */
@Mapper
public interface ComponentMapper {

	void updateDangerLevel(@Param("componentCode") String componentCode, @Param("dangerLevel") float dangerLevel,
			@Param("totalValue") float totalValue);

}
