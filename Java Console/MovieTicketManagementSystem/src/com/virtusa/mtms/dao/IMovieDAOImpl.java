package com.virtusa.mtms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.virtusa.mtms.dto.Availability;
import com.virtusa.mtms.dto.CustMovie;
import com.virtusa.mtms.dto.Movie;
import com.virtusa.mtms.util.DbConnection;

public class IMovieDAOImpl {

	public boolean AddMovie(Movie m) {
		try {
			Connection con = DbConnection.getConnection();

			String cmd1 = "select * from movie  where moviename=?";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setString(1, m.getMname());
			ResultSet rs = ps1.executeQuery();

			if (!rs.next()) {
				String cmd2 = "insert into movie (moviename,lang,morning,matinee,secondshow,start_date,end_date) values(?,?,?,?,?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setString(1, m.getMname());
				ps2.setString(2, m.getLang());
				ps2.setString(3, m.getShow1());
				ps2.setString(4, m.getShow2());
				ps2.setString(5, m.getShow3());

				String sdate = m.getSdate();
				String edate = m.getEdate();

				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date1 = sdf1.parse(sdate);
				java.util.Date date2 = sdf1.parse(edate);

				java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
				java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime());

				ps2.setDate(6, sqlStartDate);
				ps2.setDate(7, sqlEndDate);
				ps2.executeUpdate();

				String cmd3 = "with recursive Date_Ranges as (select ? as Date union all select date +interval 1 day from Date_Ranges where date < ?) select * from Date_Ranges";
				PreparedStatement ps3 = con.prepareStatement(cmd3);
				ps3.setDate(1, sqlStartDate);
				ps3.setDate(2, sqlEndDate);
				ResultSet rs3 = ps3.executeQuery();
				while (rs3.next()) {
					String isdate = rs3.getString(1);

					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date3 = sdf3.parse(isdate);
					java.sql.Date sqlSDate = new java.sql.Date(date3.getTime());

					String cmd4 = "select movieId from movie where moviename=?";
					PreparedStatement ps4 = con.prepareStatement(cmd4);
					ps4.setString(1, m.getMname());
					ResultSet rs4 = ps4.executeQuery();
					int mid = 0;

					while (rs4.next()) {
						mid = rs4.getInt(1);
					}

					String cmd5 = "insert into availability (movieId,showdate,morning,matinee,secondshow) values(?,?,120,120,120);";
					PreparedStatement ps5 = con.prepareStatement(cmd5);
					ps5.setInt(1, mid);
					ps5.setDate(2, sqlSDate);
					ps5.executeUpdate();

				}

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

	public boolean DelMovie(int m) {
		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from movie where movieId=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, m);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {

				String cmd3 = "delete from booking where movieId=?;";
				PreparedStatement ps3 = con.prepareStatement(cmd3);
				ps3.setInt(1, m);
				ps3.executeUpdate();

				String cmd4 = "delete from availability where movieId=?;";
				PreparedStatement ps4 = con.prepareStatement(cmd4);
				ps4.setInt(1, m);
				ps4.executeUpdate();

				String cmd2 = "delete from movie where movieId=?;";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setInt(1, m);
				ps2.executeUpdate();

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}

	public String SuggestMovie() {
		try {
			Connection con = DbConnection.getConnection();
			int id = 0;
			String name = "";
			String cmd1 = "SELECT movieId,COUNT(movieId) AS `value`  FROM booking  GROUP BY movieId ORDER BY COUNT(*) DESC LIMIT 1;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}

			String cmd2 = "select moviename from movie where movieId=?;";
			PreparedStatement ps2 = con.prepareStatement(cmd2);
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				name = rs2.getString(1);
			}

			if (name.equals("")) {
				return null;
			}

			return "Movie: " + name;

		} catch (Exception e) {

			e.getStackTrace();
		}
		return null;
	}

	public ArrayList<Movie> getMovies() {

		try {
			ArrayList<Movie> log = new ArrayList<Movie>();
			Connection con = DbConnection.getConnection();
			String cmd = "select * from movie";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				String mname = rs.getString(2);
				String lang = rs.getString(3);
				String show1 = rs.getString(4);
				String show2 = rs.getString(5);
				String show3 = rs.getString(6);
				String sdate = rs.getString(7);
				String edate = rs.getString(8);

				Movie l = new Movie(id, mname, lang, show1, show2, show3, sdate, edate);
				log.add(l);

			}

			if (log.size() != 0) {
				return log;
			}

			else {
				return null;
			}

		}

		catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public ArrayList<CustMovie> getCustMovies() {
		ArrayList<CustMovie> log = new ArrayList<CustMovie>();
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from movie";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				String mname = rs.getString(2);
				String lang = rs.getString(3);
				String show1 = rs.getString(4);
				String show2 = rs.getString(5);
				String show3 = rs.getString(6);

				CustMovie l = new CustMovie(id, mname, lang, show1, show2, show3);
				log.add(l);

			}
			if (log.size() != 0) {
				return log;
			}

			else {
				return null;
			}
		}

		catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public boolean ModifyMovie(Movie m) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from movie where movieId=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, m.getMid());
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {

				String cmd = "update  movie  set moviename=?,lang=?,morning=?,matinee=?,secondshow=?,start_date=?,end_date=? where movieId=?;";
				PreparedStatement ps = con.prepareStatement(cmd);
				ps.setString(1, m.getMname());
				ps.setString(2, m.getLang());
				ps.setString(3, m.getShow1());
				ps.setString(4, m.getShow2());
				ps.setString(5, m.getShow3());

				String sdate = m.getSdate();
				String edate = m.getEdate();

				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date1 = sdf1.parse(sdate);
				java.util.Date date2 = sdf1.parse(edate);

				java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
				java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime());

				ps.setDate(6, sqlStartDate);
				ps.setDate(7, sqlEndDate);

				ps.setInt(8, m.getMid());

				String cmd2 = "select * from movie where moviename=?;";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setString(1, m.getMname());
				ResultSet rs2 = ps2.executeQuery();

				if (!rs2.next()) {
					ps.executeUpdate();

					String cmd6 = "delete from availability where movieId=?;";
					PreparedStatement ps6 = con.prepareStatement(cmd6);
					ps6.setInt(1, m.getMid());
					ps6.executeUpdate();

					String cmd7 = "delete from  booking  where movieId=?;";
					PreparedStatement ps7 = con.prepareStatement(cmd7);
					ps7.setInt(1, m.getMid());
					ps7.executeUpdate();

					String cmd3 = "with recursive Date_Ranges as (select ? as Date union all select date +interval 1 day from Date_Ranges where date < ?) select * from Date_Ranges";
					PreparedStatement ps3 = con.prepareStatement(cmd3);
					ps3.setDate(1, sqlStartDate);
					ps3.setDate(2, sqlEndDate);
					ResultSet rs3 = ps3.executeQuery();
					while (rs3.next()) {
						String isdate = rs3.getString(1);

						SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date3 = sdf3.parse(isdate);
						java.sql.Date sqlSDate = new java.sql.Date(date3.getTime());

						String cmd5 = "insert into availability (movieId,showdate,morning,matinee,secondshow) values(?,?,120,120,120);";
						PreparedStatement ps5 = con.prepareStatement(cmd5);
						ps5.setInt(1, m.getMid());
						ps5.setDate(2, sqlSDate);
						ps5.executeUpdate();
						return true;

					}
				} else {
					return false;
				}

			}

			else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}

		return false;
	}

	public ArrayList<Availability> CheckSeatAvail(String m) {
		try {

			Connection con = DbConnection.getConnection();
			ArrayList<Availability> log = new ArrayList<Availability>();
			int id = 0;
			String cmd3 = "select movieId from movie where moviename=?";
			PreparedStatement ps3 = con.prepareStatement(cmd3);
			ps3.setString(1, m);
			ResultSet rs3 = ps3.executeQuery();

			if (rs3.next()) {
				id = rs3.getInt(1);

				String cmd1 = "select * from availability where movieId=?";
				PreparedStatement ps = con.prepareStatement(cmd1);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					id = rs.getInt(1);
					String date = rs.getString(2);
					int show1 = rs.getInt(3);
					int show2 = rs.getInt(4);
					int show3 = rs.getInt(5);

					String mdate = date;
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date datei = sdf1.parse(mdate);
					java.sql.Date sqlDate = new java.sql.Date(datei.getTime());

					String cmd4 = "SELECT date_format(showdate, \"%M %D %Y\") as date from availability where (movieId=? and showdate=?)";
					PreparedStatement ps4 = con.prepareStatement(cmd4);
					ps4.setInt(1, id);

					ps4.setDate(2, sqlDate);
					ResultSet rs4 = ps4.executeQuery();

					while (rs4.next()) {
						date = rs4.getString(1);
					}

					Availability l = new Availability(m, date, show1, show2, show3);
					log.add(l);

				}

			}

			if (log.size() != 0) {
				return log;
			} else {
				return null;
			}

		} catch (Exception e) {

			e.getStackTrace();
		}
		return null;
	}

	public boolean ValMovieId(int d) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from  movie  where movieId=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setInt(1, d);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return true;
			}

			else {

				return false;
			}

		}

		catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}
}
