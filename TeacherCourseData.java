package edu.uog.Teacher;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.uog.Course.CourseData;

public class TeacherCourseData {

	private static String csvFile="C:\\TimeTable\\TeacherCourse.csv";

	public static String getCsv() {
		return csvFile;
	}

	public void setCsv(String csv) {
		TeacherCourseData.csvFile = csv;
	}
	
	
	public static List<TeacherCourse> findAll(){
		List<TeacherCourse> teachercourse=new ArrayList<TeacherCourse>();
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(TeacherCourseData.csvFile));
		 
			while((line = bufferReader.readLine())!=null) {
				TeacherCourse tcourse=new TeacherCourse();
				
				String[] tRow=line.split(",");
			
				tcourse.setTEACHERCOURSE_ID(Integer.parseInt(tRow[0]));
				tcourse.setSECTION(tRow[1]);
				tcourse.setTEACHER_ID(TeacherData.findOne(Integer.parseInt(tRow[2])));
				tcourse.setCOURSE_ID(CourseData.findOne(Integer.parseInt(tRow[3])));
				
				
				teachercourse.add(tcourse);
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teachercourse;
		
	}

	@SuppressWarnings("resource")
	public static TeacherCourse findOne(int TEACHERCOURSE_ID) {
		List<TeacherCourse> courses=new ArrayList<TeacherCourse>();
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			TeacherCourse teachercourse=new TeacherCourse();
			String[] tRow=line.split(",");
			
			if (Integer.parseInt(tRow[0]) == TEACHERCOURSE_ID) {
				
				teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(tRow[0]));
				teachercourse.setSECTION(tRow[1]);
				teachercourse.setTEACHER_ID(TeacherData.findOne(Integer.parseInt(tRow[2])));
				teachercourse.setCOURSE_ID(CourseData.findOne(Integer.parseInt(tRow[3])));
				
				courses.add(teachercourse);
				return teachercourse;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<TeacherCourse> search(String search){
		List<TeacherCourse> Teachercourse=new ArrayList<TeacherCourse>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(TeacherCourseData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			TeacherCourse tcourse=new TeacherCourse();
			
			String [] tRow=line.split(",");
			
			if(tRow[1].contains(search)==true) {
			
				tcourse.setTEACHERCOURSE_ID(Integer.parseInt(tRow[0]));
				tcourse.setSECTION(tRow[1]);
				tcourse.setTEACHER_ID(TeacherData.findOne(Integer.parseInt(tRow[2])));
				tcourse.setCOURSE_ID(CourseData.findOne(Integer.parseInt(tRow[3])));
				
				Teachercourse.add(tcourse);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return Teachercourse;
	}
	
	public static TeacherCourse Save(TeacherCourse tcourse) {
		FileWriter filewriter;
		
		List<TeacherCourse> Teachercourse=findAll();
		
		try {
			filewriter=new FileWriter(TeacherCourseData.csvFile);
			
			for (int i=0; i<Teachercourse.size(); i++) {
				filewriter.append(Teachercourse.get(i).toString());
				filewriter.append("\n");
			}
			if (Teachercourse.size()>0)
				tcourse.setTEACHERCOURSE_ID(Teachercourse.get(Teachercourse.size()-1).getTEACHERCOURSE_ID()+1);
			else
				tcourse.setTEACHERCOURSE_ID(1);
			filewriter.append(tcourse.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tcourse;
		}
	public static TeacherCourse DelOne(int TeacherCourse_ID) {
		FileWriter fileWriter;
		List<TeacherCourse> TeacherCourse=findAll();
		TeacherCourse teacherCourse=TeacherCourseData.findOne(TeacherCourse_ID);
		
		try {
			fileWriter=new FileWriter(TeacherCourseData.getCsv());
			
			for(int i=0;i<TeacherCourse.size();i++) {
				if(TeacherCourse.get(i).getTEACHERCOURSE_ID()!=TeacherCourse_ID) {
					fileWriter.append(TeacherCourse.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		TeacherCourse.add(teacherCourse);
		fileWriter.flush();
		fileWriter.close();
		
		return teacherCourse;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return teacherCourse;
}
	public static List<TeacherCourse> DelAll() {
		FileWriter filewriter;
		List<TeacherCourse> TCourse=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<TCourse.size();i++) {
				TCourse.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return TCourse;
		
	}
	
	}

