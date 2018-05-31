package com.skf.management.service;

import java.util.List;

import com.skf.management.model.GearModel;

public interface GearService {
	List<GearModel> list();

	void add(GearModel model);

	GearModel getGearByCode(String code);

	void update(GearModel model);

	void delete(String code);
}
