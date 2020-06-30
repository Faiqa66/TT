package com.uog.timetable;

import java.util.List;
import java.util.Scanner;

public class TimeSlotInterface {
	public static void TimeSlotManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Time Slot Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Time Slot Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Time Slot");
				System.out.println("---------------------------------");
				TimeSlot time = new TimeSlot();

				System.out.println("Enter Weekday ID: ");
				int wId=scan.nextInt();
				time.setWeekDay_ID(WeekDayData.findOne(wId));
				
				System.out.println("Enter Time Slot Start: ");
				String start = scan.nextLine();
				start+=scan.nextLine();
				time.setTIMESLOT_START(start);

				System.out.println("Enter Time Slot End: ");
				String end = scan.nextLine();
				end+=scan.nextLine();
				time.setTIMESLOT_END(end);

				time= TimeSlotData.Save(time);
				System.out.println(time.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Time Slot");
				System.out.println("---------------------------------");
				System.out.println("Enter Time Slot ID: ");
				int slot_ID = scan.nextInt();
				
				TimeSlot slotdelete = TimeSlotData.DelOne(slot_ID);
				System.out.println(slotdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Time Slot Data");
				System.out.println("---------------------------------");
				List<TimeSlot> times = TimeSlotData.findAll();
				for (int i=0; i<times.size(); i++) {
					System.out.println(times.get(i).toString());
				}
				
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Time Slot Data");
				System.out.println("-----------------------------------");
				TimeSlot slots=TimeSlotData.findOne(1);
				System.out.println(slots.toString());
				System.out.println("------------------------------------");
			
			    break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Time Slot");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<TimeSlot> slotsearch = TimeSlotData.search(search);
				for (int i=0; i<slotsearch.size(); i++) {
					System.out.println(slotsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<TimeSlot> Del=TimeSlotData.DelAll();
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
