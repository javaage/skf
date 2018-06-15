package com.skf.management.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skf.management.model.GearModel;
import com.skf.management.model.GearModelExample;

public interface GearMapper {

	/**
	 * list page
	 * @param example
	 * @return
	 */
	List<Object> listPage(Map<String,Integer> map);
	
	/**
	 * list page count
	 * @param example
	 * @return
	 */
	int listPageCount();
}