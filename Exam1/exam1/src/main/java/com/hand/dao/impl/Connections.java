package com.hand.dao.impl;

import java.sql.Connection;

import com.hand.utils.ConnectionFactory;

public class Connections {
	Connection conn = ConnectionFactory.getInstance().makeConnection();
}
