package com.hand.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hand.bean.Film;
import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.utils.SqlUtil;

public class FilmService {
	static FilmDao filmDao = new FilmDaoImpl();
	public static void showFilm() {

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

	public static List<Map<?, ?>> getFilmList() throws SQLException {
		FilmDao filmDao = new FilmDaoImpl();

		ResultSet rs = filmDao.getAllFilm();
		List<Map<?, ?>> lists = SqlUtil.resultSetToList(rs);
		
		return lists;
	}

	public static boolean delFilmById(short id) throws SQLException {
		FilmDao filmDao = new FilmDaoImpl();
		if (filmDao.delFilmById(id)) {
			return true;
		}
		return false;
	}
	
	public static boolean addFilm(Film film) throws SQLException{
		return filmDao.addFilm(film);
	}

}
