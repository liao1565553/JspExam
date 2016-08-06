package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Customer;
import com.hand.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	public void save(Connection conn, Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(Connection conn, Long id, Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Connection conn, Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public ResultSet get(Connection conn, Customer customer) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from customer where first_name=?");
		ps.setString(1, customer.getFirstName());
		return ps.executeQuery();
		
	}

}
