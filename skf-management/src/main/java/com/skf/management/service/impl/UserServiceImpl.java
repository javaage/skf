package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.mapper.UserModelMapper;
import com.skf.management.model.UserModel;
import com.skf.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("mysqlsession")
	private SqlSession sqlSession;
	
	@Override
	public List<UserModel> list() {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExample(null);
	}

	@Override
	public void add(UserModel model) {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.insert(model);
	}

	@Override
	public UserModel getUserByCode(String code) {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		return userModelMapper.selectByPrimaryKey(code);
	}

	@Override
	public void update(UserModel model) {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.updateByPrimaryKey(model);
	}

	@Override
	public void delete(String code) {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.deleteByPrimaryKey(code);
	}

	@Override
	public List<UserModel> listWithBLOBs() {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public void updateWithBLOBs(UserModel model) {
		UserModelMapper userModelMapper =sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}
}
