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

	public boolean delFilmById(Short id) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
		ps.execute();
		ps = conn.prepareStatement("delete from film where film_id=" + id);
		ps.execute();
		if (ps.getUpdateCount() > 0) {
			return true;
		}
		return false;
	}
}
