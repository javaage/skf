package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.entity.SearchEquipment;
import com.skf.management.mapper.EquipmentModelMapper;
import com.skf.management.model.EquipmentModel;
import com.skf.management.model.EquipmentModelExample;
import com.skf.management.service.EquipmentService;
import com.skf.management.service.SensorService;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private SensorService sensorService;
	
	@Override
	public List<EquipmentModel> list() {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		return equipmentModelMapper.selectByExample(null);
	}

	@Override
	public void add(EquipmentModel model) {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		equipmentModelMapper.insert(model);
	}

	@Override
	public EquipmentModel getEquipmentByCode(String code) {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		return equipmentModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(EquipmentModel model) {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		equipmentModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public List<EquipmentModel> listByOwner(String code) {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		EquipmentModelExample example = new EquipmentModelExample();
		EquipmentModelExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerCodeEqualTo(code);
		return equipmentModelMapper.selectByExample(example);
	}

	@Override
	public List<EquipmentModel> search(SearchEquipment searchEquipment) {
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		EquipmentModelExample example = new EquipmentModelExample();
		EquipmentModelExample.Criteria criteria = example.createCriteria();
		
		if(searchEquipment.getCustomerCode()!=null && !searchEquipment.getCustomerCode().isEmpty())
			criteria.andCustomerCodeEqualTo(searchEquipment.getCustomerCode());
		if(searchEquipment.getEquipmentTypeCode()!=null && !searchEquipment.getEquipmentTypeCode().isEmpty())
			criteria.andEquipmentTypeCodeEqualTo(searchEquipment.getEquipmentTypeCode());
		if(searchEquipment.getName()!=null && !searchEquipment.getName().isEmpty())
			criteria.andNameLike(searchEquipment.getName());
		if(searchEquipment.getStartDate()!=null)
			criteria.andSetupDateGreaterThanOrEqualTo(searchEquipment.getStartDate());
		if(searchEquipment.getEndDate()!=null )
			criteria.andSetupDateLessThanOrEqualTo(searchEquipment.getEndDate());
		return equipmentModelMapper.selectByExample(example);
	}
	
	@Override
	public void deleteByOwner(String code) {
		List<EquipmentModel> listEquipmentModel = listByOwner(code);
		for(EquipmentModel equipmentModel : listEquipmentModel){
			delete(equipmentModel.getCode());
		}
	}
	
	@Override
	public List<EquipmentModel> listByTypeCode(String code){
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		EquipmentModelExample example = new EquipmentModelExample();
		EquipmentModelExample.Criteria criteria = example.createCriteria();
		criteria.andEquipmentTypeCodeEqualTo(code);
		return equipmentModelMapper.selectByExample(example);
	}
	
	@Override
	public void deleteByTypeCode(String code) {
		List<EquipmentModel> listEquipmentModel = listByTypeCode(code);
		for(EquipmentModel equipmentModel : listEquipmentModel){
			delete(equipmentModel.getCode());
		}
	}
	
	@Override
	public void delete(String code) {
		sensorService.deleteByOwner(code);
		EquipmentModelMapper equipmentModelMapper =sqlSession.getMapper(EquipmentModelMapper.class);
		equipmentModelMapper.deleteByPrimaryKey(code);
	}
}
