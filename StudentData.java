package edu.uog.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.Person.Person;
import edu.uog.Person.PersonData;
import edu.uog.Student.Student;

public class StudentData {

	private static String csvFile="C:\\TimeTable\\Stdent.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		StudentData.csvFile = csvFile;
	}
	
	public static List<Student> findAll(){
		
		List<Student> student=new ArrayList<Student>();
		
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line = bufferReader.readLine())!=null) {
			Student sTudent=new Student();
			
			String[] studentRow=line.split(",");
			
			sTudent.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
			sTudent.setSTUDENT_ROLLNO(studentRow[1]);
			sTudent.setSTUDY_PROGRAM(studentRow[2]);
			sTudent.setSTUDY_YEAR(studentRow[3]);
			sTudent.setPERSON_ID(Integer.parseInt(studentRow[4]));
			Person person =PersonData.findOne(Integer.parseInt(studentRow[4]));
			sTudent.setFORE_NAME(person.getFORE_NAME());
			sTudent.setSUR_NAME(person.getSUR_NAME());
			sTudent.setGENDER(person.getGENDER());
			sTudent.setADDRESS(person.getADDRESS());
			
			student.add(sTudent);
		}
		
		}	catch(Exception e) {
			System.out.println(e);
		}	
		return student;
		
	}

	@SuppressWarnings("resource")
	public static Student findOne(int STUDENT_ID) {
		List<Student> students=new ArrayList<Student>();
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Student student=new Student();
			String[] sRow=line.split(",");
			
			if (Integer.parseInt(sRow[0]) == STUDENT_ID) {
								
				student.setSTUDENT_ID(Integer.parseInt(sRow[0]));
				student.setSTUDENT_ROLLNO(sRow[1]);
				student.setSTUDY_PROGRAM(sRow[2]);
				student.setSTUDY_YEAR(sRow[3]);
				student.setPERSON_ID(Integer.parseInt(sRow[4]));
				Person person =PersonData.findOne(Integer.parseInt(sRow[4]));
				student.setFORE_NAME(person.getFORE_NAME());
				student.setSUR_NAME(person.getSUR_NAME());
				student.setGENDER(person.getGENDER());
				student.setADDRESS(person.getADDRESS());
				
				students.add(student);
				return student;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static List<Student> search(String search){
		List<Student> student=new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(StudentData.csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Student st=new Student();
			
			String [] sRow=line.split(",");
			
			if(sRow[1].contains(search)==true) {
			
				st.setSTUDENT_ID(Integer.parseInt(sRow[0]));
				st.setSTUDENT_ROLLNO(sRow[1]);
				st.setSTUDY_PROGRAM(sRow[2]);
				st.setSTUDY_YEAR(sRow[3]);
				st.setPERSON_ID(Integer.parseInt(sRow[4]));
				Person person =PersonData.findOne(Integer.parseInt(sRow[4]));
				st.setFORE_NAME(person.getFORE_NAME());
				st.setSUR_NAME(person.getSUR_NAME());
				st.setGENDER(person.getGENDER());
				st.setADDRESS(person.getADDRESS());
				
				
				student.add(st);
				
			}
			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return student;
	}
	
	public static Student Save(Student student) {
		FileWriter filewriter;
		
		List<Student> st=findAll();
		
		try {
			filewriter=new FileWriter(StudentData.csvFile);
			
			for (int i=0; i<st.size(); i++) {
				filewriter.append(st.get(i).toString());
				filewriter.append("\n");
			}
			if (st.size()>0)
				student.setSTUDENT_ID(st.get(st.size()-1).getSTUDENT_ID()+1);
			else
				 student.setSTUDENT_ID(1);
			filewriter.append(st.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		}
	
	public static Student DelOne(int Student_ID) {
		FileWriter fileWriter;
		List<Student> Student=findAll();
		Student student=StudentData.findOne(Student_ID);
		
		try {
			fileWriter=new FileWriter(StudentData.getCsvFile());
			
			for(int i=0;i<Student.size();i++) {
				if(Student.get(i).getSTUDENT_ID()!=Student_ID) {
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
	public static List<Student> DelAll() {
		FileWriter filewriter;
		List<Student> student=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<student.size();i++) {
				student.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return student;
		
	}
}
