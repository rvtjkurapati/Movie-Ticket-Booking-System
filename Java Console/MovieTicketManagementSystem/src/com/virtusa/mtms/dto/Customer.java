package com.virtusa.mtms.dto;

public class Customer {
	
	int id;
	String pwd;
	String name;
	String phone;
	String email;
	
	public Customer() {
		super();
	}

	public Customer(int id, String name,String pwd,  String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		
		String cid=String.valueOf(id);
		while(cid.length()<15)
		{
			cid+=" ";
		}
		while(name.length()<15)
		{
			name+=" ";
		}
		while(pwd.length()<15)
		{
			pwd+=" ";
		}
		while(phone.length()<15)
		{
			phone+=" ";
		}
		while(email.length()<15)
		{
			email+=" ";
		}
		return "           Id=" + cid + "   Name=" + name + "    Password=" + pwd + "    Phone=" + phone + "    Email=" + email ;
	}
	
	
}
