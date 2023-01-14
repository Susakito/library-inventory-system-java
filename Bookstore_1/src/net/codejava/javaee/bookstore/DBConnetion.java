package net.codejava.javaee.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnetion {

	
		
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/Bookstore";
				Connection conn = DriverManager.getConnection(url, "root", "12345");
				return conn;
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}

	

}
}
