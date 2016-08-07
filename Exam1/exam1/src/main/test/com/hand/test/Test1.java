package com.hand.test;

import java.sql.SQLException;

import com.hand.service.FilmService;

public class Test1 {
	public static void main(String[] args) {
		try {
			FilmService.getFilmList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
