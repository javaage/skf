package com.skf.management.join;

import java.util.ArrayList;
import java.util.List;

import com.skf.management.model.CustomerModel;
import com.skf.management.model.EquipmentModel;

public class CustomerJoin extends CustomerModel {
	private List<EquipmentModel> listEquipmentModel = new ArrayList<EquipmentModel>();

	public List<EquipmentModel> getListEquipmentModel() {
		return listEquipmentModel;
	}

	public void setListEquipmentModel(List<EquipmentModel> listEquipmentModel) {
		this.listEquipmentModel = listEquipmentModel;
	}
	
	public void setCustomerModel(CustomerModel customerModel){
		this.setAddress(customerModel.getAddress());
		this.setCity(customerModel.getCity());
		this.setCode(customerModel.getCode());
		this.setCountry(customerModel.getCountry());
		this.setImg(customerModel.getImg());
		this.setIntroduction(customerModel.getIntroduction());
		this.setName(customerModel.getName());
		this.setState(customerModel.getState());
		this.setUrl(customerModel.getUrl());
		this.setOemCode(customerModel.getOemCode());
	}
}
