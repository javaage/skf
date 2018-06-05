package com.skf.management.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skf.management.common.Constant;
import com.skf.management.service.NodeService;
import com.skf.management.util.ResultHelper;

@Controller
@RestController
@RequestMapping(value = "/api/node")
public class NodeController {

	private static Logger log = LoggerFactory.getLogger(NodeController.class);

	@Autowired
	private NodeService nodeService;

	@ResponseBody
	@RequestMapping(value = "/leaflist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					nodeService.getLeafNodes(""));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
