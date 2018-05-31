package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.EquipmentTypeModelMapper;
import com.skf.management.model.EquipmentTypeModel;
import com.skf.management.model.EquipmentTypeModelExample;
import com.skf.management.service.EquipmentService;
import com.skf.management.service.EquipmentTypeService;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Override
	public List<EquipmentTypeModel> list() {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		return equipmentTypeModelMapper.selectByExample(null);
	}

	@Override
	public void add(EquipmentTypeModel model) {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		equipmentTypeModelMapper.insert(model);
	}

	@Override
	public EquipmentTypeModel getEquipmentTypeByCode(String code) {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		return equipmentTypeModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(EquipmentTypeModel model) {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		equipmentTypeModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public List<EquipmentTypeModel> listByOwner(String code) {
		EquipmentTypeModelMapper customerModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		EquipmentTypeModelExample example = new EquipmentTypeModelExample();
		EquipmentTypeModelExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerCodeEqualTo(code);
		return customerModelMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<EquipmentTypeModel> listWithBLOBs() {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		return equipmentTypeModelMapper.selectByExampleWithBLOBs(null);
	}
	
	@Override
	public List<EquipmentTypeModel> listImgs(List<String> listType) {
		EquipmentTypeModelMapper customerModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		EquipmentTypeModelExample example = new EquipmentTypeModelExample();
		EquipmentTypeModelExample.Criteria criteria = example.createCriteria();
		criteria.andCodeIn(listType);
		return customerModelMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void updateWithBLOBs(EquipmentTypeModel model) {
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		equipmentTypeModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}
	
	@Override
	public void deleteByOwner(String code) {
		List<EquipmentTypeModel> listEquipmentTypeModel = listByOwner(code);
		for(EquipmentTypeModel equipmentTypeModel : listEquipmentTypeModel){
			delete(equipmentTypeModel.getCode());
		}
	}
	
	@Override
	public void delete(String code) {
		equipmentService.deleteByTypeCode(code);
		EquipmentTypeModelMapper equipmentTypeModelMapper =sqlSession.getMapper(EquipmentTypeModelMapper.class);
		equipmentTypeModelMapper.deleteByPrimaryKey(code);
	}
}
