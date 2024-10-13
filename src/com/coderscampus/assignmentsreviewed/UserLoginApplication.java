package com.coderscampus.assignmentsreviewed;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		userService.loadUsers("data.txt");
		
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		boolean loggedIn = false;
		
		while (attempts < 5 && !loggedIn) {
			System.out.print("Enter your email: ");
			String username = scanner.nextLine();
			System.out.print("Enter your password: ");
			String password = scanner.nextLine();
			
			loggedIn = userService.validateLogin(username, password);
			
			if (!loggedIn) {
				System.out.println("Invalid login, please try again");
				attempts++;
			}
		}
		
		if (!loggedIn) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		
		scanner.close();
		
	}

}
