package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-spring2020-sharma.cybyq1ucy4nv."
			+ "us-east-2.rds.amazonaws.com/cs5200_sp2020_sharma_aditya_jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "Master19";
	private static 	java.sql.Connection dbConnection ;

	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
    	Class.forName(DRIVER);

	if (dbConnection == null) {
		dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
		return  dbConnection;
	} else { return   dbConnection; } }
	
	public static void closeConnection() {
   	 try {
   		 if (dbConnection != null) {
		dbConnection.close();
		dbConnection = null; }
   	 } catch (SQLException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	 }
	}
}

