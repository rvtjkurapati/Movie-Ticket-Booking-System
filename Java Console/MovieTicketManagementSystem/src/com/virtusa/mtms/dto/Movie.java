package com.virtusa.mtms.dto;

public class Movie {

	int mid;
	String mname;
	String lang;
	String show1;
	String show2;
	String show3;
	String sdate;
	String edate;

	public Movie() {
		super();
	}

	public Movie(int mid, String mname, String lang, String show1, String show2, String show3, String sdate,
			String edate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.lang = lang;
		this.show1 = show1;
		this.show2 = show2;
		this.show3 = show3;
		this.sdate = sdate;
		this.edate = edate;
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

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		String cid = String.valueOf(mid);
		while (cid.length() < 15) {
			cid += " ";
		}
		while (mname.length() < 20) {
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

		while (show3.length() < 15) {
			show3 += " ";
		}
		while (sdate.length() < 15) {
			sdate += " ";
		}

		while (edate.length() < 15) {
			edate += " ";
		}

		return "           Movie ID = " + cid + " Movie Name = " + mname + " language = " + lang + " Morning Show = "
				+ show1 + " Matniee Show = " + show2 + " Second Show = " + show3 + " Start Date = " + sdate
				+ " End Date = " + edate;
	}

}
