package com.uog.timetable;

import java.util.List;
import java.util.Scanner;

public class WeekDayInterface {

	public static void WeekDayManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("WeekDay Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show All");
			System.out.println("4.   Show One Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Week Day");
				System.out.println("---------------------------------");
				WeekDay week = new WeekDay();

				System.out.println("Enter Week Day Name: ");
				String name=scan.nextLine();
				name+=scan.nextLine();
				week.setWEEKDAY_NAME(name);

				week = WeekDayData.Save(week);
				System.out.println(week.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Week Day");
				System.out.println("---------------------------------");
				System.out.println("Enter Week Day ID: ");
				int week_ID = scan.nextInt();
				
				WeekDay weekdelete = WeekDayData.DelOne(week_ID);
				System.out.println(weekdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Week Day Data");
				System.out.println("---------------------------------");
				List<WeekDay> weeks = WeekDayData.findAll();
				for (int i=0; i<weeks.size(); i++) {
					System.out.println(weeks.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Week Day Data");
				System.out.println("-----------------------------------");
				WeekDay day=WeekDayData.findOne(1);
				System.out.println(day.toString());
				System.out.println("------------------------------------");
				break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Room");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				List<WeekDay> weeksearch = WeekDayData.search(search);
				for (int i=0; i<weeksearch.size(); i++) {
					System.out.println(weeksearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<WeekDay> Del=WeekDayData.DelAll();
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
