package com.skf.alarm.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author P0088589
 *
 */
public class DropDownList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6124755967664699830L;
	private List<Node> device;
	private List<Leaf> status;

	/**
	 * @return the device
	 */
	public List<Node> getDevice() {
		return device;
	}

	/**
	 * @param device
	 *            the device to set
	 */
	public void setDevice(List<Node> device) {
		this.device = device;
	}

	/**
	 * @return the status
	 */
	public List<Leaf> getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(List<Leaf> status) {
		this.status = status;
	}

}