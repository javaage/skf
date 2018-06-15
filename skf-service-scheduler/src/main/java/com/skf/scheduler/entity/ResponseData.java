package com.skf.scheduler.entity;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class ResponseData implements Serializable {

	private static final long serialVersionUID = -3702022049184582610L;
	private float DefectFreqOrder;
	private float ENV1X;
	private float ENV2X;
	private float ENV3X;
	private float ENV4X;
	private float ENV5X;
	private float BearingTotalValue;
	private int ifBearingTotalValueAlarm;
	private float score;
	private String clas;
	private String bpType;

	/**
	 * @return the defectFreqOrder
	 */
	public float getDefectFreqOrder() {
		return DefectFreqOrder;
	}

	/**
	 * @param defectFreqOrder
	 *            the defectFreqOrder to set
	 */
	public void setDefectFreqOrder(float defectFreqOrder) {
		DefectFreqOrder = defectFreqOrder;
	}

	/**
	 * @return the eNV1X
	 */
	public float getENV1X() {
		return ENV1X;
	}

	/**
	 * @param eNV1X
	 *            the eNV1X to set
	 */
	public void setENV1X(float eNV1X) {
		ENV1X = eNV1X;
	}

	/**
	 * @return the eNV2X
	 */
	public float getENV2X() {
		return ENV2X;
	}

	/**
	 * @param eNV2X
	 *            the eNV2X to set
	 */
	public void setENV2X(float eNV2X) {
		ENV2X = eNV2X;
	}

	/**
	 * @return the eNV3X
	 */
	public float getENV3X() {
		return ENV3X;
	}

	/**
	 * @param eNV3X
	 *            the eNV3X to set
	 */
	public void setENV3X(float eNV3X) {
		ENV3X = eNV3X;
	}

	/**
	 * @return the eNV4X
	 */
	public float getENV4X() {
		return ENV4X;
	}

	/**
	 * @param eNV4X
	 *            the eNV4X to set
	 */
	public void setENV4X(float eNV4X) {
		ENV4X = eNV4X;
	}

	/**
	 * @return the eNV5X
	 */
	public float getENV5X() {
		return ENV5X;
	}

	/**
	 * @param eNV5X
	 *            the eNV5X to set
	 */
	public void setENV5X(float eNV5X) {
		ENV5X = eNV5X;
	}

	/**
	 * @return the bearingTotalValue
	 */
	public float getBearingTotalValue() {
		return BearingTotalValue;
	}

	/**
	 * @param bearingTotalValue
	 *            the bearingTotalValue to set
	 */
	public void setBearingTotalValue(float bearingTotalValue) {
		BearingTotalValue = bearingTotalValue;
	}

	/**
	 * @return the ifBearingTotalValueAlarm
	 */
	public int getIfBearingTotalValueAlarm() {
		return ifBearingTotalValueAlarm;
	}

	/**
	 * @param ifBearingTotalValueAlarm
	 *            the ifBearingTotalValueAlarm to set
	 */
	public void setIfBearingTotalValueAlarm(int ifBearingTotalValueAlarm) {
		this.ifBearingTotalValueAlarm = ifBearingTotalValueAlarm;
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
