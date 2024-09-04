package view;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CourseList;
import controller.Course_status;
import controller.Student;

public class Studentmenu {
	static Scanner sc = new Scanner(System.in);
public void stmenu(Student st1) throws SQLException { 
		
		System.out.println("-----------------------------------");
		System.out.println("       SELECT THE OPTIONS ");
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("    1 - Show the availble courses");
		System.out.println("    2 - Register for the new course");
		System.out.println("    3 - My course");
		System.out.println("    4 - My profile");
		
		int option = sc.nextInt();
		switch (option) {
		case 1:{
			System.out.println("   AVAILABLE COURSES");
            System.out.println();
            ArrayList<CourseList> availableCourses = CourseList.viewCourse();

            System.out.printf("  %-10s %-45s %-10s %-20s%n", "ID", "Name", "Domain" ,"Modules");
            System.out.println("-----------------------------------------------------------------------------");
          
            for (CourseList course : availableCourses) {
                System.out.printf("  %-10d %-45s %-10s %-20s%n", course.getCid(), course.getCname(), course.getDomain(),course.getModules());
            }
            break;
		}
		
		case 2:{
			System.out.println("-------------------------------");
			System.out.println("      GET NEW COURSE");
			System.out.println("-------------------------------");
			System.out.println();
			System.out.println();
			System.out.println(" NOTE : **Only choose the available course**");
			System.out.println();
			Course_status cd = new Course_status();
			System.out.println("   Enter the course name");
			sc.nextLine();
			String cname = sc.nextLine();
			String sroll = st1.getRegister_no();
		    cd.setCname(cname);
		    cd.setSregno(sroll);
			int n = Course_status.regCour(cd);
			if(n==1) {
				System.out.println(" No such course available!!.");
			    System.out.println(" Please choose the available course");
			}
			else {
				System.out.println("You have register for the course "+cname);
			}
			break;
	   }
		case 3:{
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("        My Course"                                               );
			System.out.println("----------------------------------------------------------------");
			Course_status my = new Course_status();
			String sroll = st1.getRegister_no();
			my.setSregno(sroll);
			ArrayList<Course_status> ac = Course_status.myCourse(my);
			if(ac.isEmpty()) {
				System.out.println("There are no course to display");
				break;
			}
			for (Course_status course : ac) {
				System.out.printf("%-10s %-30s %-50s%n", course.getSregno(), course.getCid(), course.getCstatus());

			}
			System.out.println();
			System.out.println();
			System.out.println(" ** if you complete the course please enter 0 to get certificate");
			System.out.println();
			System.out.println(" ** if not, please ignore the above option and select 1 to resume your course !!!");
			int com = sc.nextInt();
			if(com == 0) {
				Course_status fin = new Course_status();
				String roll = st1.getRegister_no();
				fin.setSregno(roll);
				Course_status.completeCourse(fin);
				System.out.println("Congratulation!! You have completed");
			}

			
		}
	}
}
}

