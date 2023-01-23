package com.lockedme;


public class LockedMeApp {

	//Main application welcome with numerical menu, and menu options to add,
	//search for, and delete files from folder.
		
	public static void main(String[] args) throws Exception {
		
		AppMenus.displayWelcomeScreen();
		AppMenus.displayMenu();
		AppMenus.fetchUserMenuOption();
		
	}
}
