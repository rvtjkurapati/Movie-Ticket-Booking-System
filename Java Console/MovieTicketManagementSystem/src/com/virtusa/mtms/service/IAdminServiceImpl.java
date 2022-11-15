package com.virtusa.mtms.service;

import java.util.ArrayList;
import com.virtusa.mtms.dao.IAdminDAOImpl;
import com.virtusa.mtms.dto.Admin;

public class IAdminServiceImpl implements IAdmin {

	IAdminDAOImpl dao;

	public boolean AddAdmin(Admin l) {
		dao = new IAdminDAOImpl();
		boolean flag = dao.AddAdmin(l);
		return flag;
	}

	public boolean DelAdmin(int s) {
		dao = new IAdminDAOImpl();
		boolean flag = dao.DelAdmin(s);
		return flag;
	}

	public boolean ValidateAdmin(Admin l) {
		dao = new IAdminDAOImpl();
		boolean flag = dao.ValidateAdmin(l);
		return flag;
	}

	public ArrayList<Admin> getAdmins() {
		dao = new IAdminDAOImpl();
		ArrayList<Admin> al = dao.getAdmins();
		return al;
	}

	public boolean ModifyAdmin(Admin l, String str, String pwd) {
		dao = new IAdminDAOImpl();
		boolean flag = dao.ModifyAdmin(l, str, pwd);
		return flag;
	}

	public ArrayList<Admin> SearchAdmin(String str) {
		dao = new IAdminDAOImpl();
		ArrayList<Admin> al = dao.SearchAdmin(str);
		return al;
	}

	public boolean ValidateId(int id) {
		dao = new IAdminDAOImpl();
		boolean flag = dao.ValidateId(id);
		return flag;
	}

	public int getId(Admin l) {
		dao = new IAdminDAOImpl();
		int flag = dao.getId(l);
		return flag;
	}

}
