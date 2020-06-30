package edu.uog.Student;

import java.util.List;
import java.util.Scanner;

import edu.uog.Course.CourseData;

public class StudentCourseInterface {
	public static void StudentCourseManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Student Course Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Student Course Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student Course");
				System.out.println("---------------------------------");
				StudentCourse scourse = new StudentCourse();

				System.out.println("Enter Course ID: ");
				int CID = scan.nextInt();
				scourse.setCOURSE_ID(CourseData.findOne(CID));

				System.out.println("Enter Student ID: ");
				int SID = scan.nextInt();
				scourse.setSTUDENT_ID(StudentData.findOne(SID));

				System.out.println("Enter Section: ");
				String sec = scan.nextLine();
				sec=scan.nextLine();
                scourse.setSECTION(sec);
				
                
				scourse = StudentCourseData.Save(scourse);
				System.out.println(scourse.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Student Course");
				System.out.println("---------------------------------");
				System.out.println("Enter Student Course ID: ");
				int student_ID = scan.nextInt();
				
				StudentCourse studentdelete = StudentCourseData.DelOne(student_ID);
				System.out.println(studentdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Student Course Data");
				System.out.println("---------------------------------");
				List<StudentCourse> courses = StudentCourseData.findAll();
				for (int i=0; i<courses.size(); i++) {
					System.out.println(courses.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Student Course Data");
				System.out.println("-----------------------------------");
				StudentCourse cour=StudentCourseData.findOne(1);
				System.out.println(cour.toString());
				System.out.println("------------------------------------");
			
			    break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Room");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<StudentCourse> studentsearch = StudentCourseData.search(search);
				for (int i=0; i<studentsearch.size(); i++) {
					System.out.println(studentsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<StudentCourse> Del=StudentCourseData.DelAll();
				for(int i=0;i<Del.size();i++) {
					System.out.println(Del.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 7:
				break;
			}
		}
	}

}
