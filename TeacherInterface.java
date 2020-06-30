package edu.uog.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherInterface  {
	public static void TeacherManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Teacher Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Teacher Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Teacher");
				System.out.println("---------------------------------");
				Teacher teacher= new Teacher();
				
				System.out.println("Enter Teacher Name: ");
				String name = scan.nextLine();
				name=scan.nextLine();
				teacher.setTEACHER_NAME(name);
                
				System.out.println(TeacherData.Save(teacher));
				System.out.println(teacher.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Teacher");
				System.out.println("---------------------------------");
				System.out.println("Enter Teacher ID: ");
				int teacher_ID = scan.nextInt();
				
				Teacher delete = TeacherData.DelOne(teacher_ID);
				System.out.println(delete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Teachers Data");
				System.out.println("---------------------------------");
				List<Teacher> teachers = TeacherData.findAll();
				for (int i=0; i<teachers.size(); i++) {
					System.out.println(teachers.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Teaacher Data");
				System.out.println("-----------------------------------");
				Teacher tech=TeacherData.findOne(1);
				System.out.println(tech.toString());
				System.out.println("------------------------------------");
		
                break;			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Teacher");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Teacher> teachersearch = TeacherData.search(search);
				for (int i=0; i<teachersearch.size(); i++) {
					System.out.println(teachersearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<Teacher> Del=TeacherData.DelAll();
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

