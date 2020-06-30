package edu.uog.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.Course.Course;
import edu.uog.Course.CourseData;
import edu.uog.Student.StudentCourse;
import edu.uog.Student.StudentCourseData;

public class StudentCourseData {
	private static String csvFile="C:\\TimeTable\\StudentCourse.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		StudentCourseData.csvFile = csvFile;
	}
	
	@SuppressWarnings("unused")
	public static List<StudentCourse> findAll(){
		List<StudentCourse> stcourse=new ArrayList<StudentCourse>();
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		 
			while((line = bufferReader.readLine())!=null) {
				StudentCourse studcourse=new StudentCourse();
				Course course=new Course();
				Student student=new Student();
				
				
				String[] stcourseRow=line.split(",");
			    studcourse.setSTUDENTCOURSE_ID(stcourseRow[0]);
				studcourse.setCOURSE_ID(CourseData.findOne(Integer.parseInt(stcourseRow[1])));
				studcourse.setSTUDENT_ID(StudentData.findOne(Integer.parseInt(stcourseRow[2])));
				studcourse.setSECTION(stcourseRow[3]);
				
				stcourse.add(studcourse);
			
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stcourse;
		
	}
	
	@SuppressWarnings({ "resource", "unused" })
	public static StudentCourse findOne(int STUDENTCOURSE_ID) {
		List<StudentCourse> courses=new ArrayList<StudentCourse>();
		
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			StudentCourse stc=new StudentCourse();
			String[] sRow=line.split(",");
			Course course=new Course();
			Student student=new Student();
			
			
			if (Integer.parseInt(sRow[0]) == STUDENTCOURSE_ID) {
								
				stc.setSTUDENTCOURSE_ID(sRow[0]);
				stc.setCOURSE_ID(CourseData.findOne(Integer.parseInt(sRow[1])));
				stc.setSTUDENT_ID(StudentData.findOne(Integer.parseInt(sRow[2])));
				stc.setSECTION(sRow[3]);
				
				courses.add(stc);
				return stc;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<StudentCourse> search(String search){
		List<StudentCourse> stcourse=new ArrayList<StudentCourse>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			StudentCourse stc=new StudentCourse();
			String[] sRow=line.split(",");
			
			if(sRow[1].contains(search)==true) {
			    stc.setSTUDENTCOURSE_ID(sRow[0]);
				stc.setCOURSE_ID(CourseData.findOne(Integer.parseInt(sRow[1])));
				stc.setSTUDENT_ID(StudentData.findOne(Integer.parseInt(sRow[2])));
				stc.setSECTION(sRow[3]);
				
				stcourse.add(stc);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return stcourse;
	}
	
	public static StudentCourse Save(StudentCourse student) {
		FileWriter filewriter;
		
		List<StudentCourse> stc=StudentCourseData.findAll();
		
		try {
			filewriter=new FileWriter(StudentCourseData.csvFile);
			
			for (int i=0; i<stc.size(); i++) {
				filewriter.append(stc.get(i).toString());
				filewriter.append("\n");
			}
			if (stc.size()>0)
				student.setSTUDENTCOURSE_ID(stc.get(stc.size()-1).getSTUDENTCOURSE_ID()+1);
			else
				 student.setSTUDENTCOURSE_ID("CS-103");
			filewriter.append(stc.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		
		}
	public static StudentCourse DelOne(int StudentCourse_ID) {
		FileWriter fileWriter;
		List<StudentCourse> Student=findAll();
		StudentCourse student=StudentCourseData.findOne(StudentCourse_ID);
		
		try {
			fileWriter=new FileWriter(StudentCourseData.getCsvFile());
			
			for(int i=0;i<Student.size();i++) {
				if(Student.get(i).getSTUDENTCOURSE_ID()!=(String.valueOf(StudentCourse_ID))) {
					fileWriter.append(Student.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
	   Student.add(student);
		fileWriter.flush();
		fileWriter.close();
		
		return student;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return student;
}
	public static List<StudentCourse> DelAll() {
		FileWriter filewriter;
		List<StudentCourse> SCourse=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<SCourse.size();i++) {
				SCourse.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SCourse;
		
	}
}
