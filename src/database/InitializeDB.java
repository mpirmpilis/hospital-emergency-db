package database;

/**
 * HY360 - Databases :: Fall 2020 :: Project
 * @author Georgios Mpirmpilis - Konstantinos Gkanogiannis
 * InitializeDB.java
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controller;

public class InitializeDB {
	
	//private static boolean flag = true;
	
	public static void initAll() throws ClassNotFoundException, SQLException {
		
		CreateTable_Employee();
		
		AddData_Employee();

		CreateTable_Shift();
		
		CreateTable_Patients();
		
		AddData_Patients();
		
		CreateTable_SymptomToDoctor();
		
		AddData_SymptomToDoctor();
		
		CreateTable_Drugs();
		
		AddData_Drugs();
		
		CreateTable_Exetasi();
		CreateTable_Episkepsi();
		
		
		if(Controller.flag == true) {
			working_days();
			Controller.flag = false;
		}
		Increment_WorkingDays();
	}
	
	// create employee table and add some data in it
	private static void CreateTable_Employee() throws SQLException, ClassNotFoundException {
		
        Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS employee ("
        		+ "emp_id INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,"
        		+ "fname VARCHAR(20) NOT NULL,"
        		+ "lname VARCHAR(20) NOT NULL,"
        		+ "age INT NOT NULL,"
        		+ "email VARCHAR(50) NOT NULL UNIQUE,"
        		+ "password INT NOT NULL,"
        		+ "salary INT NOT NULL,"
        		+ "branch VARCHAR(20) NOT NULL,"
        		+ "specialty VARCHAR(20)"
        		+ ");";
        
        statement.executeUpdate(query);
		statement.close();
		connection.close();

	}
	
	private static void AddData_Employee() throws ClassNotFoundException, SQLException {
		
        Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();

        String query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Kostas', 'Gkanogiannis', '25', 'csd3310@csd.uoc.gr', '3310', '20000', 'Doctor', 'Pathologist');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Giwrgos', 'Mpirmpilis', '25', 'csd3296@csd.uoc.gr','3296', '22000', 'Doctor', 'Pathologist');";
        statement.executeUpdate(query);

        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Clint', 'Eastwood', '90', 'clint@email','1930', '55000', 'Doctor', 'Cardiologist');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Dimitris', 'Plexousakis', '50', 'dp@email', '3600', '30000', 'Doctor', 'Cardiologist');";
        statement.executeUpdate(query);

        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Xin', 'Zhao', '32', 'xin@email', '1111', '15000', 'Doctor', 'Orthopedikos');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Robert', 'DeNiro', '72', 'DeNiro@email', '0000', '42000', 'Doctor', 'Orthopedikos');";
        statement.executeUpdate(query);

        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Jason', 'Statham', '48', 'JS@email', '1234', '28000', 'Doctor', 'Pneumologist');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Lord', 'Voldemort', '99', 'Lord@email', '5050', '60000', 'Doctor', 'Pneumologist');";
        statement.executeUpdate(query);

        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Gandalf', 'TheGray', '78', 'Mage@email', '9999', '90000', 'Doctor', 'Surgeon');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Julia', 'Roberts', '48', 'JR@email', '1000', '30000', 'Doctor', 'Surgeon');";
        statement.executeUpdate(query);

        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Mat', 'Damon', '42', 'Damon@email', '1000', '12000', 'Nurse', 'NULL');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Jennifer', 'Lopez', '50', 'JayLo@email', '1000', '14000', 'Nurse', 'NULL');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Gaylord', 'Focker', '31', 'GF@email', '1000', '10000', 'Nurse', 'NULL');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Lara', 'Croft', '29', 'Lara@email', '1000', '9000', 'Nurse', 'NULL');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Sakis', 'Rouvas', '39', 'Sakis@email', '1000', '12000', 'Nurse', 'NULL');";
        statement.executeUpdate(query);

        
        query = "INSERT INTO employee (fname, lname, age, email, password, salary, branch, specialty) "
        		+ "VALUES ('Marie', 'Curie', '60', 'Curie@email', '9999', '90000', 'Management', 'NULL');";
        statement.executeUpdate(query);

        
        statement.close();
		connection.close();
	}
	
	// get the first shift here
	public static void CreateTable_Shift() throws ClassNotFoundException, SQLException {
    
        Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS shift ("
        		+ "emp_id INT NOT NULL PRIMARY KEY,"
        		+ "fname VARCHAR(20) NOT NULL,"
        		+ "lname VARCHAR(20) NOT NULL,"
        		+ "email VARCHAR(20) NOT NULL,"
        		+ "branch VARCHAR(20) NOT NULL,"
        		+ "specialty VARCHAR(20)"
        		+ ");"; 
        
        statement.executeUpdate(query);

        
        query = "ALTER TABLE shift ADD FOREIGN KEY (emp_id) "
        		+ "REFERENCES employee (emp_id);";
        statement.executeUpdate(query);


        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id, fname, lname, email, branch, specialty "
        		+ "FROM employee WHERE employee.specialty = 'Surgeon' "
        		+ "ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);
        
        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.specialty = 'Cardiologist' "
        		+ "ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);
        
        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.specialty = 'Orthopedikos' "
        		+ "ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);
        

        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.specialty = 'Pathologist' "
        		+ "ORDER BY RAND() LIMIT 1;";

        statement.executeUpdate(query);
        
        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.specialty = 'Pneumologist' "
        		+ "ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);
        

        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.branch = 'Nurse' ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);
        

        query = "INSERT INTO shift (emp_id,fname, lname, email, branch, specialty) "
        		+ "SELECT emp_id,fname, lname, email, branch, specialty "
        		+ "FROM employee "
        		+ "WHERE employee.branch = 'Management' ORDER BY RAND() LIMIT 1;";
        statement.executeUpdate(query);

		statement.close();
		connection.close();
	}
	
	private static void Increment_WorkingDays() throws SQLException, ClassNotFoundException{
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "UPDATE working_days,shift SET shifts=shifts+1 "
        		+ "WHERE working_days.emp_id=shift.emp_id;";
        statement.executeUpdate(query);
        
        statement.close();
		connection.close();
	}
	
	private static void CreateTable_Exetasi() throws SQLException, ClassNotFoundException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS exetasi ("
        		+ "exetasi_id INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,"
        		+ "doctor_id INT NOT NULL,"
        		+ "AMKA BIGINT(11) NOT NULL,"
        		+ "parapomph VARCHAR(20),"
        		+ "drug_use VARCHAR(20),"
        		+ "porisma VARCHAR(20) "
        		+ ");";
        statement.executeUpdate(query);
        
        statement.close();
		connection.close();
		
	}
	
	private static void CreateTable_Drugs() throws SQLException, ClassNotFoundException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS drugs ("
        		+ "name VARCHAR(20) NOT NULL PRIMARY KEY,"
        		+ "type VARCHAR(20) NOT NULL,"
        		+ "mg INT NOT NULL,"
        		+ "cure VARCHAR(20) NOT NULL,"
        		+ "stock INT "
        		+ ");";
        statement.executeUpdate(query);
        
        statement.close();
		connection.close();
        
	}
	
	private static void CreateTable_SymptomToDoctor() throws SQLException, ClassNotFoundException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
		
        String query = "CREATE TABLE IF NOT EXISTS symptom_to_doctor ("
        		+ "symptom VARCHAR(20) NOT NULL PRIMARY KEY,"
        		+ "doctor1 INT NOT NULl,"
        		+ "doctor2 INT NOT NULL "
        		+ " );";
        statement.executeUpdate(query);
        statement.close();
		connection.close();
        
	}
	
	private static void AddData_Drugs() throws SQLException, ClassNotFoundException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
		
        String query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('aspirin', 'pill', '10', 'nautia', 200);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('depon', 'pill', '5', 'headache', 850);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('insulin', 'injection', '2', 'diabetes', 30);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('xanax', 'pill', '2', 'stress', 850);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('vicks', 'paste', '12', 'chest pain', 520);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('adrenalin', 'injection', '3', 'nautia', 130);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('lanzoprazole', 'pill', '5', 'stomach ache', 92);";
        statement.executeUpdate(query);
        
        query = "INSERT INTO drugs (name, type, mg, cure, stock) "
        		+ "VALUES ('valerian', 'pill', '7', 'headache', 1850);";
        statement.executeUpdate(query);
	}
	
	private static void AddData_SymptomToDoctor() throws SQLException, ClassNotFoundException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('1', '2', 'nautia');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('1', '2', 'concussion');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('3', '4', 'chest pain');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('3', '4', 'arrythmia');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('5', '6', 'cracked bone');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('5', '6', 'backbone pain');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('7', '8', 'asthma');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('7', '8', 'apnoia');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('9', '10', 'stomach pain');";
        statement.executeUpdate(query);
        
        query = "INSERT INTO symptom_to_doctor (doctor1, doctor2, symptom) "
        		+ "VALUES ('9', '10', 'koili');";
        statement.executeUpdate(query);

		statement.close();
		connection.close();
	}
	
	private static void CreateTable_Patients() throws SQLException, ClassNotFoundException {
   
        Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
		
        String query = "CREATE TABLE IF NOT EXISTS patients ("
        		+ "AMKA BIGINT(11) NOT NULL UNIQUE PRIMARY KEY,"
        		+ "fname VARCHAR(50) NOT NULL,"
        		+ "lname VARCHAR(50) NOT NULL,"
        		+ "password INT NOT NULL,"
        		+ "address VARCHAR(40),"
        		+ "asf_foreas VARCHAR(40) NOT NULL,"
        		+ "age INT NOT NULL,"
        		+ "email VARCHAR(50) NOT NULL,"
        		+ "chronic_disease VARCHAR(50),"
        		+ "symptom VARCHAR(50),"
        		+ "my_doctor INT NOT NULL,"
        		+ "review VARCHAR(50) "
        		+ ");";
        
        statement.executeUpdate(query); 
        
 		statement.close();
 		connection.close(); 
	}
	
	private static void AddData_Patients() throws ClassNotFoundException, SQLException {
		
        Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        // PATIENTS INITS
        String query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 22695422087, 'John', 'Wilson', '2020', 'Road 18, Heraklion', 'IKA', 55, 'wilson@email', 'asthma', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Surgeon') )";
        statement.executeUpdate(query);
        
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 41694001557, 'Mike', 'Williams', '2020', 'Rezou 35, Heraklion', 'IKA', 65, 'williams@email', 'diabetes', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Surgeon') )";
        statement.executeUpdate(query);
           
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 99783288427, 'Sarah', 'Parker', '2020', 'Rezou 55, Athens', 'TEBE', 65, 'parker@email', 'NULL', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Surgeon') )";
        statement.executeUpdate(query);
       
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 76298874174, 'Mary', 'Jones', '2020', 'Street 25, SKG', 'OGA', 48, 'jones@email', 'NULL', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Surgeon') )";
        statement.executeUpdate(query);
        
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 67572312701, 'Bill', 'Smith', '2020', 'Odos 53, Ioannina', 'IKA', 82, 'smith@email', 'arrythmia', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Cardiologist') )";
        statement.executeUpdate(query);
        
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 66964420266, 'Jack', 'White', '2020', 'Baker 18, Athens', 'IKA', 72, 'white@email', 'NULL', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Pathologist') )";
        statement.executeUpdate(query);
        
        query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
        		+ "VALUES( 11116554725, 'Betty', 'Selby', '2020', 'LA 55, Rethumno', 'IKA', 51, 'selby@email', 'osteoporosis', 'NULL', (SELECT emp_id FROM shift WHERE shift.specialty = 'Orthopedikos') )";
        statement.executeUpdate(query);

 		statement.close();
 		connection.close();
	}
	
	private static void working_days() throws ClassNotFoundException, SQLException{
		
		Connection connection = Database.getConnection();
        Statement statement   = connection.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS working_days ("
        		+ "emp_id INT NOT NULL UNIQUE PRIMARY KEY,"  
        		+ "shifts INT NOT NULL" 
        		+ ");";
        
        statement.executeUpdate(query); 

        for(int i = 1; i < 17; i++) {
            query = "INSERT INTO working_days( emp_id, shifts ) "
                	+ "VALUES(" + i + ", '0') ";
            statement.executeUpdate(query);
        }

		statement.close();
 		connection.close();
	}
	
	
	
	
	
	private static void CreateTable_Episkepsi() throws ClassNotFoundException, SQLException {
		
		 Connection connection = Database.getConnection();
	     Statement statement   = connection.createStatement();
	        
	     String query = "CREATE TABLE IF NOT EXISTS episkepsi ("
	        		+ "visit_id INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,"
	        		+ "visitor VARCHAR(20) NOT NULL,"
	        		+ "time INT NOT NULL,"
	        		+ "visited_patient BIGINT NOT NULL" 
	        		+ ");";
	        
	     statement.executeUpdate(query);
	     statement.close();
		 connection.close();
	}
}