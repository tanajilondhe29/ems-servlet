package com.tml.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * 
 * @author TML
 *
 */
public class DbUtil {

	private static Connection connection = null;

	public static Connection getConnection() {

		if (connection != null)
			return connection;
		else {
			try {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/emsservlet";
				String user = "root";
				String password = "";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return connection;
		}

	}

}
