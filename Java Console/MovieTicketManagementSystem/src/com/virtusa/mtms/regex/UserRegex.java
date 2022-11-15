package com.virtusa.mtms.regex;

import java.util.regex.Pattern;

public class UserRegex {

	public boolean MatchUname(String s) {
		boolean regex = Pattern.matches("^[a-zA-Z]+([._]?[a-zA-Z0-9]+)*$", s);

		return regex;
	}

	public boolean MatchPwd(String s) {
		boolean regex = Pattern
				.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^!&+=])" + "(?=\\S+$).{8,20}$", s);

		return regex;
	}

	public boolean MatchMail(String s) {
		boolean regex = Pattern.matches(
				"^(?=.{1,64}@)[A-Za-z0-9-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
				s);

		return regex;
	}

	public boolean MatchPhone(String s) {
		boolean regex = Pattern.matches("(0|91)?[6-9][0-9]{9}", s);

		return regex;
	}

}
