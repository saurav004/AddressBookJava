package com.Bridgelabz.AddressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.io.IOException;

public class Addressbook {

	public static void main(String[] args) {

		// DISPLAYING ALL ADDRESS BOOKS PRESENT
		System.out.println("\n------------Text files------------");
		File directoryPath = new File(
				"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook");
		File[] files = directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});

		for (File file : files) {

			String fileName = file.getName();
			fileName = fileName.replace(".txt", "");
			System.out.println(fileName);
		}

		Scanner sc = new Scanner(System.in);
		String addressBookName = null;
		int end1 = 0;
		System.out.println("WELCOME TO ADDRESS BOOK CODE");
		while (end1 == 0) {
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
				addressBookName = sc.next();
				sc.nextLine();
				openAddressBook(addressBookName);
				break;
			case 2:
				System.out.println("Enter Address Book Name you want to create");
				addressBookName = sc.next();
				createAddresssBook(addressBookName);
				break;

			case 3:
				System.out.println("Enter Address Book Name you want to DELETE");
				addressBookName = sc.nextLine();
				sc.nextLine();
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
			case 5:
				end1 = 1;
			}
		}

	}

	private static void deleteAllAddressBook() {
		System.out.println("delete All address book");
	}

	private static void deleteAddresssBook(String addressBookName) {
		System.out.println("delete address book");

	}

	private static void createAddresssBook(String addressBookName) {
		String fileName = addressBookName + ".txt";
		System.out.println(fileName);
		System.out.println("create address book");
		try {
			File myObj = new File(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				System.out.println(myObj);
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/* WRITING COLUMNS IN FIRST LINE OF THE FILE */
		try {
			FileWriter myWriter = new FileWriter(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName);
			myWriter.write("First Name\t Last Name\t Address\t City\t State\t Zip\t Phone Number\t");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static void openAddressBook(String addressBookName) {

		String fileName = addressBookName + ".txt";
//		BufferedReader r;
//		try {
//			r = new BufferedReader(new FileReader(
//					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
//							+fileName));
//			System.out.print(r);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		BufferedReader r;
		try {
			r = new BufferedReader(new FileReader(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName));
			String s = "", line = null;
			while ((line = r.readLine()) != null) {
				s += line;
				System.out.print(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\tEnter your choice");
		System.out.println("1.\tAdd a record");
		System.out.println("2.\tdelete a record");
		System.out.println("2.\tsearch a record");
		System.out.println("2.\tupdate a record");
		System.out.println("2.\tEXIT");
		Scanner scan = new Scanner(System.in);
		int choice2 = scan.nextInt();
		switch (choice2) {
		case 1:
			addARecord(addressBookName);
			break;
		case 2:
			deleteARecord(addressBookName);
			break;
		case 3:
			searchARecord(addressBookName);
			break;
		case 4:
			updateARecord(addressBookName);
		}

	}

	private static void updateARecord(String addressBookName) {
		// TODO Auto-generated method stub

	}

	private static void searchARecord(String addressBookName) {
		// TODO Auto-generated method stub

	}

	public static void deleteARecord(String addressBookName) {
		// TODO Auto-generated method stub

	}

	public static void addARecord(String addressBookName) {
		// TODO Auto-generated method stub

	}
}
