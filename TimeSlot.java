package com.uog.timetable;

public class TimeSlot {
	
	private WeekDay WeekDay_ID;
	
	 private int TIMESLOT_ID;
	 
	 private String  TIMESLOT_START;
	 
	 private String  TIMESLOT_END;
	 
	public int  getTIMESLOT_ID() {
		return TIMESLOT_ID;
	}
	public void setTIMESLOT_ID(int tIMESLOT_ID) {
		TIMESLOT_ID = tIMESLOT_ID;
	}
	public CharSequence getTIMESLOT_START() {
		return TIMESLOT_START;
	}
	public void setTIMESLOT_START(String tIMESLOT_START) {
		TIMESLOT_START = tIMESLOT_START;
	}
	public String getTIMESLOT_END() {
		return TIMESLOT_END;
	}
	public void setTIMESLOT_END(String tIMESLOT_END) {
		TIMESLOT_END = tIMESLOT_END;
	}
	public WeekDay getWeekDay_ID() {
		return WeekDay_ID;
	}
	public void setWeekDay_ID(WeekDay weekDay_ID) {
		WeekDay_ID = weekDay_ID;
	}
	 
	public String toString() {
		String str=null;
		
		str=this.TIMESLOT_ID
				+ "," + this.WeekDay_ID
				+ "," + this.TIMESLOT_START
				+ ","+this.TIMESLOT_END;
		
		return str;
	}
}
