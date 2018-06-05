package com.skf.management.common;

public final class Constant {

	public static final String TOKEN = "SKF_TOKEN";

	public static final Integer ADMIN_CODE = 1;
	public static final Integer USER_CODE = 2;

	public static final Integer HTTP_TYPE_OK = 1;
	public static final Integer HTTP_TYPE_ERROR = -1;
	public static final Integer HTTP_TYPE_UNLOGIN = -2;
	public static final Integer HTTP_TYPE_NO_PERMISSION = -3;
	public static final Integer HTTP_TYPE_CODE_NOT_EXISTS = -4;
	public static final Integer HTTP_TYPE_DUPLICATE_KEY_EXCEPTION = -5;

	public static final String HTTP_MSG_OK = "OK";
	public static final String HTTP_MSG_ERROR = "SYSTEM ERROR";
	public static final String HTTP_MSG_UNLOGIN = "NOT LOGIN";
	public static final String HTTP_MSG_NO_PERMISSION = "NO PERMISSION";
	public static final String HTTP_MSG_ERROR_REPEAT = "CODE EXISTS";
	public static final String HTTP_MSG_ERROR_NOT_EXISTS = "NOT EXISTS";
	public static final String HTTP_MSG_DUPLICATE_KEY_EXCEPTION = "DUPLICATE KEY";
}	
