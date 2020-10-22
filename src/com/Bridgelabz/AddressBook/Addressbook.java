package com.Bridgelabz.AddressBook;

import java.util.Scanner;

public class Addressbook {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO ADDRESS BOOK CODE");
		System.out.println("Select from the options below");
		System.out.println("1.\tOPEN Address Book");
		System.out.println("2.\tCREATE An Address Book");
		System.out.println("3.\tDELETE An Address Book");
		System.out.println("4.\tDELETE All Address Books");
		System.out.println("5.\tEXIT");
		int choice1=sc.nextInt();
		switch(choice1) {
		case 1:
			System.out.println("Enter Address Book Name You want to open");
			String addressBookName=sc.nextLine();
			openAddressBook(addressBookName);
		}

	}

	public static void openAddressBook(String addressBookName) {
		// TODO Auto-generated method stub
		
	}
}
