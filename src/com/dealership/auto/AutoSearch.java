package com.dealership.auto;

import java.lang.reflect.Field;

public class AutoSearch {

	public String make;
	public String model;
	public int minYear;
	public int maxMiles;
	public double minPrice;
	public double maxPrice;
	public boolean newCarsOnly;
	public String transmission;
	public String engine;
	public String bodyType;
	
	public AutoSearch() {
		
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMinYear() {
		return minYear;
	}

	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	public int getMaxMiles() {
		return maxMiles;
	}

	public void setMaxMiles(int maxMiles) {
		this.maxMiles = maxMiles;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public boolean isNewCarsOnly() {
		return newCarsOnly;
	}

	public void setNewCarsOnly(boolean newCarsOnly) {
		this.newCarsOnly = newCarsOnly;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	
	
	
	
	
}
