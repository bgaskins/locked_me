package com.lockedme;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FileOperations {
	
		//Set directory for adding, search, deleting and displaying files.
		final static String DIRECTORY = "/Users/bryangaskins/Desktop/LockedMe";
		static Scanner scan = new Scanner(System.in);
		
		public static void makeNewFolderIfNeeded () {
			String newFolderName = "";
			File file = new File (newFolderName);
			
			if (!file.exists()) {
				file.mkdirs();
			}
		}
		
		
		//Menu for main File Operations.
		public static void displayMenuFileOptions() throws Exception {
			
			String menuFileOptions = String.format ("+++ ENTER an option number below to continue: +++\n"
			+ "1. ADD a file to your directory\n"
			+ "2. DELETE a file from the directory\n"
			+ "3. SEARCH the directory for a file\n"
			+ "4. GO BACK to the Main Menu\n"
			+ "5. EXIT LockedMe.com\n"
			+ "+++++++++++++++++++++++++++++++++++++++++++++++++\n");
			System.out.println(menuFileOptions);
			
			fetchFileOperationOption();
		}
		
		
		
		// User input for File Operation Menu.
		public static void fetchFileOperationOption() throws Exception {
			try { 
				System.out.println("Please SELECT and ENTER a number from the menu options:\n");
			String option = scan.nextLine();
			switch (option) {
				case "1": 
						addFile();
						break;
				case "2":
						deleteAFile();
						break;
				case "3": 
						searchAFile();
						break;
				case "4": 
						AppMenus.displayWelcomeScreen();
						AppMenus.displayMenu();
						break;
				case "5":
						System.out.println("You are now leaving LockedMe.com. Have a great day! :)\n");
						System.exit(0);
				default: 
						System.out.println("Selected option is invalid. :( Try again.\n");
						fetchFileOperationOption();
			} 
			
			}catch (Exception e) {
				displayMenuFileOptions();
				
			}

				
	}
		
		
		// Add a file
		public static void addFile() throws Exception {
			 String fileName = "";
			 
			 try {
				System.out.println("ENTER the file name you would like to add:\n"); 
					 fileName = scan.nextLine();
					 
					 File newFile = new File (DIRECTORY + "/" + fileName);
						 
					 newFile.createNewFile();
			 }
			 catch (Exception e) {
				 displayMenuFileOptions();
				 fetchFileOperationOption();
		}
			 	System.out.println("Your file has been added successfuly. :) \n");
			 	displayMenuFileOptions();
			 	fetchFileOperationOption();
		}
		
		
		
		// Delete a file.
		public static  void deleteAFile() throws Exception {
				System.out.println("ENTER the name of the file you want deleted:\n");

				String fileName= scan.nextLine();
				String newFilePath = DIRECTORY + "/" + fileName;
			
			Path path = Paths.get(newFilePath);
			
			if (!Files.exists(path)) {
				System.out.println("Your file could not be found. :( Try again.\n");
				return;
			}
			
			File file = new File(newFilePath);
			if(file.delete()) {
				System.out.println("Your file has been deleted. :) \n");
				displayMenuFileOptions();
			 	fetchFileOperationOption();
				
			} else {
				System.out.println("Your file could not be deleted. :( Check your spelling.\n");
				displayMenuFileOptions();
			 	fetchFileOperationOption();
			}
			displayMenuFileOptions();
		 	fetchFileOperationOption();
		}
		
		
		
		// Search for a file.
		public static void searchAFile() throws Exception {
				System.out.println("ENTER the file name you are searching for:\n");
				String fileName= scan.nextLine();
				String newFilePath = DIRECTORY + "/" + fileName;
			
			Path path = Paths.get(newFilePath);
			
			if (!Files.exists(path)) {
				System.out.println("Your file could not be found. :( \n");
				displayMenuFileOptions();
			 	fetchFileOperationOption();
			}else {
				System.out.println("Success! Your file '" + path.getFileName() + "' has been found. :)\n");
				displayMenuFileOptions();
			 	fetchFileOperationOption();
			}
			displayMenuFileOptions();
		 	fetchFileOperationOption();
		}
		
		
		
		// Display files in ascending order.
		public static void displayFilesInAscendingOrder() throws Exception{
				System.out.println("As you asked--Here are your files (in ascending order):\n");
			File[] files = new File(DIRECTORY).listFiles();
			Set<String> sortedFiles = new TreeSet<>();
			for (File file: files) {
				if (!file.isFile()) {
					continue;
				}
				sortedFiles.add(file.getName());
			}
			sortedFiles.forEach(System.out::println);
			System.out.println();
			AppMenus.displayMenu();
			AppMenus.fetchUserMenuOption();
		}
		
}
