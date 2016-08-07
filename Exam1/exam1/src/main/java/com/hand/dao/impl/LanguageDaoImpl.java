package com.hand.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.LanguageDao;

public class LanguageDaoImpl extends Connections implements LanguageDao{

	public ResultSet SelectAll() throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from language");
		return ps.executeQuery();
	}

}
