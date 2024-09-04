package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.CourseList;

public class Adminmenu {
    static Scanner sc = new Scanner(System.in);
	public void admenu() throws SQLException { 
		
		System.out.println("-----------------------------------");
		System.out.println("       SELECT THE OPTIONS ");
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("    1 - Add new course");
		System.out.println("    2 - Remove course");
		System.out.println("    3 - View couse status");
//		System.out.println("    4 - View student details");
		
		int option = sc.nextInt();
		sc.nextLine();
		switch (option){
		case 1:{
			System.out.println("     ADD NEW COURSE");
			System.out.println();
			System.out.println("  Enter Course Name");
			String cname = sc.nextLine();
			System.out.println("  Enter Course ID");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("  Enter Domain");
			String domain = sc.nextLine();
			System.out.println("  Enter Number Of Modules");
			int module = sc.nextInt();
			CourseList cl = new CourseList();
			cl.setCid(id);
			cl.setCname(cname);
			cl.setDomain(domain);
			cl.setModules(module);
			CourseList add = new CourseList();
			add.addCourse(cl);
			break;
		}
		case 2:{
			System.out.println("   Remove Course");
			System.out.println();
			System.out.println("Enter CourseId");
			int cid = sc.nextInt();
			CourseList cl = new CourseList();
			cl.removeCourse(cid);
			System.out.println("Course removed Successfully");
		}
	
	}

}
}
