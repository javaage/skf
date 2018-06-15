package com.skf.management.service;

import java.util.List;

import com.skf.management.model.NodeModelWithBLOBs;

public interface NodeService {
	List<Integer> getLeafNodes(String schema);
	
	List<String> getNodeDatabase();
}
