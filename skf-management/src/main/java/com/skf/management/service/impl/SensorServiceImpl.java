package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.SensorModelMapper;
import com.skf.management.model.SensorModel;
import com.skf.management.model.SensorModelExample;
import com.skf.management.service.ComponentService;
import com.skf.management.service.SensorService;

@Service
public class SensorServiceImpl implements SensorService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ComponentService componentService;
	
	@Override
	public List<SensorModel> list() {
		SensorModelMapper sensorModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		return sensorModelMapper.selectByExample(null);
	}

	@Override
	public void add(SensorModel model) {
		SensorModelMapper sensorModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		sensorModelMapper.insert(model);
	}

	@Override
	public SensorModel getSensorByCode(String code) {
		SensorModelMapper sensorModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		return sensorModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(SensorModel model) {
		SensorModelMapper sensorModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		sensorModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public List<SensorModel> listByOwner(String code) {
		SensorModelMapper customerModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		SensorModelExample example = new SensorModelExample();
		SensorModelExample.Criteria criteria = example.createCriteria();
		criteria.andEquipmentCodeEqualTo(code);
		return customerModelMapper.selectByExample(example);
	}
	
	@Override
	public void deleteByOwner(String code) {
		List<SensorModel> listSensorModel = listByOwner(code);
		for(SensorModel sensorModel : listSensorModel){
			delete(sensorModel.getCode());
		}
	}
	
	@Override
	public void delete(String code) {
		componentService.deleteByOwner(code);
		SensorModelMapper sensorModelMapper =sqlSession.getMapper(SensorModelMapper.class);
		sensorModelMapper.deleteByPrimaryKey(code);
	}
}
