package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.GearModelMapper;
import com.skf.management.model.GearModel;
import com.skf.management.service.GearService;

@Service
public class GearServiceImpl implements GearService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSession sqlSession;
	
	@Override
	public List<GearModel> list() {
		GearModelMapper gearModelMapper =sqlSession.getMapper(GearModelMapper.class);
		return gearModelMapper.selectByExample(null);
	}

	@Override
	public void add(GearModel model) {
		GearModelMapper gearModelMapper =sqlSession.getMapper(GearModelMapper.class);
		gearModelMapper.insert(model);
	}

	@Override
	public GearModel getGearByCode(String code) {
		GearModelMapper gearModelMapper =sqlSession.getMapper(GearModelMapper.class);
		return gearModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(GearModel model) {
		GearModelMapper gearModelMapper =sqlSession.getMapper(GearModelMapper.class);
		gearModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		GearModelMapper gearModelMapper =sqlSession.getMapper(GearModelMapper.class);
		gearModelMapper.deleteByPrimaryKey(code);
	}

}
