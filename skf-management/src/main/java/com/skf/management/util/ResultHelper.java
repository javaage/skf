package com.skf.management.util;

import java.util.HashMap;
import java.util.Map;

public class ResultHelper {

	public static Map<String, Object> createResult(int code, String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("message", msg);
		return map;
	}

	public static Map<String, Object> createResult(int code, String msg, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("message", msg);
		map.put("data", data);
		return map;
	}

}
