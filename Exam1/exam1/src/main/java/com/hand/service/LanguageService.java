package com.hand.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.utils.SqlUtil;

public class LanguageService {
	static LanguageDao languageDao = new LanguageDaoImpl();
	public static List<Map<?, ?>> getLanguageList() throws SQLException {
		
		ResultSet rs = languageDao.SelectAll();
		return SqlUtil.resultSetToList(rs);
	}

	public static byte getIdByName(String name) throws SQLException{
		return languageDao.getIdByName(name);
	}
}
