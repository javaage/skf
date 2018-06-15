package com.skf.management.entity;

import com.skf.management.model.BearingModel;
import com.skf.management.model.GearModel;

public class GearEntity {
	
	private String code;
	private String img;
	private String name;
	private String type;
	private String modelNumber;
	private String manufacture;
	private String description;
	private Float meshingFrequency;
	private Float bpfo;
	private Float bpfi;
	private Float bsf;
	private Float fif;
	private String imgCode;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}	
	public Float getBpfo() {
		return bpfo;
	}
	public void setBpfo(Float bpfo) {
		this.bpfo = bpfo;
	}
	public Float getBpfi() {
		return bpfi;
	}
	public void setBpfi(Float bpfi) {
		this.bpfi = bpfi;
	}
	public Float getBsf() {
		return bsf;
	}
	public void setBsf(Float bsf) {
		this.bsf = bsf;
	}
	public Float getFif() {
		return fif;
	}
	public void setFif(Float fif) {
		this.fif = fif;
	}
	public Float getMeshingFrequency() {
		return meshingFrequency;
	}
	public void setMeshingFrequency(Float meshingFrequency) {
		this.meshingFrequency = meshingFrequency;
	}
	
	public static GearModel newModelFormEntity(GearEntity entity){
		GearModel gearModel = new GearModel();
		gearModel.setCode(entity.getCode());
		gearModel.setDescription(entity.getDescription());
		gearModel.setImageCode(entity.getImgCode());
		gearModel.setManufacture(entity.getManufacture());
		gearModel.setMeshingFrequency(entity.getMeshingFrequency());
		gearModel.setModelNumber(entity.getModelNumber());
		
		return gearModel;
	}
	
	public static BearingModel newBearingModelFormEntity(GearEntity entity){
		BearingModel bearModel = new BearingModel();
		bearModel.setBpfi(entity.getBpfi());
		bearModel.setBpfo(entity.getBpfo());
		bearModel.setBsf(entity.bsf);
		bearModel.setCode(bearModel.getCode());
		bearModel.setDescription(entity.getDescription());
		bearModel.setFtf(entity.getFif());
		bearModel.setImageCode(entity.getImgCode());
		bearModel.setManufacture(entity.getManufacture());
		bearModel.setModelNumber(entity.getModelNumber());
		
		return bearModel;
	}
	
	
}
	
