package com.uog.timetable;

import edu.uog.Campus.Room;

import edu.uog.Teacher.TeacherCourse;

public class Timetable {
	
	private int TIMETABLE_ID;
	
    private TeacherCourse TEACHERCOURSE_ID;
    
    private TimeSlot TIMESLOT_ID;
    
    private Room ROOM_ID;
    
    public Room getROOM_ID() {
		return ROOM_ID;
	}

	public void setROOM_ID(Room room) {
		ROOM_ID = room;
	}
    
	public int getTIMETABLE_ID() {
		return TIMETABLE_ID;
	}
	public void setTIMETABLE_ID(int tIMETABLE_ID) {
		TIMETABLE_ID = tIMETABLE_ID;
	}
	public TeacherCourse getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}
	public void setTEACHERCOURSE_ID(TeacherCourse tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}
	public TimeSlot getTIMESLOT_ID() {
		return TIMESLOT_ID;
	}
	public void setTIMESLOT_ID(TimeSlot tIMESLOT_ID) {
		TIMESLOT_ID = tIMESLOT_ID;
	}
	public String toString() {
		String str=null;
		
		str=this.TIMETABLE_ID
				+ "," + this.TEACHERCOURSE_ID
				+ "," + this.TIMESLOT_ID
				+ "," + this.ROOM_ID;
		
		return str;
	}
	
}