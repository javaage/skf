package com.skf.alarm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author P0088589
 *
 */
public class AlarmComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3770381765230405236L;
	private String componentCode;
	private int alarmType;
	private String userCode;
	private int type;
	private Date time;
	private String comment;

	/**
	 * @return the componentCode
	 */
	public String getComponentCode() {
		return componentCode;
	}

	/**
	 * @param componentCode
	 *            the componentCode to set
	 */
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	/**
	 * @return the alarmType
	 */
	public int getAlarmType() {
		return alarmType;
	}

	/**
	 * @param alarmType
	 *            the alarmType to set
	 */
	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode
	 *            the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
