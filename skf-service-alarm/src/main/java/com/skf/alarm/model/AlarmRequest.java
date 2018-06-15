package com.skf.alarm.model;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class AlarmRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4049849023561028599L;
	private String rowId;
	private int alarmType;
	private long markPointVal;
	private int warningType;
	private String noteMsg;
	private float dangerLevel;
	private float dangerAmountLevel;

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
	 * @return the markPointVal
	 */
	public long getMarkPointVal() {
		return markPointVal;
	}

	/**
	 * @param markPointVal
	 *            the markPointVal to set
	 */
	public void setMarkPointVal(long markPointVal) {
		this.markPointVal = markPointVal;
	}

	/**
	 * @return the noteMsg
	 */
	public String getNoteMsg() {
		return noteMsg;
	}

	/**
	 * @param noteMsg
	 *            the noteMsg to set
	 */
	public void setNoteMsg(String noteMsg) {
		this.noteMsg = noteMsg;
	}

	/**
	 * @return the dangerLevel
	 */
	public float getDangerLevel() {
		return dangerLevel;
	}

	/**
	 * @param dangerLevel
	 *            the dangerLevel to set
	 */
	public void setDangerLevel(float dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	/**
	 * @return the dangerAmountLevel
	 */
	public float getDangerAmountLevel() {
		return dangerAmountLevel;
	}

	/**
	 * @param dangerAmountLevel
	 *            the dangerAmountLevel to set
	 */
	public void setDangerAmountLevel(float dangerAmountLevel) {
		this.dangerAmountLevel = dangerAmountLevel;
	}

	/**
	 * @return the warningType
	 */
	public int getWarningType() {
		return warningType;
	}

	/**
	 * @param warningType
	 *            the warningType to set
	 */
	public void setWarningType(int warningType) {
		this.warningType = warningType;
	}

}
