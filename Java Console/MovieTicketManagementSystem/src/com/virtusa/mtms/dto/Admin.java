package com.virtusa.mtms.dto;

public class Admin {

	int id;
	String userName;
	String passWord;

	public Admin() {
		super();
	}

	public Admin(int id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		String aid = String.valueOf(id);
		while (aid.length() < 15) {
			aid += " ";
		}
		while (userName.length() < 15) {
			userName += " ";
		}
		while (passWord.length() < 15) {
			passWord += " ";
		}

		return "           Id = " + aid + "    Username = " + userName + "    Password = " + passWord;
	}

}
