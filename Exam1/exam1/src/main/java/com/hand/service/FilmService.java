package com.hand.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.utils.SqlUtil;

public class FilmService {

	public static void showFilm() {

		FilmDao filmDao = new FilmDaoImpl();
		try {
			ResultSet rs = filmDao.getAllFilm();

			List<?> ls = SqlUtil.resultSetToList(rs);
			Iterator<?> it = ls.iterator();
			while (it.hasNext()) {
				Map<?, ?> hm = (Map<?, ?>) it.next();
				System.out.println(hm.get("length"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Map<?,?>> getFilmList() throws SQLException {
		FilmDao filmDao = new FilmDaoImpl();

		ResultSet rs = filmDao.getAllFilm();
		List<Map<?,?>> lists = SqlUtil.resultSetToList(rs);

		return lists;
	}

}
