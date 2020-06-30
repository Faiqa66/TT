package edu.uog.Teacher;

import java.util.List;
import java.util.Scanner;

import edu.uog.Course.CourseData;

public class TeacherCourseInterface {
	public static void TeacherCourseManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Teacher Course Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Teacher Course");
				System.out.println("---------------------------------");
				TeacherCourse teacher = new TeacherCourse();

				System.out.println("Enter Teacher ID: ");
                int TID=scan.nextInt();

                teacher.setTEACHER_ID(TeacherData.findOne(TID));

				System.out.println("Enter Course ID: ");
				int CID = scan.nextInt();
				teacher.setCOURSE_ID(CourseData.findOne(CID));

				System.out.println("Enter Section: ");
				String sec = scan.nextLine();
				sec=scan.nextLine();
				teacher.setSECTION(sec);

				teacher = TeacherCourseData.Save(teacher);
				System.out.println(teacher.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Teacher Course");
				System.out.println("---------------------------------");
				System.out.println("Enter Teacher Course ID: ");
				int teacher_ID = scan.nextInt();
				
				TeacherCourse coursedelete = TeacherCourseData.DelOne(teacher_ID);
				System.out.println(coursedelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Teacher Course Data");
				System.out.println("---------------------------------");
				List<TeacherCourse> cour = TeacherCourseData.findAll();
				for (int i=0; i<cour.size(); i++) {
					System.out.println(cour.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Teacher Course Data");
				System.out.println("-----------------------------------");
				TeacherCourse tech=TeacherCourseData.findOne(1);
				System.out.println(tech.toString());
				System.out.println("------------------------------------");
			
			   break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Teacher Course");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search=scan.nextLine();
				List<TeacherCourse> coursesearch = TeacherCourseData.search(search);
				for (int i=0; i<coursesearch.size(); i++) {
					System.out.println(coursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<TeacherCourse> Del=TeacherCourseData.DelAll();
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
