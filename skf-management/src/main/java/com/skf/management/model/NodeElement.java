package com.skf.management.model;


public class NodeElement extends AlarmModelKey {
	private String treeString;
	private int bottomId;
	public String getTreeString() {
		return treeString;
	}
	public void setTreeString(String treeString) {
		this.treeString = treeString;
	}
	public int getBottomId() {
		return bottomId;
	}
	public void setBottomId(int bottomId) {
		this.bottomId = bottomId;
	}
	
}