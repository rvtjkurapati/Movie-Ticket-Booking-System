package com.virtusa.mtms.presentation;

import java.util.Scanner;
import com.virtusa.mtms.dto.Customer;
import com.virtusa.mtms.service.ICustomerServiceImpl;

public class CustomerMenuExt {

	String uname;
	String pwd;
	ICustomerServiceImpl service = new ICustomerServiceImpl();
	Scanner s = new Scanner(System.in);

	public Customer getCredentials() {
		System.out.println("");
		System.out.println("");
		System.out.print("Enter your username: ");
		uname = s.next();
		System.out.print("Enter your password: ");
		pwd = s.next();
		Customer l = new Customer(1, uname, pwd, " ", " ");
		return l;
	}

	public void display() {

		System.out.println();
		System.out.println("        *********************** CUSTOMER MENU ************************");
		System.out.println("        1. Show Movie List");
		System.out.println("        2. Suggest a movie");
		System.out.println("        3. Book Ticket");
		System.out.println("        4. Show Ticket");
		System.out.println("        5. Cancel Ticket");
		System.out.println("        6. Check Seat Availability");
		System.out.println("        7. Go Back to Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("        ***************************************************************");
		System.out.println("");
		System.out.print("Enter your choice :");

	}

	public Customer register() {

		System.out.println("");
		System.out.println("**Instructions to Register**");
		System.out.println("1. Username can include(digits,'.' or '_')");
		System.out.println("2. Phone Number must be 10-digits starting with(6,7,8,9)");
		System.out.println("3. Email must valid and contain '@' '.");
		System.out.println(
				"4. Password Must contain i) one uppercase  ii) one lowercase iii) one special charcter iv) one digit");
		System.out.println("");
		System.out.println(" ");
		System.out.println("        *********************** Account  Registration ************************");
		System.out.println("");
		System.out.println("");
		System.out.print("Enter your new Username: ");
		uname = s.next();
		System.out.println("");
		System.out.print("Enter your Phone number: ");
		String phone = s.next();
		System.out.println("");
		System.out.print("Enter your Email: ");
		String mail = s.next();
		System.out.println("");
		System.out.print("Enter your password: ");
		pwd = s.next();
		System.out.println("");
		Customer c1 = new Customer(1, uname, pwd, phone, mail);
		return c1;

	}

	public void Register() {
		System.out.println();
		System.out.println("        _________________________________________________________________________\r\n"
				+ "\r\n" + "        |||||||||||||||||||||||||Login into your Account||||||||||||||||||||||||||\r\n"
				+ "        _________________________________________________________________________");
		System.out.println("");
		System.out.println("");
		System.out.println("        1. Continue");
		System.out.println("        2. Register");
		System.out.println("        3. go Back to Previous Menu");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("Enter your Choice : ");
	}

	public void MoviesAvail() {
		System.out.println("");
		System.out.println("\t\t\t\t\t***********************MOVIES AVAILABLE************************");
		System.out.println("");
	}

	public void NoData() {
		System.out.println("");
		System.out.println("Sorry! No Data Available!");
		System.out.println("");
	}

	public void NoBookings() {
		System.out.println("");
		System.out.println("Sorry! Bookings not yet Started.");
		System.out.println("");
	}

	public void Suggest(String s) {
		System.out.println("");
		System.out.println("Here is our suggestion based on the Bookings :");
		System.out.println("");
		System.out.println("                " + s);
		System.out.println("");
	}

	public void Loggedin(String s) {
		System.out.println("");
		System.out.println("*************************************************************** Logged in as " + s
				+ " ***************************************************************************");
		System.out.println("");
	}

	public void Booked() {
		System.out.println("");
		System.out.println("Ticket Booked Sucessfully");
		System.out.println("");
	}

	public void BookInvalid() {
		System.out.println("");
		System.out.println("Sorry! Invalid Details. Please Check show details and Try Again!");
		System.out.println("");
	}

	public void CheckDetails() {
		System.out.println("");
		System.out.println("Please check The details you have entered");
		System.out.println("");
	}

	public void Ticketdetails() {
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t*********Ticket Details**********");
		System.out.println("");
	}

	public void BookingCancel() {
		System.out.println("");
		System.out.println("Booking cancelled Sucessfully");
		System.out.println("");
	}

	public void InvalidBook() {
		System.out.println("");
		System.out.println("Sorry! Invalid Details");
		System.out.println("");
	}

	public void SeatsAvail() {
		System.out.println("");
		System.out.println("\t\t\t\t\t\t***********************SEATS AVAILABLE************************");
		System.out.println("");
	}

	public void NameCheck() {
		System.out.println("");
		System.out.println("Please Check the name you have entered");
		System.out.println("");
	}

	public void ValidCredentials() {
		System.out.println("");
		System.out.println("Please Enter valid Credentials");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void Exit() {
		System.out.println("");
		System.out.println("        ************YOU HAVE BEEN EXITED*************");
		System.out.println("");
	}

	public void ValidOption() {
		System.out.println("");
		System.out.println("Please Choose a Valid Option!");
		System.out.println("");
		System.out.println("");
	}

	public void RegSuccess() {
		System.out.println("");
		System.out.println("Registration successfull");
		System.out.println("");
	}

}
