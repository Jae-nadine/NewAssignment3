package com.coderscampus.assignmentsreviewed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	private List<User> users = new ArrayList<>();
	
	public void loadUsers(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(",");
				users.add(new User(userData[0], userData[1], userData[2]));
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public boolean validateLogin(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("Welcome: " + user.getName());
				return true;
			}
		}
		return false;
	}

}
