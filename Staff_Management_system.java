Front Page Coding:

package staff_managenent_system2;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
import java.sql.*;

class Front_Page implements ActionListener  {
     
    JFrame f;
    JLabel id,l1;
    JButton b;
    
    Front_Page(){
        
        f=new JFrame("Staff Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel l1=new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);
        
        b=new JButton("ClICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        b.setBounds(500,600,300,70);
        b.addActionListener(this);
        
        
        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
        JLabel lid=new JLabel("STAFF MANAGEMENT SYSTEM");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);
        
        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(200,100);
        
        while(true) {
            lid.setVisible(false);
            try{
                Thread.sleep(500);
            } catch(Exception e) {}
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            f.setVisible(false);
            new Login();
        }
    }
    public static void main(String[] arg){
        Front_Page f=new Front_Page();
        
            
            
    }
}

Login Page Coding:

package staff_managenent_system2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
import java.io.*;

class Login implements ActionListener {
    
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    public Login(){
        
        f=new JFrame("Login");
        
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2=new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel I3=new JLabel(i3);
        I3.setBounds(350,20,150,150);
        f.add(I3);
       
        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
       
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        
        b2.addActionListener(this);
        
        
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
        
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            conn c1=new conn();
            String u=t1.getText();
            String v=t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs =c1.s.executeQuery(q);
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }  else {
                JOptionPane.showMessageDialog(null,"Invalid login");
                f.setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
                
        }
    }
    public static void main(String[] arg) {
        Login l=new Login();
    }
}
Staff Details Coding:

package staff_managenent_system2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 class details implements ActionListener{
    
    JFrame f;
    JLabel l1,l2;
    JButton  b1,b2,b3,b4;
    
    details() {
        
        f=new JFrame("Staff Details");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);
        
        l2=new JLabel("Staff Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);
        
        b1=new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);
        
        b2=new JButton("view");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);
        
        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);
        
        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);
        
        
        f.setSize(700,500);
        f.setLocation(450,200);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1) {
            f.setVisible(false);
            new Add_Staff();
        }
        if(ae.getSource()==b2) {
            f.setVisible(false);
            new View_Staff();
        }
        if(ae.getSource()==b3) {
            f.setVisible(false);
            new Remove_Staff();
        }
        if(ae.getSource()==b4) {
            f.setVisible(false);
            new Search_Staff();
        }
    }
    public static void main(String[] arg) {
        
        details d = new details();
            
    }
}

Add Staff Coding:

package staff_managenent_system2;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.lang.*;

public class Add_Staff implements ActionListener {
    
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b,b1,b2,b3;
    public int count=0;
    public static InputStream is,is1;
    
    public static File file,compressedImageFile;
    public static Image scaled;
    private File chooseFile;
    private String imageString;
    public static ByteArrayOutputStream boas;
    
    Add_Staff(int i){}
    
    Add_Staff() {
     
        f=new JFrame("Add_Staff");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/add_employee.jpg"));
        id15.setIcon(img);
    
       
        
        id8=new JLabel("New Staff Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);
        
        id1=new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);
        
        id2=new JLabel("Father's name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);
        
        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);
        
        id3=new JLabel("Age");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);
        
        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);
        
        id4=new JLabel("Date of Birth");
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);
        
        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);
        
        id5=new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);
        
        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);
        
        id6=new JLabel("Phone");
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);
        
        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);
        
        id7=new JLabel("Email Id");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);
        
        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);
        
        id9=new JLabel("Education");
        id9.setBounds(400,300,100,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);
        
        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);
        
        id10=new JLabel("Job Post");
        id10.setBounds(50,350,100,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        
        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id15.add(t9);
        
        id11=new JLabel("Aadhar No");
        id11.setBounds(400,350,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);
        
        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id15.add(t10);
        
        id12=new JLabel("Staff Id");
        id12.setBounds(50,400,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);
        
        t11=new JTextField();
        t11.setBounds(200,400,150,30);
        id15.add(t11);
        
        lab=new JLabel();
        lab.setBounds(200,450,250,200);
        id15.add(lab);
        
        lab1=new JLabel();
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);
        
        b=new JButton("Submit");
         b.setBackground(Color.BLACK);
         b.setForeground(Color.WHITE);
         b.setBounds(250,550,150,40);
         id15.add(b);
        
        b1=new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        
        
        
    }
    public void actionPerformed(ActionEvent ae) {
         
        String a=t1.getText();
        String bb=t2.getText();
        String c=t3.getText();
        String d=t4.getText();
        String e=t5.getText();
        String ff=t6.getText();
        String g=t7.getText();
        String h=t8.getText();
        String i=t9.getText();
        String j=t10.getText();
        String k=t11.getText();
        if(ae.getSource()==b){
             System.out.println("if");
            try{
                 System.out.println("try");
                conn cc=new conn();
                String q="insert into staff values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
                
                cc.s.executeUpdate(q);
                
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details();
            }catch(Exception ee){
                System.out.println("the error is"+ee);
            }
        }else if(ae.getSource()==b1){
            f.setVisible(false);
            new details();
        }
    }
    public static void main(String[] arg){
        Add_Staff a =new Add_Staff();
            }
        }

View Staff Coding:

package staff_managenent_system2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class View_Staff implements ActionListener {
    
    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
    
    View_Staff(){
        f=new JFrame("View");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/view.jpg"));
        l1.setIcon(img);
        
        l2=new JLabel("Staff_id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.white);
        Font f1=new Font("serif",Font.BOLD,30);
        l2.setFont(f1);
        l1.add(l2);
        f.add(l1);
        
        t=new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);
        
        b=new JButton("search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l1.add(b);
        
        b2=new JButton("cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);
        
        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            Print_Data p=new Print_Data(t.getText());
        }
    }
    public static void main(String[] arg){
        View_Staff  v=new View_Staff();
    }
}

Print Staff Coding:

package staff_managenent_system2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
        
 class Print_Data implements ActionListener {
     JFrame f;
     JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
     String s_id,name,father,address,phone,email,education,post,age,dob,aadhar;
     JButton b1,b2;
     ImageIcon icon;
     
     Print_Data(String s_id){
         try{
             conn con=new conn();
             String str="select * from staff where s_id= '"+s_id+"'";
             
              ResultSet rs = con.s.executeQuery(str);
             
             
             while(rs.next()){
                 
                 name=rs.getString("name");
                 father=rs.getString("fname");
                 age=rs.getString("age");
                 dob=rs.getString("dob");
                 address=rs.getString("address");
                 phone=rs.getString("phone");
                 email=rs.getString("email");
                 education=rs.getString("education");
                 post=rs.getString("post");
                 aadhar=rs.getString("aadhar");
                 s_id=rs.getString("s_id");
             }
         }catch(Exception e) {
             e.printStackTrace();
         }
         f=new JFrame("Print Data");
         f.setVisible(true);
         f.setSize(595,642);
         f.setLocation(450,200);
         f.setBackground(Color.white);
         f.setLayout(null);
         
         id9=new JLabel();
         id9.setBounds(0,0,595,642);
         id9.setLayout(null);
         ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/print.jpg"));
         id9.setIcon(img);
         
         id8=new JLabel("Staff Details");
         id8.setBounds(50,10,250,30);
         f.add(id8);
         id8.setFont(new Font("serif",Font.BOLD,25));
         id9.add(id8);
         f.add(id9);
         
         id=new JLabel("Staff id");
         id.setBounds(50,70,200,30);
         id.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id);
         
         aid=new JLabel(s_id);
         aid.setBounds(200,70,200,30);
         aid.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid);
         
         id1=new JLabel("Name");
         id1.setBounds(50,120,100,30);
         id1.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id1);
         
         aid1=new JLabel(name);
         aid1.setBounds(200,120,300,30);
         aid1.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid1);
         
         id2=new JLabel("Father's Name");
         id2.setBounds(50,170,200,30);
         id2.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id2);
         
         aid2=new JLabel(father);
         aid2.setBounds(200,170,300,30);
         aid2.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid2);
         
         id3=new JLabel("Address");
         id3.setBounds(50,220,100,30);
         id3.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id3);
         
         aid3=new JLabel(address);
         aid3.setBounds(200,220,300,30);
         aid3.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid3);
         
         id4=new JLabel("Mobile NO");
         id4.setBounds(50,270,100,30);
         id4.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id4);
         
         aid4=new JLabel(phone);
         aid4.setBounds(200,270,300,30);
         aid4.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid4);
         
         id5=new JLabel("Email Id");
         id5.setBounds(50,320,100,30);
         id5.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id5);
         
         aid5=new JLabel(email);
         aid5.setBounds(200,320,300,30);
         aid5.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid5);
         
         id6=new JLabel("Education");
         id6.setBounds(50,370,100,30);
         id6.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id6);
         
         aid6=new JLabel(education);
         aid6.setBounds(200,370,300,30);
         aid6.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid6);
         
         id7=new JLabel("Job Post");
         id7.setBounds(50,420,100,30);
         id7.setFont(new Font("serif",Font.BOLD,20));
         id9.add(id7);
         
         aid7=new JLabel(post);
         aid7.setBounds(200,420,300,30);
         aid7.setFont(new Font("serif",Font.BOLD,20));
         id9.add(aid7);
         
         b1=new JButton("Print");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(100,520,100,30);
         b1.addActionListener(this);
         id9.add(b1);
         
         b2=new JButton("Cancel");
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(250,520,100,30);
         b2.addActionListener(this);
         id9.add(b2);
         
     }
     public void actionPerformed(ActionEvent ae) {
         
         if(ae.getSource()==b1) {
             
             JOptionPane.showMessageDialog(null,"printed successfully");
             
             f.setVisible(false);
             details d=new details();
         }
         if(ae.getSource()==b2){
             f.setVisible(false);
             new View_Staff();
         }
     }
     public static void main(String[] args){
         
        new Print_Data("Print Data");
     }
 }

Update Staff Coding:

package staff_managenent_system2;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Update_Staff implements ActionListener {
    
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3;
    
    String id_s;
    
    Update_Staff(String idaa){
        
        
        f=new JFrame("update Staff details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);
        
        id_s=idaa;
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/add_employee.jpg"));
        id15.setIcon(img);
        
        id8=new JLabel("Update Staff details");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);
        
        id1=new JLabel("Name");
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);
        
        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);
        
        id2=new JLabel("Father's Name");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);
        
        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);
        
        id3=new JLabel("Address:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);
        
        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);
        
        id4=new JLabel("Mobile NO");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);
        
        t4=new JTextField();
        t4.setBounds(600,150,150,30);
        id15.add(t4);
        
        id5=new JLabel("Email Id");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);
        
        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);
        
        id6=new JLabel("Education");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);
        
        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);
        
        id7=new JLabel("Job Post");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);
        
        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);
        
        id9=new JLabel("Aadhar No");
        id9.setBounds(400,250,100,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);
        
        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);
        
        id10=new JLabel("Staff Id");
        id10.setBounds(50,300,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        f.setVisible(false);
        
        t9=new JTextField();
        t9.setBounds(200,300,150,30);
        id15.add(t9);
        
        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);
        
        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);
        
        showData(idaa);
    }
    int i=0;
    String age,dat;
    
    void showData(String s){
        try{
            
            conn con=new conn();
            String str = "select *from staff where s_id='"+s+"'";
            
            ResultSet rs=con.s.executeQuery(str);
            
            if(rs.next()) {
                f.setVisible(true);
                i=1;
                
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                t6.setText(rs.getString(8));
                t7.setText(rs.getString(9));
                t8.setText(rs.getString(10));
                t9.setText(rs.getString(11));
                
                age=rs.getString(3);
                dat=rs.getString(4);
            }
            if(i==0)
                
                JOptionPane.showMessageDialog(null,"id not found");
            new Search_Staff();
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1)
            try{
                conn con=new conn();
                String str="update staff set name='"+t1.getText()+"',fname='"+t2.getText()+"',age='"+age+"',dob='"+dat+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+"',post='"+t7.getText()+"',aadhar='"+t8.getText()+"',s_id='"+t9.getText()+"'where s_id='"+id_s+"'";
                
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                
                f.setVisible(false);
                new Search_Staff();
            }catch(Exception e){
                System.out.println("the error is:"+e);
            }
    
     if(ae.getSource()==b1){
         f.setVisible(false);
         details d=new details();
     }
    }
public static void main(String[] arg){
 
    new Update_Staff("Update Staff");
}
}
Remove Staff Coding:

package staff_managenent_system2;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove_Staff implements ActionListener {
    
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b,b1,b2,b3;
    
    Remove_Staff(){
        f=new JFrame("Remove Staff");
        f.setBackground(Color.green);
        f.setLayout(null);
        
        l5=new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("staff_managenent_system2/icons/remove.jpg"));
        l5.setIcon(img);
        f.add(l5);
        
        l1=new JLabel("Staff_Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.white);
        Font f2=new Font("serif",Font.BOLD,25);
        l1.setFont(f2);
        l5.add(l1);
        
        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);
        
        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        l5.add(b);
        
        b3=new JButton("back");
        b3.setBounds(360,100,100,30);
        b3.addActionListener(this);
        l5.add(b3);
        
        l2=new JLabel("Name");
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.white);
        Font f3=new Font("serif",Font.BOLD,20);
        l2.setFont(f3);
        l5.add(l2);
        
        l6=new JLabel();
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.white);
        Font f6=new Font("serif",Font.BOLD,20);
        l6.setFont(f6);
        l5.add(l6);
        
        l3=new JLabel("Mobile NO");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.white);
        Font f4=new Font("serif",Font.BOLD,20);
        l3.setFont(f4);
        l5.add(l3);
        
        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20);
        l7.setFont(F7);
        l5.add(l7);
        
        l4=new JLabel("Email Id");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20);
        l4.setFont(F5);
        l5.add(l4);
        
        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20);
        l8.setFont(f8);
        l5.add(l8);
        
        b1=new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        l5.add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        
        f.setSize(500,500);
        f.setLocation(500,250);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b){
            try{
                conn con=new conn();
                String str="select name,phone,email from staff where s_id='"+t.getText()+"'";
                
                ResultSet rs=con.s.executeQuery(str);
                
                int i=0;
                if(rs.next()){
                    String name=rs.getString(1);
                    String mob=rs.getString(2);
                    String email=rs.getString(3);
                    
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);
                    i=1;
                    l6.setText(name);
                    l7.setText(mob);
                    l8.setText(email);
                    
                }
                if(i==0)
                    
                    JOptionPane.showMessageDialog(null,"id not found");
            }catch(Exception ex){}
        }
        if(ae.getSource()==b1){
            try{
                conn con=new conn();
                String str="delete from staff where s_id= '"+t.getText()+"'";
                con.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"deleted successfully");
                
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null,"Exception occured while delting record"+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            details d=new details();
        }
    }
    public static void main(String[] arg) {
        new Remove_Staff();
    }
}
 
















