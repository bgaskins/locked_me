package com.lockedme;

import java.util.Scanner;

public class AppMenus {

	static Scanner scan = new Scanner(System.in);	
		
	public static void displayWelcomeScreen() {
		
		//Welcome screen that displays immediately at run time.
		String userWelcome = String.format("+++++++++++++++++++++++++++++++++++++++++++++++++\n"
		+ "+      Hi there! Welcome to LockedMe.com        +\n"
		+ "+       Let us help you with your files!        +\n"
		+ "+    This app was developed by Bryan Gaskins    +\n"
		+ "+             Version 1.0 / 2.26.22             +\n"
		+ "+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		//A user introduction to the various features the application can do for them.
		String appFeatures = String.format("You can use the LockedMe.com app to:\n"
		+ "~ Access all file names stored in a designated folder\n"
		+ "~ Search, add, and delete your stored files\n");
		
		System.out.println(userWelcome);
		System.out.println(appFeatures);
	
	}
	
	public static void displayMenu() throws Exception {
		
		//The main/first menu that leads user to viewing files, file operations 
		//along with the ability to exit the application.
		String menu = String.format("+++++++++++++++++++ Main Menu +++++++++++++++++++\n"
		+ "1. VIEW all current files in ascending order\n"
		+ "2. SEARCH, ADD, or DELETE a file\n"
		+ "3. EXIT the LockedMe.com App\n"
		+ "+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println(menu);
		
		fetchUserMenuOption();
	
	}
	
	public static void fetchUserMenuOption() throws Exception {
		
		//User input for main menu options.
		
		try {
			System.out.println("Please SELECT and ENTER a number from the menu options:\n");
			String option = scan.nextLine();
			switch (option) {
				case "1": 
						FileOperations.displayFilesInAscendingOrder();
						break;
				case "2":
						FileOperations.displayMenuFileOptions();
						break;
				case "3":
						System.out.println("You are now leaving LockedMe.com. Have a great day! :)\n");
						System.exit(0);
						break;
				default: 
						System.out.println("Selected option is invalid. :( Try again.\n");
						displayMenu();
				}
			
		} catch (Exception e) {
			displayMenu();
			fetchUserMenuOption();
		}
	}
}