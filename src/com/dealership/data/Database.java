package com.dealership.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import com.dealership.auto.Automobile;
import com.dealership.global.Address;
import com.dealership.user.User;

public abstract class Database {
	
	
	public static ArrayList<String> checkNull(ArrayList<String> list) {
		
		if (list == null) {		
			return new ArrayList<String>() {};
		} else {
			return list;
		}
		
	}
	
	public static String isNull(String str) {
		if (str.contentEquals("null")) {
			return null;
		} else {
			return str;
		}
	}
	
	
	/**
	 * Checks a string array and returns a valid list
	 * @param list
	 * @return
	 */
	public static String[] checkNull(String[] list) {
		
		if (list == null) {		
			return new String[0];
		} else {
			return list;
		}
		
	}
	
	public static ArrayList<String> toArrayList(String[] arr) {
		ArrayList<String> newArrayList = new ArrayList<String>();
		
		for (String string : arr) {
			newArrayList.add(string);
		}
		
		return newArrayList;
	}
	
	
	
	
	
	
	

	
	
}
