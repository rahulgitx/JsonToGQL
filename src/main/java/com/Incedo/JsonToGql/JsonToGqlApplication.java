package com.Incedo.JsonToGql;

import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;

import com.Incedo.JsonToGql.JsonToGqlApplication;
import com.Incedo.JsonToGql.Entities.Examplee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.google.gson.Gson;
@SpringBootApplication
public class JsonToGqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JsonToGqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("inside query mapping");
		String fileName = "TempData.json"; // Replace with your file name
        String jsonString ="";
        try (InputStream inputStream = JsonToGqlApplication.class.getResourceAsStream("/" + fileName);
             Scanner scanner = new Scanner(inputStream)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            jsonString = sb.toString();
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Examplee ex[] = gson.fromJson(jsonString, Examplee[].class);
        for(Examplee example:ex) {
            System.out.println(example.getName());
            System.out.println(example.getId());
            System.out.println(example.getEmail());
        }
        
//        return ex;
	}

}
