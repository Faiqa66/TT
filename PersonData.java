package edu.uog.Person;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class PersonData {

	private static String csvFile="C:\\TimeTable\\Person.csv";

	public static String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		PersonData.csvFile = csvFile;
	}
	
	public static List<Person> findAll(){
		List<Person> person=new ArrayList<Person>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader buferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line = buferReader.readLine())!=null) {
				Person prson=new Person();
				
				String[] prRow=line.split(",");
				
				prson.setPERSON_ID(Integer.parseInt(prRow[0]));
				prson.setFORE_NAME(prRow[1]);
				prson.setSUR_NAME(prRow[2]);
				prson.setAGE(Integer.parseInt(prRow[3]));
				prson.setGENDER(prRow[4]);
				prson.setADDRESS(prRow[5]);
				prson.setTITLE(prRow[6]);
				
			person.add(prson);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return person;
	}
	
	@SuppressWarnings("resource")
	public static Person findOne(int PERSON_ID) {
		List<Person> persons=new ArrayList<Person>();
		String line;
		try {
			
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
		    
			while((line=bufferReader.readLine())!=null) {
			
			Person person=new Person();
			String[] pRow=line.split(",");
			
			if (Integer.parseInt(pRow[0]) == PERSON_ID) {
								
				person.setPERSON_ID(Integer.parseInt(pRow[0]));
				person.setFORE_NAME(pRow[1]);
				person.setSUR_NAME(pRow[2]);
				person.setAGE(Integer.parseInt(pRow[3]));
				person.setGENDER(pRow[4]);
				person.setADDRESS(pRow[5]);
				person.setTITLE(pRow[6]);
				
				persons.add(person);
				return person;
			}
				
				
			}
			
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static List<Person> search(String search){
		List<Person> person=new ArrayList<Person>();
		String line;
		
		try {
			BufferedReader bufferReader=new BufferedReader(new FileReader(csvFile));
			
			while((line=bufferReader.readLine())!=null) {
			Person pr=new Person();
			
			String[] pRow=line.split(",");
						
			if(pRow[1].contains(search)==true) {
			
				pr.setPERSON_ID(Integer.parseInt(pRow[0]));
				pr.setFORE_NAME(pRow[1]);
				pr.setSUR_NAME(pRow[2]);
				pr.setADDRESS(pRow[3]);
				pr.setGENDER(pRow[4]);
				pr.setTITLE(pRow[5]);
				pr.setAGE(Integer.parseInt(pRow[6]));
				
				person.add(pr);
				
		}
	}
			}catch(IOException e) {
				e.printStackTrace();
			}
			   return person;
	}
	
	public static Person Save(Person person) {
		FileWriter filewriter;
		
		List<Person> pr=PersonData.findAll();
		
		try {
			filewriter=new FileWriter(PersonData.csvFile);
			
			for (int i=0; i<pr.size(); i++) {
				filewriter.append(pr.get(i).toString());
				filewriter.append("\n");
			}
			if (pr.size()>0)
				person.setPERSON_ID(pr.get(pr.size()-1).getPERSON_ID()+1);
			else
				 person.setPERSON_ID(1);
			filewriter.append(pr.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;	
		

		}
	
	public static Person DelOne(int Person_ID) {
		FileWriter fileWriter;
		List<Person> Person=findAll();
		Person person=PersonData.findOne(Person_ID);
		
		try {
			fileWriter=new FileWriter(PersonData.getCsvFile());
			
			for(int i=0;i<Person.size();i++) {
				if(Person.get(i).getPERSON_ID()!=Person_ID) {
					fileWriter.append(Person.get(i).toString());
					fileWriter.append("\n");
				}
		}
		
		Person.add(person);
		fileWriter.flush();
		fileWriter.close();
		
		return person;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return person;
}
	public static List<Person> DelAll() {
		FileWriter filewriter;
		List<Person> person=findAll();
		try {
			filewriter=new FileWriter(csvFile);
			for(int i=0;i<person.size();i++) {
				person.remove(i);
			}
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return person;
		
	}
	
}
