package com.skf.alarm.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author P0088589
 *
 */
public class ResultHelper {

	public static Map<String, Object> getSuccessResult() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "success");
		return map;
	}

	public static Map<String, Object> getFailedResult(String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "error");
		map.put("message", msg);
		return map;
	}

}
