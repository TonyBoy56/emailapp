package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 30;
	private String alternateEmail;
	private String companySuffix = "CruzOps.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for the department = return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your email is: " + email);
	}
	// Ask for the department
	private String setDepartment() {
		// Prompt to request department from the user
		System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
		// Read tool for user response
		Scanner in = new Scanner(System.in);
		// Stores int value of user's choice
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3){ return "acct"; }
		else { return "None"; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			// If there are 30 chars in passwordSet, we want a random number between 0 and 30. Math.random() is 0 and 1. Multiply it by that by the number of chars in the array. Make that number an int and store into rand.
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Setters; Encapsulation so that we are able to set properties. We are hiding the actual property of mailboxCapacity with making the capacity we pass in public
	// Set mailboxCap
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Getters; databinding and datahiding. These methods will return what is in the private values established earlier
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"COMPANY EMAIL: " + email +
				"MAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
