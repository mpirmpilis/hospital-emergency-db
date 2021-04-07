package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import database.InitializeDB;
import database.Database;
import database.DeleteDB;

import view.GUI;


/**
 * HY360 - Databases :: Fall 2020 :: Project
 * @author Georgios Mpirmpilis - Konstantinos Gkanogiannis
 * Controller.java
 */

public class Controller {

	private GUI view;
	
	public int current_AMKA;
	String[] infos = new String[5];
	public String[] current_staff_infos = new String[9];
	public String[] current_patient_infos = new String[12];
	public static boolean flag = true;

	//public static boolean flag = true;
	
	public Controller() throws ClassNotFoundException, SQLException  {
	
		DeleteDB.deleteAll();       // clear any leftover tables from previous testing
		InitializeDB.initAll();     // setup the whole db with tables and data in them
		
		current_AMKA = 0;
		
		this.view = new GUI(this);    // make a reference to view so we can update our frames
		this.view.addLoginStaffListener(new LoginStaffListener());     // add listener (=action) to button intended for staff login
		this.view.addLoginPatientListener(new LoginPatientListener()); // add listener (=action) to button intended for patient login
		this.view.addLExamineListener(new ExamineButtonListener());
		this.view.AddSendToNurseButton(new SendToNurseListener());
		this.view.AddLogoutListener(new LogoutListener());
		this.view.AddExamineByNurseListener(new ExamineByNurseListener());
		this.view.updatePatientInfo(new UpdateInfoListener());
		this.view.logoutPatient(new LogoutPatientListener());
		this.view.confirmPatientChanges(new ConfirmChangesListener());
		this.view.newPatient(new NewPatientListener());
		this.view.registerNewPatient(new RegisterPatientListener());
		this.view.addVisitor(new VisitorListener());
		this.view.registerVisitor(new RegisterVisitorListener());
		
		
		
		
		
		this.view.AddNewShiftListener(new NewShiftListener());
		this.view.AddQueryListener(new QueryChangesListener());
	}
	
	
	class QueryChangesListener implements ActionListener {
public void actionPerformed(ActionEvent e)  {
		if (view.afthaireti_erwtisi.getText().equals("working days")) {	
			
			try {
				Connection connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				String s = "";
				String query = "SELECT fname, lname, shifts FROM employee NATURAL LEFT JOIN working_days WHERE employee.emp_id = working_days.emp_id;";
				ResultSet apotelesmata88 = statement.executeQuery(query);
				
				while (apotelesmata88.next() == true) {
					s = s + apotelesmata88.getString("fname") + " " + apotelesmata88.getString("lname") + " - " + apotelesmata88.getString("shifts") + "\n";
				}
				JOptionPane.showMessageDialog(null,s,"Katastasi Efimeriwn",JOptionPane.INFORMATION_MESSAGE);
				statement.close();
				connection.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} else if (view.afthaireti_erwtisi.getText().equals("COVID-19 reports")) {
			String s = "AMKA  -  First_Name  -  Last_Name  -  Password  -  Address  -  Asf_Foreas  -  Age  -  email  -  Xronies pathiseis  -  Symptwmata\n\n";
			String query = "SELECT * FROM patients WHERE review = \"COVID-19\";";
			
			try {
				Connection connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				ResultSet apotelesmata88 = statement.executeQuery(query);
				ResultSetMetaData metadata = apotelesmata88.getMetaData();
				while (apotelesmata88.next() == true) {
					for (int i=1; i<=metadata.getColumnCount(); i++) {
						s = s + apotelesmata88.getString(i) + " - ";
					}
					s = s.substring(0, s.length() - 3);
					s = s + "\n";
				}
				JOptionPane.showMessageDialog(null,s,"COVID-19 REPORTS",JOptionPane.INFORMATION_MESSAGE);
				statement.close();
				connection.close();
			} catch (SQLException | ClassNotFoundException e1) {
				// NOTHING HERE
			}
		} else if (view.afthaireti_erwtisi.getText().equals("total visits")) {
			String s = "Total visits for today: ";
			String query = "SELECT COUNT(*) FROM episkepsi;";

			try {
				Connection connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				ResultSet apotelesmata88 = statement.executeQuery(query);
				while (apotelesmata88.next() == true) {
					s = s + apotelesmata88.getInt("count(*)");
				}
				JOptionPane.showMessageDialog(null,s,"Current shift TOTAL VISITS",JOptionPane.INFORMATION_MESSAGE);
				statement.close();
				connection.close();
			} catch (SQLException | ClassNotFoundException e1) {
				// NOTHING HERE
			}
		} else {
			
			String query = view.afthaireti_erwtisi.getText();
			try {
				Connection connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				ResultSet apotelesmata88 = statement.executeQuery(query);
				String s = "Given query --> " + query + "\n\n";
				ResultSetMetaData metadata = apotelesmata88.getMetaData();
				
				for (int i=1; i<=metadata.getColumnCount(); i++) {
					s = s + metadata.getColumnName(i) + " - ";
				}
				s = s.substring(0, s.length() - 3);
				s = s + "\n";
				while (apotelesmata88.next() == true) {
					for (int i=1; i<=metadata.getColumnCount(); i++) {
						if (metadata.getColumnName(i).equals("password")) {
							s = s  + " ********** - ";
						} else {
							s = s + apotelesmata88.getString(i) + " - ";
						}
					}
					s = s.substring(0, s.length() - 3);
					s = s + "\n";
				}
				
				JOptionPane.showMessageDialog(null,s,"Results from QUERY",JOptionPane.INFORMATION_MESSAGE);
				statement.close();
				connection.close();
			} catch (SQLException | ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null,"You are prohibited from modifying the database","Results from QUERY",JOptionPane.ERROR_MESSAGE);
			}
		}
		
}
	}
	
	
	
	
	class ExamineButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			view.examine_frame();
				
			try {
				Connection connection5 = Database.getConnection();
				Statement statement5   = connection5.createStatement();
				
				String selectedPatient = view.patientList.getSelectedItem().toString();
				String query = "SELECT * FROM patients WHERE fname = " + "\"" + selectedPatient +  "\"" +" LIMIT 1;";
				
				view.porisma_textbox.setVisible(false);
				view.porisma_label.setVisible(false);
				ResultSet apotelesmata5 = statement5.executeQuery(query);		
				apotelesmata5.next();
				
				current_patient_infos[0] = apotelesmata5.getString("AMKA");
				current_patient_infos[1] = apotelesmata5.getString("fname");
				current_patient_infos[2] = apotelesmata5.getString("lname");
				current_patient_infos[3] = apotelesmata5.getString("password");
				current_patient_infos[4] = apotelesmata5.getString("address");
				current_patient_infos[5] = apotelesmata5.getString("asf_foreas");
				current_patient_infos[6] = apotelesmata5.getString("age");
				current_patient_infos[7] = apotelesmata5.getString("email");
				current_patient_infos[8] = apotelesmata5.getString("chronic_disease");
				current_patient_infos[9] = apotelesmata5.getString("symptom");
				current_patient_infos[10] = apotelesmata5.getString("my_doctor");
				current_patient_infos[11] = apotelesmata5.getString("review");
				
				statement5.close();
				connection5.close();
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	class LoginStaffListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			Connection connection = null;
			Statement statement = null;
			try {
				connection = Database.getConnection();
				statement  = connection.createStatement();
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
	        
			
	        //String query = "SELECT * FROM employee WHERE email = " + "\"" 
	        //+ view.email_staff_textbox.getText() + "\"" + " AND password = " + view.pass_staff_textbox.getText() + " LIMIT 1;";
	        
String query = "SELECT * FROM employee WHERE email = " + "\"" 
        + view.email_staff_textbox.getText() + "\"" + " AND password = " + view.pass_staff_textbox.getText() + " AND EXISTS (SELECT * FROM shift WHERE email=\"" + view.email_staff_textbox.getText()+"\"" +") LIMIT 1;";        
	        
//String query = "SELECT * FROM employee WHERE email=\"" +view.email_staff_textbox.getText()+ "\" AND password=" + view.pass_staff_textbox.getText() + " IF ( EXISTS (SELECT * FROM shift WHERE email=\"" + view.email_staff_textbox.getText()+"\"" +")) LIMIT 1;";        
	        /* sto try mpainei to epituxes query (dil. vrike atomo me ta stoixeia poy dothikan) --> Logic succeed
	         * sto catch mpainei to anepituxes (otidipote allo)   --> Login failed
	         */
	        try {
				ResultSet apotelesmata = statement.executeQuery(query);
				if (apotelesmata.next() == true) {
					JOptionPane.showMessageDialog(null, "Welcome back!");
					current_staff_infos[0] = apotelesmata.getString("emp_id"); //first name
					current_staff_infos[1] = apotelesmata.getString("fname");  //last name
					current_staff_infos[2] = apotelesmata.getString("lname");  //age
					current_staff_infos[3] = apotelesmata.getString("age");  //chronic disease
					current_staff_infos[4] = apotelesmata.getString("email"); //symptom
					current_staff_infos[5] = apotelesmata.getString("password"); //symptom
					current_staff_infos[6] = apotelesmata.getString("salary"); //symptom
					current_staff_infos[7] = apotelesmata.getString("branch"); //symptom
					current_staff_infos[8] = apotelesmata.getString("specialty"); //symptom
					
					view.login_frame.setVisible(false);
					
					// a doctor has logged in
					if (current_staff_infos[7].equals("Doctor")) {
						view.patientList.removeAllItems();
						
						// query gia na doume poioi astheneis exoun anatethei ston giatro pou ekane molis login
						// wste na ta emfanisoume sthn lista tou prin tou anoiksoume to parathuro
						Connection connection2 = Database.getConnection();
						Statement statement2  = connection2.createStatement();
						String query2 = "SELECT * FROM patients WHERE my_doctor = " + current_staff_infos[0]+";";
						ResultSet apotelesmata2 = statement2.executeQuery(query2);
						while (apotelesmata2.next() == true) {
							//System.out.println(apotelesmata2.getString("fname"));
							view.doc_patients.add(apotelesmata2.getString("fname"));
						}
						
						view.doc_name.setText("<html><span style='font-size:15px'>"+apotelesmata.getString("fname")+ " " +apotelesmata.getString("lname")+ "</span></html>");
						
						view.doctor_panel();
					} else if (current_staff_infos[7].equals("Nurse")) {
						// blepoume posoi perimenoun gia eksetasi apo nosokoma
						Connection connection2 = Database.getConnection();
						Statement statement2  = connection2.createStatement();
						String query2 = "SELECT * FROM exetasi;";
						ResultSet apotelesmata2 = statement2.executeQuery(query2);
						while (apotelesmata2.next() == true) {
							//System.out.println(apotelesmata2.getString("AMKA"));
							view.patient_list_nosokomas.add(apotelesmata2.getString("AMKA"));
						}
						view.nurse_panel();
					} else {
						view.manager_panel();
					}
					
					statement.close();
					connection.close();
				} else {
					JOptionPane.showMessageDialog(null, "Error in login\nPossible reasons: Incorrect credentials or not in shift", "Login failed", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException | ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Error in login\nPossible reasons: Incorrect credentials or not in shift", "Login failed", JOptionPane.ERROR_MESSAGE);
				
				
			}
		}
	}
	
	
	class SendToNurseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			 
			try {
				Connection connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				
			String query = "";
			if (current_staff_infos[7].equals("Nurse"))	{
				//edw dhmiourgeitai h kainouria pleiada
				query = "UPDATE exetasi SET porisma = " + "\"" + view.porisma_textbox.getText() + "\"" + " WHERE AMKA = " + view.patientList.getSelectedItem() +";";
				statement.executeUpdate(query);
				query = "UPDATE patients SET my_doctor = -1 WHERE AMKA = " + view.patientList.getSelectedItem() +";";
				statement.executeUpdate(query);
				query = "UPDATE patients SET review = " + "\"" + view.porisma_textbox.getText() + "\"" + " WHERE AMKA = " + view.patientList.getSelectedItem() +";";
				statement.executeUpdate(query);
			} else {
				query = "INSERT INTO exetasi (doctor_id, AMKA, parapomph, drug_use, porisma) "
		        		+ "VALUES (" + current_staff_infos[0] + ", " + current_patient_infos[0] + ", " + "\"" + view.eksetasi_textbox.getText() + "\"" + ", " + "\"" + view.farmako_textbox.getText() + "\"" + " ," + "\"" + view.porisma_textbox.getText() + "\"" + ");";
			}
			view.patientList.removeItem(view.patientList.getSelectedItem());
				statement.executeUpdate(query);		
		        //view.examine_frame.dispose();
		        view.eksetasi_textbox.setText("");
		        view.porisma_textbox.setText("");
		        view.farmako_textbox.setText("");
		        view.examine_frame.setVisible(false);
				statement.close();
				connection.close();

			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	class ExamineByNurseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			String selected = view.patientList.getSelectedItem().toString();
			view.examine_frame();
		}
	}
	
	
	class LoginPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			
			Connection connection;
			try {
				
				connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				
				String query = "SELECT * FROM patients WHERE AMKA=" + view.amka_patient_textbox.getText()
							 + " AND password=" + view.pass_patient_textbox.getText() + ";";
				ResultSet apotelesmata = statement.executeQuery(query);
				apotelesmata.next();
				
				current_patient_infos[0] = apotelesmata.getString("AMKA");
				current_patient_infos[1] = apotelesmata.getString("fname");
				current_patient_infos[2] = apotelesmata.getString("lname");
				current_patient_infos[3] = apotelesmata.getString("password");
				current_patient_infos[4] = apotelesmata.getString("address");
				current_patient_infos[5] = apotelesmata.getString("asf_foreas");
				current_patient_infos[6] = apotelesmata.getString("age");
				current_patient_infos[7] = apotelesmata.getString("email");
				current_patient_infos[8] = apotelesmata.getString("chronic_disease");
				current_patient_infos[9] = apotelesmata.getString("symptom");
				current_patient_infos[10] = apotelesmata.getString("my_doctor");
				current_patient_infos[11] = apotelesmata.getString("review");
				
				view.patient_panel();
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	class LogoutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			view.doctor_frame.setVisible(false);
			view.nurse_frame.setVisible(false);
			view.examine_frame.setVisible(false);
			view.manager_frame.setVisible(false);
			view.login_frame.setVisible(true);
			
			view.doc_patients.clear();
			view.patient_list_nosokomas.clear();
			
			view.email_staff_textbox.setText("");
			view.pass_staff_textbox.setText("");
		}
	}
	
	

	
	
	
	
	class NewShiftListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)  {
			try {
				DeleteDB.deleteAll();
				InitializeDB.initAll();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	class LogoutPatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e)  {
			view.patient_frame.setVisible(false);
			view.login_frame.setVisible(true);
			
			view.doc_patients.clear();
			view.patient_list_nosokomas.clear();
			
			view.amka_patient_textbox.setText("");
			view.pass_patient_textbox.setText("");
		}
	}
	
	class UpdateInfoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			view.update_patient_panel();
		}
	}
	
	class ConfirmChangesListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String email = view.change_email.getText();
			String pass = view.change_pass.getText();
			String addr = view.change_addr.getText();
			
			Connection connection;
			try {
				connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				
				if(email.equals(null)) email = current_patient_infos[7];
				if(pass.equals(null)) pass = current_patient_infos[3];
				if(addr.equals(null)) addr = current_patient_infos[4];
				
				String query = "UPDATE patients SET email=" + "\"" + email  + "\"," + " password=" + pass + " ," +  " address=" + "\"" + addr +  "\" WHERE AMKA=" + current_patient_infos[0] + ";";
				statement.executeUpdate(query);
				
				view.update_menu.setVisible(false);
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	class NewPatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			view.new_patient_menu();
		}
	}
	
	class RegisterPatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Connection connection;
			try {
				connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				
				String amka = view.new_patient_amka.getText();
				String fname = view.new_patient_fname.getText();
				String lname = view.new_patient_lname.getText();
				String pass = view.new_patient_pass.getText();
				String chronic = view.new_patient_chronic.getText();
				String symptom = view.new_patient_symptom.getText();
				
				int my_doc = 10;
				String query = "SELECT doctor1, doctor2 FROM symptom_to_doctor WHERE symptom = " +"\""+symptom+"\"";
				ResultSet rs = statement.executeQuery(query);
				if (rs.next() == true) {
					query = "SELECT emp_id FROM shift WHERE emp_id=" + rs.getString(1) + " OR emp_id=" + rs.getString(2);
					ResultSet rs2 = statement.executeQuery(query);
					rs2.next();
					my_doc = rs2.getInt(1);
					System.out.println("1 " + my_doc);
				}
				System.out.println("2 " + my_doc);
				query = "INSERT INTO patients( AMKA, fname, lname, password, address, asf_foreas, age, email, chronic_disease, symptom, my_doctor ) "
		        		+ "VALUES("+amka+"," + "'"+fname+"'," + "'"+lname+"'," + "'"+pass+"'," + "'"+"DROMOS 45', 'IKA', '34', 'pati@gmail.com"+"'," + "'"+chronic+"'," + "'"+symptom+"', " + "'"+my_doc+"');";
						
				statement.executeUpdate(query);
				
				view.new_patient_menu.setVisible(false);
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
	}
	
	class VisitorListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			view.new_visitor_menu();
		}
	}
	
	class RegisterVisitorListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Connection connection;
			try {
				connection = Database.getConnection();
				Statement statement   = connection.createStatement();
				
				String query = "SELECT * FROM patients WHERE AMKA = " + view.visited_amka.getText() + ";";
				ResultSet rs = statement.executeQuery(query);
				
				if (rs.next() == true) {
					query = "INSERT INTO episkepsi ( visitor, time, visited_patient ) "
							+  "VALUES( " + "\"" + view.visitor_name.getText() + "\"" + " ," +  view.visit_time.getText() + " ," + view.visited_amka.getText() + " )";
					statement.executeUpdate(query);
				
					view.new_visitor_menu.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,"ERROR 404 : The given Patient was not found in the database","ERROR 404 : Patient not found",JOptionPane.ERROR_MESSAGE);
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
}
