package com.skf.management.sqlservermapper;

import java.util.List;
import java.util.Map;

public interface NodeMapper {
	
	public List<Integer> getLeafNodes(Map map);
	
	public List<String> getDatabases();
	
	public int getNodeCount(Map map);
	
}