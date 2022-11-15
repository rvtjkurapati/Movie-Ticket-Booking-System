package com.virtusa.mtms.service;

import java.util.ArrayList;
import com.virtusa.mtms.dao.IMovieDAOImpl;
import com.virtusa.mtms.dto.Availability;
import com.virtusa.mtms.dto.CustMovie;
import com.virtusa.mtms.dto.Movie;

public class IMovieServiceImpl implements IMovie {

	IMovieDAOImpl dao;

	public boolean AddMovie(Movie l) {
		dao = new IMovieDAOImpl();
		boolean flag = dao.AddMovie(l);
		return flag;
	}

	public boolean DelMovie(int s) {
		dao = new IMovieDAOImpl();
		boolean flag = dao.DelMovie(s);
		return flag;
	}

	public ArrayList<Movie> getMovies() {
		dao = new IMovieDAOImpl();
		ArrayList<Movie> al = dao.getMovies();
		return al;
	}

	public ArrayList<CustMovie> getCustMovies() {
		dao = new IMovieDAOImpl();
		ArrayList<CustMovie> al = dao.getCustMovies();
		return al;
	}

	public boolean ModifyMovie(Movie l) {
		dao = new IMovieDAOImpl();
		boolean flag = dao.ModifyMovie(l);
		return flag;
	}

	public boolean ValMovieId(int d) {
		dao = new IMovieDAOImpl();
		boolean flag = dao.ValMovieId(d);
		return flag;
	}

	public String SuggestMovie() {
		dao = new IMovieDAOImpl();
		String flag = dao.SuggestMovie();
		return flag;
	}

	public ArrayList<Availability> CheckSeatAvail(String m) {
		dao = new IMovieDAOImpl();
		ArrayList<Availability> al = dao.CheckSeatAvail(m);
		return al;
	}
}
