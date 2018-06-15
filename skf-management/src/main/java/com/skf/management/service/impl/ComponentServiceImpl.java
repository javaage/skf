package com.skf.management.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.join.ComponentJoin;
import com.skf.management.mapper.ComponentMapper;
import com.skf.management.mapper.ComponentModelMapper;
import com.skf.management.model.ComponentModel;
import com.skf.management.model.ComponentModelExample;
import com.skf.management.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;
	
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

	@Override
	public List<ComponentJoin> getComponentScoreByOwerID(String sensorCode) {
		ComponentMapper customerMapper =sqlSession.getMapper(ComponentMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("sensorCode", sensorCode);
		return customerMapper.getComponentScoreByOwerID(map);
	}

	@Override
	public ComponentJoin getComponentScoreByID(String componentCode) {
		ComponentMapper customerMapper =sqlSession.getMapper(ComponentMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("componentCode", componentCode);
		return customerMapper.getComponentScoreByID(map);
	}

}
