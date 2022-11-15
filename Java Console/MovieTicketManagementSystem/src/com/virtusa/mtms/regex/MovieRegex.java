package com.virtusa.mtms.regex;

import java.util.regex.Pattern;

public class MovieRegex {
	String str = "";

	public boolean MatchName(String s) {
		boolean f = Pattern.matches("^([a-zA-Z0-9.-]{1,25})$", s);

		return f;
	}

	public boolean MatchLang(String s) {
		boolean f = Pattern.matches("^([A-Z]{1}[a-z]{1,12})$", s);

		return f;
	}

	public boolean MatchMorning(String s) {
		boolean f = Pattern.matches("[0-1]{1}[0-9]{1}:[0-5]{1}[0-9]{1}[A][M]$", s);

		return f;
	}

	public boolean MatchMatinee(String s) {
		boolean f = Pattern.matches("[0-1]{1}[0-9]{1}:[0-5]{1}[0-9]{1}[P][M]$", s);

		return f;
	}

	public boolean MatchSecnodShow(String s) {
		boolean f = Pattern.matches("[0-1]{1}[0-9]{1}:[0-5]{1}[0-9]{1}[P][M]$", s);

		return f;
	}

	public boolean MatchSDate(String s) {
		boolean f = Pattern.matches(
				"^(((0[1-9]|[12][0-9]|30)[-]?(0[13-9]|1[012])|31[-]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-]?02)[-]?[0-9]{4}|29[-]?02[-]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$",
				s);
		str = s;
		return f;
	}

	public boolean MatchEDate(String s) {
		boolean f = Pattern.matches(
				"^(((0[1-9]|[12][0-9]|30)[-]?(0[13-9]|1[012])|31[-]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-]?02)[-]?[0-9]{4}|29[-]?02[-]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$",
				s);

		return f;

	}
}
