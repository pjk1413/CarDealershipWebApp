package com.dealership.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dealership.global.Transaction;

public class Admin {

	public static final String path = "c:/users/pjk14/desktop/tempAdmin/";
	//public static final String path = "../Data/Admin/";
	private static final String d = ";";
	public static String email = "admin@admin.com";
	public static String password = "12345";

	
	public Admin() {}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
	
