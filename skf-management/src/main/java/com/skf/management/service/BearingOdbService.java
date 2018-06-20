package com.skf.management.service;

import java.util.List;

import com.skf.management.model.DboBearingModel;

public interface BearingOdbService {
	List<DboBearingModel> list(String modelNumber);
	
}
