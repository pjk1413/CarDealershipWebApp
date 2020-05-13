package com.dealership.global;

import java.io.File;
import java.net.URL;

public class Constant {
	public static final String webName = "BigRedCars";
	
	//public static final String signupCaption1 = 

	public static int isNull(String str, int defaultValue) {
		
		if (null == str) {
			return defaultValue;
		} else {
			return Integer.parseInt(str);
		}
		
	}
	
	
	
	public static double isNull(String str, double defaultValue) {
		
		if (null == str || str.isEmpty()) {
			return defaultValue;
		} else {
			return Double.parseDouble(str);
		}
		
	}
	
	public static String isNull(String str) {
		if (null == str) {
			return "";
		} else {
			return str;
		}
	}
}
