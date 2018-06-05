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
import com.xk.services.xkServices;
/**
 * 课程信息的查询
 * @author SPL
 *
 */
@Controller("xkCourseAction")
@Scope("prototype")
public class xkCourseAction extends ActionSupport{
	@Resource(name="xkservices")
	private xkServices xkservices;
	private String message;
	private String courseId;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
	private String college;
	private String major;
	private String coursename;
	private String coursetype;
	private String credit;
	private String message2;
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
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
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
	@Action(value = "Course_findAll", results = { @Result(name = "findAll", location = "/AllCourse.jsp") })
	public String ClassInfofindAll() {
		List<Course> list=xkservices.getCourlist();
		ActionContext.getContext().getSession().put("coulist", list);
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "findAll";
	}
	@Action(value = "Course_findByID", results = { @Result(name = "success", location = "/AllCourse.jsp") })
	public String courByID() {
		courseId=courseId.replaceAll(" +", "");
		List<Course> coulist=xkservices.getCouByID(Integer.parseInt(courseId));
		if(coulist.isEmpty()){
			System.out.println("iddddddddddddddddddd");
			setMessage("该课程编号不存在！");
			List<Course> result = xkservices.getCourBySomething(college, major, coursename, coursetype,credit);
			
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
				   coulist.add(result.get(i));
			   }
			 }
			ActionContext.getContext().getSession().put("coulist", coulist);
			
			
			
			
		}else{
			setMessage2("1");
			ActionContext.getContext().getSession().put("coulist", coulist);
		}
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "success";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
