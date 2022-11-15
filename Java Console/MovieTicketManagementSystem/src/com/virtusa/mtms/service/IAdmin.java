package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dto.Admin;

public interface IAdmin {

	public boolean AddAdmin(Admin l);

	public boolean DelAdmin(int s);

	public boolean ValidateAdmin(Admin l);

	public ArrayList<Admin> getAdmins();

	public boolean ModifyAdmin(Admin l, String str, String pwd);

	public ArrayList<Admin> SearchAdmin(String str);

	public boolean ValidateId(int id);

	public int getId(Admin l);

}
