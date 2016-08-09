package com.hand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface LanguageDao {
	public ResultSet SelectAll() throws SQLException;
	public byte getIdByName(String name)throws SQLException;
}
