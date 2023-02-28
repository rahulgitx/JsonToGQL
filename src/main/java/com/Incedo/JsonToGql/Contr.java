package com.Incedo.JsonToGql;

import org.springframework.stereotype.Controller;

import com.Incedo.JsonToGql.JsonToGqlApplication;
import com.Incedo.JsonToGql.Entities.Examplee;
import com.Incedo.JsonToGql.Repository.ExRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import com.google.gson.Gson;


@Controller
public class Contr {
	
	@Autowired
	ExRepo exRepo;

	@QueryMapping("getAll")
	public Examplee[] getAAll() {
		
		String fileName = "TempData.json"; // Replace with your file name
        String jsonString ="";
        System.out.println("inside query mapping");
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
        
        return ex;
	}
	
	@MutationMapping("saveData")
	public Examplee[] saveData() {
		System.out.println("safadsf");
		Examplee res[] = getAAll();
		for(Examplee ex:res) {
			exRepo.save(ex);
		}
		
		return res;
	}
}
