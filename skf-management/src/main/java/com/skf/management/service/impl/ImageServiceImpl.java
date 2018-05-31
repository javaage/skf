package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.ImageModelMapper;
import com.skf.management.model.ImageModel;
import com.skf.management.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ImageModel> list() {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		return imageModelMapper.selectByExample(null);
	}

	@Override
	public void add(ImageModel model) {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		imageModelMapper.insert(model);
	}

	@Override
	public ImageModel getImageByCode(String code) {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		return imageModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(ImageModel model) {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		imageModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		imageModelMapper.deleteByPrimaryKey(code);
	}

	@Override
	public List<ImageModel> listWithBLOBs() {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		return imageModelMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public void updateWithBLOBs(ImageModel model) {
		ImageModelMapper imageModelMapper =sqlSession.getMapper(ImageModelMapper.class);
		imageModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}

}
