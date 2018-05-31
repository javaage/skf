package com.skf.management.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skf.management.common.Constant;
import com.skf.management.model.GearModel;
import com.skf.management.service.GearService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/gear")
public class GearController {

	private static Logger log = LoggerFactory.getLogger(GearController.class);

	@Autowired
	private GearService gearService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					gearService.list());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody GearModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			gearService.add(model);
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
			GearModel model = gearService.getGearByCode(code);
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
	public Object edit(@RequestBody GearModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (gearService.getGearByCode(model.getCode()) != null) {
				gearService.update(model);
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

	@ResponseBody
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object delete(@PathVariable("code") String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			gearService.delete(code);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
