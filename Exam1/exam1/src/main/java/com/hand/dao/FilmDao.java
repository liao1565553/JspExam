package com.hand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FilmDao {
	public ResultSet getAllFilm() throws SQLException;
}
