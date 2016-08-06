package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Customer;

public interface CustomerDao {
	public void save(Connection conn, Customer customer) throws SQLException;

	public void update(Connection conn, Long id, Customer customer) throws SQLException;

	public void delete(Connection conn, Customer customer) throws SQLException;

	public ResultSet get(Connection conn, Customer customer) throws SQLException;
}
