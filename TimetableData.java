package com.uog.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.Campus.RoomData;
import edu.uog.Teacher.TeacherCourseData;


public class TimetableData {
	private static String csvFile="C:\\TimeTable\\Timetable.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		TimetableData.csvFile = csvFile;
	}
	
	public static List<Timetable> findAll(){
		List<Timetable> timeTable=new ArrayList<Timetable>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader buferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line = buferReader.readLine())!=null) {
				Timetable tt=new Timetable();
				String[] ttRow=line.split(",");
				
				tt.setTIMETABLE_ID(Integer.parseInt(ttRow[0]));
				tt.setTEACHERCOURSE_ID(TeacherCourseData.findOne(Integer.parseInt(ttRow[1])));
				tt.setTIMESLOT_ID(TimeSlotData.findOne(Integer.parseInt(ttRow[2])));
				tt.setROOM_ID(RoomData.findOne(Integer.parseInt(ttRow[3])));
		
			      timeTable.add(tt);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
		return timeTable;
		
	}
	@SuppressWarnings("resource")
	public static Timetable findOne(int TIMETABLE_ID) {
        List<Timetable> times=new ArrayList<Timetable>();		
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Timetable tt=new Timetable();
			String[] ttRow=line.split(",");
			
			if (Integer.parseInt(ttRow[0]) == TIMETABLE_ID) {
								
				tt.setTIMETABLE_ID(Integer.parseInt(ttRow[0]));
				tt.setROOM_ID(RoomData.findOne(Integer.parseInt(ttRow[1])));
				tt.setTEACHERCOURSE_ID(TeacherCourseData.findOne(Integer.parseInt(ttRow[2])));
				tt.setTIMESLOT_ID(TimeSlotData.findOne(Integer.parseInt(ttRow[3])));
			
				times.add(tt);
				
				return tt;
				
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<Timetable> search(String search){
		List<Timetable> timetable=new ArrayList<Timetable>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(TimetableData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Timetable tt=new Timetable();
			
			String [] ttRow=line.split(",");
			
			if(ttRow[1].contains(search)==true) {
			
				tt.setTIMETABLE_ID(Integer.parseInt(ttRow[0]));
				tt.setROOM_ID(RoomData.findOne(Integer.parseInt(ttRow[1])));
				tt.setTEACHERCOURSE_ID(TeacherCourseData.findOne(Integer.parseInt(ttRow[2])));
				tt.setTIMESLOT_ID(TimeSlotData.findOne(Integer.parseInt(ttRow[3])));
				
				timetable.add(tt);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return timetable;
	}
	
	public static Timetable Save(Timetable timetable) {
		FileWriter filewriter;
		
		List<Timetable> tt=findAll();
		
		try {
			filewriter=new FileWriter(TimetableData.csvFile);
			
			for (int i=0; i<tt.size(); i++) {
				filewriter.append(tt.get(i).toString());
				filewriter.append("\n");
			}
			if (tt.size()>0)
				timetable.setTIMETABLE_ID(tt.get(tt.size()-1).getTIMETABLE_ID()+1);
			else
				timetable.setTIMETABLE_ID(1);
			filewriter.append(tt.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return timetable;
		}
	public static Timetable DelOne(int TimeTable_ID) {
		FileWriter fileWriter;
		List<Timetable> TimeTable=findAll();
		Timetable time=TimetableData.findOne(TimeTable_ID);
		
		try {
			fileWriter=new FileWriter(TimetableData.getCsvFile());
			
			for(int i=0;i<TimeTable.size();i++) {
				if(TimeTable.get(i).getTIMETABLE_ID()!=TimeTable_ID) {
					fileWriter.append(TimeTable.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		TimeTable.add(time);
		fileWriter.flush();
		fileWriter.close();
		
		return time;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return time;
}
	public static List<Timetable> DelAll() {
		FileWriter filewriter;
		List<Timetable> time=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<time.size();i++) {
				time.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return time;
		
	}
}
