package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dto.Customer;

public interface ICustomer {

	public boolean AddCustomer(Customer l);

	public boolean DelCustomer(int s);

	public boolean ValidateCustomer(Customer l);

	public ArrayList<Customer> getCustomers();

	public boolean ModifyCustomer(String l, String uname, String pwd, String phn, String mail);

	public ArrayList<Customer> SearchCustomer(String str);

	public Customer getCustIdPhone(Customer l);

	public boolean ValidateId(int id);

	public boolean ValidateName(String name);

}
