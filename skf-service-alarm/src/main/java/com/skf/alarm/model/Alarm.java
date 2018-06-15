package com.skf.alarm.model;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class Alarm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8692855585502242608L;
	private String id;
	private String deviceName;
	private String sensorName;
	private String partName;
	private int type;
	private String status;
	private float score;
	private String alarmTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the sensorName
	 */
	public String getSensorName() {
		return sensorName;
	}

	/**
	 * @param sensorName
	 *            the sensorName to set
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 *            the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}

	/**
	 * @return the alarmTime
	 */
	public String getAlarmTime() {
		return alarmTime;
	}

	/**
	 * @param alarmTime
	 *            the alarmTime to set
	 */
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

}
