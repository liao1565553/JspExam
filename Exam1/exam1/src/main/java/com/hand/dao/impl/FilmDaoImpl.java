package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.utils.ConnectionFactory;

public class FilmDaoImpl implements FilmDao {
	Connection conn = ConnectionFactory.getInstance().makeConnection();;

	public ResultSet getAllFilm() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from film limit 10");
		return ps.executeQuery();
	}
}
