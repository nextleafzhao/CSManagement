package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
/**
 * ∞¥≈≈øŒ±‡∫≈≤È—Ø
 * @author SPL
 *
 */
@Controller("xkScheByIDAction")
@Scope("prototype")
public class xkScheByIDAction {
	
	private String college;
	private String courseTeacher;
	private String major;
	private String grade;
	private String classroom;
	private String classInfo;
	private String courseName;
	private String schId;
	private String message;
	private String message2;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
	public String getSchId() {
		return schId;
	}
	public void setSchId(String schId) {
		this.schId = schId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Resource(name="xkservices")
	private xkServices xkservices;
	@Action(value = "Schedule_findByID", results = { @Result(name = "success", location = "/tables.jsp") })
	public String schByID() {
		schId=schId.replaceAll(" +", "");
		List<Schedule> list=xkservices.getSchByID(Integer.parseInt(schId));
		if(list.isEmpty()){
			System.out.println("iddddddddddddddddddd");
			message="∏√≈≈øŒ±‡∫≈≤ª¥Ê‘⁄£°";
			List<Schedule> result = xkservices.getSchlistBySomething(college,major,grade,classroom,classInfo,courseName,courseTeacher);
			  if(result != null && result.size() > 0){
			   int allCount = result.size();
			   totalPage = (allCount + pageSize-1) / pageSize;
			   if(page >= totalPage){
			    page = totalPage;
			   }
			   int start = (page-1) * pageSize;
			   int end = page * pageSize;
			   if(end >= allCount){
			    end = allCount;
			   }
			   for(int i = start; i < end; i ++){
				  list.add(result.get(i));
			   }
			 
			   ActionContext.getContext().getSession().put("slist", list);}
			   
		}else{
		setMessage2("1");
		ActionContext.getContext().getSession().put("slist", list);}
		List<College> list1 = xkservices.getColl();
		   ActionContext.getContext().getSession().put("clist", list1);
		   List<ClassInfo> list3 = xkservices.getClInfo();
		   ActionContext.getContext().getSession().put("cllist", list3);
		   List<Teacher> list4=xkservices.getTea();
		   ActionContext.getContext().getSession().put("tealist", list4);
		return "success";
	}
}
