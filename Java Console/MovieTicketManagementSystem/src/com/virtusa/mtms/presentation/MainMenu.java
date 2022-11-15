package com.virtusa.mtms.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.virtusa.mtms.dto.Customer;
import com.virtusa.mtms.regex.UserRegex;
import com.virtusa.mtms.service.ICustomerServiceImpl;

public class MainMenu {

	public static void main(String[] args) throws Exception {

		AdminMenu am = new AdminMenu();
		CustomerMenu cm = new CustomerMenu();
		ICustomerServiceImpl cs = new ICustomerServiceImpl();
		CustomerMenuExt ch = new CustomerMenuExt();
		UserRegex ur = new UserRegex();
		MainMenuExt ds = new MainMenuExt();
		Logger mainlog = Logger.getLogger(MainMenu.class);
		Scanner s = new Scanner(System.in);
		int po = 0;
		int reg = 0;
		int d = 0;
		String check = "";
		String choose;
		try {
			do {
				ds.HomePage();
				mainlog.info("Homepage Displayed!");
				System.out.print("Enter your choice: ");
				d = s.nextInt();
				switch (d) {
				case 1: {
					mainlog.info("Selected Register!");
					ds.CaseOne();
					System.out.print("Enter your choice: ");
					reg = s.nextInt();
					switch (reg) {
					case 1: {
						mainlog.info("selected  to continue");
						Customer r = ch.register();
						if (ur.MatchUname(r.getName()) && ur.MatchPwd(r.getPwd()) && ur.MatchPhone(r.getPhone())
								&& ur.MatchMail(r.getEmail())) {
							boolean c1 = cs.AddCustomer(r);
							if (c1 == true) {
								ds.RegSucess();
								mainlog.info("Registration Sucess!");
							} else {
								ds.UserExist();
								mainlog.error("Already Exists!");
							}
						} else {
							ds.ValidDetails();
							mainlog.error("Please enter valid details!");
						}
						break;
					}

					case 2: {
						cm.customerMenu();
						mainlog.info("Selected  to Login");
						break;

					}

					case 0: {

						ds.Exit();
						ds.ThankYou();
						mainlog.info("Program Exit");
						System.exit(0);
						break;

					}
					}
					break;
				}

				case 2: {
					mainlog.info("Selected Customer Login!");
					cm.customerMenu();
					break;
				}
				case 3: {
					mainlog.info("Selected Admin Login!");
					am.adminMenu();
					break;
				}
				case 0: {
					ds.Exit();
					ds.ThankYou();
					mainlog.info("Program Exit!");
					System.exit(0);
				}
				default: {
					ds.ValidOption();
					mainlog.warn("Please choose a valid option!");
					d = 0;
				}

				}
			} while (d < 4);
		} catch (InputMismatchException e) {
			System.out.println("Please check the input given!");
			mainlog.warn("Input Mismatch Error!");
		} catch (Exception e) {
			mainlog.warn(e);
			e.printStackTrace();
		}

	}
}
