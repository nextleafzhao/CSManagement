package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
/**
 * 排课信息的条件查询
 * @author SPL
 *
 */
@Controller("xkSchByConAction")
@Scope("prototype")
public class xkSchByConAction extends ActionSupport{
	@Resource(name="xkservices")
	private xkServices xkservices;
	private String college;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
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
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	private String major;
	private String grade;
	private String classroom;
	private String classInfo;
	private String courseName;
	private int flag=1;
	private String message1;
	private String courseTeacher;
	@Action(value = "Schedule_findByCondition", results = {
			@Result(name = "findByCondition", location = "/tables.jsp") ,
			@Result(name = "error", type = "redirectAction", location = "Schedule_findByCondition.action?message1=1")	
	})
	public String findByCondition() {
		System.out.println("sdsdsdssssssssssssssss");
		List<Schedule> result = xkservices.getSchlistBySomething(college,major,grade,classroom,classInfo,courseName,courseTeacher);
		if(result.isEmpty()){
			setMessage1("未找到符合条件的记录！");
			
			return "error";
		}
		
		else{
			
			List<Schedule> list = new ArrayList<Schedule>();
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
			 }
		ActionContext.getContext().getSession().put("slist", list);}
		List<College> list1 = xkservices.getColl();
		System.out.println("1");
		ActionContext.getContext().getSession().put("clist", list1);
		List<ClassInfo> list3 = xkservices.getClInfo();
		System.out.println("2");
		ActionContext.getContext().getSession().put("cllist", list3);
		List<Teacher> list4=xkservices.getTea();
		System.out.println("3");
		ActionContext.getContext().getSession().put("tealist", list4);		
		return "findByCondition";
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}


}
