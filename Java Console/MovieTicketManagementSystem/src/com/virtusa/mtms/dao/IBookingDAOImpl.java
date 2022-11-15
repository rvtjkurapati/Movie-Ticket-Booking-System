package com.virtusa.mtms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.virtusa.mtms.dto.Booking;
import com.virtusa.mtms.dto.Ticket;
import com.virtusa.mtms.util.DbConnection;

public class IBookingDAOImpl {

	public boolean BookTicket(Booking b, String mname, String role) {
		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "";
			if (role.equals("admin")) {
				cmd1 = "select adminId from admin  where adminId=?";
			} else if (role.equals("customer")) {
				cmd1 = "select custId from customer  where custId=?";
			}

			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, b.getCid());
			ResultSet rs1 = ps1.executeQuery();

			String cmd2 = "select moviename from movie  where moviename=?;";
			PreparedStatement ps2 = con.prepareStatement(cmd2);
			ps2.setString(1, mname);
			ResultSet rs2 = ps2.executeQuery();

			int mid = 0;
			String cmd6 = "select movieId from movie where moviename=?";
			PreparedStatement ps6 = con.prepareStatement(cmd6);
			ps6.setString(1, mname);
			ResultSet rs6 = ps6.executeQuery();
			while (rs6.next()) {
				mid = rs6.getInt(1);
			}
			int aid = 0;
			if (role.equals("admin")) {
				String cmd8 = "select adminId from admin where username=?";
				PreparedStatement ps8 = con.prepareStatement(cmd8);
				ps8.setString(1, b.getName());
				ResultSet rs8 = ps8.executeQuery();
				while (rs8.next()) {
					aid = rs8.getInt(1);
				}
			}

			String mdate = b.getShowd();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date datei = sdf1.parse(mdate);
			java.sql.Date sqlDate = new java.sql.Date(datei.getTime());

			String cmd3 = "select movieId from movie where (? >= start_date) and (end_date >= ? ) and movieId=?;";
			PreparedStatement ps3 = con.prepareStatement(cmd3);
			ps3.setDate(1, sqlDate);
			ps3.setDate(2, sqlDate);
			ps3.setInt(3, mid);
			ResultSet rs3 = ps3.executeQuery();
			String cmd7 = "";
			if (b.getShowt().equals("morning")) {
				cmd7 = "select morning from availability where showdate=? and movieId=?;";
			} else if (b.getShowt().equals("matinee")) {
				cmd7 = "select matinee from availability where showdate=? and movieId=?;";
			} else if (b.getShowt().equals("secondshow")) {
				cmd7 = "select secondshow from availability where showdate=? and movieId=?;";
			}

			PreparedStatement ps7 = con.prepareStatement(cmd7);
			ps7.setDate(1, sqlDate);
			ps7.setInt(2, mid);
			ResultSet rs7 = ps7.executeQuery();

			if (rs1.next() && rs2.next() && rs3.next() && rs7.next()) {

				String cmd4 = "insert into booking (custId,username,phone,movieId,showdate,showtime,seats) values(?,?,?,?,?,?,?)";
				PreparedStatement ps4 = con.prepareStatement(cmd4);
				if (role.equals("admin")) {
					ps4.setInt(1, aid);
				} else {
					ps4.setInt(1, b.getCid());
				}

				ps4.setString(2, b.getName());
				ps4.setString(3, b.getPhone());
				ps4.setInt(4, mid);
				ps4.setDate(5, sqlDate);
				ps4.setString(6, b.getShowt());
				ps4.setInt(7, b.getSeats());
				ps4.executeUpdate();

				String cmd5 = "";
				if (b.getShowt().equals("morning")) {
					cmd5 = "update availability set morning =(morning-?) where (movieId=? and showdate=?)";
				} else if (b.getShowt().equals("matinee")) {
					cmd5 = "update availability set matinee =(matinee-?) where (movieId=? and showdate=?)";
				} else if (b.getShowt().equals("secondshow")) {
					cmd5 = "update availability set secondshow =(secondshow-?) where (movieId=? and showdate=?)";
				}

				PreparedStatement ps5 = con.prepareStatement(cmd5);
				ps5.setInt(1, b.getSeats());
				ps5.setInt(2, mid);
				ps5.setDate(3, sqlDate);
				ps5.executeUpdate();

				return true;
			}

			else {
				return false;
			}

		} catch (Exception e) {

			e.getStackTrace();
		}
		return false;
	}

	public boolean CancelTicket(int id) {
		try {
			int mid = 0;
			int seats = 0;
			String stime = "";
			String date = "";
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from booking  where bid=?";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, id);

			String cmd3 = "select * from booking  where bid=?";
			PreparedStatement ps3 = con.prepareStatement(cmd3);
			ps3.setInt(1, id);
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			while (rs1.next()) {
				mid = rs1.getInt(5);
				stime = rs1.getString(7);
				seats = rs1.getInt(8);
				date = rs1.getString(6);
			}

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date datei = sdf1.parse(date);
			java.sql.Date dateS = new java.sql.Date(datei.getTime());

			if (rs3.next()) {

				String cmd5 = "";

				if (stime.equals("morning")) {
					cmd5 = "update availability set morning =(morning+?) where (movieId=? and showdate=?)";
				} else if (stime.equals("matinee")) {
					cmd5 = "update availability set matinee =(matinee+?) where (movieId=? and showdate=?)";
				} else if (stime.equals("secondshow")) {
					cmd5 = "update availability set secondshow =(secondshow+?) where (movieId=? and showdate=?)";
				}

				PreparedStatement ps5 = con.prepareStatement(cmd5);
				ps5.setInt(1, seats);
				ps5.setInt(2, mid);
				ps5.setDate(3, dateS);
				ps5.executeUpdate();

				String cmd2 = "delete from booking where bid=?";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setInt(1, id);
				ps2.executeUpdate();
				return true;
			}

			else {
				return false;
			}

		} catch (Exception e) {

			e.getStackTrace();
		}
		return false;
	}

	public ArrayList<Ticket> ShowTicket(int custid) {
		try {
			Connection con = DbConnection.getConnection();
			ArrayList<Ticket> al = new ArrayList<Ticket>();
			String cmd1 = "select * from booking  where custid=?";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, custid);
			ResultSet rs3 = ps1.executeQuery();

			if (rs3.next()) {
				String mname = "";
				String cmd2 = "select * from booking where custId=?";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setInt(1, custid);
				ResultSet rs1 = ps2.executeQuery();

				int bid = 0;
				int cid = 0;
				int mid = 0;
				String mdate = "";
				String date = "";
				String showt = "";
				int seats = 0;
				String time = "";

				while (rs1.next()) {
					bid = rs1.getInt(1);
					cid = rs1.getInt(2);
					mid = rs1.getInt(5);
					showt = rs1.getString(7);
					seats = rs1.getInt(8);

					String cmd3 = "select moviename from movie where movieId=?";
					PreparedStatement ps3 = con.prepareStatement(cmd3);
					ps3.setInt(1, mid);
					ResultSet rs2 = ps3.executeQuery();

					while (rs2.next()) {
						mname = rs2.getString(1);
					}

					String cmd4 = "SELECT date_format(showdate, \"%M %D %Y\") as date from booking where (movieId=? and bid=?)";
					PreparedStatement ps4 = con.prepareStatement(cmd4);
					ps4.setInt(1, mid);
					ps4.setInt(2, bid);
					ResultSet rs4 = ps4.executeQuery();

					while (rs4.next()) {
						date = rs4.getString(1);
					}

					String cmd5 = "";

					if (showt.equals("morning")) {
						cmd5 = "select morning from movie where movieId=?";
					} else if (showt.equals("matinee")) {
						cmd5 = "select matinee from movie where movieId=?";
					} else if (showt.equals("secondshow")) {
						cmd5 = "select secondshow from movie where movieId=?";
					}

					PreparedStatement ps5 = con.prepareStatement(cmd5);
					ps5.setInt(1, mid);
					ResultSet rs5 = ps5.executeQuery();

					while (rs5.next()) {
						time = rs5.getString(1);
					}

					Ticket l = new Ticket(bid, cid, mname, date, time, seats);
					al.add(l);
				}

				return al;
			}

			else {
				return null;
			}

		} catch (Exception e) {

			e.getStackTrace();
			return null;
		}

	}

	public ArrayList<Booking> getBookings() {
		try {
			Connection con = DbConnection.getConnection();
			ArrayList<Booking> al = new ArrayList<Booking>();
			String cmd1 = "select * from booking";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ResultSet rs3 = ps1.executeQuery();
			while (rs3.next()) {
				int bid = rs3.getInt(1);
				int cid = rs3.getInt(2);
				String cname = rs3.getString(3);
				String phone = rs3.getString(4);
				int mid = rs3.getInt(5);
				String date = rs3.getString(6);
				String time = rs3.getString(7);
				int seats = rs3.getInt(8);

				Booking l = new Booking(bid, cid, cname, phone, mid, date, time, seats);
				al.add(l);
			}

			if (al.size() != 0) {

				return al;
			}

			else {
				return null;
			}

		} catch (Exception e) {

			e.getStackTrace();
			return null;
		}

	}

}
