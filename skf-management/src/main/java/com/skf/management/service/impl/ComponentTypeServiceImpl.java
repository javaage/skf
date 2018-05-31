package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.ComponentTypeModelMapper;
import com.skf.management.model.ComponentTypeModel;
import com.skf.management.service.ComponentTypeService;

@Service
public class ComponentTypeServiceImpl implements ComponentTypeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ComponentTypeModel> list() {
		ComponentTypeModelMapper componentTypeModelMapper =sqlSession.getMapper(ComponentTypeModelMapper.class);
		return componentTypeModelMapper.selectByExample(null);
	}

	@Override
	public void add(ComponentTypeModel model) {
		ComponentTypeModelMapper componentTypeModelMapper =sqlSession.getMapper(ComponentTypeModelMapper.class);
		componentTypeModelMapper.insert(model);
	}

	@Override
	public ComponentTypeModel getComponentTypeByCode(int id) {
		ComponentTypeModelMapper componentTypeModelMapper =sqlSession.getMapper(ComponentTypeModelMapper.class);
		return componentTypeModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(ComponentTypeModel model) {
		ComponentTypeModelMapper componentTypeModelMapper =sqlSession.getMapper(ComponentTypeModelMapper.class);
		componentTypeModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(int id) {
		ComponentTypeModelMapper componentTypeModelMapper =sqlSession.getMapper(ComponentTypeModelMapper.class);
		componentTypeModelMapper.deleteByPrimaryKey(id);
	}

}
