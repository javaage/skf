package com.skf.management.service;

import java.util.List;

import com.skf.management.join.OEMJoin;
import com.skf.management.model.OEMModel;

public interface OEMService {
	List<OEMModel> list();
	
	List<OEMModel> listWithBLOBs();
	
	List<OEMJoin> listTree();

	List<OEMJoin> listTree(List<String> oemList, List<String> cstmList);
	
	void add(OEMModel model);

	OEMModel getOEMByCode(String code);

	void update(OEMModel model);
	
	void updateWithBLOBs(OEMModel model);

	void delete(String code);
}
