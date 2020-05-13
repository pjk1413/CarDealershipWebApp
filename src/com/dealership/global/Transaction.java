package com.dealership.global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.dealership.auto.Automobile;
import com.dealership.data.Database;
import com.dealership.user.User;

public class Transaction {
	
	private static final String d = ";";
	private String userEmail;
	private String dealerEmail;
	private double price;
	private String automobileVin;
	
	public Transaction() {}
	
	public Transaction(String userEmail, String automobileVin) {
		this.userEmail = userEmail;
		this.automobileVin = automobileVin;
	}
	
	
	/**
	 * Saves a string of data to the database representing a Transaciton object
	 */
	public void save() {
		
		String fileContent = this.userEmail + d + this.dealerEmail + d + this.price + d + this.automobileVin;
		System.out.println("SAVE");
		
		try {
			File file = new File(Database.path_transaction +this.automobileVin + ".txt");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(fileContent);
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Loads a transaction object when given a string id of a transaction object
	 */
	public static Transaction load(String autoVin) {
		//Create a directory List
		File directory = new File(Database.path_transaction);
		String[] files = directory.list();
				
			Transaction transaction = new Transaction();
			
			try {
				for (String file : files) {
					if (file.contains(autoVin)) {
						File f = new File(file);
							
						Scanner scanner = new Scanner(f);
							
						String stringToParse = "";
							
						while (scanner.hasNext()) {
							stringToParse += scanner.next();
								
						}
							
						transaction = transaction.parse(stringToParse); //This could also be a constructor that parses
							
					}
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
				
		return transaction;
	}
	
	
	/**
	 * Deletes a dealer object from the database when given a string id of a dealer object
	 */
	public static void delete(String autoVin) {
		File directory = new File(Database.path_transaction);
		String[] files = directory.list();
		
		for (String file : files) {
			if (file.contains(autoVin)) {
				File deleteFile = new File(file);
				deleteFile.delete();
			}
		}
		
	}

	
	/**
	 * Updates a dealer object in the database
	 */

	public static void update(Transaction transaction) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transactionList = loadAll();
		
		for (Transaction t : transactionList) {
			if (transaction.automobileVin.contentEquals(t.getAutomobileVin())) {
				delete(t.getAutomobileVin());
				transaction.save();
			}
		}
	}
	
	
	/**
	 * Loads all dealer objects into an arrayList from the database
	 * @return ArrayList of dealers
	 */
	public static ArrayList<Transaction> loadAll() {
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		File directory = new File(Database.path_transaction);
		String[] files = directory.list();
		
		if (null == files || files.length < 1) {
			return null;
		}
		
		try {
			for (String file : files) {
				
				File f = new File(Database.path_transaction + file);
				Scanner scanner = new Scanner(f);
				
				String parsableString = "";
				
				while (scanner.hasNext()) {
					
					parsableString += scanner.next();
				}
				
				
				Transaction transaction = parse(parsableString);
				transactionList.add(transaction);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		
		return transactionList;
	}

	
	/**
	 * Parse a string of data and return a dealer object
	 */
	protected static Transaction parse(String str) {
		//String fileContent = this.id + d + this.userId + d + this.price + d + this.paid + d + this.balance + d + this.automobileId;
		String[] s = str.split(d);

		Transaction transaction = new Transaction();
		transaction.userEmail = s[0];
		transaction.dealerEmail = s[1];
		transaction.price = Double.parseDouble(s[2]);
		transaction.automobileVin = s[3];
		
		return transaction;
	}
	
	
	
	/*
	 * Gettes and Setters
	 */
	


	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getAutomobileVin() {
		return automobileVin;
	}

	public void setAutomobileVin(String automobileVin) {
		this.automobileVin = automobileVin;
	}
	
	
	
}
