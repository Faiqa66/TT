package edu.uog.Campus;

import java.util.List;
import java.util.Scanner;

public class RoomInterface {

	public static void RoomManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Rooms Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Room Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.   Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("+++++++++++++++++++++++++++++++++");
				System.out.println("Add New Room");
				System.out.println("+++++++++++++++++++++++++++++++++");
				Room aroom = new Room();
							
				System.out.println("Enter Room Name: ");
				String roomname = scan.nextLine();
				roomname+=scan.nextLine();
				aroom.setROOM_NAME(roomname);
				
				System.out.println("Enter Room Floor: ");
				int floor = scan.nextInt();
				aroom.setROOM_FLOOR(floor);
				
				System.out.println("Enter Room Capacity: ");
				int capacity = scan.nextInt();
				aroom.setROOM_CAPACITY(capacity);
				
				System.out.println("Enter Room Type: ");
				String type = scan.nextLine();
				type+=scan.nextLine();
				aroom.setROOM_TYPE(type);
				
				aroom= RoomData.Save(aroom);
				System.out.println(aroom.toString());
				
				System.out.println("---------------------------------\n");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Room");
				System.out.println("---------------------------------");
				System.out.println("Enter Room ID: ");
				int room_ID = scan.nextInt();
				
				Room roomdelete = RoomData.DelOne(room_ID);
				System.out.println(roomdelete.toString());
				System.out.println("---------------------------------\n");
				break;
			case 3:
				System.out.println("--------------$$$$---------------");
				System.out.println("Show All Rooms Data");
				System.out.println("--------------$$$$---------------");
				List<Room> rooms = RoomData.findAll();
				for (int i=0; i<rooms.size(); i++) {
					System.out.println(rooms.get(i).toString());
				}
				System.out.println("---------------------------------\n");
				break;
			case 4:
				System.out.println("-----------------$$$$-------------");
				System.out.println("Show One Room Data");
				System.out.println("-----------------$$$$--------------");
				Room room=RoomData.findOne(1);
				System.out.println(room.toString());
				System.out.println("------------------------------------\n");
			    
				break;
			case 5:
				System.out.println("-----------********----------------");
				System.out.println("Search Room");
				System.out.println("-----------********--------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Room> roomsearch = RoomData.search(search);
				for (int i=0; i<roomsearch.size(); i++) {
					System.out.println(roomsearch.get(i).toString());
				}
				System.out.println("---------------------------------\n");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<Room> Del=RoomData.DelAll();
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
