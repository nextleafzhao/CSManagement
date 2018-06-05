package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
/**
 * 条件查询课程信息
 * @author SPL
 *
 */
@Controller("xkCourByConAction")
@Scope("prototype")
public class xkCourByConAction extends ActionSupport{
	@Resource(name="xkservices")
	private xkServices xkservices;
	private String college;
	private String major;
	private String coursename;
	private String coursetype;
	private String credit;
	private String message1;
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
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Action(value = "Course_findByCondition", results = {
			@Result(name = "findByCondition", location = "/AllCourse.jsp")
			,
			@Result(name = "error", type = "redirectAction", location = "Course_findByCondition.action?message1=1"	)	
	
	
	})
	public String findByCondition() {
		List<Course> result = xkservices.getCourBySomething(college, major, coursename, coursetype,credit);
		if(result.isEmpty()){
			System.out.println("message3=============");
			message1="未找到符合条件的记录!";
			System.out.println(message1);
			return "error";
		}
		else{
			List<Course> list = new ArrayList<Course>();
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
			ActionContext.getContext().getSession().put("coulist", list);}
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "findByCondition";
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	
}
