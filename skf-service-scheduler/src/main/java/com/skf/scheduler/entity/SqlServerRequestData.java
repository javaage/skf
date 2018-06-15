package com.skf.scheduler.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author P0088589
 *
 */
public class SqlServerRequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7068930163233403115L;
	private String schema;
	private int idMeasurement;
	private int idNode;
	private Date measDate;
	private int storageReason;
	private float sampleRate;
	private int spectraScaling;
	private int timesignalLines;
	private float endFreq;
	private int spectraLines;
	private float scaleFactor;
	private byte[] rawData;

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
	 * @return the idMeasurement
	 */
	public int getIdMeasurement() {
		return idMeasurement;
	}

	/**
	 * @param idMeasurement
	 *            the idMeasurement to set
	 */
	public void setIdMeasurement(int idMeasurement) {
		this.idMeasurement = idMeasurement;
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
	 * @return the measDate
	 */
	public Date getMeasDate() {
		return measDate;
	}

	/**
	 * @param measDate
	 *            the measDate to set
	 */
	public void setMeasDate(Date measDate) {
		this.measDate = measDate;
	}

	/**
	 * @return the storageReason
	 */
	public int getStorageReason() {
		return storageReason;
	}

	/**
	 * @param storageReason
	 *            the storageReason to set
	 */
	public void setStorageReason(int storageReason) {
		this.storageReason = storageReason;
	}

	/**
	 * @return the sampleRate
	 */
	public float getSampleRate() {
		return sampleRate;
	}

	/**
	 * @param sampleRate
	 *            the sampleRate to set
	 */
	public void setSampleRate(float sampleRate) {
		this.sampleRate = sampleRate;
	}

	/**
	 * @return the spectraScaling
	 */
	public int getSpectraScaling() {
		return spectraScaling;
	}

	/**
	 * @param spectraScaling
	 *            the spectraScaling to set
	 */
	public void setSpectraScaling(int spectraScaling) {
		this.spectraScaling = spectraScaling;
	}

	/**
	 * @return the timesignalLines
	 */
	public int getTimesignalLines() {
		return timesignalLines;
	}

	/**
	 * @param timesignalLines
	 *            the timesignalLines to set
	 */
	public void setTimesignalLines(int timesignalLines) {
		this.timesignalLines = timesignalLines;
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
	 * @return the spectraLines
	 */
	public int getSpectraLines() {
		return spectraLines;
	}

	/**
	 * @param spectraLines
	 *            the spectraLines to set
	 */
	public void setSpectraLines(int spectraLines) {
		this.spectraLines = spectraLines;
	}

	/**
	 * @return the scaleFactor
	 */
	public float getScaleFactor() {
		return scaleFactor;
	}

	/**
	 * @param scaleFactor
	 *            the scaleFactor to set
	 */
	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SqlServerRequestData [schema=" + schema + ", idMeasurement=" + idMeasurement + ", idNode=" + idNode
				+ ", measDate=" + measDate + ", storageReason=" + storageReason + ", sampleRate=" + sampleRate
				+ ", spectraScaling=" + spectraScaling + ", timesignalLines=" + timesignalLines + ", endFreq=" + endFreq
				+ ", spectraLines=" + spectraLines + ", scaleFactor=" + scaleFactor + ", rawData="
				+ Arrays.toString(rawData) + "]";
	}

}
