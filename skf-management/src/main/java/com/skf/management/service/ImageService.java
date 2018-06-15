package com.skf.management.service;

import java.util.List;

import com.skf.management.model.ImageModel;

public interface ImageService {
	List<ImageModel> list();

	List<ImageModel> listWithBLOBs();
	
	List<ImageModel> listByType(Integer type);
	
	void add(ImageModel model);

	ImageModel getImageByCode(String code);

	void update(ImageModel model);
	
	void updateWithBLOBs(ImageModel model);

	void delete(String code);
}
