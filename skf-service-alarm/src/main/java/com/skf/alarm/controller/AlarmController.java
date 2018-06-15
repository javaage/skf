package com.skf.alarm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.skf.alarm.common.Constant;
import com.skf.alarm.model.AlarmCommentModel;
import com.skf.alarm.model.AlarmCount;
import com.skf.alarm.model.AlarmDetailRequest;
import com.skf.alarm.model.AlarmQueryRequest;
import com.skf.alarm.model.AlarmRequest;
import com.skf.alarm.model.DropDownList;
import com.skf.alarm.service.AlarmCommentService;
import com.skf.alarm.service.AlarmService;
import com.skf.alarm.service.ComponentService;
import com.skf.alarm.service.DangerLevelUpdateLogService;
import com.skf.alarm.util.ResultHelper;

/**
 * @author P0088589
 *
 */
@Controller
@RestController
@RequestMapping(value = "/api/alarm")
public class AlarmController {

	private static Logger log = LoggerFactory.getLogger(AlarmController.class);

	@Autowired
	private AlarmService alarmService;

	@Autowired
	private AlarmCommentService commentService;

	@Autowired
	private ComponentService componentService;

	@Autowired
	private DangerLevelUpdateLogService logService;

	@ResponseBody
	@RequestMapping(value = "/counts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAlarmCount(HttpServletRequest request) {
		List<AlarmCount> list = new ArrayList<AlarmCount>();
		try {
			list = alarmService.getAlarmCounts(getUserCode(request));
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/dropdowns", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getDropDownLists(HttpServletRequest request) {
		DropDownList datas = new DropDownList();
		try {
			datas = alarmService.getDropDownList(getUserCode(request));
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return datas;
	}

	@ResponseBody
	@RequestMapping(value = "/alarms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAlarms(HttpServletRequest request, @RequestBody AlarmQueryRequest query) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			query.setUserCode(getUserCode(request));
			result = alarmService.getAlarms(query);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/alarmDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAlarmDetails(@RequestBody AlarmDetailRequest query) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = alarmService.getAlarmDetail(query);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/alarmFreq", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getFreq(@RequestBody AlarmRequest query) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = alarmService.getFreqData(query);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/comments/{rowId}/{alarmType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getComments(@PathVariable(value = "rowId") String rowId,
			@PathVariable(value = "alarmType") int alarmType) {
		List<AlarmCommentModel> list = new ArrayList<AlarmCommentModel>();
		try {
			list = commentService.list(rowId, alarmType);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/comment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveComment(HttpServletRequest request, @RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			commentService.save(getUserCode(request), commentRequest.getRowId(), commentRequest.getAlarmType(),
					commentRequest.getNoteMsg(), commentRequest.getWarningType());
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/claim", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object claimAlarm(HttpServletRequest request, @RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			alarmService.updateAlarmStatus(commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.ALARM_STATUS_PROCESSING);
			commentService.save(getUserCode(request), commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.COMMENT_MESSAGE_CLAIM, Constant.COMMENT_TYPE_CLAIM);
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/terminate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object terminateAlarm(HttpServletRequest request, @RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			alarmService.updateAlarmStatus(commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.ALARM_STATUS_PROCESSED);
			commentService.save(getUserCode(request), commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.COMMENT_MESSAGE_TERMINATE, Constant.COMMENT_TYPE_TERMINATE);
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/reopen", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object reopenAlarm(HttpServletRequest request, @RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			alarmService.updateAlarmStatus(commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.ALARM_STATUS_PROCESSING);
			commentService.save(getUserCode(request), commentRequest.getRowId(), commentRequest.getAlarmType(),
					Constant.COMMENT_MESSAGE_REOPEN, Constant.COMMENT_TYPE_REOPEN);
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object removeAlarm(@RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			alarmService.removeAlarm(commentRequest.getRowId(), commentRequest.getAlarmType());
			commentService.remove(commentRequest.getRowId(), commentRequest.getAlarmType());
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/updateDangerLevel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateDangerLevel(HttpServletRequest request, @RequestBody AlarmRequest commentRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			componentService.updateDangerLevel(commentRequest.getRowId(), commentRequest.getDangerLevel(),
					commentRequest.getDangerAmountLevel());
			logService.Save(commentRequest.getRowId(), commentRequest.getDangerLevel(),
					commentRequest.getDangerAmountLevel(), getUserCode(request));
			result = ResultHelper.getSuccessResult();
		} catch (Exception e) {
			result = ResultHelper.getFailedResult(e.getMessage());
			log.debug(e.getMessage());
		}
		return result;
	}

	private String getUserCode(HttpServletRequest request) {
		return request.getAttribute("userCode") == null ? "" : String.valueOf(request.getAttribute("userCode"));
	}
}
