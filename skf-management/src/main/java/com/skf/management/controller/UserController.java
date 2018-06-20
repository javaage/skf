/**
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skf.management.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skf.management.common.Constant;
import com.skf.management.entity.User;
import com.skf.management.service.UserService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	// @RequestMapping(value = "{id:.+}", method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public Object getUser(HttpServletRequest request, @PathVariable("id")
	// String id){
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("code", 1);
	// map.put("message", "Successfully");
	// map.put("data", "your data");
	//
	// return map;
	// }

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
					Constant.HTTP_MSG_OK, userService.list());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list/{currentPage}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(@PathVariable("currentPage") int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
				
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					userService.listPage(currentPage));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(@RequestBody User model) {
		Map<String, Object> map = new HashMap<String, Object>();
				
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					userService.getCountByUserInfo(model));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody User model) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			userService.add(model);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
					Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object edit(@RequestBody User model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (userService.getUserByCode(model.getCode()) != null) {
				boolean updateFlag = userService.update(model);
				if(updateFlag){
					map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
							Constant.HTTP_MSG_OK);
				}else{
					map = ResultHelper.createResult(
							Constant.HTTP_TYPE_CHECK_ERROR,
							Constant.HTTP_MSG_CHECK_PW_ERROR);
				}
			} else {
				map = ResultHelper.createResult(
						Constant.HTTP_TYPE_CODE_NOT_EXISTS,
						Constant.HTTP_MSG_ERROR_NOT_EXISTS);
			}
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object login(HttpServletRequest request,
			@PathVariable("username") String username,
			@PathVariable("password") String password)
			throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();

		String pwd64 = new String(Base64.encodeBase64(password.getBytes("UTF-8")), "UTF-8");
		List<com.skf.management.model.User> users =userService.login(username, pwd64);
		if(users.size()!=0){

			map.put("code", "success");
			map.put("token", new String(Base64.encodeBase64(users.get(0).getCode().getBytes("UTF-8")), "UTF-8"));
			map.put("username", users.get(0).getName());
			map.put("userRoleId", users.get(0).getRoleId());
			map.put("image", users.get(0).getImg());
		}else{
			map.put("code", "fail");
		}	
		return map;
	}

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object delete(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(code.equals("1")){
				map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
						Constant.HTTP_MSG_SUPERADMIN_DELETE_ERROR);
			}else{
				userService.delete(code);
				map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
						Constant.HTTP_MSG_OK);
			}		
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/dels/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object delete(@PathVariable("code") List<String> code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.delete(code);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
					Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUser(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userService.getUserAllByCode(code);
			if (user == null) {
				map = ResultHelper.createResult(
						Constant.HTTP_TYPE_CODE_NOT_EXISTS,
						Constant.HTTP_MSG_ERROR_NOT_EXISTS);
			} else {
				map = ResultHelper.createResult(Constant.HTTP_TYPE_OK,
						Constant.HTTP_MSG_OK, user);
			}
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR,
					Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

}
