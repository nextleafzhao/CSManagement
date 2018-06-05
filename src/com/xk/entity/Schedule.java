package com.xk.entity;

import java.io.Serializable;

public class Schedule implements Serializable{
	private int id;
	private String campus;
	private String classroom;
	private String schooltime;
	private String collegeName;
	//private int teaid;
	/*private int courseid;*/
	/*private int classid;*/
	/*private int majorid;*/
	private ClassInfo classinfo;
    private Course course;
    private Teacher teacher;
    private Major major;
/*	public int getArrtabid() {
		return arrtabid;
	}

	public void setArrtabid(int arrtabid) {
		this.arrtabid = arrtabid;
	}*/

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getSchooltime() {
		return schooltime;
	}

	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}

	/*public int getTeaid() {
		return teaid;
	}

	public void setTeaid(int teaid) {
		this.teaid = teaid;
	}*/

	/*public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}*/

	/*public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}*/

	/*public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
*/
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public ClassInfo getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(ClassInfo classinfo) {
		this.classinfo = classinfo;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
