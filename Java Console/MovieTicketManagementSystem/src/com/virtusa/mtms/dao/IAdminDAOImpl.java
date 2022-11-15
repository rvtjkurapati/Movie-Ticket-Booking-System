package com.virtusa.mtms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.virtusa.mtms.dto.Admin;
import com.virtusa.mtms.util.DbConnection;

public class IAdminDAOImpl {

	public boolean AddAdmin(Admin l) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from admin  where username=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setString(1, l.getUserName());
			ResultSet rs = ps1.executeQuery();

			if (!rs.next()) {
				String cmd2 = "insert into admin (username, password) values(?,?);";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setString(1, l.getUserName());
				ps2.setString(2, l.getPassWord());
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

	public boolean DelAdmin(int s) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from admin where adminId=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, s);
			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {
				String cmd2 = "delete from admin where adminId=?;";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setInt(1, s);
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

	public boolean ValidateAdmin(Admin l) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from admin where username=? and password=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, l.getUserName());
			ps.setString(2, l.getPassWord());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
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

	public int getId(Admin l) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select adminId from admin where username=? and password=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, l.getUserName());
			ps.setString(2, l.getPassWord());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);

				return id;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return 0;
	}

	public boolean ValidateId(int id) {
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from admin where adminId=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
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

	public ArrayList<Admin> getAdmins() {
		ArrayList<Admin> log = new ArrayList<Admin>();
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from admin;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String uName = rs.getString(2);
				String pWord = rs.getString(3);
				Admin l = new Admin(id, uName, pWord);
				log.add(l);

			}
			if (log.size() != 0) {
				return log;
			} else {
				return null;
			}
		}

		catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public boolean ModifyAdmin(Admin l, String name, String pwd) {

		try {

			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from admin where username=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setString(1, l.getUserName());
			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {
				String cmd = "update  admin  set username=? , password=? where username=?;";
				PreparedStatement ps = con.prepareStatement(cmd);
				ps.setString(1, name);
				ps.setString(2, pwd);
				ps.setString(3, l.getUserName());
				ps.executeUpdate();
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

	public ArrayList<Admin> SearchAdmin(String str) {

		try {
			Connection con = DbConnection.getConnection();
			ArrayList<Admin> log = new ArrayList<Admin>();
			String cmd = "select * from  admin  where username=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String uName = rs.getString(2);
				String pWord = rs.getString(3);
				Admin l = new Admin(id, uName, pWord);
				log.add(l);

			}

			if (log.size() != 0) {

				return log;
			}

			else {

				return null;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

}
