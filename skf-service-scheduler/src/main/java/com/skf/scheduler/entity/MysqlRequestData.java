package com.skf.scheduler.entity;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class MysqlRequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5485152617371492858L;
	private String componentCode;
	private Float freqRotation;
	private int freqRotationType;
	private String schema;
	private int idNode;
	private float bpfi;
	private float bpfo;
	private float bsf;
	private float ftf;
	private float machineFreq;
	private float dangerLevel;
	private float totalValueDangerLevel;
	private float defectFreqMonitoringRange;
	private int componentType;

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
	 * @return the freqRotation
	 */
	public Float getFreqRotation() {
		return freqRotation;
	}

	/**
	 * @param freqRotation
	 *            the freqRotation to set
	 */
	public void setFreqRotation(Float freqRotation) {
		this.freqRotation = freqRotation;
	}

	/**
	 * @return the freqRotationType
	 */
	public int getFreqRotationType() {
		return freqRotationType;
	}

	/**
	 * @param freqRotationType
	 *            the freqRotationType to set
	 */
	public void setFreqRotationType(int freqRotationType) {
		this.freqRotationType = freqRotationType;
	}

	/**
	 * @return the schema
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * @param schema
	 *            the schema to set
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}

	/**
	 * @return the idNode
	 */
	public int getIdNode() {
		return idNode;
	}

	/**
	 * @param idNode
	 *            the idNode to set
	 */
	public void setIdNode(int idNode) {
		this.idNode = idNode;
	}

	/**
	 * @return the bpfi
	 */
	public float getBpfi() {
		return bpfi;
	}

	/**
	 * @param bpfi
	 *            the bpfi to set
	 */
	public void setBpfi(float bpfi) {
		this.bpfi = bpfi;
	}

	/**
	 * @return the bpfo
	 */
	public float getBpfo() {
		return bpfo;
	}

	/**
	 * @param bpfo
	 *            the bpfo to set
	 */
	public void setBpfo(float bpfo) {
		this.bpfo = bpfo;
	}

	/**
	 * @return the bsf
	 */
	public float getBsf() {
		return bsf;
	}

	/**
	 * @param bsf
	 *            the bsf to set
	 */
	public void setBsf(float bsf) {
		this.bsf = bsf;
	}

	/**
	 * @return the ftf
	 */
	public float getFtf() {
		return ftf;
	}

	/**
	 * @param ftf
	 *            the ftf to set
	 */
	public void setFtf(float ftf) {
		this.ftf = ftf;
	}

	/**
	 * @return the machineFreq
	 */
	public float getMachineFreq() {
		return machineFreq;
	}

	/**
	 * @param machineFreq
	 *            the machineFreq to set
	 */
	public void setMachineFreq(float machineFreq) {
		this.machineFreq = machineFreq;
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
	 * @return the defectFreqMonitoringRange
	 */
	public float getDefectFreqMonitoringRange() {
		return defectFreqMonitoringRange;
	}

	/**
	 * @param defectFreqMonitoringRange
	 *            the defectFreqMonitoringRange to set
	 */
	public void setDefectFreqMonitoringRange(float defectFreqMonitoringRange) {
		this.defectFreqMonitoringRange = defectFreqMonitoringRange;
	}

	/**
	 * @return the componentType
	 */
	public int getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType
	 *            the componentType to set
	 */
	public void setComponentType(int componentType) {
		this.componentType = componentType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MysqlRequestData [componentCode=" + componentCode + ", freqRotation=" + freqRotation
				+ ", freqRotationType=" + freqRotationType + ", schema=" + schema + ", idNode=" + idNode + ", bpfi="
				+ bpfi + ", bpfo=" + bpfo + ", bsf=" + bsf + ", ftf=" + ftf + ", machineFreq=" + machineFreq
				+ ", dangerLevel=" + dangerLevel + ", totalValueDangerLevel=" + totalValueDangerLevel
				+ ", defectFreqMonitoringRange=" + defectFreqMonitoringRange + ", componentType=" + componentType + "]";
	}

}
