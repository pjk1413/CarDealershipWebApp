package com.dealership.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import com.dealership.auto.Automobile;
import com.dealership.data.Database;
import com.dealership.dealer.Dealer;
import com.dealership.global.Address;
import com.dealership.global.Transaction;


//Represents a person searching for a car
public class User {
	
	//private static final String path = "Java/Week2/Web/car_dealership1.0/Data/User/";
	private static final String path = "c:/users/pjk14/desktop/tempUser/";
	private static final String d = ";";
	private static final String l = ":";
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String cart;
	private ArrayList<String> favoriteList; 
	private ArrayList<String> purchaseHistory; 
	private Address address;
	
	/*
	 * ---------------------- Constructors -------------------------------------
	 */
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.favoriteList = new ArrayList<String>();
		this.purchaseHistory = new ArrayList<String>();
		this.cart = null;
	}
	
	

	
	/*
	 * --------------------------------- Methods --------------------------------------------
	 */
	
	/**
	 * Puts the user object into a semi-colon sperated string
	 */
	public String toString() {
		
		String favoriteListString = "";
		String purchaseHistoryString = "";
		
		for (String string : favoriteList) {
			favoriteListString += string + ";";
		}
		
		for (String string : purchaseHistory) {
			purchaseHistoryString += string + ";";
		}
		
		String fileContent = this.firstName + d + this.lastName + d + this.email + d + this.password + d + this.cart + l + Address.addressString(this.address) + l + 
				favoriteListString +l + purchaseHistoryString;
		
		return fileContent;
	}
	
	/**
	 * Saves an User object to the database (text file), make sure the object has all properties loaded prior to saving
	 */
	public void save() {
		
		try {
			
			File file = new File(path + this.email + ".txt");
			
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
	 * Loads an individual user object from the database based on the id
	 */
	public static User load(String email) {
		//Create a directory List
		File directory = new File(path);
		String[] files = directory.list();
		
		User user = new User();
		
		try {
			for (String file : files) {
				if (file.contains(email)) {
					File f = new File(path + file);

					Scanner scanner = new Scanner(f);
					
					String stringToParse = "";
					
					while (scanner.hasNext()) {
						stringToParse += scanner.next();
						
					}
					user = User.parse(stringToParse);
				}
			}	
		} catch (Exception e) {
			e.getMessage();
		}
		
		return user;
	}
	
	/**
	 * Deletes the file that is associated with the id
	 * @param id
	 */
	public static void delete(String email) {
		File directory = new File(path);
		String[] files = directory.list();
		
		for (String file : files) {
			
			if (file.contains(email)) {
				File deleteFile = new File(path + file);
				deleteFile.delete();
			}
		}	
	}

	
	
	/**
	 * Updates a dealer object in the database
	 */
	public static void update(User newUser) {
		
		ArrayList<User> userList = loadAll();
		
		for (User user : userList) {
			if (user.getEmail().contentEquals(newUser.getEmail())) {
				delete(user.getEmail());
				newUser.save();
			}
		}
	}

	
	
	/**
	 * Loads all dealer objects into an arrayList from the database
	 * @return ArrayList of dealers
	 */
	public static ArrayList<User> loadAll() {
		ArrayList<User> list = new ArrayList<User>();
		
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
				
				while (scanner.hasNext()) {
					
					parsableString += scanner.next();
				}
				
				User user = parse(parsableString);
				list.add(user);
				
			}
		} catch (NullPointerException|FileNotFoundException e ) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return list;
	}

	/**
	 * Parse a string of data and return a user object
	 */
	protected static User parse(String str) {
		
		String[] s = null;
		String a = null;
		String[] f = null;
		String[] p = null;
		
		try {
			s = str.split(l)[0].split(d);
			a = str.split(l)[1];
			f = str.split(l)[2].split(d);
			p = str.split(l)[3].split(d);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		}
		
		User user = new User();
		
		user.firstName = s[0];
		user.lastName = s[1];
		user.email = s[2];
		user.password = s[3];
		user.cart = s[4];
		user.address = Address.parseAddress(a);
		
		user.favoriteList = Database.toArrayList(Database.checkNull(f));
		user.purchaseHistory = Database.toArrayList(Database.checkNull(p));

		return user;
	}
	
	
	
	/*
	 * --------------------------- Getters and Setters ---------------------------------------
	 */
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<String> getFavoriteList() {
		return favoriteList;
	}
	public void setFavoriteList(ArrayList<String> favoriteList) {
		this.favoriteList = favoriteList;
	}
	public ArrayList<String> getPurchaseHistory() {
		return purchaseHistory;
	}
	public void setPurchaseHistory(ArrayList<String> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	
	
	//Notes
	
	/*
	 * Vehicle inventory, new and used
	 * 
	 */
}
