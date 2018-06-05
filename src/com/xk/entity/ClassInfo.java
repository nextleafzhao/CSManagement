package com.xk.entity;

import java.io.Serializable;

public class ClassInfo implements Serializable{
	private int classid;
	private String classname;
	private int classnum;
	private String grade;
	/*private int teaid;*/
	/*private int majorid;*/
	private Major major;
	private String collegename;
    private String studydirection;
    private Teacher teacher;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getClassnum() {
		return classnum;
	}

	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

/*	public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}*/

	public String getStudydirection() {
		return studydirection;
	}

	public void setStudydirection(String studydirection) {
		this.studydirection = studydirection;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
