package com.skf.management.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
import com.skf.management.entity.SearchEquipment;
import com.skf.management.model.EquipmentModel;
import com.skf.management.service.EquipmentService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/equipment")
public class EquipmentController {

	private static Logger log = LoggerFactory.getLogger(EquipmentController.class);

	@Autowired
	private EquipmentService equipmentService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					equipmentService.list());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object listByOwner(HttpServletRequest request, @PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					equipmentService.listByOwner(code));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody EquipmentModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			equipmentService.add(model);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
		} catch (DuplicateKeyException e){
			map = ResultHelper.createResult(Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION, Constant.HTTP_MSG_DUPLICATE_KEY_EXCEPTION);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody SearchEquipment searchEquipment) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK, equipmentService.search(searchEquipment));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getDetail(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			EquipmentModel model = equipmentService.getEquipmentByCode(code);
			if (model == null) {
				map = ResultHelper.createResult(Constant.HTTP_TYPE_CODE_NOT_EXISTS, Constant.HTTP_MSG_ERROR_NOT_EXISTS);
			} else {
				map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK, model);
			}
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object edit(@RequestBody EquipmentModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (equipmentService.getEquipmentByCode(model.getCode()) != null) {
				equipmentService.update(model);
				map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
			} else {
				map = ResultHelper.createResult(Constant.HTTP_TYPE_CODE_NOT_EXISTS, Constant.HTTP_MSG_ERROR_NOT_EXISTS);
			}
		} catch (DuplicateKeyException e){
			map = ResultHelper.createResult(Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION, Constant.HTTP_MSG_DUPLICATE_KEY_EXCEPTION);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@Transactional(rollbackFor=Exception.class)
	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object delete(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			equipmentService.delete(code);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
