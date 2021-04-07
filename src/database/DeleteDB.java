package database;

/**
 * HY360 - Databases :: Fall 2020 :: Project
 * @author Georgios Mpirmpilis - Konstantinos Gkanogiannis
 * DeleteDB.java
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controller;

public class DeleteDB {
	
	public static void deleteAll() throws ClassNotFoundException, SQLException {
        Connection connection  = Database.getConnection();
        Statement statement = connection.createStatement();
        

        String query = "SET FOREIGN_KEY_CHECKS = 0;";    // set this to 0 and delete every row in any way you like
        statement.executeUpdate(query);
        
        query = "DROP TABLE IF EXISTS shift;";
        statement.executeUpdate(query);
        
        query = "DROP TABLE IF EXISTS patients;";
        statement.executeUpdate(query);

        query = "DROP TABLE IF EXISTS disease_symptoms;";
        statement.executeUpdate(query);

        query = "DROP TABLE IF EXISTS employee;";
        statement.executeUpdate(query); 

        
        query = "DROP TABLE IF EXISTS drugs;";
        statement.executeUpdate(query); 

        
        query = "DROP TABLE IF EXISTS symptom_to_doctor;";
        statement.executeUpdate(query); 
        
        query = "DROP TABLE IF EXISTS episkepsi;";
        statement.executeUpdate(query); 
        
        query = "DROP TABLE IF EXISTS exetasi;";
        statement.executeUpdate(query); 
       
        
        // used when shifting staff. when we shift staff, we delete all the records except this because a new day starts
        if (Controller.flag == true) {
        	query = "DROP TABLE IF EXISTS working_days;";
        	statement.executeUpdate(query); 
       }
        query = "SET FOREIGN_KEY_CHECKS = 1;";   // reset it back to 1
        statement.executeUpdate(query);
		statement.close();
		connection.close();
	}
}