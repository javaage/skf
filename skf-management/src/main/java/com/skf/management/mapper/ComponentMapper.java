package com.skf.management.mapper;

import java.util.List;
import java.util.Map;

import com.skf.management.join.ComponentJoin;

public interface ComponentMapper {

	List<ComponentJoin> getComponentScoreByOwerID(Map map);
	
	ComponentJoin getComponentScoreByID(Map map);
}