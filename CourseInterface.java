package edu.uog.Course;

import java.util.List;
import java.util.Scanner;


public class CourseInterface {
	public static void CourseManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Course Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Course Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("+++++++++++++++++++++++++++++++++");
				System.out.println("Add New Course");
				System.out.println("+++++++++++++++++++++++++++++++++");
				Course course = new Course();
				
				System.out.println("Enter Course Code: ");
				String name = scan.nextLine();
				name=scan.nextLine();
				course.setCOURSE_CODE(name);

				System.out.println("Enter Course Tiltle: ");
				String title = scan.nextLine();
				course.setCOURSE_TITLE(title);

				System.out.println("Enter course desciption: ");
				String des=scan.nextLine();
				des+=scan.nextLine();
				course.setCOURSE_DESC(des);
				
				System.out.println("Enter Course Credit hours:");
			    int cred=scan.nextInt();
				course.setCREDITHOUR(cred);
				
			    System.out.println("Enter Course Prerequisit:");
				int pre=scan.nextInt();
				course.setCOURSEPREREQUIST_ID(CourseData.findOne(pre));
                
				course = CourseData.Save(course);
				System.out.println(course.toString());
				System.out.println("---------------------------------\n");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Course");
				System.out.println("---------------------------------");
				System.out.println("Enter Course ID: ");
				int course_ID = scan.nextInt();
				
				Course coursedelete = CourseData.DelOne(course_ID);
				System.out.println(coursedelete.toString());
				System.out.println("---------------------------------\n");
				break;
			case 3:
				System.out.println("------------$$$$$$$$-------------");
				System.out.println("Show All Courses Data");
				System.out.println("------------$$$$$$$$-------------");
				List<Course> courses = CourseData.findAll();
				for (int i=0; i<courses.size(); i++) {
					System.out.println(courses.get(i).toString());
				}
				System.out.println("---------------------------------\n");
				break;
			case 4:
				System.out.println("--------------$$$$$$$--------------");
				System.out.println("Show One Course Data");
				System.out.println("--------------$$$$$$$--------------");
				Course cour=CourseData.findOne(1);
				System.out.println(cour.toString());
				System.out.println("------------------------------------\n");
			
			    break;
			case 5:
				System.out.println("*********************************");
				System.out.println("Search Course");
				System.out.println("*********************************");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Course> coursesearch = CourseData.search(search);
				for (int i=0; i<coursesearch.size(); i++) {
					System.out.println(coursesearch.get(i).toString());
				}
				System.out.println("---------------------------------\n");
				
				break;
			case 6:
				System.out.println("**********************************");
				System.out.println("Delete All Data");
				System.out.println("**********************************");
				
				List<Course> Del=CourseData.DelAll();
				for(int i=0;i<Del.size();i++) {
					System.out.println(Del.get(i).toString());
				}
				System.out.println("---------------------------------\n");
				
				break;
			case 7:
				break;
			}
		}
	}
}


