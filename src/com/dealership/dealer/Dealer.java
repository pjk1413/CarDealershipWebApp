package com.dealership.dealer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.dealership.auto.Automobile;
import com.dealership.data.Database;
import com.dealership.global.Transaction;

public class Dealer {
	
	//public static final String path = "c:/users/pjk14/desktop/tempDealer/";
	public static final String path = "Java/Week2/Web/car_dealership1.0/Data/Dealer/";
	private static final String d = ";";
	private static final String l = ":";
	private String firstName;
	private String lastName;
	private String companyName;
	private String email;
	private String password;
	private ArrayList<String> transactionHistory;
	private ArrayList<String> inventory;
	
	/*
	 * ------------------------------- Constructors -------------------------------
	 */

	public Dealer(String firstName, String lastName, String email, String password, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.companyName = company;
		this.inventory = new ArrayList<String>();
		this.transactionHistory = new ArrayList<String>();
	}
	
	
	/**
	 * Only to be used when loading and unloading dealer objects
	 */
	public Dealer() {
		this.transactionHistory = new ArrayList<String>();
		this.inventory = new ArrayList<String>();
	};
	

	/*
	 * ------------------------------ Methods --------------------------------------
	 */
	
	/**
	 * Puts the dealer object into a semi-colon spereated string
	 */
	public String toString() {
		
		String transactionHistoryString = "";
		String inventoryString = "";
		
		for (String transaction : this.transactionHistory) {
			transactionHistoryString += transaction + ";";
		}
		
		for (String automobile : this.inventory) {
			inventoryString += automobile + ";";
		}
		
		String fileContent = this.firstName + d + this.lastName + d + this.companyName + d + this.email + d + this.password + l + 
				transactionHistoryString + l + inventoryString;
		
		return fileContent;
	}
	
	
	
	/**
	 * Saves a string of data to a text file to be reloaded and parsed later
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
		
			e.printStackTrace();
		}
	}

	
	/**
	 * Loads a dealer object when given a string id of a dealer object
	 */
	public static Dealer load(String email) {

		File directory = new File(path);
		String[] files = directory.list();
		
		Dealer dealer = new Dealer();
		
			try {
				for (String file : files) {
					if (file.contains(email)) {
						File f = new File(path + file);
						
						Scanner scanner = new Scanner(f);
							
						String stringToParse = "";
							
						while (scanner.hasNext()) {
							stringToParse += scanner.next();
								
						}
						dealer = Dealer.parse(stringToParse); 
							
					}
				}
			} catch (Exception e) {
				e.getMessage();
			}	
		return dealer;
	}
	
	
	/**
	 * Deletes a dealer object from the database when given a string id of a dealer object
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
	public static void update(Dealer newDealer) {
		ArrayList<Dealer> dealerList = loadAll();

		for (Dealer dealer : dealerList) {
			if (dealer.getEmail().contentEquals(newDealer.getEmail()) ) {
				delete(dealer.getEmail());
				newDealer.save();
			}
		}
	}
	
	
	/**
	 * Loads all dealer objects into an arrayList from the database
	 * @return ArrayList of dealers
	 */
	public static ArrayList<Dealer> loadAll() {
		ArrayList<Dealer> dealerList = new ArrayList<Dealer>();
		
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
				
				Dealer dealer = parse(parsableString);
				dealerList.add(dealer);
				
			} 
		}catch (NullPointerException|FileNotFoundException e) {
			// TODO: handle exception
			e.getMessage();
		}

		return dealerList;
	}
	
	public void removeInventory(String vin) {
		this.inventory.remove(vin);
	}
	
	public void removeTransaction(String vin) {
		this.transactionHistory.remove(vin);
	}
	
	public void addTransaction(String vin) {
		this.transactionHistory = Database.checkNull(this.transactionHistory);
		this.transactionHistory.add(vin);
	}
	
	public void addInventory(String vin) {
		this.inventory = Database.checkNull(this.inventory);
		this.inventory.add(vin);
	}
	
	/**
	 * Parse a string of data and return a dealer object
	 */
	protected static Dealer parse(String str) {
		//String fileContent = this.id + d + this.firstName + d + this.lastName + d + this.companyName + d + this.email + d + this.password + "|\n" + 
		//	transactionHistoryString + "|\n" + inventoryString;
		
		String[] s = null;
		String[] th = null;
		String[] i = null;

		try {
			s = str.split(l)[0].split(d);
			th = str.split(l)[1].split(d);
			i = str.split(l)[2].split(d);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		Dealer dealer = new Dealer();
		dealer.firstName = s[0];
		dealer.lastName = s[1];
		dealer.companyName = s[2];
		dealer.email = s[3];
		dealer.password = s[4];
		
		dealer.transactionHistory = Database.toArrayList(Database.checkNull(th));
		dealer.inventory = Database.toArrayList(Database.checkNull(i));

		return dealer;
	}
	
	
	public void sellAutomobile(String vin) {
		this.removeInventory(vin);
		this.addTransaction(vin);
	}
	/*
	 * ------------------------- Getters and Setters -----------------------------------
	 */
	
	
	
	public String[] getInventoryAsArray() {
		String[] autoList = new String[this.inventory.size()];
		
		for (int i = 0; i < autoList.length; i++) {
			autoList[i] = this.inventory.get(i);
		}
		
		return autoList;
	}
	
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public ArrayList<String> getTransactionHistory() {
		if (transactionHistory.isEmpty() || transactionHistory.equals(null)) {
			this.transactionHistory = new ArrayList<String>();
		}
		return transactionHistory;
	}
	public void setTransactionHistory(ArrayList<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public ArrayList<String> getInventory() {
		if (null == this.inventory) {
			this.inventory = new ArrayList<String>();
		}
		return inventory;
	}
	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}


	
	
	
	
	
	
	
	
}
