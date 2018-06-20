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
	@RequestMapping(value = "/leaflist/{schema}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object leaflist(HttpServletRequest request, @PathVariable("schema") String schema) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					nodeService.getLeafNodes(schema));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/leafpath/{schema}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object leafpath(HttpServletRequest request, @PathVariable("schema") String schema) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,nodeService.getNodeElements(schema));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getNodeDatabase", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getNodeDatabase(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,
					nodeService.getNodeDatabase());
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/value/{schema}/{nodeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getNodeValue(HttpServletRequest request, @PathVariable("schema") String schema, @PathVariable("nodeID") int nodeID) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = ResultHelper.createResult(Constant.HTTP_TYPE_OK, Constant.HTTP_MSG_OK,nodeService.getNodeValue(schema, nodeID));
		} catch (Exception e) {
			map = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return map;
	}
}
