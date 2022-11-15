package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dao.ICustomerDAOImpl;
import com.virtusa.mtms.dto.Customer;

public class ICustomerServiceImpl implements ICustomer {

	ICustomerDAOImpl dao;

	public boolean AddCustomer(Customer l) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.AddCustomer(l);
		return flag;
	}

	public boolean DelCustomer(int s) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.DelCustomer(s);
		return flag;
	}

	public boolean ValidateCustomer(Customer l) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.ValidateCustomer(l);
		return flag;
	}

	public ArrayList<Customer> getCustomers() {
		dao = new ICustomerDAOImpl();
		ArrayList<Customer> al = dao.getCustomers();
		return al;
	}

	public boolean ModifyCustomer(String l, String uname, String pwd, String phn, String mail) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.ModifyCustomer(l, uname, pwd, phn, mail);
		return flag;
	}

	public ArrayList<Customer> SearchCustomer(String str) {
		dao = new ICustomerDAOImpl();
		ArrayList<Customer> al = dao.SearchCustomer(str);
		return al;
	}

	public Customer getCustIdPhone(Customer l) {
		dao = new ICustomerDAOImpl();
		Customer flag = dao.getCustIdPhone(l);
		return flag;
	}

	public boolean ValidateId(int id) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.ValidateId(id);
		return flag;
	}

	public boolean ValidateName(String name) {
		dao = new ICustomerDAOImpl();
		boolean flag = dao.ValidateName(name);
		return flag;
	}

}
