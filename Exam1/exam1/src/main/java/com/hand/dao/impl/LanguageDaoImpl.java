package com.hand.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hand.dao.LanguageDao;
import com.hand.utils.SqlUtil;

public class LanguageDaoImpl extends Connections implements LanguageDao{

	public ResultSet SelectAll() throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from language");
		return ps.executeQuery();
	}

	public byte getIdByName(String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select language_id from language where name='"+name+"'");
		ResultSet rs=ps.executeQuery();
		List<Map<?, ?>>lists= SqlUtil.resultSetToList(rs);
		return  Byte.parseByte( lists.get(0).get("language_id").toString()) ;
	}

}
