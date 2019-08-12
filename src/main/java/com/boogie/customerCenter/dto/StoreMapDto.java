package com.boogie.customerCenter.dto;

public class StoreMapDto {
	private int location_code;
	private String location_name;
	
	private String store_name;
	private Float lat;
	private Float longt;
	private String store_addr;
	private String store_phone;
	
	public StoreMapDto() {}

	public int getLocation_code() {
		return location_code;
	}

	public void setLocation_code(int location_code) {
		this.location_code = location_code;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLongt() {
		return longt;
	}

	public void setLongt(Float longt) {
		this.longt = longt;
	}

	public String getStore_addr() {
		return store_addr;
	}

	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	@Override
	public String toString() {
		return "CustomerCenterDto [location_code=" + location_code + ", location_name=" + location_name
				+ ", store_name=" + store_name + ", lat=" + lat + ", longt=" + longt + ", store_addr=" + store_addr
				+ ", store_phone=" + store_phone + "]";
	}
	
}
