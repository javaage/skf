package com.skf.management.sqlservermapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skf.management.model.NodeElement;

public interface NodeMapper {
	
	public List<Integer> getLeafNodes(Map map);
	
	public List<String> getDatabases();
	
	public int getNodeCount(Map map);
	
	public NodeElement getNodeNameTree(@Param("idNode") int idNode, @Param("schema") String schema);
	
	public Float getNodeValue(@Param("idNode") int idNode, @Param("schema") String schema);
}