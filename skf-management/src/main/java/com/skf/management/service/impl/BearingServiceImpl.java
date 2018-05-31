package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.BearingModelMapper;
import com.skf.management.model.BearingModel;
import com.skf.management.service.BearingService;

@Service
public class BearingServiceImpl implements BearingService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BearingModel> list() {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		return bearingModelMapper.selectByExample(null);
	}

	@Override
	public void add(BearingModel model) {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		bearingModelMapper.insert(model);
	}

	@Override
	public BearingModel getBearingByCode(String code) {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		return bearingModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(BearingModel model) {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		bearingModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		bearingModelMapper.deleteByPrimaryKey(code);
	}

}
