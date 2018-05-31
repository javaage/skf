package com.skf.management.service;

import java.util.List;

import com.skf.management.entity.SearchEquipment;
import com.skf.management.model.EquipmentModel;

public interface EquipmentService {
	List<EquipmentModel> list();

	List<EquipmentModel> listByOwner(String code);	
	
	List<EquipmentModel> listByTypeCode(String code);	
	
	void add(EquipmentModel model);

	EquipmentModel getEquipmentByCode(String code);

	void update(EquipmentModel model);

	void delete(String code);
	
	List<EquipmentModel> search(SearchEquipment searchEquipment);
	
	void deleteByOwner(String code);
	
	void deleteByTypeCode(String code);
}
