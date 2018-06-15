/**
 * 
 */
package com.skf.alarm.model;

import java.util.List;

/**
 * @author P0088589
 *
 */
public class Node extends Leaf {

	/**
	 * 
	 */
	private static final long serialVersionUID = -282788113666576019L;
	private List<Leaf> data;

	public Node() {
	}

	public Node(String id, String name, List<Leaf> data) {
		this.id = id;
		this.name = name;
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public List<Leaf> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<Leaf> data) {
		this.data = data;
	}

}
