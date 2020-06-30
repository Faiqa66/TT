package edu.uog.Student;

import java.util.List;
import java.util.Scanner;

public class StudentInterface {
	public static void StudentManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Student Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Student Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student");
				System.out.println("---------------------------------");
				Student student = new Student();

				System.out.println("Enter Student Roll No: ");
				String roll = scan.nextLine();
				roll=scan.nextLine();
				student.setSTUDENT_ROLLNO(roll);
				
				System.out.println("Enter Study Program: ");
				String study = scan.nextLine();
				student.setSTUDY_PROGRAM(study);;

				System.out.println("Enter Study Year: ");
				String year = scan.nextLine();
				student.setSTUDY_YEAR(year);

				student = StudentData.Save(student);
				System.out.println(student.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Student");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				int student_ID = scan.nextInt();
				
				Student studentdelete = StudentData.DelOne(student_ID);
				System.out.println(studentdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Students Data");
				System.out.println("---------------------------------");
				List<Student> students = StudentData.findAll();
				for (int i=0; i<students.size(); i++) {
					System.out.println(students.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Student Data");
				System.out.println("-----------------------------------");
				Student oneStudent=StudentData.findOne(1);
				System.out.println(oneStudent.toString());
				System.out.println("------------------------------------");
			
			   break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Student");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Student> studentsearch = StudentData.search(search);
				for (int i=0; i<studentsearch.size(); i++) {
					System.out.println(studentsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<Student> Del=StudentData.DelAll();
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
