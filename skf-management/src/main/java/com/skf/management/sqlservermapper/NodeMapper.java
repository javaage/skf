package com.skf.management.sqlservermapper;

import java.util.List;

public interface NodeMapper {
	
	public List<Integer> getLeafNodes(String schemaName);
	
}