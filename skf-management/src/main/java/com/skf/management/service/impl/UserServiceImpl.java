package com.skf.management.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.entity.Page;
import com.skf.management.entity.User;
import com.skf.management.entity.UserCustomerEntity;
import com.skf.management.entity.UserOEMEntity;
import com.skf.management.mapper.LoginMapper;
import com.skf.management.mapper.UserCustomerMapper;
import com.skf.management.mapper.UserCustomerModelMapper;
import com.skf.management.mapper.UserModelMapper;
import com.skf.management.mapper.UserOEMMapper;
import com.skf.management.mapper.UserOEMModelMapper;
import com.skf.management.model.UserCustomerModelExample;
import com.skf.management.model.UserCustomerModelKey;
import com.skf.management.model.UserModel;
import com.skf.management.model.UserModelExample;
import com.skf.management.model.UserOEMModelExample;
import com.skf.management.model.UserOEMModelKey;
import com.skf.management.service.UserService;
import com.skf.management.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("mysqlsession")
	private SqlSessionTemplate sqlSession;

	public List<UserModel> list() {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExample(null);
	}
	
	@Override
	public	Map<String, Object> getCountByUserInfo(User model){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		if(model.getName()!=null && !model.getName().equals("")){
			resultMap.put("name", getCountByName(model));
		}
		if(model.getPhone()!=null && !model.getPhone().equals("")){
			resultMap.put("phone", getCountPhone(model));
		}
		if(model.getEmail()!=null && !model.getEmail().equals("")){
			resultMap.put("email", getCountByEmail(model));
		}
		return resultMap;
	}
	
	public	int getCountByName(User model){
		UserModelExample example = new UserModelExample();
		
		example.createCriteria().andNameEqualTo(model.getName());
		List<UserModel> resultNameList = getListSelectByExample(example);
		
		return resultNameList.size();
	}
	
	public	int getCountPhone(User model){
		UserModelExample example = new UserModelExample();
		
		example.createCriteria().andPhoneEqualTo(model.getName());
		List<UserModel> resultPhoneList = getListSelectByExample(example);
		
		return resultPhoneList.size();
	}
	
	public	int getCountByEmail(User model){
		UserModelExample example = new UserModelExample();
		
		example.createCriteria().andEmailEqualTo(model.getName());
		
		List<UserModel> resultEmailList = getListSelectByExample(example);
		
		return resultEmailList.size();
	}
	
	public	List<UserModel> getListSelectByExample(UserModelExample example){
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExample(example);
	}
	
	@Override
	public Page listPage(int currentPage) {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);

		Page page = new Page();

		int record = userModelMapper.listPageCount();

		page.setAllRowsAmount(record);
		page.setCurrentPage(currentPage);
		page.calculatePage();

		Map<String, Integer> parmMap = new HashMap<String, Integer>();
		parmMap.put("stratRow", page.getCurrentPageStartRow());
		parmMap.put("endRow", page.getCurrentPageEndRow());

		List<Object> data = userModelMapper.listPage(parmMap);

		page.setItems(data);

		return page;
	}

	public UserModel add(UserModel model) {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		userModelMapper.insert(model);
		return model;
	}

	public void add(User user) throws Exception{
		UserModel model = add(User.newModelFormUser(user));

		updateUserOem(model.getCode(), user.getOemGroup());
		updatUserCustomer(model.getCode(), user.getCusGroup());
	}

	public UserModel getUserByCode(String code) {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		return userModelMapper.selectByPrimaryKey(code);
	}

	public User getUserAllByCode(String code) throws Exception{
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		UserOEMMapper userOEMMapper = sqlSession
				.getMapper(UserOEMMapper.class);
		UserCustomerMapper userCustomerMapper = sqlSession
				.getMapper(UserCustomerMapper.class);
		
		UserModel model = userModelMapper.selectByPrimaryKey(code);

		User user = User.newUserFormModel(model);
		String userCode = user.getCode();

		List<UserOEMEntity> oems = userOEMMapper
				.selectByUserCode(userCode);
		List<UserCustomerEntity> customers = userCustomerMapper
				.selectByUserCode(userCode);

		user.setUserOems(oems);
		user.setUserCustomers(customers);

		return user;
	}

	public void update(UserModel model) throws Exception {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);

		if (model.getName() == null || model.getName().equals("")) {
			userModelMapper.updateByPrimaryKeySelective(model);
		} else {
			userModelMapper.updateByPrimaryKeyWithBLOBs(model);
		}
	}

	public boolean update(User user) throws Exception {
		
		UserModel model = User.newModelFormUser(user);
		
		if(user.getPasswordOne()==null || user.getPasswordOne().equals("")){
			update(model);
			if(user.getName()!=null && !user.getName().equals("")){
				updateUserOem(user.getCode(), user.getOemGroup());
				updatUserCustomer(user.getCode(), user.getCusGroup());
			}
		}else{
			UserModel userModel = getUserByCode(user.getCode());
			String passWord = StringUtil.decodeBase64(userModel.getPassword());
			if(passWord.equals(user.getPasswordOne())){
				return false;
			}else if(!passWord.equals(user.getPassword())){
				return false;
			}else{
				model.setPassword(StringUtil.encodeBase64(user.getPasswordOne()));
				update(model);
			}
		}
		return true;
	}

	public void updateWithBLOBs(UserModel model) throws Exception {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);

		model.setPassword(StringUtil.encodeBase64(model.getPassword()));

		userModelMapper.updateByPrimaryKeyWithBLOBs(model);
	}

	public void delete(String code) {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		userModelMapper.deleteByPrimaryKey(code);
	}

	public void delete(List<String> code) {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		UserModelExample userModelExample = new UserModelExample();

		delUserOem(null, code);
		delUserCustomer(null, code);

		userModelExample.createCriteria().andCodeIn(code);
		userModelMapper.deleteByExample(userModelExample);
	}

	public List<UserModel> listWithBLOBs() {
		UserModelMapper userModelMapper = sqlSession
				.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExampleWithBLOBs(null);
	}

	public void updateUserOem(String userCode, List<String> oemGroup) {
		UserOEMModelMapper userOEMModelMapper = sqlSession
				.getMapper(UserOEMModelMapper.class);

		delUserOem(userCode, new ArrayList<String>());

		for (String oemString : oemGroup) {
			UserOEMModelKey key = new UserOEMModelKey();
			key.setUserCode(userCode);
			key.setOemCode(oemString);
			userOEMModelMapper.insertSelective(key);
		}
	}

	public void updatUserCustomer(String userCode, List<String> cusoemGroup) {
		UserCustomerModelMapper userCustomerModelMapper = sqlSession
				.getMapper(UserCustomerModelMapper.class);

		delUserCustomer(userCode, new ArrayList<String>());

		for (String cusString : cusoemGroup) {
			UserCustomerModelKey key = new UserCustomerModelKey();
			key.setUserCode(userCode);
			key.setCustomerCode(cusString);
			userCustomerModelMapper.insertSelective(key);
		}

	}

	public void delUserOem(String userCode, List<String> userCodes) {
		UserOEMModelMapper userOEMModelMapper = sqlSession
				.getMapper(UserOEMModelMapper.class);
		UserOEMModelExample delKey = new UserOEMModelExample();

		com.skf.management.model.UserOEMModelExample.Criteria criteria = delKey
				.createCriteria();
		if (userCode != null && !userCodes.equals(userCode)) {
			criteria.andUserCodeEqualTo(userCode);
		} else if (userCodes != null && userCodes.size() > 0) {
			criteria.andUserCodeIn(userCodes);
		}
		userOEMModelMapper.deleteByExample(delKey);

	}

	public void delUserCustomer(String userCode, List<String> userCodes) {
		UserCustomerModelMapper userCustomerModelMapper = sqlSession
				.getMapper(UserCustomerModelMapper.class);

		UserCustomerModelExample customerExample = new UserCustomerModelExample();
		com.skf.management.model.UserCustomerModelExample.Criteria criteria = customerExample
				.createCriteria();
		if (userCode != null && !userCodes.equals(userCode)) {
			criteria.andUserCodeEqualTo(userCode);
		} else if (userCodes != null && userCodes.size() > 0) {
			criteria.andUserCodeIn(userCodes);
		}
		userCustomerModelMapper.deleteByExample(customerExample);
	}

	@Override

	public List<com.skf.management.model.User> login(String username, String password) {
		LoginMapper loginMapper =sqlSession.getMapper(LoginMapper.class);
		List<com.skf.management.model.User> users = loginMapper.getUserCode(username,username,password);
		return users;

	}

	@Override
	public boolean checkToken(String username, String usercode) {

		LoginMapper loginMapper =sqlSession.getMapper(LoginMapper.class);
		Long count= loginMapper.checkToken(username,username,usercode);
		if(count==0){

			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<String> getUsrOemList(String usercode) {
		LoginMapper loginMapper =sqlSession.getMapper(LoginMapper.class);
		return loginMapper.getUsrOemList(usercode);
	}

	@Override
	public List<String> getUsrCstmList(String usercode) {
		LoginMapper loginMapper =sqlSession.getMapper(LoginMapper.class);
		return loginMapper.getUsrCstmList(usercode);
	}

	@Override
	public int getUserRoleId(String usercode) {
		LoginMapper loginMapper =sqlSession.getMapper(LoginMapper.class);
		return loginMapper.getUsrRoleId(usercode);
	}

}
