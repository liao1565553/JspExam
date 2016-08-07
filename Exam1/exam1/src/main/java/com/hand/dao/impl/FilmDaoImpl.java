package com.hand.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;

public class FilmDaoImpl extends Connections implements FilmDao {

	public ResultSet getAllFilm() throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from film left outer join language on film.language_id = language.language_id");
		return ps.executeQuery();
	}
}
