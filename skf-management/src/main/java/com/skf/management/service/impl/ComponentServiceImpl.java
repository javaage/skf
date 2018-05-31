package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.ComponentModelMapper;
import com.skf.management.model.ComponentModel;
import com.skf.management.model.ComponentModelExample;
import com.skf.management.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ComponentModel> list() {
		ComponentModelMapper componentModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		return componentModelMapper.selectByExample(null);
	}

	@Override
	public void add(ComponentModel model) {
		ComponentModelMapper componentModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		componentModelMapper.insert(model);
	}

	@Override
	public ComponentModel getComponentByCode(String code) {
		ComponentModelMapper componentModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		return componentModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(ComponentModel model) {
		ComponentModelMapper componentModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		componentModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		ComponentModelMapper componentModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		componentModelMapper.deleteByPrimaryKey(code);
	}

	@Override
	public List<ComponentModel> listByOwner(String code) {
		ComponentModelMapper customerModelMapper =sqlSession.getMapper(ComponentModelMapper.class);
		ComponentModelExample example = new ComponentModelExample();
		ComponentModelExample.Criteria criteria = example.createCriteria();
		criteria.andSensorCodeEqualTo(code);
		return customerModelMapper.selectByExample(example);
	}

	@Override
	public void deleteByOwner(String code) {
		List<ComponentModel> listComponentModel = listByOwner(code);
		for(ComponentModel componentModel : listComponentModel){
			delete(componentModel.getCode());
		}
		
	}

}
