package com.virtusa.mtms.dto;

public class Ticket {

	int bid;
	int custid;
	String mname;
	String date;
	String showt;
	int seats;

	public Ticket() {
		super();
	}

	public Ticket(int bid, int custid, String mname, String date, String showt, int seats) {
		super();
		this.bid = bid;
		this.custid = custid;
		this.mname = mname;
		this.date = date;
		this.showt = showt;
		this.seats = seats;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
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

	public String getShowt() {
		return showt;
	}

	public void setShowt(String showt) {
		this.showt = showt;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {

		String cid = String.valueOf(bid);
		String cuid = String.valueOf(custid);
		while (cid.length() < 15) {
			cid += " ";
		}
		while (cuid.length() < 15) {
			cuid += " ";
		}
		while (mname.length() < 15) {
			mname += " ";
		}
		while (date.length() < 25) {
			date += " ";
		}
		while (showt.length() < 15) {
			showt += " ";
		}

		return "           Booking Id: " + cid + "    Customer Id: " + cuid + "    Movie Name: " + mname
				+ "    Show date: " + date + "    Show Time: " + showt + "    Tickets:  " + seats;
	}

}
