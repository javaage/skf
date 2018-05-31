package com.skf.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.management.join.OEMJoin;
import com.skf.management.mapper.OEMModelMapper;
import com.skf.management.model.OEMModel;
import com.skf.management.service.CustomerService;
import com.skf.management.service.OEMService;

@Service
public class OEMServiceImpl implements OEMService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public List<OEMModel> list() {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		return oemModelMapper.selectByExample(null);
	}

	@Override
	public void add(OEMModel model) {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		oemModelMapper.insert(model);
	}

	@Override
	public OEMModel getOEMByCode(String code) {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		return oemModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(OEMModel model) {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		oemModelMapper.updateByPrimaryKey(model);
		
	}

	@Override
	public List<OEMJoin> listTree() {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		List<OEMModel> listOEMModel = oemModelMapper.selectByExampleWithBLOBs(null);
		List<OEMJoin> listOEMJoin = new ArrayList<OEMJoin>();
		
		for(OEMModel oemModel : listOEMModel){
			OEMJoin oemJoin = new OEMJoin();
			oemJoin.setOEMModel(oemModel);
			oemJoin.setListCustomerJoin(customerService.listTree(oemModel.getCode()));
			listOEMJoin.add(oemJoin);
		}
		
		return listOEMJoin;
	}

	@Override
	public List<OEMModel> listWithBLOBs() {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		return oemModelMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public void updateWithBLOBs(OEMModel model) {
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		oemModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}
	
	@Override
	public void delete(String code) {
		customerService.deleteByOwner(code);
		OEMModelMapper oemModelMapper =sqlSession.getMapper(OEMModelMapper.class);
		oemModelMapper.deleteByPrimaryKey(code);
	}
}