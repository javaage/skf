package com.skf.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author P0088589
 *
 */
public class Alarm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9011001141284840332L;
	private String componentCode;
	private int alarmType;
	private Date alarmTime;
	private int status;
	private float totalValue;
	private float dangerLevel;
	private float score;
	private String clas;
	private float defectFreqOrder;
	private String bpType;

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
	 * @return the alarmTime
	 */
	public Date getAlarmTime() {
		return alarmTime;
	}

	/**
	 * @param alarmTime
	 *            the alarmTime to set
	 */
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the totalValue
	 */
	public float getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue
	 *            the totalValue to set
	 */
	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
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
	 * @return the clas
	 */
	public String getClas() {
		return clas;
	}

	/**
	 * @param clas
	 *            the clas to set
	 */
	public void setClas(String clas) {
		this.clas = clas;
	}

	/**
	 * @return the defectFreqOrder
	 */
	public float getDefectFreqOrder() {
		return defectFreqOrder;
	}

	/**
	 * @param defectFreqOrder
	 *            the defectFreqOrder to set
	 */
	public void setDefectFreqOrder(float defectFreqOrder) {
		this.defectFreqOrder = defectFreqOrder;
	}

	/**
	 * @return the bpType
	 */
	public String getBpType() {
		return bpType;
	}

	/**
	 * @param bpType
	 *            the bpType to set
	 */
	public void setBpType(String bpType) {
		this.bpType = bpType;
	}

}
