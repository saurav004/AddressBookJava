package com.Bridgelabz.AddressBook;

import java.util.Scanner;

public class Addressbook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String addressBookName = null;
		System.out.println("WELCOME TO ADDRESS BOOK CODE");
		System.out.println("Select from the options below");
		System.out.println("1.\tOPEN Address Book");
		System.out.println("2.\tCREATE An Address Book");
		System.out.println("3.\tDELETE An Address Book");
		System.out.println("4.\tDELETE All Address Books");
		System.out.println("5.\tEXIT");
		int choice1 = sc.nextInt();
		switch (choice1) {
		case 1:
			System.out.println("Enter Address Book Name You want to open");
			addressBookName = sc.nextLine();
			openAddressBook(addressBookName);
			break;
		case 2:
			System.out.println("Enter Address Book Name you want to create");
			addressBookName = sc.nextLine();
			createAddresssBook(addressBookName);
			break;

		case 3:
			System.out.println("Enter Address Book Name you want to DELETE");
			addressBookName = sc.nextLine();
			deleteAddresssBook(addressBookName);
			break;
		case 4:
			System.out.println("do you really want to delete all");
			System.out.println("1.yes 2.No");
			int choice2 = sc.nextInt();
			if (choice2 == 1) {
				deleteAllAddressBook();
			}
			break;
		}

	}

	private static void deleteAllAddressBook() {
		// TODO Auto-generated method stub

	}

	private static void deleteAddresssBook(String addressBookName) {
		// TODO Auto-generated method stub

	}

	private static void createAddresssBook(String addressBookName) {
		// TODO Auto-generated method stub

	}

	public static void openAddressBook(String addressBookName) {
		// TODO Auto-generated method stub

	}
}
