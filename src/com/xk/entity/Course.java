package com.xk.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable{
	private int id;
	private String coursename;
	private String coursetype;
	private int credit;
	/*private int collegeid;*/
	/*private int majorid;*/
	private Major major;
	private College college;
    //private Set<Schedule> schedules=new HashSet<Schedule>();
	//private Teacher teacher;

	/*public Set<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}*/

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}


	/*public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}*/

}
