package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xk.entity.ClassInfo;
import com.xk.entity.Schedule;
import com.xk.services.xkServices;
/**
 * 检查上课时间是否冲突
 * @author SPL
 *
 */
@ParentPackage("json-default")
@Controller("xkCheckSchtimeAction")
@Scope("prototype")
public class xkCheckSchtimeAction{
	//注入数据源
	@Resource(name="xkservices")
	private xkServices xkservices;
	private List<Schedule> list;
	private String error;
	private String schooltime;
	public String getSchooltime() {
		return schooltime;
	}
	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}
	public List<Schedule> getList() {
		return list;
	}
	public void setList(List<Schedule> list) {
		this.list = list;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Action(value = "Schedule_checkSchtime", results = { @Result(name = "checkEnd", type = "json", params = {
			"root", "error" }) })
	public String ClassInfofindAll() {
		System.out.println(schooltime);
		String aa=schooltime.replaceAll("T", " ");
		setList(xkservices.checkSchooltime(aa));
		if(!list.isEmpty()){
			error="error";
		}
		return "checkEnd";
	}
}
