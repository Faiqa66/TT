package edu.uog;
import java.util.*;

import com.uog.timetable.TimeSlotInterface;
import com.uog.timetable.TimetableInterface;
import com.uog.timetable.WeekDayInterface;

import edu.uog.Campus.RoomInterface;
import edu.uog.Course.CourseInterface;
import edu.uog.Person.PersonInterface;
import edu.uog.Student.StudentCourseInterface;
import edu.uog.Student.StudentInterface;
import edu.uog.Teacher.TeacherCourseInterface;
import edu.uog.Teacher.TeacherInterface;
public class TimetableManagement1 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=11) {
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Rooms");
			System.out.println("2.   Courses");
			System.out.println("3.   Persons");
			System.out.println("4.   Students");
			System.out.println("5.   Student Courses");
			System.out.println("6.   Teachers");
			System.out.println("7.   Teacher Courses ");
			System.out.println("8.   TimeTable");
			System.out.println("9.   TimeSlot");
			System.out.println("10.  WeekDay");
			System.out.println("11.   Quit");
			System.out.println("Enter Your Choice [1-11]: ");
			choice = scan.nextInt();
	
			switch (choice) {
			case 1:
				RoomInterface.RoomManu();
				break;

			case 2:
				CourseInterface.CourseManu();
				break;
				
			case 3:
				PersonInterface.PersonManu();
				break;
				
			case 4:
				StudentInterface.StudentManu();
				break;
				
			case 5:
				StudentCourseInterface.StudentCourseManu();
				break;
				
			case 6:
				TeacherInterface.TeacherManu();
				break;
				
			case 7:
				TeacherCourseInterface.TeacherCourseManu();
				break;
				
			case 8:
				TimetableInterface.TimetableManu();
				break;
			case 9:
				TimeSlotInterface.TimeSlotManu();
				break;
				
			case 10:
				WeekDayInterface.WeekDayManu();
				break;
				
			default:
				System.out.println("Allah Hafiz Beta Allah Tumhari Errors ko asani sy solve karny ki tofeeq dy (-,-)");
			}
		}
}
}