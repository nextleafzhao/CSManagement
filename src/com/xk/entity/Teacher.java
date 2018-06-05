package com.xk.entity;

import java.io.Serializable;


public class Teacher implements Serializable{
	private int id;
	private String teaname;
	private int teasex;
	private String teabirthday;
	private int collegeid;
	private String teatel;
	private String teapassword;
	//private Set<Schedule> schedules=new HashSet<Schedule>();
	//private Set<Course> course=new HashSet<Course>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public int getTeasex() {
		return teasex;
	}
	public void setTeasex(int teasex) {
		this.teasex = teasex;
	}
	public String getTeabirthday() {
		return teabirthday;
	}
	public void setTeabirthday(String teabirthday) {
		this.teabirthday = teabirthday;
	}
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getTeatel() {
		return teatel;
	}
	public void setTeatel(String teatel) {
		this.teatel = teatel;
	}
	public String getTeapassword() {
		return teapassword;
	}
	public void setTeapassword(String teapassword) {
		this.teapassword = teapassword;
	}
}
