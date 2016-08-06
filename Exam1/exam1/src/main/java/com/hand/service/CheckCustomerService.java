package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Customer;
import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.utils.ConnectionFactory;

public class CheckCustomerService {
	private static CustomerDao customerdao = null;

	public static Customer CheckUser(Customer customer) {
		Connection conn = null;
		try {
			customerdao = new CustomerDaoImpl();
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet rs = customerdao.get(conn, customer);
			if (rs.next()) {
				customer.setLastName(rs.getString("last_update"));
				customer.setCreateDate(rs.getDate("create_date"));
				customer.setAddressId(rs.getShort("address_id"));
				customer.setEmail(rs.getString("email"));
				customer.setLastName(rs.getString("last_name"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setStoreId(rs.getByte("store_id"));
				customer.setCustomerId(rs.getShort("customer_id"));
				customer.setActive(rs.getBoolean("active"));
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
