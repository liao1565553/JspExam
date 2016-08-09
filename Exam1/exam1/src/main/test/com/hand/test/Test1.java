package com.hand.test;

import java.sql.SQLException;

import com.hand.service.LanguageService;

public class Test1 {
	public static void main(String[] args) {
		try {
			System.out.println(LanguageService.getIdByName("Italian"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
