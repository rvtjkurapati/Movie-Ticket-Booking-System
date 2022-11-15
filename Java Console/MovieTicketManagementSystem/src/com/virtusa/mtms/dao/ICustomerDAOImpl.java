package com.virtusa.mtms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.virtusa.mtms.dto.Customer;
import com.virtusa.mtms.util.DbConnection;

public class ICustomerDAOImpl {

	public boolean AddCustomer(Customer cust) {

		try {
			Connection con = DbConnection.getConnection();

			String cmd1 = "select * from customer where username=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setString(1, cust.getName());
			ResultSet rs = ps1.executeQuery();
			if (!rs.next()) {
				String cmd2 = "insert into customer(username,password,phone,email) values(?,?,?,?);";
				PreparedStatement ps2 = con.prepareStatement(cmd2);
				ps2.setString(1, cust.getName());
				ps2.setString(2, cust.getPwd());
				ps2.setString(3, cust.getPhone());
				ps2.setString(4, cust.getEmail());
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

	public boolean DelCustomer(int s) {

		try {
			Connection con = DbConnection.getConnection();

			String cmd1 = "select * from customer where custId=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setInt(1, s);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				String cmd2 = "delete from customer where custId=?;";
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

	public boolean ValidateCustomer(Customer c) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from customer where username=? and password=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, c.getName());
			ps.setString(2, c.getPwd());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}

	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> log = new ArrayList<Customer>();
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from customer";
			PreparedStatement ps = con.prepareStatement(cmd);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String uName = rs.getString(2);
				String pWord = rs.getString(3);
				String phone = rs.getString(4);
				String mail = rs.getString(5);
				Customer l = new Customer(id, uName, pWord, phone, mail);
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

	public boolean ModifyCustomer(String name, String uname, String pwd, String phn, String mail) {

		try {
			Connection con = DbConnection.getConnection();
			String cmd1 = "select * from customer where username=?;";
			PreparedStatement ps1 = con.prepareStatement(cmd1);
			ps1.setString(1, name);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {

				String cmd = "update  customer  set username=? , password=? , phone=? , email=? where username=?;";
				PreparedStatement ps = con.prepareStatement(cmd);
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ps.setString(3, phn);
				ps.setString(4, mail);
				ps.setString(5, name);
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

	public ArrayList<Customer> SearchCustomer(String str) {

		try {
			Connection con = DbConnection.getConnection();
			ArrayList<Customer> log = new ArrayList<Customer>();
			String cmd = "select * from  customer  where username=?;";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String uName = rs.getString(2);
				String pWord = rs.getString(3);
				String phone = rs.getString(4);
				String mail = rs.getString(5);
				Customer l = new Customer(id, uName, pWord, phone, mail);
				log.add(l);

			}

			if (log.size() > 0) {

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

	public Customer getCustIdPhone(Customer l) {
		try {
			int id = 0;
			String phn = "";
			Customer c = new Customer();
			Connection con = DbConnection.getConnection();
			String cmd = "select custId,phone from customer where username=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, l.getName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
				phn = rs.getString(2);
				c = new Customer(id, "", "", phn, "");
				return c;
			}
			return null;
		}

		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public boolean ValidateId(int id) {
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from customer where custId=?";
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

	public boolean ValidateName(String name) {
		try {
			Connection con = DbConnection.getConnection();
			String cmd = "select * from customer where username=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, name);
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

}
