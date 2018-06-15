package com.skf.management.service;

import java.util.List;

import com.skf.management.entity.Page;
import com.skf.management.model.BearingModel;

public interface BearingService {
	List<BearingModel> list();
	
	Page listPage(int currentPage);

	void add(BearingModel model);

	BearingModel getBearingByCode(String code);

	void update(BearingModel model);

	void delete(String code);
	
	List<BearingModel> listModel(String modelNumber);
}
