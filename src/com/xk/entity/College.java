package com.xk.entity;

import java.io.Serializable;

public class College implements Serializable {
	private int collegeid;
	private String collegename;
	private String createtime;
	private String deanname;
	private String collegeemail;
	private String collegetel;
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDeanname() {
		return deanname;
	}
	public void setDeanname(String deanname) {
		this.deanname = deanname;
	}
	public String getCollegeemail() {
		return collegeemail;
	}
	public void setCollegeemail(String collegeemail) {
		this.collegeemail = collegeemail;
	}
	public String getCollegetel() {
		return collegetel;
	}
	public void setCollegetel(String collegetel) {
		this.collegetel = collegetel;
	}
	
	
}
