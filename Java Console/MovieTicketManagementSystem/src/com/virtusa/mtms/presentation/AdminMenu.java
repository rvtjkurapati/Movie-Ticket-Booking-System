package com.virtusa.mtms.presentation;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;

import com.virtusa.mtms.dto.Admin;
import com.virtusa.mtms.dto.Availability;
import com.virtusa.mtms.dto.Booking;
import com.virtusa.mtms.dto.Customer;
import com.virtusa.mtms.dto.Movie;
import com.virtusa.mtms.dto.Ticket;
import com.virtusa.mtms.regex.MovieRegex;
import com.virtusa.mtms.regex.UserRegex;
import com.virtusa.mtms.service.IAdminServiceImpl;
import com.virtusa.mtms.service.IBookingServiceImpl;
import com.virtusa.mtms.service.ICustomerServiceImpl;
import com.virtusa.mtms.service.IMovieServiceImpl;

public class AdminMenu {
	int a = 0;
	int o = 0;
	String uname;
	String pwd;
	IAdminServiceImpl admin = new IAdminServiceImpl();
	ICustomerServiceImpl cust = new ICustomerServiceImpl();
	IBookingServiceImpl bs = new IBookingServiceImpl();
	IMovieServiceImpl ms = new IMovieServiceImpl();
	AdminMenuExt ah = new AdminMenuExt();
	CustomerMenuExt ch = new CustomerMenuExt();
	MainMenuExt md = new MainMenuExt();
	UserRegex ur = new UserRegex();
	MovieRegex mr = new MovieRegex();
	Logger adminlog = Logger.getLogger(AdminMenu.class);
	Scanner s = new Scanner(System.in);

	public void adminMenu() {
		adminlog.info(" Admin Login Displayed!");
		ah.loginDisplay();
		Admin lv = ah.getCredentials();
		boolean f = admin.ValidateAdmin(lv);
		int custid = admin.getId(lv);
		String custname = lv.getUserName();
		if (f == true) {
			adminlog.info(" Admin Login Success!");
			ah.LoggedIn();
			do {
				ah.adminMenu();
				adminlog.info(" Admin Menu Displayed!");
				a = s.nextInt();
				switch (a) {
				case 1: {
					do {
						ah.adminMgmt();
						adminlog.info("Selected Admin User Management!");
						o = s.nextInt();
						switch (o) {
						case 1: {
							adminlog.info("Selected to add new Admin user!");
							// ah.AdminIns();
							adminlog.info("Instructions displayed");
							Admin la = ah.addCredentials();
							if (ur.MatchUname(la.getUserName()) && ur.MatchPwd(la.getPassWord())) {
								f = admin.AddAdmin(la);
								if (f == true) {
									ah.AdminAdded();
									adminlog.info(" Admin user added sucessfully!");
								} else {
									ah.AdminExists();
									adminlog.error(" Admin username already exists!");
								}
							} else {
								ah.ReadIns();
								adminlog.error(" Details Incorrect");
							}

							break;
						}

						case 2: {
							adminlog.info("Selected to add Admin by ID");
							System.out.println("Enter Admin ID to Delete: ");
							int id = s.nextInt();
							boolean del = admin.ValidateId(id);
							if (del == true) {
								System.out.println("Are you sure want to delete this account ?  (yes/no) :");
								adminlog.warn(" Confirming to delete");
								String op = s.next();
								if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
									admin.DelAdmin(id);
									ah.AdminDeleted();
									adminlog.info(" Admin user " + id + " deleted");
								}

								else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
									ah.Reconsider();
									adminlog.info(" Confirmed not to delete");
								} else {
									ah.ValidOption();
									adminlog.info("Wrong Option Selected (yes/no)");
								}
							}

							else {
								ah.UserNotFound();
								adminlog.error(" User Not Found");
							}

							break;
						}

						case 3: {
							adminlog.info("Selected to modify a admin");
							Admin lm = ah.getCredentials();
							boolean flag = admin.ValidateAdmin(lm);
							if (flag == true) {
								ah.AdminIns();
								adminlog.info("Instructions displayed");
								System.out.print("Enter your new ADMIN username :");
								String str = s.next();
								System.out.print("Enter your new Password: ");
								String pwd = s.next();
								if (ur.MatchUname(str) && ur.MatchPwd(pwd)) {
									System.out.println(
											"Are you sure want to modify " + lm.getUserName() + " ?  (yes/no) :");
									adminlog.warn("Confirming to modify");
									String op = s.next();
									if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
										admin.ModifyAdmin(lm, str, pwd);
										ah.ModifySucess();
										adminlog.info("Mofification Sucess");
									}

									else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
										ah.Reconsider();
										adminlog.info("Choose not to modify");
									} else {
										ah.ValidOption();
										adminlog.error("Wrong input given (yes/no)");
									}
								}

								else {
									ah.ReadIns();
									adminlog.error("User new details were not valid");

								}
							} else {
								ah.UserNotFound();
								adminlog.error("User not found");
							}

							break;
						}

						case 4: {
							adminlog.info("Selected to display All Admin Users");
							ArrayList<Admin> al = new ArrayList<Admin>();
							al = admin.getAdmins();
							if (al != null) {
								ah.AdminDb();
								for (Admin x : al) {
									System.out.println(x + "");
								}
							} else {
								ah.NoData();
								adminlog.error("No Data Available");
							}
							break;
						}

						case 5: {
							adminlog.info("Searching Admin user by name");
							System.out.println("Enter username to Search :");
							String name = s.next();
							ArrayList<Admin> al = new ArrayList<Admin>();
							al = admin.SearchAdmin(name);
							if (al != null) {
								ah.AdminDb();
								for (Admin x : al) {
									System.out.println(x + "");
								}
								adminlog.info("User displayed");
							} else {
								ah.NoData();
								adminlog.error("No Data Available!");
							}
							o = 0;
							break;
						}

						case 6: {
							adminlog.info("Selected to go back to previous menu");
							o = 5;
							break;
						}

						case 0: {
							ah.Exit();
							md.ThankYou();
							adminlog.info("Program Exit");
							System.exit(0);
						}

						default: {
							ah.ValidOption();
							adminlog.error("Wrong option selected");
							o = 0;
						}

						}

					} while (o < 5);

					break;
				}

				case 2: {
					adminlog.info("selected customer Management");
					do {
						ah.custMgmt();
						adminlog.info("customer management menu displayed");
						o = s.nextInt();
						switch (o) {
						case 1: {
							adminlog.info("selected to add new user");
							Customer ac = ch.register();
							if (ur.MatchUname(ac.getName()) && ur.MatchPwd(ac.getPwd()) && ur.MatchPhone(ac.getPhone())
									&& ur.MatchMail(ac.getEmail())) {
								f = cust.AddCustomer(ac);
								if (f == true) {
									ah.AdminAdded();
									adminlog.info("new user added successfully");
								} else {
									ah.AdminExists();
									adminlog.error("username already exists");
								}
							} else {
								ah.ReadIns();
								adminlog.error("new user details invalid");
							}
							break;
						}

						case 2: {
							adminlog.info("selected to delete customer");
							System.out.print("Enter Customer ID to Delete: ");
							int id = s.nextInt();
							boolean del = cust.ValidateId(id);
							if (del == true) {
								System.out.print("Are you sure want to delete this account ?  (yes/no) :");
								adminlog.warn("confirming to delete");
								String op = s.next();
								if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
									cust.DelCustomer(id);
									ah.AdminDeleted();
									adminlog.info("User deleted Sucessfully");
								} else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
									ah.Reconsider();
									adminlog.info("choose not to delete");
								} else {
									ah.ValidOption();
									adminlog.error("Wrong input selected (yes/no)");
								}
							}

							else {
								ah.UserNotFound();
								adminlog.error("User Not Found");
							}
							break;
						}

						case 3: {
							adminlog.info("Selected to modify user");
							System.out.print("Enter Customer Name :");
							String name = s.next();
							boolean flag = cust.ValidateName(name);
							if (flag == true) {
								ah.AdminIns();
								adminlog.info("Instructions displayed");
								System.out.print("Enter  new username :");
								String str = s.next();
								System.out.print("Enter  new Password: ");
								String pwd = s.next();
								System.out.print("Enter  new Phone Number :");
								String phn = s.next();
								System.out.print("Enter  new Email : ");
								String mail = s.next();
								if (ur.MatchUname(str) && ur.MatchPwd(pwd)) {
									System.out.println("Are you sure want to modify " + name + " ?  (yes/no) :");
									adminlog.warn("confirming to modify");
									String op = s.next();
									if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
										cust.ModifyCustomer(name, str, pwd, phn, mail);
										System.out.println("");
										System.out.println("User Modify sucessful");
										System.out.println("");
										adminlog.info("User Modify sucessful");
									} else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
										ah.Reconsider();
										adminlog.info("choose not to modify");
									} else {
										ah.ValidOption();
										adminlog.error("Wrong input given (yes/no)");
									}
								}

								else {
									ah.ReadIns();
									adminlog.error("User details were invalid");
								}

							}

							else {
								ah.UserNotFound();
								adminlog.error("User Not Found");
							}
							break;
						}

						case 4: {
							adminlog.info("Selected to display all customers");
							ArrayList<Customer> al = new ArrayList<Customer>();
							al = cust.getCustomers();
							if (al != null) {
								ah.CustDb();
								for (Customer x : al) {
									System.out.println(x + "");
								}
								adminlog.info("Displayed all customers");
							} else {
								ah.NoData();
								adminlog.warn("No Data Available!");
							}

							break;
						}

						case 5: {
							adminlog.info("Selected to search user by name");
							System.out.print("Enter username to Search :");
							String name = s.next();
							ArrayList<Customer> al = new ArrayList<Customer>();
							al = cust.SearchCustomer(name);
							if (al != null) {
								ah.CustDb();
								for (Customer x : al) {
									System.out.println(x + "");
								}
								adminlog.info("user details displayed");
							} else {
								ah.NoData();
								adminlog.error("User not found");
							}
							o = 0;
							break;
						}

						case 6: {
							o = 5;
							break;
						}

						case 0: {
							ah.Exit();
							md.ThankYou();
							adminlog.info("Program Exit");
							System.exit(0);
						}

						default: {
							System.out.println("Please Choose a valid option!");
							adminlog.error("Wrong option selected");
							o = 0;
						}
						}

					} while (o < 5);
					break;
				}

				case 3: {
					adminlog.info("Selected Movie Management");
					do {
						ah.MovieMgmt();
						adminlog.info("Movie Management Menu displayed");
						o = s.nextInt();
						switch (o) {
						case 1: {
							ah.MovieIns();
							adminlog.info("Instructions displayed");
							System.out.print("Enter Movie Name : ");
							String mname = s.next();
							System.out.print("Enter Language : ");
							String lang = s.next();
							System.out.print("Enter Morning Show time(hh:mmAM) : ");
							String show1 = s.next();
							System.out.print("Enter Matinee Show time(hh:mmPM) : ");
							String show2 = s.next();
							System.out.print("Enter Second Show time(hh:mmPM) : ");
							String show3 = s.next();
							System.out.print("Enter Starting Date : ");
							String date1 = s.next();
							System.out.print("Enter Ending Date : ");
							String date2 = s.next();

							try {
								SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
								java.util.Date date3 = sdf1.parse(date1);
								java.util.Date date4 = sdf1.parse(date2);
								if (date4.getTime() >= date3.getTime()) {
									f = true;
								} else {
									f = false;
								}

							} catch (Exception e) {
								e.getStackTrace();
								adminlog.error("Date input conversion error");
								f = false;
							}
							if (mr.MatchName(mname) && mr.MatchLang(lang) && mr.MatchMorning(show1)
									&& mr.MatchMatinee(show2) && mr.MatchSecnodShow(show3) && mr.MatchSDate(date1)
									&& mr.MatchEDate(date2) && f == true) {
								Movie m = new Movie(1, mname, lang, show1, show2, show3, date1, date2);
								f = ms.AddMovie(m);
								if (f == true) {
									ah.MovieAdd();
									adminlog.info("Movie added Sucessfully");
								}

								else {
									ah.MovieExist();
									adminlog.info("Movie already exists");
								}

							} else {
								ah.ReadIns();
								adminlog.error("Movie detais entered Invalid");
							}
							break;
						}

						case 2: {
							adminlog.info("Selected to delete movie by Id");
							System.out.print("Enter Movie ID :");
							int id = s.nextInt();
							boolean del = ms.ValMovieId(id);
							if (del == true) {
								System.out.print("Are you sure want to delete this movie ?  (yes/no) :");
								adminlog.warn("Confirming to delete");
								String op = s.next();
								if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
									ms.DelMovie(id);
									ah.MovieDelete();
									adminlog.info("Movie deleted Sucessfully");
								} else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
									ah.Reconsider();
									adminlog.info("Choose not no delete");
								} else {
									ah.ValidOption();
									adminlog.error("Wrong input Given(yes /no)");
								}
							} else {
								ah.NoData();
								adminlog.error("No Movies Found");
							}
							break;
						}

						case 3: {
							adminlog.info("Selected to modify a movie");
							System.out.println("Enter Movie ID: ");
							int id = s.nextInt();
							boolean flag = ms.ValMovieId(id);
							if (flag == true) {
								ah.MovieIns();
								adminlog.info("Instructions displayed");
								System.out.print("Enter Movie Name : ");
								String mname = s.next();
								System.out.print("Enter Language : ");
								String lang = s.next();
								System.out.print("Enter Morning Show time(hh:mmAM) : ");
								String show1 = s.next();
								System.out.print("Enter Matinee Show time(hh:mmPM) : ");
								String show2 = s.next();
								System.out.print("Enter Second Show time(hh:mmPM) : ");
								String show3 = s.next();
								System.out.print("Enter Starting Date : ");
								String date1 = s.next();
								System.out.print("Enter Ending Date : ");
								String date2 = s.next();
								try {
									SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
									java.util.Date date3 = sdf1.parse(date1);
									java.util.Date date4 = sdf1.parse(date2);
									if (date4.getTime() > date3.getTime()) {
										f = true;
									} else {
										f = false;
									}

								} catch (Exception e) {
									e.getStackTrace();
									adminlog.error("Input Date conversion error");
									f = false;
								}
								if (mr.MatchName(mname) && mr.MatchLang(lang) && mr.MatchMorning(show1)
										&& mr.MatchMatinee(show2) && mr.MatchSecnodShow(show3) && mr.MatchSDate(date1)
										&& mr.MatchEDate(date2) && f == true) {
									Movie m = new Movie(id, mname, lang, show1, show2, show3, date1, date2);
									System.out.println("Are you sure want to modify this movie ?  (yes/no) :");
									adminlog.warn("Confirming to modify");
									String op = s.next();
									if (op.equals("yes") || op.equals("YES") || op.equals("Yes")) {
										ms.ModifyMovie(m);
										ah.MovieModify();
										adminlog.info("Modify sucessful");
									} else if (op.equals("no") || op.equals("NO") || op.equals("No")) {
										ah.Reconsider();
										adminlog.info("choose not to modify");
									} else {
										ah.ValidOption();
										adminlog.error("Wrong input given (yes/no)");
									}

								} else {
									ah.ReadIns();
									adminlog.error("Input details entered were Invalid");
								}
							} else {
								ah.CheckMId();
								adminlog.error("Movie Not found");
							}

							break;
						}
						case 4: {
							adminlog.info("Selected to display all movies");
							ArrayList<Movie> al = new ArrayList<Movie>();
							al = ms.getMovies();
							if (al != null) {
								ah.MoviesAvail();
								for (Movie x : al) {
									System.out.println(x + "");
									System.out.println("");
								}
								adminlog.info("displayed all movies");
							} else {
								ah.NoData();
								adminlog.error(" No Data Available");
							}
							break;
						}
						case 5: {
							adminlog.info("Selected to Goback to previous menu");
							o = 5;
							break;
						}
						case 0: {
							ah.Exit();
							md.ThankYou();
							adminlog.info("Program Exit");
							System.exit(0);
						}
						default: {
							ah.ValidOption();
							adminlog.error("Wrong input given");
							o = 0;
						}
						}
					} while (o < 5);
					break;
				}

				case 4: {
					do {
						adminlog.info("Selected Booking Management");
						ah.BookingMgmt();
						adminlog.info("Booking Management Menu Displayed");
						o = s.nextInt();
						switch (o) {
						case 1: {
							adminlog.info("Selected to book a ticket");
							System.out.print("Enter Movie Name : ");
							String mname = s.next();
							System.out.println("Enter Date : ");
							String date = s.next();
							System.out.print("Enter Show time(morning/matinee/secondshow) : ");
							String time = s.next();
							System.out.print("Enter Seats for the Show(<=8): ");
							int seats = s.nextInt();
							System.out.print("Enter your Phone number to get Updates : ");
							String phone = s.next();
							if (mr.MatchSDate(date) && ur.MatchPhone(phone) && seats <= 8 && (time.equals("morning")
									|| time.equals("matinee") || time.equals("secondshow"))) {
								Booking b = new Booking(1, custid, custname, phone, 1, date, time, seats);
								f = bs.BookTicket(b, mname, "admin");
								if (f == true) {
									ah.Booked();
									adminlog.info("Ticket Booked Sucessfully");
								} else {
									ah.BookInvalid();
									adminlog.error("Invalid Details");
								}
							} else {
								ah.CheckDetails();
								adminlog.error("Invalid Details");
							}
							break;
						}
						case 2: {
							adminlog.info("Selected Movie suggestion");
							String s = ms.SuggestMovie();
							if (s == null) {
								ah.NoBookings();
								adminlog.error("Bookings not yet Started.");
							} else {
								ah.Suggest();
								System.out.println(s);
								adminlog.info("suggestion displayed");
							}
							break;
						}
						case 3: {
							adminlog.info("Selected to display ticket");
							System.out.println(" ");
							ArrayList<Ticket> al = new ArrayList<Ticket>();
							al = bs.ShowTicket(custid);
							if (al != null) {
								ah.Ticketdetails();
								for (Ticket x : al) {
									System.out.println(x + "");
									System.out.println("");
								}
								adminlog.info("Ticket Displayed");
							} else {
								ah.NoData();
								adminlog.error("No Data Available!");
							}
							break;
						}
						case 4: {
							adminlog.info("Selected to Cancel a ticket");
							System.out.println(" ");
							System.out.print("Enter Booking Id : ");
							int id = s.nextInt();
							f = bs.CancelTicket(id);
							if (f == true) {
								ah.BookingCancel();
								adminlog.info("Booking cancelled Sucessfully");
							} else {
								ah.InvalidBook();
								adminlog.error("No Data Available!");
							}
							break;
						}
						case 5: {
							adminlog.info("Selected to check movie availability");
							ArrayList<Availability> al = new ArrayList<Availability>();
							System.out.println("Enter movie name : ");
							String str = s.next();
							if (mr.MatchName(str)) {
								al = ms.CheckSeatAvail(str);
								if (ms.CheckSeatAvail(str) != null) {
									ah.SeatsAvail();
									for (Availability x : al) {
										System.out.println(x + "");
										System.out.println("");
									}
									adminlog.info("Movie availability displayed");
								} else {
									ah.NoData();
									adminlog.error("No Data Available!");
								}
							} else {
								ah.NameCheck();
								adminlog.error("Input Entered is not valid");
							}
							break;
						}
						case 6: {
							adminlog.info("Selected to show all booking details");
							ArrayList<Booking> al = new ArrayList<Booking>();
							al = bs.getBookings();
							if (al != null) {
								System.out.println("");
								System.out.println(
										"\t\t\t\t\t\t\t\t\t\t***********************BOOKING DATABASE************************");
								System.out.println("");
								for (Booking x : al) {
									System.out.println(x + "");
									System.out.println("");
								}
								adminlog.info("Booking details displayed");
							} else {
								ah.NoData();
								adminlog.error("No Data Available!");
							}
							o = 0;
							break;
						}
						case 7: {
							adminlog.info("Selected to go back to previous menu");
							o = 6;
							break;
						}
						case 0: {
							ah.Exit();
							md.ThankYou();
							adminlog.info("Program Exit");
							System.exit(0);
						}
						default: {
							ah.ValidOption();
							adminlog.error("Wrong option Selected");
							o = 0;
						}
						}
					} while (o < 6);
					break;
				}

				case 5: {
					adminlog.info("Selected to go back to previous menu");
					a = 5;
					break;
				}
				case 0: {
					ah.Exit();
					md.ThankYou();
					adminlog.info("Program Exit");
					System.exit(0);
				}
				default: {
					ah.ValidOption();
					adminlog.error("Wrong option Selected");
					a = 0;
				}
				}
			} while (a < 5);
		}

		else {
			ah.ValidCredentials();
			adminlog.error("Admin Credentials were wrong");
		}
	}

}
