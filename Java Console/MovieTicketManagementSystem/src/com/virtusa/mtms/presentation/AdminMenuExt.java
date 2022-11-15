package com.virtusa.mtms.presentation;

import com.virtusa.mtms.dto.Admin;
import java.util.*;

public class AdminMenuExt {
	Scanner s = new Scanner(System.in);

	public Admin getCredentials() {
		System.out.println("");
		System.out.println("");
		System.out.print("Enter your ADMIN username: ");
		String uname = s.next();
		System.out.print("Enter password: ");
		String pwd = s.next();
		Admin lv = new Admin(1, uname, pwd);
		return lv;
	}

	public Admin addCredentials() {
		System.out.println("");
		System.out.println("**Instructions to Add a Admin**");
		System.out.println("1. Username can include(digits,'.' or '_')");
		System.out.println(
				"2. Password Must contain i) one uppercase  ii) one lowercase iii) one special charcter iv) one digit");
		System.out.println("");
		System.out.print("Enter new username : ");
		String uname = s.next();
		System.out.print("Enter password: ");
		String pwd = s.next();
		Admin lv = new Admin(1, uname, pwd);
		return lv;
	}

	public void adminMenu() {

		System.out.println();
		System.out.println("        *********************** ADMIN MENU ************************");
		System.out.println("        1. Admin User Management");
		System.out.println("        2. Customer User Management");
		System.out.println("        3. Movie Management");
		System.out.println("        4. Booking Management");
		System.out.println("        5. Go Back Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("        ***************************************************************");
		System.out.println("");
		System.out.print("Enter your choice : ");
	}

	public void adminMgmt() {
		System.out.println("");
		System.out.println("        1. Add new ADMIN");
		System.out.println("        2. Delete ADMIN by ID");
		System.out.println("        3. Modify ADMIN");
		System.out.println("        4. Show all ADMIN Users");
		System.out.println("        5. Search ADMIN");
		System.out.println("        6. Go Back to Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("");
		System.out.print("Enter your choice : ");

	}

	public void custMgmt() {
		System.out.println("");
		System.out.println("        1. Add new Customer");
		System.out.println("        2. Delete Customer by Username");
		System.out.println("        3. Modify Customer");
		System.out.println("        4. Show all Customer Users");
		System.out.println("        5. Search Customer");
		System.out.println("        6. Go Back to Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("");
		System.out.print("Enter your choice : ");

	}

	public void MovieMgmt() {
		System.out.println("");
		System.out.println("        1. Add new Movie");
		System.out.println("        2. Delete Movie by ID");
		System.out.println("        3. Modify Movie");
		System.out.println("        4. Show all Movies");
		System.out.println("        5. Go Back to Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("");
		System.out.print("Enter your choice : ");

	}

	public void BookingMgmt() {
		System.out.println("");
		System.out.println("        1. Book new Ticket");
		System.out.println("        2. Suggest a Movie");
		System.out.println("        3. Show Ticket");
		System.out.println("        4. Cancel Ticket");
		System.out.println("        5. Check Seat Availability");
		System.out.println("        6. Show all Bookings");
		System.out.println("        7. Go Back to Previous Menu");
		System.out.println("        0. Exit");
		System.out.println("");
		System.out.print("Enter your choice : ");

	}

	public void loginDisplay() {
		System.out.println();
		System.out.println("        _________________________________________________________________________\r\n"
				+ "\r\n" + "        |||||||||||||||||||||||||Login into your Account||||||||||||||||||||||||||\r\n"
				+ "        _________________________________________________________________________");
		System.out.println("");
		System.out.println("");
	}

	public void LoggedIn() {
		System.out.println("");
		System.out.println(
				"*************************************************************************** Logged in as ADMIN **********************************************************************************");
		System.out.println("");
		System.out.println("");
	}

	public void AdminIns() {
		System.out.println("");
		System.out.println("**Instructions to Add a Admin**");
		System.out.println("1. Username can include(digits,'.' or '_')");
		System.out.println(
				"2. Password Must contain i) one uppercase  ii) one lowercase iii) one special charcter iv) one digit");
		System.out.println("");
		System.out.println("");
	}

	public void AdminAdded() {
		System.out.println("");
		System.out.println("User added Sucessfully");
		System.out.println("");
		System.out.println("");
	}

	public void AdminExists() {
		System.out.println("");
		System.out.println("Sorry! username already exists.");
		System.out.println("");
	}

	public void ReadIns() {
		System.out.println("");
		System.out.println("Please read the Instructions carefully and try again!.");
		System.out.println("");
		System.out.println("");
	}

	public void AdminDeleted() {
		System.out.println("");
		System.out.println("User deleted Sucessfully");
		System.out.println("");
		System.out.println("");
	}

	public void Reconsider() {
		System.out.println("");
		System.out.println("Thanks for reconsidering your descision!");
		System.out.println("");
		System.out.println("");
	}

	public void ValidOption() {
		System.out.println("");
		System.out.println("Please Choose a Valid Option!");
		System.out.println("");
		System.out.println("");
	}

	public void UserNotFound() {
		System.out.println("");
		System.out.println(" Sorry. User Not Found. Please try again!");
		System.out.println("");
		System.out.println("");
	}

	public void ModifySucess() {
		System.out.println("");
		System.out.println("Modify sucessful");
		System.out.println("");
		System.out.println("");
	}

	public void AdminDb() {
		System.out.println("");
		System.out.println("                   ***********************ADMIN DATABASE************************");
		System.out.println("");
	}

	public void CustDb() {
		System.out.println("");
		System.out.println(
				"                                       ***********************CUSTOMER DATABASE************************");
		System.out.println("");
	}

	public void NoData() {
		System.out.println("");
		System.out.println("Sorry! No Data Available!");
		System.out.println("");
	}

	public void Exit() {
		System.out.println("");
		System.out.println("        ************YOU HAVE BEEN EXITED*************");
		System.out.println("");
	}

	public void MovieIns() {
		System.out.println("");
		System.out.println("**Instructions to Add Movie**");
		System.out.println("1. Movie name must be of length below 25");
		System.out.println("2. Language must start with captial letter");
		System.out.println("3. Show timing must be as as specified.");
		System.out.println("4. Date must be valid");
		System.out.println("");
	}

	public void MovieAdd() {
		System.out.println("");
		System.out.println("Movie added Sucessfully");
		System.out.println("");
	}

	public void MovieExist() {
		System.out.println("");
		System.out.println("Sorry! Movie already exists");
		System.out.println("");
	}

	public void MovieDelete() {
		System.out.println("");
		System.out.println("Movie deleted Sucessfully");
		System.out.println("");
	}

	public void MovieModify() {
		System.out.println("");
		System.out.println("Modify sucessful");
		System.out.println("");
	}

	public void MoviesAvail() {
		System.out.println("");
		System.out.println(
				"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t***********************MOVIES AVAILABLE************************");
		System.out.println("");
	}

	public void CheckMId() {
		System.out.println("");
		System.out.println("Please check Movie ID ");
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

	public void NoBookings() {
		System.out.println("");
		System.out.println("Sorry! Bookings not yet Started.");
		System.out.println("");
	}

	public void Suggest() {
		System.out.println("");
		System.out.println("Here is our suggestion based on the Bookings :");
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
}
