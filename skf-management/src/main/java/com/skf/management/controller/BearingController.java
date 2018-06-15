package com.skf.management.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.skf.management.model.BearingModel;
import com.skf.management.service.BearingService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/bearing")
public class BearingController {

	private static Logger log = LoggerFactory.getLogger(BearingController.class);

	@Autowired
	private BearingService bearingService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					bearingService.list());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
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
					bearingService.listPage(currentPage));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody BearingModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			bearingService.add(model);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
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
			BearingModel model = bearingService.getBearingByCode(code);
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
	public Object edit(@RequestBody BearingModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (bearingService.getBearingByCode(model.getCode()) != null) {
				bearingService.update(model);
				map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
			} else {
				map = ResultHelper.createResult(Constant.HTTP_TYPE_CODE_NOT_EXISTS, Constant.HTTP_MSG_ERROR_NOT_EXISTS);
			}
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object delete(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bearingService.delete(code);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listModel/{modelNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object listModel(HttpServletRequest request, @PathVariable("modelNumber") String modelNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					bearingService.listModel(modelNumber));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
