package database;


/**
 * HY360 - Databases :: Fall 2020 :: Project
 * @author Georgios Mpirmpilis - Konstantinos Gkanogiannis
 * Database.java
 */

import java.sql.*;

public class Database {
	
	private static final int port 			 = 3306;
	private static final String url 		 = new String("jdbc:mysql://localhost");
	private static final String driver 		 = new String("com.mysql.cj.jdbc.Driver");
	private static final String username 	 = new String("root");
	private static final String password 	 = new String("");
	private static final String databaseName = new String("hy360_database");
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url + ":" + port + "/" + databaseName, username, password);
    }
	
}