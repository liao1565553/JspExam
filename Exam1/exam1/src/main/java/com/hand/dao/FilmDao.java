package com.hand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Film;

public interface FilmDao {
	public ResultSet getAllFilm() throws SQLException;
	public boolean delFilmById(Short id) throws SQLException;
	public boolean addFilm(Film film) throws SQLException;
}
