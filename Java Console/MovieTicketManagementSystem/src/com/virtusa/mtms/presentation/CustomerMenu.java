package com.virtusa.mtms.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.virtusa.mtms.dto.Availability;
import com.virtusa.mtms.dto.Booking;
import com.virtusa.mtms.dto.CustMovie;
import com.virtusa.mtms.dto.Customer;
import com.virtusa.mtms.dto.Movie;
import com.virtusa.mtms.dto.Ticket;
import com.virtusa.mtms.regex.MovieRegex;
import com.virtusa.mtms.regex.UserRegex;
import com.virtusa.mtms.service.IBookingServiceImpl;
import com.virtusa.mtms.service.ICustomerServiceImpl;
import com.virtusa.mtms.service.IMovieServiceImpl;

public class CustomerMenu {

	public void customerMenu() {

		int c = 0;
		int cust;
		String uname;
		String pwd;
		ICustomerServiceImpl cs = new ICustomerServiceImpl();
		CustomerMenuExt ch = new CustomerMenuExt();
		IMovieServiceImpl ms = new IMovieServiceImpl();
		IBookingServiceImpl bs = new IBookingServiceImpl();
		MainMenuExt ds = new MainMenuExt();
		MovieRegex mr = new MovieRegex();
		UserRegex ur = new UserRegex();
		Logger custlog = Logger.getLogger(CustomerMenu.class);
		Scanner s = new Scanner(System.in);
		do {

			ch.Register();
			custlog.info("Confirming to continue (or) to Register");
			cust = s.nextInt();
			switch (cust) {
			case 1: {
				custlog.info("Continued to Login");
				Customer l = ch.getCredentials();
				boolean f = cs.ValidateCustomer(l);
				Customer idp = new Customer();
				int custid = 0;
				String custname = "";
				if (f == true) {
					idp = cs.getCustIdPhone(l);
					custid = idp.getId();
					custname = l.getName();
				}

				if (f == true) {
					custlog.info("Login Success");
					ch.Loggedin(custname);
					do {
						ch.display();
						custlog.info("Customer Menu Displayed");
						c = s.nextInt();
						switch (c) {
						case 1: {
							custlog.info("Selected to view movie list");
							ArrayList<CustMovie> al = new ArrayList<CustMovie>();
							al = ms.getCustMovies();
							if (al != null) {
								ch.MoviesAvail();
								for (CustMovie x : al) {
									System.out.println(x + "");
									System.out.println("");
								}
								custlog.info("Movies list Displayed");
							} else {
								ch.NoData();
								custlog.error("No Movies Avaliable");
							}
							break;
						}
						case 2: {
							custlog.info("Selected Movie suggestion");
							String st = ms.SuggestMovie();
							if (st == null) {
								ch.NoBookings();
								custlog.error("No Bookings available to suggest");
							} else {
								ch.Suggest(st);
								custlog.info("Suggestion Displayed");
							}
							break;
						}

						case 3: {
							custlog.info("Selected to book a ticket");
							System.out.print("Enter Movie Name : ");
							String mname = s.next();
							System.out.print("Enter Date : ");
							String date = s.next();
							System.out.print("Enter Show time(morning/matinee/secondshow) : ");
							String time = s.next();
							System.out.print("Enter Seats for the Show (<=8) : ");
							int seats = s.nextInt();
							System.out.print("Enter your Phone number to get Updates : ");
							String phonen = s.next();
							if (mr.MatchSDate(date) && ur.MatchPhone(phonen) && seats <= 8 && (time.equals("morning")
									|| time.equals("matinee") || time.equals("secondshow"))) {
								Booking b = new Booking(1, custid, custname, phonen, 1, date, time, seats);
								f = bs.BookTicket(b, mname, "customer");
								if (f == true) {
									ch.Booked();
									custlog.info("Ticket Booked Sucessfully");
								} else {
									ch.BookInvalid();
									custlog.error("Invalid Details");
								}
							} else {
								ch.CheckDetails();
								custlog.error("Invalid Details");
							}

							break;
						}

						case 4: {
							custlog.info("Selected to view the ticket");
							ArrayList<Ticket> al = new ArrayList<Ticket>();
							al = bs.ShowTicket(custid);
							if (al != null) {
								ch.Ticketdetails();
								for (Ticket x : al) {
									System.out.println(x);
									System.out.println("");
								}
							} else {
								ch.NoData();
								custlog.error("No data Available");
							}
							break;
						}

						case 5: {
							custlog.info("Selected to cancel the ticket");
							System.out.println(" ");
							System.out.println("Enter Booking Id : ");
							int id = s.nextInt();
							f = bs.CancelTicket(id);
							if (f == true) {
								ch.BookingCancel();
								custlog.info("Booking cancelled Sucessfully");
							} else {
								ch.InvalidBook();
								custlog.error("No Data Available!");
							}
							break;
						}

						case 6: {
							custlog.info("Selected to check check seat availability");
							ArrayList<Availability> al = new ArrayList<Availability>();
							System.out.println("Enter movie name : ");
							String str = s.next();
							if (mr.MatchName(str)) {
								al = ms.CheckSeatAvail(str);
								if (ms.CheckSeatAvail(str) != null) {
									ch.SeatsAvail();
									for (Availability x : al) {
										System.out.println(x + "");
										System.out.println("");
									}
									custlog.info("Seat availability displayed");
								} else {
									ch.NoData();
									custlog.error("No data Available");
								}
							}

							else {
								ch.NameCheck();
								custlog.error("Invalid Name Entered");
							}
							break;
						}

						case 7: {
							custlog.info("Selected to Go Back to Previous Menu");
							c = 7;
							break;
						}

						case 0: {
							ch.Exit();
							ds.ThankYou();
							custlog.info("Program Exit");
							System.exit(0);
						}

						default: {
							ch.ValidOption();
							custlog.error("Invalid input given");
							c = 0;
						}

						}

					} while (c < 7);

				}

				else {
					ch.ValidCredentials();
					custlog.error("Invalid Credentials");

				}
				break;
			}

			case 2: {
				custlog.info("Selected to Register ");
				Customer r = ch.register();
				if (ur.MatchUname(r.getName()) && ur.MatchPwd(r.getPwd()) && ur.MatchPhone(r.getPhone())
						&& ur.MatchMail(r.getEmail())) {
					boolean c1 = cs.AddCustomer(r);
					if (c1 == true) {
						ds.RegSucess();
						custlog.info("Registration Sucess!");
					} else {
						ds.UserExist();
						custlog.error("Already Exists!");
					}
				} else {
					ds.ValidDetails();
					custlog.error("Please enter valid details!");
				}
				break;
			}

			case 3: {
				custlog.info("Selected to go back to previous menu ");
				cust = 3;
				break;
			}

			case 0: {
				ch.Exit();
				ds.ThankYou();
				System.exit(0);
			}

			default: {
				ch.ValidOption();
				cust = 0;
			}

			}
		} while (cust < 3);
	}
}
