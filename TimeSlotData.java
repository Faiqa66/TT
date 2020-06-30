package com.uog.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TimeSlotData {

	private static String csvFile="C:\\TimeTable\\TimeSlot.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		TimeSlotData.csvFile = csvFile;
	}
	
	@SuppressWarnings({ "resource", "unused" })
	public static List<TimeSlot> findAll(){
		List<TimeSlot> timeSlot=new ArrayList<TimeSlot>();
		String line;
		
		try {
			BufferedReader buferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line = buferReader.readLine())!=null) {
				TimeSlot ts=new TimeSlot();
                WeekDay weekDay=new WeekDay();				
				String[] tsRow=line.split(",");
				
				
				ts.setTIMESLOT_ID(Integer.parseInt(tsRow[1]));
				ts.setWeekDay_ID(WeekDayData.findOne(Integer.parseInt(tsRow[0])));
			    ts.setTIMESLOT_START(tsRow[2]);
			    ts.setTIMESLOT_END(tsRow[3]);
			    
			    timeSlot.add(ts);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
		return timeSlot;
		
	}
	
public static TimeSlot findOne(int TIMESLOT_ID) {
		
	List<TimeSlot> slots=new ArrayList<TimeSlot>();
		String line;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			TimeSlot ts=new TimeSlot();
			String[] tRow=line.split(",");
			
			if (Integer.parseInt(tRow[0]) == TIMESLOT_ID) {
				
			     ts.setTIMESLOT_ID(Integer.parseInt(tRow[0]));
			     ts.setWeekDay_ID(WeekDayData.findOne(Integer.parseInt(tRow[1])));
			     ts.setTIMESLOT_START(tRow[2]);
			     ts.setTIMESLOT_END(tRow[3]);
				
			     slots.add(ts);
				return ts;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static List<TimeSlot> search(String search){
		List<TimeSlot> timeslot=new ArrayList<TimeSlot>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(TimeSlotData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			TimeSlot ts=new TimeSlot();
			
			String[] tRow=line.split(",");
			
			if(tRow[1].contains(search)==true) {
				ts.setTIMESLOT_ID(Integer.parseInt(tRow[0]));
			     ts.setWeekDay_ID(WeekDayData.findOne(Integer.parseInt(tRow[1])));
			     ts.setTIMESLOT_START(tRow[2]);
			     ts.setTIMESLOT_END(tRow[3]);
			
			       timeslot.add(ts);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return timeslot;
	}
	
	public static TimeSlot Save(TimeSlot timeslot) {
		FileWriter filewriter;
		
		List<TimeSlot> ts=findAll();
		
		try {
			filewriter=new FileWriter(TimeSlotData.csvFile);
			
			for (int i=0; i<ts.size(); i++) {
				filewriter.append(ts.get(i).toString());
				filewriter.append("\n");
			}
			if (ts.size()>0)
				timeslot.setTIMESLOT_ID(ts.get(ts.size()-1).getTIMESLOT_ID()+1);
			else
				 timeslot.setTIMESLOT_ID(1);
			filewriter.append(ts.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeslot;
		}
	
	public static TimeSlot DelOne(int TimeSlot_ID) {
		FileWriter fileWriter;
		List<TimeSlot> TimeSlot=findAll();
		TimeSlot time=TimeSlotData.findOne(TimeSlot_ID);
		
		try {
			fileWriter=new FileWriter(TimeSlotData.getCsvFile());
			
			for(int i=0;i<TimeSlot.size();i++) {
				if(TimeSlot.get(i).getTIMESLOT_ID()!=TimeSlot_ID) {
					fileWriter.append(TimeSlot.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		TimeSlot.add(time);
		fileWriter.flush();
		fileWriter.close();
		
		return time;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return time;
}
	public static List<TimeSlot> DelAll() {
		FileWriter filewriter;
		List<TimeSlot> slot=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<slot.size();i++) {
				slot.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return slot;
		
	}
}
