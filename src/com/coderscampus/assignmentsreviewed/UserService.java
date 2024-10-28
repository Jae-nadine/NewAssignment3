package com.coderscampus.assignmentsreviewed;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


public class UserService {
	
	private User[] users;
	private int userCount = 0;
	
	public UserService() {
		users = new User[10];
	}
	
	public void loadUsers(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(",");
				if (userData.length == 3) {
					if (userCount < users.length) {
						users[userCount] = new User(userData[0].trim(), userData[1].trim(), userData[2].trim());
						userCount++;
					}

				} else {
					System.out.println("User array is full, can't add more users.");
					break;
				}
			} 
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public boolean validateLogin(String username, String password) {
		for (User user : users) {
			
			if (user == null) continue;
			
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("Welcome: " + user.getName());
				return true;
			}
		}
		return false;
	}

}
