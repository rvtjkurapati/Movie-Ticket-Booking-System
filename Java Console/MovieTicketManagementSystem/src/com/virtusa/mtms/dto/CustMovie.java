package com.virtusa.mtms.dto;

public class CustMovie {

	int mid;
	String mname;
	String lang;
	String show1;
	String show2;
	String show3;

	public CustMovie() {
		super();
	}

	public CustMovie(int mid, String mname, String lang, String show1, String show2, String show3) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.lang = lang;
		this.show1 = show1;
		this.show2 = show2;
		this.show3 = show3;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getShow1() {
		return show1;
	}

	public void setShow1(String show1) {
		this.show1 = show1;
	}

	public String getShow2() {
		return show2;
	}

	public void setShow2(String show2) {
		this.show2 = show2;
	}

	public String getShow3() {
		return show3;
	}

	public void setShow3(String show3) {
		this.show3 = show3;
	}

	@Override
	public String toString() {
		while (mname.length() < 15) {
			mname += " ";
		}
		while (lang.length() < 15) {
			lang += " ";
		}
		while (show1.length() < 15) {
			show1 += " ";
		}
		while (show2.length() < 15) {
			show2 += " ";
		}
		return "           Movie Name = " + mname + " Language = " + lang + " Morning Show = " + show1
				+ " Matniee Show = " + show2 + " Second Show = " + show3;
	}

}
