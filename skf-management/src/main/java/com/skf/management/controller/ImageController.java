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
import com.skf.management.model.ImageModel;
import com.skf.management.service.ImageService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

	private static Logger log = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	private ImageService imageService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					imageService.list());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object listByType(@PathVariable("type") Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					imageService.listByType(type));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listWithBLOBs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object listWithBLOBs(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					imageService.listWithBLOBs());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add(@RequestBody ImageModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			imageService.add(model);
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
			ImageModel model = imageService.getImageByCode(code);
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
	public Object edit(@RequestBody ImageModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (imageService.getImageByCode(model.getCode()) != null) {
				imageService.update(model);
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
	@RequestMapping(value="blob", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object editWithBLOBs(@RequestBody ImageModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (imageService.getImageByCode(model.getCode()) != null) {
				imageService.updateWithBLOBs(model);
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
			imageService.delete(code);
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK);
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
