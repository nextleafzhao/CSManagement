package com.xk.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xk.dao.xkDao;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Major;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
@Service("xkservices")
public class xkServices {
	//给Services注入数据源
	@Resource(name="xkdao")
	private xkDao xkdao;
	//查询全部排课信息
	public List<Schedule> getSchlist() {
		return xkdao.getSchlist();
	};
	//获取全部课程信息
	public List<Course> getCourlist(){
		return xkdao.getCourlist();
	}
	//删除排课信息
	public void deleteSch(int id) {
		xkdao.deleteSch(id);
	}
	//条件查询排课信息
	public List<Schedule> getSchlistByCon(int grade) {
		return xkdao.getSchlistByCon(grade);
	}
	//新增排课信息
	public void save(Schedule s) {
		xkdao.save(s);
	}
	//获取单个排课信息
	public Schedule getSingleSch(int id) {
		return xkdao.getSingleSch(id);
	}
	//更新排课信息
	public void updateSch(Schedule s) {
		xkdao.updateSch(s);
	}
	//获取全部学院信息
	public List<College> getColl() {
		return xkdao.getColl();
	}
	//获取专业信息
	public List<Major> getMaj(int id) {
		return xkdao.getMaj(id);
	}
	//获取课程信息
	public List<Course> getCour(int id){
		return xkdao.getCour(id);
	}
	//查询班级基本信息
	public List<ClassInfo> getClInfo() {
		return xkdao.getClInfo();
	}
	//获取全部老师信息
	public List<Teacher> getTea(){
		return xkdao.getTea();
	}
	//查询单个班级基本信息
	public ClassInfo getSingleClass(int id){
		return xkdao.getSingleClass(id);
	}
	//更新班级基本信息
	public void upClassInfo(ClassInfo c){
		xkdao.upClassInfo(c);
	}
	//检查上课时间是否冲突
	public List<Schedule> checkSchooltime(String schooltime){
		return xkdao.checkSchooltime(schooltime);
	}
	//按ID查询排课信息
	public List<Schedule> getSchByID(int id){
		return xkdao.getSchByID(id);
	}
	//查询课程信息
	public List<Course> getCouByID(int id){
		return xkdao.getCouByID(id);
	}
	//查询班级基本信息
	public List<ClassInfo> getClassByID(int id){
		return xkdao.getClassByID(id);
	}
	//条件查询排课信息
	public List<Schedule> getSchlistBySomething(String college,String major,String grade,String classroom,String classInfo,String courseName,String courseTeacher) {
		return xkdao.getSchlistBySomething(college,major,grade,classroom,classInfo,courseName,courseTeacher);
	}
	//条件查询课程信息
	public List<Course> getCourBySomething(String college,String major,String coursename,String courseTye,String credit){
		return xkdao.getCourBySomething(college,major,coursename,courseTye,credit);
	}
	//条件查询班级基本信息
	public List<ClassInfo> getClassBySomething(String college,String major,String grade,String studyDirection,String teacher){
		return xkdao.getClassBySomething(college,major,grade,studyDirection,teacher);
	}
}