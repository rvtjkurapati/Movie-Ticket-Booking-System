package com.virtusa.mtms.service;

import java.util.ArrayList;

import com.virtusa.mtms.dto.Availability;
import com.virtusa.mtms.dto.CustMovie;
import com.virtusa.mtms.dto.Movie;

public interface IMovie {

	public boolean AddMovie(Movie l);

	public boolean DelMovie(int s);

	public ArrayList<Movie> getMovies();

	public ArrayList<CustMovie> getCustMovies();

	public boolean ModifyMovie(Movie l);

	public boolean ValMovieId(int d);

	public String SuggestMovie();

	public ArrayList<Availability> CheckSeatAvail(String m);

}
