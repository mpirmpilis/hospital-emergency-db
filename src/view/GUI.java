package view;

/**
 * HY360 - Databases :: Fall 2020 :: Project
 * @author Georgios Mpirmpilis - Konstantinos Gkanogiannis
 * GUI.java
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.Controller;


public class GUI {
	private Controller controller;
	public ArrayList<String> doc_patients = new ArrayList<String>();
	public ArrayList<String> patient_list_nosokomas = new ArrayList<String>();
	
	public JComboBox<String> patientList = new JComboBox<>();
	public JComboBox<String> farmakaList = new JComboBox<>();
	
	/***************** OLA TA FRAMES(parathurakia) EINAI MAZEMENA EDW *****************/
	public JFrame login_frame = new JFrame("Tmima Epeigontwn Peristatikwn - HY360");
	public JFrame doctor_frame = new JFrame("Doctor logged in");    // gia testarisma ths mparas
	public JFrame nurse_frame = new JFrame("Nurse logged in");
	public JFrame examine_frame = new JFrame("Patient Examination");
	public JFrame patient_frame = new JFrame("Patient logged in");
	public JFrame update_menu = new JFrame("Update my infos");
	public JFrame new_patient_menu = new JFrame("Enter your credentials");
	public JFrame new_visitor_menu = new JFrame("New Visitor");
	public JFrame manager_frame = new JFrame("Manager logged in");
	
	
	
	
	
	
	/***************** OLA TA LABELS EINAI MAZEMENA EDW *****************/
	public JLabel doc_name = new JLabel();
	public JLabel eksetasi_label = new JLabel("Eksetasi");
	public JLabel farmako_label = new JLabel("Farmako");
	public JLabel porisma_label = new JLabel("Porisma");
	
	
	
	
	
	
	/***************** OLA TA KOYMPAKIA(apo kathe frame) EINAI MAZEMENA EDW *****************/
	private JButton login_staff = new JButton ("Staff Login");
	private JButton logn_patient = new JButton ("Patient Login");
	private JButton examine_patient_button = new JButton("Examine");
	private JButton send_to_nurse_button = new JButton("Send");
	private JButton logout_button = new JButton("Logout");
	private JButton logout_patient_button = new JButton("Logout");
	private JButton examine_by_nurse = new JButton("Examine");
	private JButton updatePatientInfo_button = new JButton("Update my infos");
	private JButton confirm_changes = new JButton("Confirm Changes");
	private JButton new_shift_button = new JButton("Change shift");
	private JButton query_login_button = new JButton("SQL Queries");
	private JButton add_patient = new JButton("add patient");
	private JButton add_visitor = new JButton("add visitor");
	private JButton register_patient = new JButton("add me");
	private JButton visit_button = new JButton("visit");
	
	
	
	
	
	/***************** OLA TA TEXTBOXES(gia eisagwgh. Apo kathe frame) EINAI MAZEMENA EDW *****************/
	public JTextField email_staff_textbox = new JTextField();
	public JTextField pass_staff_textbox = new JTextField();
	public JTextField amka_patient_textbox = new JTextField();
	public JTextField pass_patient_textbox = new JTextField();
	public JTextField eksetasi_textbox = new JTextField();
	public JTextField farmako_textbox = new JTextField();
	public JTextField porisma_textbox = new JTextField();
	public JTextField change_email = new JTextField("Change my email...");
	public JTextField change_pass = new JTextField("Change my password...");
	public JTextField change_addr = new JTextField("Change my address...");
	public JTextField new_patient_amka = new JTextField("My AMKA...");
	public JTextField new_patient_fname = new JTextField("My first name...");
	public JTextField new_patient_lname = new JTextField("My last name...");
	public JTextField new_patient_pass = new JTextField("My passsword...");
	public JTextField new_patient_chronic = new JTextField("My chronic diesease...");
	public JTextField new_patient_symptom = new JTextField("My symptom...");
	public JTextField visitor_name = new JTextField("Visitor name...");
	public JTextField visit_time = new JTextField("Time...");
	public JTextField visited_amka = new JTextField("I want to visit...");
	public JTextField afthaireti_erwtisi = new JTextField();
	
	public GUI(Controller controller) {
		this.controller = controller;
		
		//examine_frame();
		//doctor_panel();
		display_login();
	}
	
	private void display_login() {
		JLabel email_staff_label = new JLabel("Staff email");
		JLabel pass_staff_label = new JLabel("password");
		JLabel amka_patient_label = new JLabel("Patient AMKA");
		JLabel pass_patient_label = new JLabel("password");
		
		
		login_frame.setLayout(null);
		login_frame.setPreferredSize(new Dimension(400,400));
		
		login_staff.setBounds(10, 320, 100, 30);
		logn_patient.setBounds(260, 320, 100, 30);
		new_shift_button.setBounds(110, 20, 180, 30);
		query_login_button.setBounds(120, 275, 120, 20);
		
		afthaireti_erwtisi.setBounds(70, 250, 200, 20);
		email_staff_textbox.setBounds(10, 120, 150, 20);
		pass_staff_textbox.setBounds(10, 180, 150, 20);
		email_staff_label.setBounds(50, 100, 200, 20);
		pass_staff_label.setBounds(50, 160, 200, 20);
		
		amka_patient_textbox.setBounds(200, 120, 150, 20);
		pass_patient_textbox.setBounds(200, 180, 150, 20);
		amka_patient_label.setBounds(245, 100, 200, 20);
		pass_patient_label.setBounds(245, 160, 200, 20);
		
		
		login_frame.add(query_login_button);
		login_frame.add(afthaireti_erwtisi);
		login_frame.add(new_shift_button);
		login_frame.add(email_staff_label);
		login_frame.add(pass_staff_label);
		login_frame.add(email_staff_textbox);
		login_frame.add(pass_staff_textbox);
		
		login_frame.add(amka_patient_textbox);
		login_frame.add(pass_patient_textbox);
		login_frame.add(amka_patient_label);
		login_frame.add(pass_patient_label);
		
		login_frame.getContentPane().setBackground(Color.decode("#00B47D"));
		login_frame.add(logn_patient);
		login_frame.add(login_staff);
		login_frame.setVisible(true);
		login_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		login_frame.setResizable(false);
		login_frame.pack();
		login_frame.requestFocus();
	}
	
	
	
	public void doctor_panel() {
		JLabel fullname_label = new JLabel("<html><span style='font-size:15px'>Welcome back Dr.</span></html>");
		JLabel patients_examine = new JLabel("<html><span style='font-size:12px'>Patients to examine</span></html>");
		
		patientList.removeAllItems();

		for (int i=0; i<doc_patients.size(); i++) {
			patientList.addItem(doc_patients.get(i));
		}
		//patientList.addItem("English");
		doctor_frame.setLayout(null);
		doctor_frame.setVisible(true);
		doctor_frame.setPreferredSize(new Dimension(600,500));
		
		examine_patient_button.setBounds(335, 115, 100, 20);
		
		patientList.setBounds(105, 115, 200, 20);
		patientList.setForeground(Color.BLUE);
		patientList.setFont(new Font("Arial", Font.BOLD, 14));
		fullname_label.setBounds(105, 20, 200, 20);
		patients_examine.setBounds(115, 90, 200, 20);
		doc_name.setBounds(300, 15, 800, 30);
		logout_button.setBounds(300, 300, 100, 30);
		
		
		doctor_frame.add(logout_button);
		doctor_frame.add(examine_patient_button);
		doctor_frame.add(patients_examine);
		doctor_frame.add(fullname_label);
		doctor_frame.add(doc_name);
		doctor_frame.add(patientList);
		doctor_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		doctor_frame.setResizable(false);
		doctor_frame.pack();
		doctor_frame.requestFocus();
	}
	
	
	
	
	
	
public void manager_panel() {
		
		JLabel fullname_label = new JLabel("<html><span style='font-size:11px'>Welcome back Manager " + controller.current_staff_infos[1] + " " + controller.current_staff_infos[2] + "</span></html>");
		fullname_label.setBounds(40, 20, 200, 40);
		
		add_patient.setBounds(40, 70, 200, 20);
		add_visitor.setBounds(40, 100, 200, 20);
		logout_button.setBounds(40, 130, 200, 20);
		
		manager_frame.setLayout(null);
		manager_frame.setVisible(true);
		manager_frame.setSize(300, 250);
		
		manager_frame.add(fullname_label);
		manager_frame.add(add_patient);
		manager_frame.add(add_visitor);
		manager_frame.add(logout_button);
		
		//manager_frame.pack();
		//manager_frame.requestFocus();
	}
	
	
	
	
	
	
	
	public void examine_frame() {

		
		eksetasi_label.setBounds(105, 20, 200, 20);
		eksetasi_textbox.setBounds(85, 40, 100, 20);
		farmako_label.setBounds(105, 70, 200, 20);
		farmako_textbox.setBounds(85, 90, 100, 20);
		send_to_nurse_button.setBounds(85, 122, 100, 20);
		porisma_label.setBounds(105, 162, 100, 20);
		porisma_textbox.setBounds(85, 192, 100, 20);
		
		
		
		examine_frame.add(eksetasi_label);
		examine_frame.add(eksetasi_textbox);
		examine_frame.add(farmako_label);
		examine_frame.add(farmako_textbox);
		examine_frame.add(porisma_label);
		examine_frame.add(porisma_textbox);
		
		examine_frame.setResizable(false);
		examine_frame.add(send_to_nurse_button);
		examine_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		examine_frame.setLayout(null);
		examine_frame.setVisible(true);
		examine_frame.setPreferredSize(new Dimension(300,400));
		
		examine_frame.pack();
		examine_frame.requestFocus();
	}
	
	
	public void nurse_panel() {
		nurse_frame.setPreferredSize(new Dimension(300,400));
		nurse_frame.setLayout(null);
		nurse_frame.setVisible(true);
		
		patientList.removeAllItems();     // katharisma giati eixe thn lista apo ton giatro
		
		for (int i=0; i<patient_list_nosokomas.size(); i++) {
			patientList.addItem(patient_list_nosokomas.get(i));
		}
		
		porisma_textbox.setVisible(true);
		porisma_label.setVisible(true);
		patientList.setBounds(105, 115, 150, 20);
		patientList.setForeground(Color.BLUE);
		patientList.setFont(new Font("Arial", Font.BOLD, 14));
		
		nurse_frame.add(patientList);
		logout_button.setBounds(100, 300, 100, 30);
		examine_by_nurse.setBounds(100, 250, 100, 30);
		
		nurse_frame.add(examine_by_nurse);
		nurse_frame.add(logout_button);
		
		
		nurse_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		nurse_frame.pack();
		nurse_frame.requestFocus();
	}
	
	
	public void patient_panel() {
		login_frame.setVisible(false);
		
		JLabel prompt = new JLabel("<html><span style='font-size:11px'>Welcome back Patient</span></html>");
		JLabel amka = new JLabel("<html><span style='font-size:11px'>Your AMKA:     "+ controller.current_patient_infos[0] + "</span></html>");
		JLabel full_name = new JLabel("<html><span style='font-size:11px'>Full Name:     "+ controller.current_patient_infos[1] + " " + controller.current_patient_infos[2] + "</span></html>");
		JLabel addr = new JLabel("<html><span style='font-size:11px'>Address:     "+ controller.current_patient_infos[4] + "</span></html>");
		JLabel asf = new JLabel("<html><span style='font-size:11px'>Asfalistikos foreas:     "+ controller.current_patient_infos[5] + "</span></html>");
		JLabel age = new JLabel("<html><span style='font-size:11px'>Age:     "+ controller.current_patient_infos[6] + "</span></html>");
		JLabel chronic = new JLabel("<html><span style='font-size:11px'>Chronic Disease:     "+ controller.current_patient_infos[8] + "</span></html>");
		JLabel symptom = new JLabel("<html><span style='font-size:11px'>Symptom:     "+ controller.current_patient_infos[9] + "</span></html>");
		JLabel my_doc = new JLabel("<html><span style='font-size:11px'>Your Doctor:     "+ controller.current_patient_infos[10] + "</span></html>");
		JLabel review = new JLabel("<html><span style='font-size:11px'>Exetasi review:     "+ controller.current_patient_infos[11] + "</span></html>");
		
		patient_frame.setLayout(null);
		patient_frame.setVisible(true);
		patient_frame.setPreferredSize(new Dimension(300,400));
		
		prompt.setBounds(40, 20, 200, 20);
		amka.setBounds(40, 30, 200, 20);
		full_name.setBounds(40, 50, 200, 20);
		addr.setBounds(40, 70, 200, 30);
		asf.setBounds(40, 95, 200, 20);
		age.setBounds(40, 110, 200, 20);
		chronic.setBounds(40, 130, 200, 20);
		symptom.setBounds(40, 150, 200, 20);
		my_doc.setBounds(40, 170, 200, 20);
		review.setBounds(40, 190, 200, 20);
		
		updatePatientInfo_button.setBounds(40, 240, 200, 20);
		logout_patient_button.setBounds(40, 270, 200, 20);
		
		patient_frame.add(amka);
		patient_frame.add(full_name);
		patient_frame.add(addr);
		patient_frame.add(asf);
		patient_frame.add(age);
		patient_frame.add(chronic);
		patient_frame.add(symptom);
		patient_frame.add(my_doc);
		patient_frame.add(review);
		patient_frame.add(updatePatientInfo_button);
		patient_frame.add(logout_patient_button);
		
		patient_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		patient_frame.setResizable(false);
		patient_frame.pack();
		patient_frame.requestFocus();
	}
	
	
	
	
	public void update_patient_panel() {
		update_menu.setSize(300, 300);
		update_menu.setLayout(new GridLayout(4,1));
		
		update_menu.add(change_email);
		update_menu.add(change_pass);
		update_menu.add(change_addr);
		update_menu.add(confirm_changes);
		
		update_menu.setVisible(true);
	}
	
	public void new_patient_menu() {
		new_patient_menu.setSize(300, 300);
		new_patient_menu.setLayout(new GridLayout(7,1));
		
		new_patient_menu.add(new_patient_amka);
		new_patient_menu.add(new_patient_fname);
		new_patient_menu.add(new_patient_lname);
		new_patient_menu.add(new_patient_pass);
		new_patient_menu.add(new_patient_chronic);
		new_patient_menu.add(new_patient_symptom);
		new_patient_menu.add(register_patient);
		
		new_patient_menu.setVisible(true);
	}
	
	public void new_visitor_menu() {
		new_visitor_menu.setSize(300, 300);
		new_visitor_menu.setLayout(new GridLayout(4,1));
		
		new_visitor_menu.add(visitor_name);
		new_visitor_menu.add(visit_time);
		new_visitor_menu.add(visited_amka);
		new_visitor_menu.add(visit_button);
		
		new_visitor_menu.setVisible(true);
	}
	
	
	
	
	
	
	
	public void AddExamineByNurseListener(ActionListener ExamineByNurseListener) {
		examine_by_nurse.addActionListener(ExamineByNurseListener);
	}
	
	
	public void AddSendToNurseButton(ActionListener SendToNurseListener) {
		send_to_nurse_button.addActionListener(SendToNurseListener);
	}
	
	
	
	
	
	
	
	public void AddQueryListener(ActionListener QueryListener) {
		query_login_button.addActionListener(QueryListener);
	}
	
	
	
	
	
	
	public void AddNewShiftListener(ActionListener NewShiftListener) {
		new_shift_button.addActionListener(NewShiftListener);
	}
	
	
	public void AddPatients(String anotherPatient) {
		doc_patients.add(anotherPatient);
	}
	
	
	public void AddLogoutListener(ActionListener LogoutListener) {
		logout_button.addActionListener(LogoutListener);
	}
	
	public void addLExamineListener(ActionListener ExamineListener) {
		examine_patient_button.addActionListener(ExamineListener);
	}
	
	public void addLoginStaffListener(ActionListener StaffListener) {
		login_staff.addActionListener(StaffListener);
	}
	
	
	public void addLoginPatientListener(ActionListener PatientListener) {
		logn_patient.addActionListener(PatientListener);
	}
	


	
	public void updatePatientInfo(ActionListener UpdateInfoListener) {
		updatePatientInfo_button.addActionListener(UpdateInfoListener);
	}
	
	public void logoutPatient(ActionListener LogoutPatientListener) {
		logout_patient_button.addActionListener(LogoutPatientListener);
	}
	
	public void confirmPatientChanges(ActionListener ConfirmChangesListener) {
		confirm_changes.addActionListener(ConfirmChangesListener);
	}
	
	public void newPatient(ActionListener NewPatientListener) {
		add_patient.addActionListener(NewPatientListener);
	}
	
	public void registerNewPatient(ActionListener RegisterPatientListener) {
		register_patient.addActionListener(RegisterPatientListener);
	}
	
	public void addVisitor(ActionListener VisitorListener) {
		add_visitor.addActionListener(VisitorListener);
	}
	
	public void registerVisitor(ActionListener RegisterVisitorListener) {
		visit_button.addActionListener(RegisterVisitorListener);
	}
	
}
