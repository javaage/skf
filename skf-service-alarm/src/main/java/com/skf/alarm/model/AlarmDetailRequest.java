package com.skf.alarm.model;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class AlarmDetailRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3978037948563406773L;
	private String startDate;
	private String endDate;
	private String rowId;
	private int alarmType;
	private float thresholdValue;

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the rowId
	 */
	public String getRowId() {
		return rowId;
	}

	/**
	 * @param rowId
	 *            the rowId to set
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	 * @return the thresholdValue
	 */
	public float getThresholdValue() {
		return thresholdValue;
	}

	/**
	 * @param thresholdValue the thresholdValue to set
	 */
	public void setThresholdValue(float thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

}
