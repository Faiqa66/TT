package edu.uog.Teacher;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.uog.Person.Person;
import edu.uog.Person.PersonData;


public class TeacherData {

	private static String csvFile="C:\\TimeTable\\Teacher.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		TeacherData.csvFile = csvFile;
	}
	
	public static List<Teacher> findAll(){
		List<Teacher> teacher=new ArrayList<Teacher>();
		
		String line;
		
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(TeacherData.csvFile));
			
			while((line = bufferReader.readLine())!=null) {
				Teacher tEacher=new Teacher();
				
				String[] teacherRow=line.split(",");
				
				tEacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
				
				tEacher.setTEACHER_NAME(teacherRow[1]);
				
				tEacher.setPERSON_ID(Integer.parseInt(teacherRow[2]));
				
				Person person=PersonData.findOne(Integer.parseInt(teacherRow[2]));
				
				tEacher.setADDRESS(person.getADDRESS());
				
				teacher.add(tEacher);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return teacher;
	}
	@SuppressWarnings("resource")
	public static Teacher findOne(int TEACHER_ID) {
		
		List<Teacher> teachers=new ArrayList<Teacher>();
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Teacher teacher=new Teacher();
			String[] tRow=line.split(",");
			
			if (Integer.parseInt(tRow[0]) == TEACHER_ID) {
								
				teacher.setTEACHER_ID(Integer.parseInt(tRow[0]));
				
				teacher.setTEACHER_NAME(tRow[1]);
				
                teacher.setPERSON_ID(Integer.parseInt(tRow[2]));
				
				Person person=PersonData.findOne(Integer.parseInt(tRow[2]));
				
				teacher.setADDRESS(person.getADDRESS());
				
				teachers.add(teacher);
				
				return teacher;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<Teacher> search(String search){
		List<Teacher> teacher=new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(TeacherData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Teacher tc=new Teacher();
			
			String [] tRow=line.split(",");
			
			
			if(tRow[1].contains(search)==true) {
			
				tc.setTEACHER_ID(Integer.parseInt(tRow[0]));
				
				tc.setTEACHER_NAME(tRow[1]);
			
                tc.setPERSON_ID(Integer.parseInt(tRow[2]));
				
				Person person=PersonData.findOne(Integer.parseInt(tRow[2]));
				
				tc.setADDRESS(person.getADDRESS());
				
			   teacher.add(tc);
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return teacher;
	}
	
	public static Teacher Save(Teacher teacher) {
		FileWriter filewriter;
		
		List<Teacher> tc=findAll();
		
		try {
			filewriter=new FileWriter(TeacherData.csvFile);
			
			for (int i=0; i<tc.size(); i++) {
				filewriter.append(tc.get(i).toString());
				filewriter.append("\n");
			}
			if (tc.size()>0)
				teacher.setTEACHER_ID(tc.get(tc.size()-1).getTEACHER_ID()+1);
			else
				 teacher.setTEACHER_ID(1);
			filewriter.append(tc.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return teacher;
		}
	public static Teacher DelOne(int Teacher_ID) {
		FileWriter fileWriter;
		List<Teacher> Teacher=findAll();
		Teacher teacher=TeacherData.findOne(Teacher_ID);
		
		try {
			fileWriter=new FileWriter(TeacherData.getCsvFile());
			
			for(int i=0;i<Teacher.size();i++) {
				if(Teacher.get(i).getTEACHER_ID()!=Teacher_ID) {
					fileWriter.append(Teacher.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		Teacher.add(teacher);
		fileWriter.flush();
		fileWriter.close();
		
		return teacher;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return teacher;
}
	public static List<Teacher> DelAll() {
		FileWriter filewriter;
		List<Teacher> teacher=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<teacher.size();i++) {
				teacher.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return teacher;
		
	}
}
