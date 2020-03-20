package Hb;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import javax.swing.*;

import Hb.Hms.Login;

/* create another class for
 * create a registration
 * form
 */
class Options extends JFrame implements ActionListener {
	
	JLabel l1;
	JButton b1,b2,b3,b4;
	JTextField t1,t2;
	JTextArea ta;
	
	public void actionPerformed(ActionEvent e) {
		
		String ch = e.getActionCommand();
		if(ch=="REGISTER PATIENT") {
			
			Registration rg = new Registration();
			Container c1 = rg.getContentPane();
			c1.setBackground(Color.pink);
			rg.setVisible(true);
			rg.setBounds(200,50,1200,820);
			
			
		}
		else if(ch=="REMOVE PATIENT") {
		
//			try {
//				
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","harshbobby");
//				String del = t6.getText();
//				
//				String sql ="delete from patient where name = ?";
//				PreparedStatement st = conn.prepareStatement(sql);
//				st.setString(1,del);
//				st.executeUpdate();
//				
//				//ta.setText("DELETED SUCCESFULLY");
//			
//			}
//			catch(SQLException ae) {
//				
//				System.out.println("SOMETHING WRONG");
//				
//			}
//			catch(ClassNotFoundException ae) {
//				
//				System.out.println("hello");
//			} 
//			
	}
			
			
			
		else if(ch=="UPDATE PATIENT") {
			
			
		
			
		}
		else {
			
		
	}}
		
	
	public Options() {
		
		Font f1 = new Font("Aerial",Font.BOLD,50);
		Font f2 = new Font("Aerial",Font.BOLD,25);
		
		l1 = new JLabel("HOME");
		b1 = new JButton("REGISTER PATIENT");
		b2 = new JButton("REMOVE PATIENT");
		b3 = new JButton("UPDATE PATIENT");
		b4 = new JButton("SEARCH PATIENT");
		ta = new JTextArea();
		t1 = new JTextField();
		t2 = new JTextField();
		setLayout(null);
		l1.setBounds(250,60,250,50);
		b1.setBounds(200,180,290,50);
		b2.setBounds(60,300,270,50);
		b3.setBounds(390,150,270,50);
		b4.setBounds(390,300,270,50);
		t1.setBounds(60,240,250,30);
		t2.setBounds(390,240,250,30);
		ta.setBounds(700,60,350,350);
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		b4.setFont(f2);
		l1.setFont(f1);
		t1.setFont(f2);
		t2.setFont(f2);
		ta.setFont(f2);
		add(l1);
		add(b1);
//		add(b2);
//		add(b3);
//		add(b4);
//		add(t1);
//		add(t2);
//		add(ta);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}
	

}



class UpdatePatient extends JFrame implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

class SearchPatient extends JFrame implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

class Registration extends JFrame implements ActionListener {
	
	JLabel l1,l11,l2,l3,l4,l5,l6,l7,l8,ms,dept,city,postcd,state,country,p_id,message;
	JTextField t1,t11,t2,t3,t4,t5,t6,t7,postcdt,cityt,statet,countryt,p_idt;
	
	JButton b1,b2,b3,b4,b5;
	JCheckBox cb;
	JComboBox cmb1,cmb2,cmb3,cmb4,cmb5;
	JRadioButton rb1,rb2;
	ButtonGroup gend;
	JTextArea ta;
	
	
	public void actionPerformed(ActionEvent e) {
		
		String ch = e.getActionCommand();
		if(ch=="SUBMIT")
		{
			if(cb.isSelected()) {
				
				String first_name = t1.getText();
				String last_name = t11.getText();
				String email = t3.getText();
				String mobile = t2.getText();
				String address = t4.getText();
				String postal_code = postcdt.getText();
				String city = cityt.getText();
				String state = statet.getText();
				String country = countryt.getText();
				String p_id = p_idt.getText();
				String gen = "Male";
				if(rb2.isSelected()) {
					gen = "Female";
				}
				
				String date = (String)cmb1.getSelectedItem();
				String mon = (String)cmb2.getSelectedItem();
				String year =(String) cmb3.getSelectedItem();
				String department = (String)cmb5.getSelectedItem();
				String marital = (String)cmb4.getSelectedItem();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","harshbobby");
					System.out.println("DATABASE CONNECTED");
					
					String sql ="insert into patient(first_name,last_name,gender,date,month,year,p_id,marital_status,department,email,mobile,address,postal_code,city,state,country) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1,first_name);
					st.setString(2,last_name);
					st.setString(3,gen);
					st.setString(4,date);
					st.setString(5,mon);
					st.setString(6,year);
					st.setString(7,p_id);
					st.setString(8,marital);
					st.setString(9,department);
					st.setString(10,email);
					st.setString(11,mobile);
					st.setString(12,address);
					st.setString(13,postal_code);
					st.setString(14,city);
					st.setString(15,state);
					st.setString(16,country);
					
					st.executeUpdate();
					
					
					ta.setText("REGISTRATION SUCCESFULL");
				}
				catch(SQLException ae) {
					
					System.out.println("SOMETHING WRONG");
					
				}
				catch(ClassNotFoundException ae) {
					
					System.out.println("hello");
				}

				
			}
			else {
				
				ta.setText("PLEASE ACCEPT TERMS AND CONDITIONS");
			
			}
		}
		
		else if(ch=="UPDATE PATIENT") {
			
try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","harshbobby");
				
				String search = t6.getText();
				String sql ="update patient set email='"+t3.getText()+"',mobile ='"+t2.getText()+"' where p_id = '"+p_idt.getText()+"'";
				PreparedStatement st = conn.prepareStatement(sql);
//				st.setString(1,search);
//				ResultSet rs = st.executeQuery();
				
				st.executeUpdate();
			
			
			}
			catch(SQLException ae) {
				
				System.out.println("SOMETHING WRONG");
				
			}
			catch(ClassNotFoundException ae) {
				
				System.out.println("hello");
			}
			
			
			
		}
		
		else if(ch=="SEARCH PATIENT") {
			
try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","harshbobby");
				
				String search = t6.getText();
				String sql ="select * from patient where p_id = ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1,search);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
		
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String postal_code = rs.getString("postal_code");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String country = rs.getString("country");
					String p_id = rs.getString("p_id");
					String gen = rs.getString("gender");
					String date = rs.getString("date");
					String mon = rs.getString("month");
					String year =rs.getString("year");
					String department = rs.getString("department");
					String marital = rs.getString("marital_status");
					
//					
//					String name = rs.getString("name");
//					String gen = rs.getString("gender");
//					String date = rs.getString("day");
//					String month = rs.getString("month");
//					String year = rs.getString("year");
//					String email = rs.getString("email");
//					String mobile = rs.getString("mobile");
//					String address = rs.getString("address");
//					
					ta.setText("Patient_Id : "+p_id+"\nFirst_Name : "+first_name+"\nLast_Name : "+last_name+"\nGender : "+gen+"\nDOB : "+date+" "+mon+" "+year+"\nMOBILE : "+mobile+"\nE-Mail : "+email+"\nDepartment : "+department+"\nMarital_Status : "+marital+"\nAddress :"+address+"\nPostal_Code : "+postal_code+"\nCity : "+city+"\nState : "+state+"\nCountry : "+country);
//					
					
				}
			
			}
			catch(SQLException ae) {
				
				System.out.println("SOMETHING WRONG");
				
			}
			catch(ClassNotFoundException ae) {
				
				System.out.println("hello");
			}
			
		}
		else if(ch=="REMOVE PATIENT") {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","harshbobby");
				String del = t7.getText();
				
				String sql ="delete from patient where p_id = ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1,del);
				st.executeUpdate();
				
				ta.setText("DELETED SUCCESFULLY");
			
			}
			catch(SQLException ae) {
				
				System.out.println("SOMETHING WRONG");
				
			}
			catch(ClassNotFoundException ae) {
				
				System.out.println("hello");
			} 
			
		}
		else {
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			t4.setText(null);
			t5.setText(null);
			t6.setText(null);
			t7.setText(null);
			t11.setText(null);
			cityt.setText(null);
			countryt.setText(null);
			statet.setText(null);
			postcdt.setText(null);
			p_idt.setText(null);
			ta.setText(null);
			gend.clearSelection();
			
			cb.setSelected(false);
			cmb1.setSelectedIndex(0);
			cmb2.setSelectedIndex(0);
			cmb3.setSelectedIndex(0);
			cmb4.setSelectedIndex(0);
			cmb5.setSelectedIndex(0);
		}
		
	}
	
	//REGISTRATION CLASS CONSTRUCTOR
	
	public Registration() {
		
		
		Font f1 = new Font("Aerial",Font.BOLD,30);
		Font f2 = new Font("Aerial",Font.BOLD,25);
		Font f3 = new Font("Aerial",Font.BOLD,18);
		String[] arr1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] arr2 = {"jan","feb","mar","apr","may","jun","jul","aug","sept","oct","nov","dec"};
		String[] arr3 = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
		String[] arr4 = {"Single","Married","Widowed","Divorced"};
		String[] arr5 = {"OPD","Medical","Nursing","Dietary","Pharmacy"};
		rb1 = new JRadioButton("Male");
		rb2 = new JRadioButton("Female");
		gend = new ButtonGroup();
		cmb1 = new JComboBox(arr1);
		cmb2 = new JComboBox(arr2);
		cmb3 = new JComboBox(arr3);
		cmb4 = new JComboBox(arr4);
		cmb5 = new JComboBox(arr5);
		message = new JLabel();
		p_id = new JLabel("P Id");
		p_idt = new JTextField();
		city = new JLabel("City");
		postcd = new JLabel("Postal Code");
		state = new JLabel("State");
		country = new JLabel("Country");
		l1 = new JLabel("First Name");
		l11 = new JLabel("Last Name");
		ms = new JLabel("Marital Status");
		dept = new JLabel("Department");
		l2 = new JLabel("Gender");
		l3 = new JLabel("DOB");
		l4 = new JLabel("Contact No.");
		l5 = new JLabel("E-Mail Id");
		l8 = new JLabel("PATIENT DETAILS");
		l6 = new JLabel("Address");
		l7 = new JLabel("I ACCEPT TERMS AND CONDITIONS");
		b1 = new JButton("SUBMIT");
		b2 = new JButton("RESET");
		b3 = new JButton("UPDATE PATIENT");
		b4 = new JButton("SEARCH PATIENT");
		b5 = new JButton("REMOVE PATIENT");
		ta = new JTextArea();
		cb = new JCheckBox();
		t1 = new JTextField();
		t11 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		postcdt = new JTextField();
		statet = new JTextField();
		countryt = new JTextField();
		cityt = new JTextField();
		setLayout(null);
		postcd.setBounds(50,450,150,30);
		postcdt.setBounds(240,450,100,30);
		city.setBounds(400,450,80,30);
		cityt.setBounds(510,450,100,30);
		state.setBounds(50,500,80,30);
		statet.setBounds(180,500,100,30);
		country.setBounds(400,500,100,30);
		countryt.setBounds(550,500,120,30);
		cb.setBounds(70,550,30,25);
		b1.setBounds(50,600,170,30);
		message.setBounds(80,650,550,30);
		b2.setBounds(300,600,170,30);
		b3.setBounds(80,680,250,60);
		b4.setBounds(420,730,320,30);
		b5.setBounds(820,730,320,30);
		t5.setBounds(80,670,250,30);
		t6.setBounds(420,670,320,30);
		t7.setBounds(820,670,320,30);
		ta.setBounds(750,130,400,500);
		ms.setBounds(50,300,200,30);
		dept.setBounds(390,300,170,30);
		cmb1.setBounds(150,250,40,20);
		cmb2.setBounds(210,250,70,20);
		cmb3.setBounds(300,250,70,20);
		cmb4.setBounds(240,300,110,25);
		cmb5.setBounds(550,300,120,25);
		l1.setBounds(50,150,160,30);
		l11.setBounds(400,150,160,30);
		l2.setBounds(50,200,120,30);
		p_id.setBounds(520,220,80,25);
		p_idt.setBounds(600,220,80,25);
		l3.setBounds(50,250,80,30);
		l4.setBounds(380,350,180,30);
		l5.setBounds(50,350,150,30);
		l6.setBounds(50,400,100,30);
		l7.setBounds(140,550,600,30);
		l8.setBounds(200,50,380,30);
		t1.setBounds(220,150,140,30);
		t11.setBounds(550,150,150,30);
		t2.setBounds(550,350,140,30);
		t3.setBounds(200,350,140,30);
		t4.setBounds(200,400,300,30);
		rb1.setBounds(200,200,130,30);
		rb2.setBounds(350,200,130,30);
		rb2.setFont(f2);
		rb1.setFont(f2);
		l1.setFont(f2);
		l11.setFont(f2);
		b1.setFont(f2);
		message.setFont(f2);
		b2.setFont(f2);
		p_id.setFont(f2);
		p_idt.setFont(f2);
		ms.setFont(f2);
		dept.setFont(f2);
		postcd.setFont(f2);
		postcdt.setFont(f2);
		city.setFont(f2);
		cityt.setFont(f2);
		state.setFont(f2);
		statet.setFont(f2);
		country.setFont(f2);
		countryt.setFont(f2);
		b3.setFont(f2);
		b4.setFont(f2);
		b5.setFont(f2);
		l8.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		t1.setFont(f2);
		t11.setFont(f2);
		t2.setFont(f2);
		t3.setFont(f2);
		t4.setFont(f2);
		t5.setFont(f2);
		t6.setFont(f2);
		t7.setFont(f2);
		ta.setFont(f3);
		gend.add(rb1);
		gend.add(rb2);
		add(message);
		add(cmb1);
		add(cmb2);
		add(cmb3);
		add(cmb4);
		add(cmb5);
		add(ms);
		add(dept);
		add(rb1);
		add(rb2);
		add(ta);
		add(l1);
		add(l11);
		add(postcd);
		add(postcdt);
		add(city);
		add(cityt);
		add(state);
		add(statet);
		add(country);
		add(countryt);
		add(b1);
		add(b2);
		add(p_id);
		add(p_idt);
		add(b3);
		add(b4);
		add(b5);
		add(l2);
		add(l3);
		add(l8);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(t1);
		add(t11);
		add(t2);
		add(t3);
		add(t4);
//		add(t5);
		add(t6);
		add(t7);
		add(cb);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
	
	
}

	
/*create a public class
 * for Login Page
 */

public class Hms extends JFrame {
	
	JLabel l1,l2,l3,l4,l5,user_view,proj;
	JTextField t1;
	JPasswordField pw1;
	JButton b1;
	
	
	class Login implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String s1 = t1.getText();
			String s2 = pw1.getText();
			
			if(s1.equals("hello") && s2.equals("12345")) {
				
				Options o1 = new Options();
				Container c1 = o1.getContentPane();
				c1.setBackground(Color.yellow);
				o1.setVisible(true);
				o1.setBounds(200,150,650,450);
//				Registration r1 = new Registration();
//				Container c1 = r1.getContentPane();
//				c1.setBackground(Color.green);
//				r1.setVisible(true);
//				r1.setBounds(200,100,1200,900);
				
				
				
			}
			else {
				l5.setText("INVALID USERNAME OR PASSWORD");
			}
			
		}
	}
	
	/*Constructor*/
	
	public void setcomponents() {
		
		Font f1 = new Font("Aerial",Font.BOLD,50);
		Font f3 = new Font("Aerial",Font.ITALIC,40);
		proj = new JLabel("");
		Font f2 = new Font("Aerial",Font.BOLD,30);
		Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
		Image img = new ImageIcon(this.getClass().getResource("/policy.jpg")).getImage();
		proj.setIcon(new ImageIcon(img));
		l1 = new JLabel("HOSPITAL REGISTRATION SYSTEM");
		user_view = new JLabel("USER VIEW");
		l2 = new JLabel("WELCOME");
		l3 = new JLabel("USER NAME");
		l4 = new JLabel("PASSWORD");
		l5 = new JLabel();
		b1 = new JButton("LOGIN");
		t1 = new JTextField();
		pw1 = new JPasswordField();
		user_view.setBounds(480,320,300,40);
		l3.setBounds(420,430,200,30);
		b1.setBounds(540,590,80,40);
		l4.setBounds(420,510,200,40);
		l5.setBounds(400,650,550,40);
		l2.setBounds(500,100,300,50);
		l1.setBounds(250,200,1000,50);
		t1.setBounds(670,430,150,30);
		pw1.setBounds(670,510,150,30);
		proj.setBounds(200,100,1300,800);
		user_view.setFont(f3);
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		t1.setFont(f2);
		pw1.setFont(f2);
		add(user_view);
//		add(proj);
		add(l4);
		add(l5);
		add(b1);
		add(pw1);
		add(t1);
		add(l3);
		add(l1);
		add(l2);
		b1.addActionListener(new Login());
	}
	
	public static void main(String[] args) {
		
		
		Hms jf = new Hms();
		Container c = jf.getContentPane();
		
		
		
		jf.setBounds(200,100,1300,800);
		jf.setVisible(true);
		jf.setTitle("PROJECT FOR HOSPITAL REGISTRATION SYSTEM");
		jf.setLayout(null);
		c.setBackground(Color.green);
		jf.setcomponents();
		

	}

}
