package edu.uog.Campus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomData {

	private static String csvFile="C:\\TimeTable\\Room.csv";
	
	public static List<Room> findAll(){
		List<Room> room=new ArrayList<Room>();
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		 
			while((line = bufferReader.readLine())!=null) {
				Room room1=new Room();
				
				String[] room1Row=line.split(",");
			
				room1.setROOM_ID(Integer.parseInt(room1Row[0]));
				room1.setROOM_NAME((room1Row[1]));
				room1.setROOM_FLOOR(Integer.parseInt(room1Row[2]));
				room1.setROOM_CAPACITY(Integer.parseInt(room1Row[3]));
				room1.setROOM_TYPE((room1Row[4]));
				

				room.add(room1);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return room;
	}
	@SuppressWarnings("resource")
	public static Room findOne(int ROOM_ID) {
		List<Room> rooms=new ArrayList<Room>();
		
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Room room=new Room();
			String[] roomRow=line.split(",");
			
			if (Integer.parseInt(roomRow[0]) == ROOM_ID) {
								
				room.setROOM_ID(Integer.parseInt(roomRow[0]));
				room.setROOM_NAME(roomRow[1]);
				room.setROOM_CAPACITY(Integer.parseInt(roomRow[2]));
				room.setROOM_FLOOR(Integer.parseInt(roomRow[3]));
				room.setROOM_TYPE(roomRow[4]);
				
				rooms.add(room);
				
				return room;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<Room> search(String search){
		List<Room> rooms=new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Room room=new Room();
			
			String [] roomRow=line.split(",");
			
			if(roomRow[1].contains(search)==true) {
			
				room.setROOM_ID(Integer.parseInt(roomRow[0]));
				room.setROOM_NAME(roomRow[1]);
				room.setROOM_CAPACITY(Integer.parseInt(roomRow[2]));
				room.setROOM_FLOOR(Integer.parseInt(roomRow[3]));
				room.setROOM_TYPE(roomRow[4]);
			    
				rooms.add(room);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return rooms;
	}
	
	public static Room Save(Room room)
	{
		FileWriter filewriter;
        List<Room> rooms = findAll();
		try 
		{
			filewriter = new FileWriter(RoomData.csvFile);
			
			for(int i=0; i<rooms.size(); i++)
			{
				filewriter.append(rooms.get(i).toString());
				filewriter.append("\n");
			}
			if(rooms.size()>0)
			{  room.setROOM_ID(rooms.get(rooms.size()-1).getROOM_ID()+1);  }
			else
			{  room.setROOM_ID(1); 
			}
			filewriter.append(room.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println(e); 
			e.printStackTrace();    
		}
	
		return room;
	}
	
	public static Room DelOne(int Room_ID) {
		FileWriter fileWriter;
		List<Room> Room=findAll();
		Room room=RoomData.findOne(Room_ID);
		
		try {
			fileWriter=new FileWriter(RoomData.csvFile);
			
			for(int i=0;i<Room.size();i++) {
				if(Room.get(i).getROOM_ID()!=Room_ID) {
					fileWriter.append(Room.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		Room.add(room);
		fileWriter.flush();
		fileWriter.close();
		
		return room;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return room;
}

	
	public static List<Room> DelAll() {
		FileWriter filewriter;
		List<Room> rooms=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<rooms.size();i++) {
				rooms.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rooms;
		
	}
	
}
