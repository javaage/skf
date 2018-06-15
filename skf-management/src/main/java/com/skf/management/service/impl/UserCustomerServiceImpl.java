package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.entity.UserCustomerEntity;
import com.skf.management.mapper.UserCustomerModelMapper;
import com.skf.management.model.UserCustomerModelExample;
import com.skf.management.model.UserCustomerModelKey;
import com.skf.management.service.UserCustomerService;

@Service
public class UserCustomerServiceImpl implements UserCustomerService {

	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<UserCustomerModelKey> list() {
		UserCustomerModelMapper customerModelMapper =sqlSession.getMapper(UserCustomerModelMapper.class);
		return customerModelMapper.selectByExample(null);
	}

	@Override
	public void add(UserCustomerModelKey model) {
		UserCustomerModelMapper customerModelMapper =sqlSession.getMapper(UserCustomerModelMapper.class);
		customerModelMapper.insert(model);
	}

	@Override
	public List<UserCustomerModelKey> getCustomerByCode(String code) {
		UserCustomerModelMapper customerModelMapper =sqlSession.getMapper(UserCustomerModelMapper.class);
		UserCustomerModelExample example = new UserCustomerModelExample();
		UserCustomerModelExample.Criteria criteria = example.createCriteria();
		criteria.andUserCodeEqualTo(code);
		return customerModelMapper.selectByExample(example);
	}

	@Override
	public void delete(String code) {
		UserCustomerModelMapper customerModelMapper =sqlSession.getMapper(UserCustomerModelMapper.class);
		UserCustomerModelExample example = new UserCustomerModelExample();
		UserCustomerModelExample.Criteria criteria = example.createCriteria();
		criteria.andUserCodeEqualTo(code);
		customerModelMapper.deleteByExample(example);
	}

	@Override
	public List<UserCustomerEntity> getCustomerListByCode(String code) {
		// TODO Auto-generated method stub
		UserCustomerModelMapper customerModelMapper =sqlSession.getMapper(UserCustomerModelMapper.class);
		return customerModelMapper.selectByUserCode(code);
	}

}
