package com.uog.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeekDayData {
	private static String csvFile="C:\\TimeTable\\Weekday.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		WeekDayData.csvFile = csvFile;
	}
	
	public static List<WeekDay> findAll(){
		List<WeekDay> weekDay=new ArrayList<WeekDay>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader buferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line = buferReader.readLine())!=null) {
				WeekDay wk=new WeekDay();
				
				String[] wkRow=line.split(",");
				
				wk.setWEEKDAY_ID(Integer.parseInt(wkRow[0]));
				wk.setWEEKDAY_NAME(wkRow[1]);
		
              weekDay.add(wk);			
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
		return weekDay;
		
	}
	
@SuppressWarnings("resource")
public static WeekDay findOne(int WEEkDAY_ID) {
		List<WeekDay> weeks=new ArrayList<WeekDay>();
	
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			WeekDay wkd=new WeekDay();
			String[] wRow=line.split(",");
			
			if (Integer.parseInt(wRow[0]) == WEEkDAY_ID) {
								
				wkd.setWEEKDAY_ID(Integer.parseInt(wRow[0]));
				wkd.setWEEKDAY_NAME(wRow[1]);
				
				weeks.add(wkd);
				
				return wkd;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static List<WeekDay> search(String search){
		List<WeekDay> weekDay=new ArrayList<WeekDay>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			WeekDay wkd=new WeekDay();
			
			String[] wRow=line.split(",");
			
			if(wRow[1].contains(search)==true) {
			   wkd.setWEEKDAY_ID(Integer.parseInt(wRow[0]));
			   wkd.setWEEKDAY_NAME(wRow[1]);
				
			   weekDay.add(wkd);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return weekDay;
	}
	
	public static WeekDay Save(WeekDay weekday) {
		FileWriter filewriter;
		
		List<WeekDay> wkd=WeekDayData.findAll();
		
		try {
			filewriter=new FileWriter(WeekDayData.csvFile);
			
			for (int i=0; i<wkd.size(); i++) {
				filewriter.append(wkd.get(i).toString());
				filewriter.append("\n");
			}
			if (wkd.size()>0)
				weekday.setWEEKDAY_ID(wkd.get(wkd.size()-1).getWEEKDAY_ID()+1);
			else
				 weekday.setWEEKDAY_ID(1);
			filewriter.append(wkd.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weekday;
		
		}
	public static WeekDay DelOne(int Weekday_ID) {
		FileWriter fileWriter;
		List<WeekDay> weekday=findAll();
		WeekDay week=WeekDayData.findOne(Weekday_ID);
		
		try {
			fileWriter=new FileWriter(WeekDayData.getCsvFile());
			
			for(int i=0;i<weekday.size();i++) {
				if(weekday.get(i).getWEEKDAY_ID()!=Weekday_ID) {
					fileWriter.append(weekday.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		weekday.add(week);
		fileWriter.flush();
		fileWriter.close();
		
		return week;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return week;
}
	public static List<WeekDay> DelAll() {
		FileWriter filewriter;
		List<WeekDay> week=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<week.size();i++) {
				week.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return week;
		
	}
}
