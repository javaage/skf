package com.skf.management.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.entity.GearEntity;
import com.skf.management.entity.Page;
import com.skf.management.mapper.BearingModelMapper;
import com.skf.management.mapper.GearMapper;
import com.skf.management.mapper.GearModelMapper;
import com.skf.management.model.BearingModel;
import com.skf.management.model.BearingModelExample;
import com.skf.management.model.GearModel;
import com.skf.management.model.GearModelExample;
import com.skf.management.model.GearModelExample.Criteria;
import com.skf.management.service.GearService;

@Service
public class GearServiceImpl implements GearService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<GearModel> list() {
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		return gearModelMapper.selectByExample(null);
	}

	@Override
	public Page listPage(int currentPage) {
		GearMapper gearMapper = sqlSession
				.getMapper(GearMapper.class);

		Page page = new Page();

		int record = gearMapper.listPageCount();

		page.setAllRowsAmount(record);
		page.setCurrentPage(currentPage);
		page.calculatePage();

		Map<String, Integer> parmMap = new HashMap<String, Integer>();
		parmMap.put("stratRow", page.getCurrentPageStartRow());
		parmMap.put("endRow", page.getCurrentPageEndRow());

		List<Object> data = gearMapper.listPage(parmMap);

		page.setItems(data);

		return page;
	}

	@Override
	public void add(GearModel model) {
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		gearModelMapper.insert(model);
	}
	
	public void update(GearEntity entity){
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		
		GearModel record = GearEntity.newModelFormEntity(entity);
		gearModelMapper.updateByPrimaryKey(record);
		
		BearingModelMapper bearingModelMapper = sqlSession
				.getMapper(BearingModelMapper.class);
		
		BearingModel bearingModel = GearEntity.newBearingModelFormEntity(entity);
		
		BearingModelExample example = new BearingModelExample();
		
		example.createCriteria().andImageCodeEqualTo(bearingModel.getImageCode());
		
		BearingModel bearOldModel =  bearingModelMapper.selectByExample(example).get(0);
		bearingModel.setCode(bearOldModel.getCode());
		bearingModelMapper.updateByPrimaryKey(bearingModel);
	}

	@Override
	public GearModel getGearByCode(String code) {
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		return gearModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(GearModel model) {
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		gearModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		GearModelMapper gearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		gearModelMapper.deleteByPrimaryKey(code);
	}

	@Override
	public List<GearModel> listModel(String modelNumber) {
		GearModelMapper GearModelMapper = sqlSession
				.getMapper(GearModelMapper.class);
		GearModelExample example = new GearModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andModelNumberLike("%" + modelNumber + "%");
		return GearModelMapper.selectByExample(example);
	}
}
