package com.skf.management.util;

import org.apache.tomcat.util.codec.binary.Base64;

public class StringUtil {

	public static String encodeBase64(String str) throws Exception {

		return new String(Base64.encodeBase64(str.getBytes("UTF-8")), "UTF-8");
	}

	public static String decodeBase64(String str) throws Exception {

		return new String(Base64.decodeBase64(str.getBytes("UTF-8")), "UTF-8");
	}

}
