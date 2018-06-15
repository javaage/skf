package com.skf.scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skf.scheduler.common.Constant;

@Controller
@RestController
@RequestMapping(value = "/api/scheduler")
public class SchedulerController {

	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public String stopScheduler() {
		Constant.STOP_FLAG = Boolean.TRUE;
		return "stopped";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public Object startScheduler() {
		Constant.STOP_FLAG = Boolean.FALSE;
		return "started";
	}

}
