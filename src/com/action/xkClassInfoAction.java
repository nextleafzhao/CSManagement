package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.services.xkServices;
/**
 * 班级基本信息的查询
 * @author SPL
 *
 */
@Controller("xkClassInfoAction")
@Scope("prototype")
public class xkClassInfoAction {
	@Resource(name="xkservices")
	private xkServices xkservices;
	private String message;
	private String classinfoId;
	private String college;
	private String major;
	private String grade;
	private String studyDirection;
	private String teacher;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
	private String message2;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClassinfoId() {
		return classinfoId;
	}
	public void setClassinfoId(String classinfoId) {
		this.classinfoId = classinfoId;
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
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	@Action(value = "ClassInfo_findAll", results = { @Result(name = "findAll", location = "/AllClassInfo.jsp") })
	public String ClassInfofindAll() {
		List<ClassInfo> list=xkservices.getClInfo();
		ActionContext.getContext().getSession().put("clalist", list);
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "findAll";
	}
	@Action(value = "ClassInfo_findByID", results = { @Result(name = "success", location = "/AllClassInfo.jsp") })
	public String courByID() {
		System.out.println("zxxxxxxxxxxx");
		classinfoId=classinfoId.replaceAll(" +", "");
		List<ClassInfo> clalist=xkservices.getClassByID(Integer.parseInt(classinfoId));
		if(clalist.isEmpty()){
			System.out.println("iddddddddddddddddddd");
			setMessage("该班级编号不存在！");
			List<ClassInfo> result = xkservices.getClassBySomething(college, major, grade, studyDirection, teacher);
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
					   clalist.add(result.get(i));
				   }
				 }
				ActionContext.getContext().getSession().put("clalist", clalist);
		}else{
			setMessage2("1");
		ActionContext.getContext().getSession().put("clalist", clalist);}
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		return "success";
	}
}
