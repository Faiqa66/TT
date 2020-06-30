package edu.uog.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CourseData {

	private static String csvFile="C:\\TimeTable\\Course.csv";

	public static String getCsv() {
		return csvFile;
	}

	public void setCsv(String csv) {
		CourseData.csvFile = csv;
	}
	
	@SuppressWarnings("unused")
	public static List<Course> findAll(){
		List<Course> courses=new ArrayList<Course>();
		String line;
		Course prerequistcourse=new Course();
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(CourseData.csvFile));
		    Course prerequisitecourse;
			
			while((line = bufferReader.readLine())!=null) {
				Course course=new Course();
				
				String[] courseRow=line.split(",");
			
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE(courseRow[2]);
				course.setCOURSE_DESC(courseRow[3]);
				course.setCREDITHOUR(Integer.parseInt(courseRow[4]));
				
				if(courseRow.length>5) {
					course.setCOURSEPREREQUIST_ID(CourseData.findOne(Integer.parseInt(courseRow[5])));
				}
				courses.add(course);
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
		
		
	}

	@SuppressWarnings({ "resource", "unused" })
	public static Course findOne(int COURSE_ID) {
		List<Course> courses=new ArrayList<Course>();
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Course course=new Course();
			Course prerequistcourse=new Course();
			String[] courseRow=line.split(",");
			
			if (Integer.parseInt(courseRow[0]) == COURSE_ID) {
								
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE(courseRow[2]);
				course.setCOURSE_DESC(courseRow[3]);
				course.setCREDITHOUR(Integer.parseInt(courseRow[4]));
				
				if(courseRow.length>5) {
					course.setCOURSEPREREQUIST_ID(CourseData.findOne(Integer.parseInt(courseRow[5])));
				}
				courses.add(course);
				
				return course;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<Course> search(String search){
		List<Course> courses=new ArrayList<Course>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(CourseData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Course course=new Course();
			
			String [] courseRow=line.split(",");
			
			if(courseRow[1].contains(search)==true) {
			
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE(courseRow[2]);
		        course.setCOURSE_DESC(courseRow[3]);
				course.setCREDITHOUR(Integer.parseInt(courseRow[4]));
			    
				courses.add(course);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return courses;
	}
	
	public static Course Save(Course course) {
		FileWriter filewriter;
		
		List<Course> courses=findAll();
		
		try {
			filewriter=new FileWriter(CourseData.csvFile);
			
			for (int i=0; i<courses.size(); i++) {
				filewriter.append(courses.get(i).toString());
				filewriter.append("\n");
			}
			if (courses.size()>0)
				course.setCOURSE_ID(courses.get(courses.size()-1).getCOURSE_ID()+1);
			else
				course.setCOURSE_ID(1);
			filewriter.append(course.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return course;
		}
	
	public static Course DelOne(int Course_ID) {
		FileWriter fileWriter;
		List<Course> Course=findAll();
		Course course=CourseData.findOne(Course_ID);
		
		try {
			fileWriter=new FileWriter(CourseData.getCsv());
			
			for(int i=0;i<Course.size();i++) {
				if(Course.get(i).getCOURSE_ID()!=Course_ID) {
					fileWriter.append(Course.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		Course.add(course);
		fileWriter.flush();
		fileWriter.close();
		
		return course;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return course;
}
	public static List<Course> DelAll() {
		FileWriter filewriter;
		List<Course> course=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<course.size();i++) {
				course.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return course;
		
	}
	}

