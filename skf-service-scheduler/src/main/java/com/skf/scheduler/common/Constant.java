package com.skf.scheduler.common;

public final class Constant {

	public static String PRE_SCHEMA = "skf_";
	public static Boolean STOP_FLAG = Boolean.FALSE;
	public static final int TASK_SCHEDULER_CORE_POOL_SIZE = 100;
	public static final int TASK_LISTENER_THREAD_SIZE = 50;
	public static final long DATABASE_FIXED_DELAY = 30 * 1000;
	public static final long ALARM_FIXED_DELAY = 10 * 1000;
	public static final int ROTATION_SPEED_TYPE_MYSQL = 1;
	public static final int ROTATION_SPEED_TYPE_SQLSERVER = 2;
	public static final int COMPONENT_TYPE_BEARING = 1;
	public static final int COMPONENT_TYPE_GEAR = 2;
	public static final String HTTP_ERROR = "error";
	public static final String PYTHON_SERVER_URL = "pythonServerURL";
	public static final String CLASS_A = "A";
	public static final String CLASS_B = "B";
	public static final String CLASS_C = "C";
	public static final int ALARM_TYPE_TOTAL = 1;
	public static final int ALARM_TYPE_BEARING = 2;
	public static final int ALARM_STATUS_UNPROCESSED = 1;
	public static final int ALARM_STATUS_PROCESSING = 2;
	public static final int ALARM_STATUS_PROCESSED = 3;

	public static final String BP_TYPE_BPFI = "BPFI";
	public static final String BP_TYPE_BPFO = "BPFO";
	public static final String BP_TYPE_BSF = "BSF";

}
