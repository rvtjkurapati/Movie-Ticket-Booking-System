package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dto.Booking;
import com.virtusa.mtms.dto.Ticket;

public interface IBooking {

	public boolean BookTicket(Booking b, String name, String role);

	public boolean CancelTicket(int id);

	public ArrayList<Ticket> ShowTicket(int id);

	public ArrayList<Booking> getBookings();

}
