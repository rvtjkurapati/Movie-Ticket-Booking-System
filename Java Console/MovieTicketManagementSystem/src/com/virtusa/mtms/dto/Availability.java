package com.virtusa.mtms.dto;

public class Availability {

	String mname;
	String date;
	int mrng;
	int aftrn;
	int nyt;

	public Availability() {
		super();
	}

	public Availability(String mname, String date, int mrng, int aftrn, int nyt) {
		super();
		this.mname = mname;
		this.date = date;
		this.mrng = mrng;
		this.aftrn = aftrn;
		this.nyt = nyt;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMrng() {
		return mrng;
	}

	public void setMrng(int mrng) {
		this.mrng = mrng;
	}

	public int getAftrn() {
		return aftrn;
	}

	public void setAftrn(int aftrn) {
		this.aftrn = aftrn;
	}

	public int getNyt() {
		return nyt;
	}

	public void setNyt(int nyt) {
		this.nyt = nyt;
	}

	@Override
	public String toString() {

		String mid = String.valueOf(mrng);
		String maid = String.valueOf(aftrn);
		String nid = String.valueOf(nyt);

		while (mname.length() < 15) {
			mname += " ";
		}
		while (date.length() < 30) {
			date += " ";
		}
		while (mid.length() < 15) {
			mid += " ";
		}
		while (maid.length() < 15) {
			maid += " ";
		}
		while (nid.length() < 15) {
			nid += " ";
		}

		return "           Movie Name = " + mname + " Date = " + date + " Morning Show = " + mid + " Matinee Show = "
				+ maid + "  Second Show = " + nid;
	}

}
