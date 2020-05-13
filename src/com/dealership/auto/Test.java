package com.dealership.auto;
import java.util.ArrayList;

import com.dealership.auto.Automobile;
import com.dealership.data.Database;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		private String make;
		private String model;
		private String purchaseDate;
		private String year;
		private double price;
		private int mileage;
		private String description;
		private ArrayList<String> pictures;
		private String vin;
		private String transmission;
		private String bodyType;
		private String engine;
		private boolean newVehicle;
		*/

		Automobile auto = new Automobile("honda", "civic", "1995", "VJKUY23478JKJGJ378");
		auto.setPurchaseDate("");
		auto.setPrice(34500);
		auto.setMileage(150345);
		auto.setDescription("Big Farty Car");
		auto.setTransmission("automatic");
		auto.setEngine("gasonline");
		auto.setBodyType("coupe");
		auto.setNewVehicle(true);
		
		ArrayList<String> newList = Database.checkNull(auto.getPictures());
		
		auto.save();
		
	}

}
