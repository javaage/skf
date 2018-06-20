package com.skf.alarm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author P0088589
 *
 */
public class AlarmPoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5988748425639157299L;
	private Date time;
	private float value;
	private float level;
	private float dangerLevel;
	private float totalValueDangerLevel;
	private Float bpfi;
	private Float bpfo;
	private Float bsf;
	private Float ftf;
	private Float machineFreq;
	private float endFreq;
	private byte[] rawData;
	private float defectFreqOrder;
	private String bpType;
	private float scaleFactor;

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
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(float value) {
		this.value = value;
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
	 * @return the bpfi
	 */
	public Float getBpfi() {
		return bpfi;
	}

	/**
	 * @param bpfi
	 *            the bpfi to set
	 */
	public void setBpfi(Float bpfi) {
		this.bpfi = bpfi;
	}

	/**
	 * @return the bpfo
	 */
	public Float getBpfo() {
		return bpfo;
	}

	/**
	 * @param bpfo
	 *            the bpfo to set
	 */
	public void setBpfo(Float bpfo) {
		this.bpfo = bpfo;
	}

	/**
	 * @return the bsf
	 */
	public Float getBsf() {
		return bsf;
	}

	/**
	 * @param bsf
	 *            the bsf to set
	 */
	public void setBsf(Float bsf) {
		this.bsf = bsf;
	}

	/**
	 * @return the ftf
	 */
	public Float getFtf() {
		return ftf;
	}

	/**
	 * @param ftf
	 *            the ftf to set
	 */
	public void setFtf(Float ftf) {
		this.ftf = ftf;
	}

	/**
	 * @return the machineFreq
	 */
	public Float getMachineFreq() {
		return machineFreq;
	}

	/**
	 * @param machineFreq
	 *            the machineFreq to set
	 */
	public void setMachineFreq(Float machineFreq) {
		this.machineFreq = machineFreq;
	}

	/**
	 * @return the level
	 */
	public float getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(float level) {
		this.level = level;
	}

	/**
	 * @return the endFreq
	 */
	public float getEndFreq() {
		return endFreq;
	}

	/**
	 * @param endFreq
	 *            the endFreq to set
	 */
	public void setEndFreq(float endFreq) {
		this.endFreq = endFreq;
	}

	/**
	 * @return the rawData
	 */
	public byte[] getRawData() {
		return rawData;
	}

	/**
	 * @param rawData
	 *            the rawData to set
	 */
	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
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

	/**
	 * @return the scaleFactor
	 */
	public float getScaleFactor() {
		return scaleFactor;
	}

	/**
	 * @param scaleFactor the scaleFactor to set
	 */
	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

}
