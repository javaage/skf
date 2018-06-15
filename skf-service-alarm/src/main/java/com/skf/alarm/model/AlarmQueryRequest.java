package com.skf.alarm.model;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class AlarmQueryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7778134449227618599L;
	private String sortByRowType;
	private boolean isSortByAsc;
	private int warningType;
	private int currentPageNum;
	private String selectDevice;
	private String selectSensor;
	private String selectStatus;
	private Float startScore;
	private Float endScore;
	private String startTime;
	private String endTime;
	private String userCode;
	private int startLine;
	private int countLine;

	/**
	 * @return the sortByRowType
	 */
	public String getSortByRowType() {
		return sortByRowType;
	}

	/**
	 * @param sortByRowType
	 *            the sortByRowType to set
	 */
	public void setSortByRowType(String sortByRowType) {
		this.sortByRowType = sortByRowType;
	}

	/**
	 * @return the isSortByAsc
	 */
	public boolean isSortByAsc() {
		return isSortByAsc;
	}

	/**
	 * @param isSortByAsc
	 *            the isSortByAsc to set
	 */
	public void setIsSortByAsc(boolean isSortByAsc) {
		this.isSortByAsc = isSortByAsc;
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

	/**
	 * @return the currentPageNum
	 */
	public int getCurrentPageNum() {
		return currentPageNum;
	}

	/**
	 * @param currentPageNum
	 *            the currentPageNum to set
	 */
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	/**
	 * @return the selectDevice
	 */
	public String getSelectDevice() {
		return selectDevice;
	}

	/**
	 * @param selectDevice
	 *            the selectDevice to set
	 */
	public void setSelectDevice(String selectDevice) {
		this.selectDevice = selectDevice;
	}

	/**
	 * @return the selectSensor
	 */
	public String getSelectSensor() {
		return selectSensor;
	}

	/**
	 * @param selectSensor
	 *            the selectSensor to set
	 */
	public void setSelectSensor(String selectSensor) {
		this.selectSensor = selectSensor;
	}

	/**
	 * @return the selectStatus
	 */
	public String getSelectStatus() {
		return selectStatus;
	}

	/**
	 * @param selectStatus
	 *            the selectStatus to set
	 */
	public void setSelectStatus(String selectStatus) {
		this.selectStatus = selectStatus;
	}

	/**
	 * @return the startScore
	 */
	public Float getStartScore() {
		return startScore;
	}

	/**
	 * @param startScore
	 *            the startScore to set
	 */
	public void setStartScore(Float startScore) {
		this.startScore = startScore;
	}

	/**
	 * @return the endScore
	 */
	public Float getEndScore() {
		return endScore;
	}

	/**
	 * @param endScore
	 *            the endScore to set
	 */
	public void setEndScore(Float endScore) {
		this.endScore = endScore;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	/**
	 * @return the startLine
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * @param startLine
	 *            the startLine to set
	 */
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	/**
	 * @return the countLine
	 */
	public int getCountLine() {
		return countLine;
	}

	/**
	 * @param countLine
	 *            the countLine to set
	 */
	public void setCountLine(int countLine) {
		this.countLine = countLine;
	}

}
