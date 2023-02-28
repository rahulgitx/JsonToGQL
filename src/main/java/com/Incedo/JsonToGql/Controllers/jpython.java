package com.Incedo.JsonToGql.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class jpython {
	
	public static void main(String[] args) throws IOException {
		System.out.println("inside the main function");
		ProcessBuilder pb = new ProcessBuilder("python", "D:\\Java Training\\JsonToGql\\JsonToGql\\src\\main\\java\\com\\Incedo\\JsonToGql\\Controllers\\abc.py");
		Process p = pb.start();
		// Get the output of the process
		InputStream stdout = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		String line;
		while ((line = reader.readLine()) != null) {
		    System.out.println(line);
		}	
	}

}
