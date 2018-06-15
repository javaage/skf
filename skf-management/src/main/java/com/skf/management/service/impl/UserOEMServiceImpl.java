package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.entity.UserOEMEntity;
import com.skf.management.mapper.UserOEMModelMapper;
import com.skf.management.model.UserOEMModelExample;
import com.skf.management.model.UserOEMModelKey;
import com.skf.management.service.UserOEMService;

@Service
public class UserOEMServiceImpl implements UserOEMService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<UserOEMModelKey> list() {
		UserOEMModelMapper oemModelMapper =sqlSession.getMapper(UserOEMModelMapper.class);
		return oemModelMapper.selectByExample(null);
	}

	@Override
	public void add(UserOEMModelKey model) {
		UserOEMModelMapper oemModelMapper =sqlSession.getMapper(UserOEMModelMapper.class);
		oemModelMapper.insert(model);
	}

	@Override
	public List<UserOEMModelKey> getOEMByCode(String code) {
		UserOEMModelMapper oemModelMapper =sqlSession.getMapper(UserOEMModelMapper.class);
		UserOEMModelExample example = new UserOEMModelExample();
		UserOEMModelExample.Criteria criteria = example.createCriteria();
		criteria.andUserCodeEqualTo(code);
		return oemModelMapper.selectByExample(example);
	}

	@Override
	public void delete(String code) {
		UserOEMModelMapper oemModelMapper =sqlSession.getMapper(UserOEMModelMapper.class);
		UserOEMModelExample example = new UserOEMModelExample();
		UserOEMModelExample.Criteria criteria = example.createCriteria();
		criteria.andUserCodeEqualTo(code);
		oemModelMapper.deleteByExample(example);
	}

	@Override
	public List<UserOEMEntity> getOEMListByCode(String code) {
		// TODO Auto-generated method stub
		UserOEMModelMapper oemModelMapper =sqlSession.getMapper(UserOEMModelMapper.class);
		return oemModelMapper.selectByUserCode(code);
	}

}
