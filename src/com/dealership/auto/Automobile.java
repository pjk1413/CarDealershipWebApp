package com.dealership.auto;


import com.dealership.data.Database;
import com.dealership.dealer.Dealer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Automobile extends Database {
	
	//private static final String path = "Java/Week2/Web/car_dealership1.0/Data/Automobile/";
	private static final String path = "c:/users/pjk14/desktop/tempAuto/";
	private static final String d = ";";
	private static final String l = "#";
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
	
	
	
	/*
	 * ----------------------- Constructors ----------------------------
	 */
	
	/**
	 * Basic constructor
	 */
	public Automobile() {
		this.purchaseDate = "NA";
		this.pictures = new ArrayList<String>();
	}
	
	
	/**
	 * Constructor used to make a new automobile, not to be used otherwise
	 * @param make
	 * @param model
	 * @param year
	 * @param vin
	 */
	public Automobile(String make, String model, String year, String vin) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.vin = vin;
		this.purchaseDate = "NA";
		this.newVehicle = false;
	}
	
	
	
	/*
	 * ------------------------- Methods ----------------------------------------- 
	 */
	
	/**
	 * returns a list of autmobiles after passing in a search object
	 * @param search
	 * @return
	 */
	public static ArrayList<Automobile> search(AutoSearch search) {
		//Pass in an search object, find fields that are not empty and use those to help currate your search
		//hierarchy - price make model year miles bodytype engine transmission newcarsonly
		
		ArrayList<Automobile> searchList = loadAll();
		TreeMap<Integer, Automobile> returnList = new TreeMap <Integer, Automobile>();
		
		
		for (Automobile a : searchList) {
			int rating = 0;
			
			if (a.make.contains(search.make) && a.model.contains(search.model)) {
				rating++;
				if (a.price < search.maxPrice && a.price > search.minPrice) {
					rating++;
					if (a.mileage < search.maxMiles && Integer.parseInt(a.year) <= search.minYear) {
						rating++;
						if (a.bodyType.equals(search.bodyType)) {
							rating++;
							if (a.engine.equals(search.engine) && a.transmission.equals(search.transmission)) {
								rating++;
								if (search.newCarsOnly) {
									rating += 10;
								}
							}
						}
					}
				}
			}
			returnList.put(rating, a);

		}
		ArrayList<Automobile> finalList = new ArrayList<>(returnList.values());
		return finalList;
		
	}
	
	
	/**
	 * To string method prepares auto object for saving
	 */
	public String toString() {
		String pictureList = "";
		
		for (String str : Database.checkNull(pictures)) {
			pictureList += str + d;
		}
		
		String fileContent = this.make + d + this.model + d + this.purchaseDate + d + this.year + d + this.price + d + this.mileage + d +
				this.description + d + this.vin + d + this.transmission + d + this.bodyType + d + this.engine + d + this.newVehicle + l + pictureList;
		
		return fileContent;
	}
	
	
	/**
	 * Saves an automobile object to the database (text file), make sure the object has all properties loaded prior to saving
	 */
	public void save() {
		try {
			
			File file = new File(path + this.vin + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(this.toString());
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Loads an individual automobile object from the database based on the id
	 */
	public static Automobile load(String vin) {

		File directory = new File(path);
		String[] files = directory.list();

		Automobile automobile = new Automobile();

		try {
			for (String file : files) {
				if (file.contains(vin)) {

					File f = new File(path + file);
					Scanner scanner = new Scanner(f);
					
					String stringToParse = "";
					
					while (scanner.hasNext()) {
						stringToParse += scanner.next();
					}
					
					automobile = parse(stringToParse); 			
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return automobile;
	}
	
	
	/**
	 * Deletes the object by id from the database
	 */
	public static void delete(String vin) {

		File directory = new File(path);
		String[] files = directory.list();

		for (String file : files) {
	
			if (file.contains(vin)) {
				File deleteFile = new File(path + file);
				deleteFile.delete();
			}
		}
	}
	
	
	
	/**
	 * Updates the current automobile object identifying it by using a string passed in
	 */
	public static void update(Automobile newAutomobile) {

		ArrayList<Automobile> autoList = loadAll();
		
		for (Automobile automobile : autoList) {
			if (automobile.getVin().contentEquals(newAutomobile.getVin())) {
				delete(automobile.getVin());
				newAutomobile.save();
			}
		}
	}
	
	
	/**
	 * Loads all automobile objects from the database into an array to be used later
	 */
	public static ArrayList<Automobile> loadAll() {
		ArrayList<Automobile> autoList = new ArrayList<Automobile>();
		
		File directory = new File(path);
		String[] files = directory.list();
		
		if (files.length < 1 || files == null) {
			return null;
		}
		
		try {
			for (String file : files) {
				File f = new File(path + file);
				Scanner scanner = new Scanner(f);
				
				String parsableString = "";
				
				while (scanner.hasNextLine()) {
					
					parsableString += scanner.nextLine();
				}
				Automobile automobile = parse(parsableString);
				autoList.add(automobile);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return autoList;
	}
	
	
	/**
	 * Parses a string from a automobile text file and brings back an automobile object
	 */
	protected static Automobile parse(String str) {
		
		String[] p = null;
		String[] a = null;
		
		try {
			p = str.split(l)[1].split(d); //list of pictures
			a = str.split(l)[0].split(d); //all of the auto properties
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Automobile automobile = new Automobile();
		automobile.make = a[0];
		automobile.model = a[1];
		automobile.purchaseDate = a[2]; //change to date type (may not be filled out)
		automobile.year = a[3];
		automobile.price = Double.parseDouble(a[4]);
		automobile.mileage = Integer.parseInt(a[5]);
		automobile.description = a[6];
		automobile.vin = a[7];
		automobile.transmission = a[8]; 
		automobile.bodyType = a[9]; 
		automobile.engine = a[10]; 
		automobile.newVehicle = Boolean.parseBoolean(a[11]);
		
		automobile.pictures = toArrayList(Database.checkNull(p));

		return automobile;
	}
	
	
	/**
	 * returns fields to populate drop down boxes in front end
	 * @param type
	 * @return
	 */
	public static ArrayList<String> returnAllUnique(String type) {
		//makes model bodytype transmission engine
		ArrayList<Automobile> autoList = loadAll();
		
		ArrayList<String> types = new ArrayList<String>();
		
		type = type.toLowerCase();
		
		for (Automobile auto: autoList) {
			
			switch (type) {
			case "make":
				if (!types.contains(auto.make)) {
					types.add(auto.make);
				}
				break;
			case "model":
				if (!types.contains(auto.model)) {
					types.add(auto.model);
				}
				break;
			case "bodytype":
				if (!types.contains(auto.bodyType)) {
					types.add(auto.bodyType);
				}
				break;
			case "transmission":
				if (!types.contains(auto.transmission)) {
					types.add(auto.transmission);
				}
				break;
			case "engine":
				if (!types.contains(auto.engine)) {
					types.add(auto.engine);
				}
				break;
			default:
				
			}
		}
		
		return types;
	}
	
	
	/**
	 * Adds a single picture to the picture list for a vehicle
	 * @param pic
	 */
	public void addPicture(String pic) {
		ArrayList<String> tempPictures = Database.checkNull(this.pictures);
		tempPictures.add(pic);
		this.pictures = tempPictures;
	}
	
	
	/**
	 * Sells an automobile by putting the removing from dealer list and creating transaction objects and adding to dealer list
	 * @param date
	 */
	public void sellAutomobile(String date) {
		//Add functionality to remove from appropriate lists
		this.purchaseDate = date;
	}
	

	/*
	 * ***************************************************************************************************************************
	 * ***					GETTERS AND SETTERS								
	 * ***************************************************************************************************************************
	 */
	
	
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
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<String> getPictures() {
		return pictures;
	}
	
	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getTransmission() {
		return transmission;
	}
	
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public String getBodyType() {
		return bodyType;
	}
	
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public boolean isNewVehicle() {
		return newVehicle;
	}

	public void setNewVehicle(boolean newVehicle) {
		this.newVehicle = newVehicle;
	}







	
	
	
	
	
}
