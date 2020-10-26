package com.Bridgelabz.AddressBook;

import java.io.BufferedReader;
import java.util.regex.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.io.IOException;

public class Addressbook {

	public static void main(String[] args) throws IOException {

		// DISPLAYING ALL ADDRESS BOOKS PRESENT
		System.out.println("\n------------Text files------------");
		int end1 = 0;
		while (end1 == 0) {
			File directoryPath = new File(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook");
			File[] files = directoryPath.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			});
			System.out.println("All available Address Books are listed below");
			for (File file : files) {

				String fileName = file.getName();
				fileName = fileName.replace(".txt", "");
				System.out.println(fileName);
			}

			Scanner sc = new Scanner(System.in);
			String addressBookName = null;
			System.out.println("WELCOME TO ADDRESS BOOK CODE");
			int choice1 = 0;
			System.out.println("Select from the options below");
			System.out.println("1.\tOPEN Address Book");
			System.out.println("2.\tCREATE An Address Book");
			System.out.println("3.\tDELETE An Address Book");
			System.out.println("4.\tDELETE All Address Books");
			System.out.println("5.\tEXIT");
			choice1 = sc.nextInt();
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
				addressBookName = sc.next();
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
			File file1 = new File(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName);
			if (file1.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
		}
	}

	private static void deleteAddresssBook(String addressBookName) {
		String fileName = addressBookName + ".txt";
		File file = new File(
				"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
						+ fileName);
		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}
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
			myWriter.write("First Name\tLast Name\tEmail\tAddress\tCity\tState\tZip\tPhone Number\t");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static void openAddressBook(String addressBookName) throws IOException {
		String phoneNumber = null;
		String fileName = addressBookName + ".txt";
		BufferedReader r = null;
		int end = 0;
		while (end == 0) {
			try {
				r = new BufferedReader(new FileReader(
						"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
								+ fileName));
				String line = null;
				while ((line = r.readLine()) != null) {
					System.out.println("\t\t" + line);
				}
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (r != null)
					r.close();
			}
			System.out.println("\t\tEnter your choice");
			System.out.println("1.\t\tAdd a record");
			System.out.println("2.\t\tdelete a record");
			System.out.println("3.\t\tsearch a record");
			System.out.println("4.\t\tupdate a record");
			System.out.println("5.\t\tEXIT");
			Scanner scan = new Scanner(System.in);
			int choice2 = scan.nextInt();
			switch (choice2) {
			case 1:
				phoneNumber = checkPhone();
				addARecord(addressBookName, phoneNumber);
				break;
			case 2:
				phoneNumber = checkPhone();
				deleteARecord(addressBookName, phoneNumber);
				break;
			case 3:
				phoneNumber = checkPhone();
				String s = searchARecord(addressBookName, phoneNumber);
				break;
			case 4:
				phoneNumber = checkPhone();
				updateARecord(addressBookName, phoneNumber);
				break;
			case 5:
				end = 1;
				break;
			default:
				System.out.println("Invalid choice");

			}
		}
	}

	private static void updateARecord(String addressBookName, String phoneNumber) throws IOException {
//		deleteARecord(addressBookName, phoneNumber);
//		addARecord(addressBookName,phoneNumber);
		String fileName = addressBookName + ".txt";
		String record = searchARecord(addressBookName, phoneNumber);
		System.out.println();
		String[] recordLine = record.trim().split("\\s+");
		System.out.println("What do u want to update");
		System.out.println(
				"\t1.\tFirst Name \t2.\tlast Name \t3.\temail \t4.\tAddress \n \t5.\tcity \t6.\tState \t7.\tzip");

		Scanner scan = new Scanner(System.in);
		int choice1 = scan.nextInt();
		String fName = recordLine[0];
		String lName = recordLine[1];
		String emailId = recordLine[2];
		String Address = recordLine[3];
		String city = recordLine[4];
		String state = recordLine[5];
		String zip = recordLine[6];

		switch (choice1) {
		case 1:
			fName = checkfName();
			break;
		case 2:
			lName = checklName();
			break;
		case 3:
			emailId = checkEmail();
			break;
		case 4:
			Address = checkAddress();
			break;
		case 5:
			city = checkCity();
			break;
		case 6:
			state = checkState();
			break;
		case 7:
			zip = checkZip();
			break;
		default:
			System.out.println("Incorrect Choice");
		}
		deleteARecord(addressBookName, phoneNumber);
		try {
			FileWriter myWriter = new FileWriter(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName,
					true);
			myWriter.write("\n" + fName + "\t" + lName + "\t" + emailId + "\t" + Address + "\t" + city + "\t" + state
					+ "\t" + zip + "\t" + phoneNumber + "\t");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private static String searchARecord(String addressBookName, String phoneNumber) {

		String fileName = addressBookName + ".txt";
		File file = new File(
				"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
						+ fileName);
		Scanner scanner = null;
		String line = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				int index = line.indexOf(phoneNumber);
				if (index != -1) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured while processing the file");
			e.printStackTrace();
		}
		scanner.close();
		return line;
	}

	public static void deleteARecord(String addressBookName, String phoneNumber) throws IOException {

		String fileName = addressBookName + ".txt";
		String dest = "Output.txt";
		File file = new File(
				"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
						+ fileName);
		Scanner scanner = null;
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ dest,
					true);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int index = line.indexOf(phoneNumber);

				if (index != -1) {
				} else {
					System.out.println(line);
					myWriter.write("\n" + line);
				}
			}
			myWriter.close();

		} catch (Exception e) {
			System.out.println("Error occured while processing the file");
			e.printStackTrace();
		} finally {
			if (myWriter != null)
				myWriter.close();
			if (scanner != null)
				scanner.close();
		}
		if (file.delete()) {
			System.out.println("Deleted the file: " + file.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
		System.out.println(file);
		File oldName = new File(
				"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\" + dest);
		System.out.println(oldName);

		if (oldName.renameTo(file))
			System.out.println("Renamed successfully");
		else
			System.out.println("Error");

	}

	public static void addARecord(String addressBookName, String phoneNumber) {
		String fileName = addressBookName + ".txt";
		String fName = null, lName = null, emailId = null, Address = null, city = null, state = null, zip = null;
		fName = checkfName();
		lName = checklName();
		emailId = checkEmail();
		Address = checkAddress();
		city = checkCity();
		state = checkState();
		zip = checkZip();

		try {
			FileWriter myWriter = new FileWriter(
					"C:\\Users\\Saurabh\\eclipse-workspace\\AddressBookJava\\src\\com\\Bridgelabz\\AddressBook\\"
							+ fileName,
					true);
			myWriter.write("\n" + fName + "\t" + lName + "\t" + emailId + "\t" + Address + "\t" + city + "\t" + state
					+ "\t" + zip + "\t" + phoneNumber + "\t");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static String checklName() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patFname = "^[A-Z]{1}[a-z]{2,30}$";
		String FName = null;
		while (correct) {
			System.out.println("\n\tEnter your last Name");
			FName = scan.nextLine();
			System.out.println(FName);
			Pattern pat = Pattern.compile(patFname);
			Matcher Match = pat.matcher(FName);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return FName;
	}

	private static String checkZip() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patZip = "^[1-9]{1}[0-9]{2}[ ]{0,1}[0-9]{3}$";
		String Zip = null;
		while (correct) {
			System.out.println("\n\tEnter your Zip");
			Zip = scan.nextLine();
			System.out.println(Zip);
			Pattern pat = Pattern.compile(patZip);
			Matcher Match = pat.matcher(Zip);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return Zip;
	}

	private static String checkState() {
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patState = "^[A-Z]{1}[a-z]{2,50}$";
		String State = null;
		while (correct) {
			System.out.println("\n\tEnter your State");
			State = scan.nextLine();
			System.out.println(State);
			Pattern pat = Pattern.compile(patState);
			Matcher Match = pat.matcher(State);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return State;
	}

	private static String checkCity() {
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patcity = "^[A-Z]{1}[a-z]{2,50}$";
		String City = null;
		while (correct) {
			System.out.println("\n\tEnter your City");
			City = scan.nextLine();
			System.out.println(City);
			Pattern pat = Pattern.compile(patcity);
			Matcher Match = pat.matcher(City);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return City;
	}

	private static String checkEmail() {
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patEmail = "^[a-zA-Z][a-zA-Z0-9_\\-+]*[.]{0,1}[a-zA-Z0-9_\\-+]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z]{2,}[.]{0,}[a-zA-Z]*$";
		String Email = null;
		while (correct) {
			System.out.println("\n\tEnter your Email");
			Email = scan.nextLine();
			System.out.println(Email);
			Pattern pat = Pattern.compile(patEmail);
			Matcher Match = pat.matcher(Email);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return Email;
	}

	private static String checkAddress() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patAddress = "^[A-Za-z0-9'\\.\\-\\s\\,]{10,200}$";
		String Address = null;
		while (correct) {
			System.out.println("\n\tEnter your Address");
			Address = scan.nextLine();
			System.out.println(Address);
			Pattern pat = Pattern.compile(patAddress);
			Matcher Match = pat.matcher(Address);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return Address;
	}

	private static String checkfName() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patFname = "^[A-Z]{1}[a-z]{2,30}$";
		String FName = null;
		while (correct) {
			System.out.println("\n\tEnter your First Name");
			FName = scan.nextLine();
			System.out.println(FName);
			Pattern pat = Pattern.compile(patFname);
			Matcher Match = pat.matcher(FName);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return FName;
	}

	private static String checkPhone() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Boolean correct = true;
		String patMobileNumber = "^[0-9]{10}";
		String Phone = null;
		while (correct) {
			System.out.println("\n\tEnter your Phone Number");
			Phone = scan.nextLine();
			System.out.println(Phone);
			Pattern pat = Pattern.compile(patMobileNumber);
			Matcher Match = pat.matcher(Phone);
			if (Match.matches()) {
				correct=false;
				break;

			}
		}
		return Phone;
	}
}
