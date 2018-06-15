package com.skf.management.mapper;

import java.util.List;
import java.util.Map;

public interface BearingMapper {

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