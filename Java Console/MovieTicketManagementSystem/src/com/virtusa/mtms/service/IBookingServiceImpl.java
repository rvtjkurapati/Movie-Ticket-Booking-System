package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dao.IBookingDAOImpl;
import com.virtusa.mtms.dto.Booking;
import com.virtusa.mtms.dto.Ticket;

public class IBookingServiceImpl implements IBooking {

	IBookingDAOImpl dao;

	public boolean BookTicket(Booking b, String name, String role) {
		dao = new IBookingDAOImpl();
		boolean flag = dao.BookTicket(b, name, role);
		return flag;
	}

	public boolean CancelTicket(int id) {
		dao = new IBookingDAOImpl();
		boolean flag = dao.CancelTicket(id);
		return flag;
	}

	public ArrayList<Ticket> ShowTicket(int id) {
		dao = new IBookingDAOImpl();
		ArrayList<Ticket> al = dao.ShowTicket(id);
		return al;
	}

	public ArrayList<Booking> getBookings() {
		dao = new IBookingDAOImpl();
		ArrayList<Booking> al = dao.getBookings();
		return al;
	}
}
