package com.bki.tlv.ipop;

import java.util.LinkedHashMap;

public class TlvCrtIPOP implements TankIPOP {
	// common objects -------------->
	
	private CustomerDtails custDtls;
	private com.bki.tlv.cyv.elpt.CyVertElptIPOP elpt;
	private String tankLocation;
	private String tankId;
	
	// out put objects
	private double capacity;
	private LinkedHashMap<Integer,String> volData;
	
	
	
	public CustomerDtails getCustDtls() {
		return custDtls;
	}
	public void setCustDtls(CustomerDtails custDtls) {
		this.custDtls = custDtls;
	}
	public String getTankLocation() {
		return tankLocation;
	}
	public void setTankLocation(String tankLocation) {
		this.tankLocation = tankLocation;
	}
	public String getTankId() {
		return tankId;
	}
	public void setTankId(String tankId) {
		this.tankId = tankId;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public LinkedHashMap<Integer, String> getVolData() {
		return volData;
	}
	public void setVolData(LinkedHashMap<Integer, String> volData) {
		this.volData = volData;
	}
	public com.bki.tlv.cyv.elpt.CyVertElptIPOP getElpt() {
		return elpt;
	}
	public void setElpt(com.bki.tlv.cyv.elpt.CyVertElptIPOP elpt) {
		this.elpt = elpt;
	}
	
	

}
