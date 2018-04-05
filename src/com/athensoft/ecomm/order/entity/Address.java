package com.athensoft.ecomm.order.entity;

public class Address {
	
	public static String STREET_TYPE_RUE 		= "Rue" ;
	public static String STREET_TYPE_BOUL 		= "Boul" ;
	public static String STREET_TYPE_ANVENUE 	= "Ave" ;
	public static String UNIT_TYPE_APT 			= "Apt" ;
	public static String UNIT_TYPE_SUITE 		= "Suite" ;
	
		
	private String streetNo;
	private String streetType;
	private String streetName;
	private String unitType;
	private String unitNo;
	
	private String city;
	private String province;
	private String country;
	private String postalCode;
	
	
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getUnitNo() {
		return unitNo;
	}
	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
}
