package com.uog.timetable;

import java.util.List;
import java.util.Scanner;

import edu.uog.Campus.RoomData;
import edu.uog.Teacher.TeacherCourseData;

public class TimetableInterface {
	public static void TimetableManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Time Table Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Time Table Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
		    System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Time Table");
				System.out.println("---------------------------------");
				Timetable time= new Timetable();

				System.out.println("Enter TeacherCourse ID: ");
				int TCI=scan.nextInt();
				time.setTEACHERCOURSE_ID(TeacherCourseData.findOne(TCI));
				
				System.out.println("Enter TimeSlot ID: ");
				int SID=scan.nextInt();
				time.setTIMESLOT_ID(TimeSlotData.findOne(SID));
				
				System.out.println("Enter Room ID: ");
				int RID=scan.nextInt();
				time.setROOM_ID(RoomData.findOne(RID));
						
				time = TimetableData.Save(time);
				System.out.println(time.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Time Table");
				System.out.println("---------------------------------");
				System.out.println("Enter Time Table ID: ");
				int time_ID = scan.nextInt();
				
				Timetable timedelete = TimetableData.DelOne(time_ID);
				System.out.println(timedelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Timetable Data");
				System.out.println("---------------------------------");
				List<Timetable> table = TimetableData.findAll();
				for (int i=0; i<table.size(); i++) {
					System.out.println(table.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Timetable Data");
				System.out.println("-----------------------------------");
				Timetable times=TimetableData.findOne(1);
				System.out.println(times.toString());
				System.out.println("------------------------------------");
			
			    break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Timetable");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Timetable> timesearch = TimetableData.search(search);
				for (int i=0; i<timesearch.size(); i++) {
					System.out.println(timesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<Timetable> Del=TimetableData.DelAll();
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
