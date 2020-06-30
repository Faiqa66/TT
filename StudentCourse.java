package edu.uog.Student;

import edu.uog.Course.Course;

public class StudentCourse {

	private String STUDENTCOURSE_ID;
	
	private Course COURSE_ID;
	
	private Student STUDENT_ID;
	
	private String SECTION;
	
	
	public String getSTUDENTCOURSE_ID() {
	
		return STUDENTCOURSE_ID;
	}
	 public void setSTUDENTCOURSE_ID(String sTUDENTCOURSE_ID) {
		STUDENTCOURSE_ID = sTUDENTCOURSE_ID;
	}
	public Course getCOURSE_ID() {
		return COURSE_ID;
	}
	public void setCOURSE_ID(Course cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}
	public Student getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(Student sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getSECTION() {
		return SECTION;
	}
	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}
	public String toString() {
		String str=null;
		
		     str=this.STUDENTCOURSE_ID
				+ "," + this.COURSE_ID
				+ "," + this.STUDENT_ID
				+ "," + this.SECTION;
		
		return str;
	}
	
	
	
}
