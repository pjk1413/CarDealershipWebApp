package com.dealership.global;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public static String addressString(Address a) {
		return a.street + ";" + a.city + ";" + a.state + ";" + a.zipcode;
	}
	
	public static Address parseAddress(String str) {
		Address address = new Address();
		
		String[] adStr = str.split(";");
		
		address.street = adStr[0];
		address.city = adStr[1];
		address.state = adStr[2];
		address.zipcode = adStr[3];
		
		return address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
