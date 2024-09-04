package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.Admin;
import controller.Student;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
        	System.out.println(" SRI SHAKTHI INSTITUTE OF ENGINEERING AND TECHNOLOGY");
        	System.out.println("    ************  COURSE PORTAL  ************");
        	System.out.println();
        	System.out.println("            <--  press 1 to Login  -->");
        	System.out.println("            <--  press 0 to Logout -->");
        	int choice = sc.nextInt();
        	switch (choice)
        	{
        	case 1:
        		login();
        		break;
        	case 2:
        		System.out.println("Logout successfully");
        	}
        }
	static Admin a = new Admin();
	static Student s = new Student();
	private static void login() throws SQLException {
		System.out.println("<----------  Enter your mail_id  ---------->");
		String mail = sc.next();
		System.out.println("<-----------  Enter your password  ---------->");
		String psw = sc.next();
		System.out.println("<----------  Enter your role  ---------->");
		String role = sc.next();
		
		if(role.equalsIgnoreCase("admin")) {
			Admin a1 = new Admin();
			a1.setEmail_ID(mail);
			a1.setPassword(psw);
			Admin ad1 = a.adminLogin(a1);
			if(ad1!=null){
				System.out.println();
				System.out.println("      Login Succesfull");
				System.out.println();
				Adminmenu am = new Adminmenu();
				am.admenu();
				
			}
			else {
				System.out.println("Invalid mail_id or Password");
			}
		}
		if(role.equalsIgnoreCase("student")) {
			Student s1 = new Student();
			s1.setMailid(mail);
			s1.setPassword(psw);
			Student st1 = s.studentLogin(s1);
			if(st1!=null) {
				System.out.println();
				System.out.println("     Login Successfull");
				System.out.println();
				Studentmenu sm = new Studentmenu();
				sm.stmenu(st1);
			}
			else {
				System.out.println("Invalid mail_id or Password");
			}
		}
	}

}


