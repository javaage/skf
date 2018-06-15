package com.skf.management.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.entity.Page;
import com.skf.management.mapper.BearingMapper;
import com.skf.management.mapper.BearingModelMapper;
import com.skf.management.model.BearingModel;
import com.skf.management.model.BearingModelExample;
import com.skf.management.model.BearingModelExample.Criteria;
import com.skf.management.service.BearingService;

@Service
public class BearingServiceImpl implements BearingService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BearingModel> list() {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		return bearingModelMapper.selectByExample(null);
	}
	
	@Override
	public Page listPage(int currentPage) {
		BearingMapper bearingMapper = sqlSession
				.getMapper(BearingMapper.class);

		Page page = new Page();

		int record = bearingMapper.listPageCount();

		page.setAllRowsAmount(record);
		page.setCurrentPage(currentPage);
		page.calculatePage();

		Map<String, Integer> parmMap = new HashMap<String, Integer>();
		parmMap.put("stratRow", page.getCurrentPageStartRow());
		parmMap.put("endRow", page.getCurrentPageEndRow());

		List<Object> data = bearingMapper.listPage(parmMap);

		page.setItems(data);

		return page;
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

	@Override
	public List<BearingModel> listModel(String modelNumber) {
		BearingModelMapper bearingModelMapper =sqlSession.getMapper(BearingModelMapper.class);
		BearingModelExample example = new BearingModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andModelNumberLike("%"+modelNumber+"%");
		return bearingModelMapper.selectByExample(example);
		
//		List<BearingModel> listBearingModel= new ArrayList<BearingModel>();
//		BearingModel bearingModel = new BearingModel();
//		bearingModel.setBpfi(0.1f);
//		bearingModel.setBpfo(0.2f);
//		bearingModel.setBsf(0.3f);
//		bearingModel.setCode("123456");
//		bearingModel.setDescription("test");
//		bearingModel.setFtf(0.4f);
//		bearingModel.setImageCode("1");
//		bearingModel.setManufacture("TEST");
//		bearingModel.setModelNumber("123456");
//		listBearingModel.add(bearingModel);
//		return listBearingModel;
	}

}
