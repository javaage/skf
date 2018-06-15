package com.skf.alarm.entity;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class DangerLevelUpdateLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3022278053432122284L;
	private String componentCode;
	private float dangerLevel;
	private float totalValueDangerLevel;
	private String userCode;

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
	 * @return the totalValueDangerLevel
	 */
	public float getTotalValueDangerLevel() {
		return totalValueDangerLevel;
	}

	/**
	 * @param totalValueDangerLevel
	 *            the totalValueDangerLevel to set
	 */
	public void setTotalValueDangerLevel(float totalValueDangerLevel) {
		this.totalValueDangerLevel = totalValueDangerLevel;
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

}
