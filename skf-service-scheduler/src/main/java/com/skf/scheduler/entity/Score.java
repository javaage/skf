package com.skf.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author P0088589
 *
 */
public class Score implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6331318510415365351L;
	private String componentCode;
	private Date time;
	private String clas;
	private float score;
	private float totalValue;
	private float dangerLevel;
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
