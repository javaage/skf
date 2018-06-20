package com.skf.management.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.model.DboBearingModel;
import com.skf.management.model.DboBearingModelExample;
import com.skf.management.service.BearingOdbService;
import com.skf.management.sqlservermapper.DboBearingModelMapper;

@Service
public class BearingOdbServiceImpl implements BearingOdbService {

	@Autowired
	@Qualifier("sqlserversession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<DboBearingModel> list(String modelNumber) {
		DboBearingModelMapper bearingModelMapper =sqlSession.getMapper(DboBearingModelMapper.class);
		
		DboBearingModelExample example = new DboBearingModelExample();
		
		example.createCriteria().andModelNumberLike("%"+modelNumber+"%");
		
		return bearingModelMapper.selectByExample(example);
	}
	
	


}
