package edu.uog.Teacher;

import edu.uog.Person.Person;

public class Teacher extends Person{
	private int TEACHER_ID;
	
	private String TEACHER_NAME;
	
    private int PERSON_ID;
    
	
	public int getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(int pERSON_ID) {
		PERSON_ID = pERSON_ID;
	}

	public String getTEACHER_NAME() {
		return TEACHER_NAME;
	}

	public void setTEACHER_NAME(String tEACHER_NAME) {
		TEACHER_NAME = tEACHER_NAME;
	}

	public int getTEACHER_ID() {
		return TEACHER_ID;
	}

	public void setTEACHER_ID(int tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}
	public String toString() {
		String str=null;
		
		str=this.TEACHER_ID
	   +","+ this.TEACHER_NAME
	   +","+ this.PERSON_ID
	   +","+ this.getADDRESS();
		
		return str;
	}
	
}
