package com.skf.management.join;

import java.util.ArrayList;
import java.util.List;

import com.skf.management.model.OEMModel;

public class OEMJoin extends OEMModel {
	private List<CustomerJoin> listCustomerJoin = new ArrayList<CustomerJoin>();

	public List<CustomerJoin> getListCustomerJoin() {
		return listCustomerJoin;
	}

	public void setListCustomerJoin(List<CustomerJoin> listCustomerJoin) {
		this.listCustomerJoin = listCustomerJoin;
	}
	
	public void setOEMModel(OEMModel oemModel){
		this.setAddress(oemModel.getAddress());
		this.setCity(oemModel.getCity());
		this.setCode(oemModel.getCode());
		this.setCountry(oemModel.getCountry());
		this.setImg(oemModel.getImg());
		this.setIntroduction(oemModel.getIntroduction());
		this.setName(oemModel.getName());
		this.setState(oemModel.getState());
		this.setUrl(oemModel.getUrl());
	}
}
