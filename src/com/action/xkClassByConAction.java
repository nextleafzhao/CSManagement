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
import com.xk.services.xkServices;
/**
 * 条件查询班级基本信息
 * @author SPL
 *
 */
@Controller("xkClassByConAction")
@Scope("prototype")
public class xkClassByConAction extends ActionSupport{
	@Resource(name="xkservices")
	private xkServices xkservices;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
	private String college;
	private String major;
	private String grade;
	private String message1;
	private String studyDirection;
	private String teacher;
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
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
	public String getStudyDirection() {
		return studyDirection;
	}
	public void setStudyDirection(String studyDirection) {
		this.studyDirection = studyDirection;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Action(value = "ClassInfo_findByCondition", results = {
			@Result(name = "findByCondition", location = "/AllClassInfo.jsp"),
			@Result(name = "error", type = "redirectAction", location = "ClassInfo_findByCondition.action?message1=1" )})
	public String findByCondition() {
		List<ClassInfo> result = xkservices.getClassBySomething(college, major, grade, studyDirection, teacher);
		if(result.isEmpty()){
			setMessage1("未找到符合条件的记录！");
			return "error";
		}
		else{
			List<ClassInfo> list = new ArrayList<ClassInfo>();
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
			ActionContext.getContext().getSession().put("clalist", list);
			}
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "findByCondition";
	}
}
