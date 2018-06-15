package com.skf.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.join.CustomerJoin;
import com.skf.management.mapper.CustomerModelMapper;
import com.skf.management.model.CustomerModel;
import com.skf.management.model.CustomerModelExample;
import com.skf.management.service.CustomerService;
import com.skf.management.service.EquipmentService;
import com.skf.management.service.EquipmentTypeService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private EquipmentTypeService equipmentTypeService;
	
	@Override
	public List<CustomerModel> listWithBLOBs() {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		return customerModelMapper.selectByExampleWithBLOBs(null);
	}
	
	@Override
	public List<CustomerModel> list() {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		return customerModelMapper.selectByExample(null);
	}

	@Override
	public void add(CustomerModel model) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		customerModelMapper.insert(model);
	}

	@Override
	public CustomerModel getCustomerByCode(String code) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		return customerModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(CustomerModel model) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		customerModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}

	@Override
	public List<CustomerModel> listByOwner(String code) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		CustomerModelExample example = new CustomerModelExample();
		CustomerModelExample.Criteria criteria = example.createCriteria();
		criteria.andOemCodeEqualTo(code);
		return customerModelMapper.selectByExample(example);
	}

	@Override
	public List<CustomerJoin> listTree(String code) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		CustomerModelExample example = new CustomerModelExample();
		CustomerModelExample.Criteria criteria = example.createCriteria();
		criteria.andOemCodeEqualTo(code);
		List<CustomerModel> listCustomerModel= customerModelMapper.selectByExampleWithBLOBs(example);
		
		List<CustomerJoin> listCustomerJoin = new ArrayList<CustomerJoin>();
		
		for(CustomerModel customerModel : listCustomerModel){
			CustomerJoin customerJoin = new CustomerJoin();
			customerJoin.setCustomerModel(customerModel);
			customerJoin.setListEquipmentModel(equipmentService.listByOwner(customerModel.getCode()));
			listCustomerJoin.add(customerJoin);
		}
		return listCustomerJoin;
	}
	
	@Override
	public List<CustomerJoin> listTree(String code, List<String> oemList, List<String> cstmList) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		CustomerModelExample example = new CustomerModelExample();
		CustomerModelExample.Criteria criteria = example.createCriteria();
		criteria.andOemCodeEqualTo(code);
		List<CustomerModel> listCustomerModel= customerModelMapper.selectByExampleWithBLOBs(example);
		
		List<CustomerJoin> listCustomerJoin = new ArrayList<CustomerJoin>();
		
		for(CustomerModel customerModel : listCustomerModel){
			CustomerJoin customerJoin = new CustomerJoin();
			
			if(cstmList.contains(customerModel.getCode())){
				customerJoin.setCustomerModel(customerModel);
				customerJoin.setListEquipmentModel(equipmentService.listByOwner(customerModel.getCode()));
				listCustomerJoin.add(customerJoin);
			}
		}
		return listCustomerJoin;
	}

	@Override
	public void updateWithBLOBs(CustomerModel model) {
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		customerModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}
	
	@Override
	public void deleteByOwner(String code) {
		List<CustomerModel> listCustomerModel = listByOwner(code);
		for(CustomerModel customerModel : listCustomerModel){
			delete(customerModel.getCode());
		}
		
	}
	
	@Override
	public void delete(String code) {
		equipmentService.deleteByOwner(code);
		equipmentTypeService.deleteByOwner(code);
		CustomerModelMapper customerModelMapper =sqlSession.getMapper(CustomerModelMapper.class);
		customerModelMapper.deleteByPrimaryKey(code);
	}
}
