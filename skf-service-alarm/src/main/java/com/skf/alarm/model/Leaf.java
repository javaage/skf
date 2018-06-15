package com.skf.alarm.model;

import java.io.Serializable;

/**
 * @author P0088589
 *
 */
public class Leaf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6111572089663324813L;
	protected String id;
	protected String name;

	public Leaf() {
		this("", "");
	}

	public Leaf(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
