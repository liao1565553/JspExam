package com.hand.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	static {
		Properties prop = new Properties();
		try {
			InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream(
					"dbconfig.properties");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("=====读取数据库配置文件错误====");
		}

		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");

	}

	// 定义单例模式
	private static final ConnectionFactory FACTORY = new ConnectionFactory();

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		return FACTORY;
	}

	private Connection conn;

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
