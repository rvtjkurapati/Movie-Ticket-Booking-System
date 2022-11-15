package com.virtusa.mtms.dto;

public class Booking {

	int bid;
	int cid;
	String name;
	String phone;
	int mid;
	String showd;
	String showt;
	int seats;

	public Booking() {
		super();
	}

	public Booking(int bid, int cid, String name, String phone, int mid, String showd, String showt, int seats) {
		super();
		this.bid = bid;
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.mid = mid;
		this.showd = showd;
		this.showt = showt;
		this.seats = seats;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getShowd() {
		return showd;
	}

	public void setShowd(String showd) {
		this.showd = showd;
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
		String boid = String.valueOf(bid);
		String cuid = String.valueOf(cid);
		String moid = String.valueOf(mid);
		while (cuid.length() < 15) {
			cuid += " ";
		}
		while (boid.length() < 15) {
			boid += " ";
		}
		while (name.length() < 15) {
			name += " ";
		}
		while (phone.length() < 15) {
			phone += " ";
		}
		while (moid.length() < 15) {
			moid += " ";
		}
		while (showd.length() < 15) {
			showd += " ";
		}
		while (showt.length() < 15) {
			showt += " ";
		}

		return "           Booking ID = " + boid + " CustId = " + cuid + " Name = " + name + " Phone = " + phone
				+ " Email = " + moid + " Show Date = " + showd + " Show Time=" + showt + " Tickets Booked=" + seats;
	}

}
