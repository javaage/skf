package com.skf.management.service;

import java.util.List;

import com.skf.management.model.BearingModel;

public interface BearingService {
	List<BearingModel> list();

	void add(BearingModel model);

	BearingModel getBearingByCode(String code);

	void update(BearingModel model);

	void delete(String code);
}
