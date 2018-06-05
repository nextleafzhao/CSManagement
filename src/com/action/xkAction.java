package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xk.dao.xkDao;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Major;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
/**
 * 排课表的增删改查
 * @author SPL
 *
 */
@ParentPackage("json-default")
@Controller("xkAction")
@Scope("prototype")
public class xkAction extends ActionSupport {
	//注入数据源
	@Resource(name="xkservices")
	private xkServices xkservices;
	private int id;
	private String schId;
	private String majorId;
	private String teaId;
	private int page=1;
	private int pageSize=5;
	private int totalPage;
	private String classId;
	private List<Major> list2;
	private String college1;
	private String major1;
	private String grade;
	private String classInfo;
	private String grade1;
	private String schooltime;
	private String classroom;
	private String campus;
	private int collId;
	private int majorId1;
	private Schedule schedule;
	private String courseId;
	private List<Course> list4;
    private String incollege;
    private String inmajor;
    private String incourseId;
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
   
	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getSchooltime() {
		return schooltime;
	}

	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Major> getList2() {
		return list2;
	}

	public void setList2(List<Major> list2) {
		this.list2 = list2;
	}

	public int getCollId() {
		return collId;
	}

	public void setCollId(int collId) {
		this.collId = collId;
	}
	public List<Course> getList4() {
		return list4;
	}

	public void setList4(List<Course> list4) {
		this.list4 = list4;
	}

	public int getMajorId1() {
		return majorId1;
	}

	public void setMajorId1(int majorId1) {
		this.majorId1 = majorId1;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getCollege1() {
		return college1;
	}

	public void setCollege1(String college1) {
		this.college1 = college1;
	}

	public String getMajor1() {
		return major1;
	}

	public void setMajor1(String major1) {
		this.major1 = major1;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public String getGrade1() {
		return grade1;
	}

	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	public String getIncollege() {
		return incollege;
	}

	public void setIncollege(String incollege) {
		this.incollege = incollege;
	}

	public String getInmajor() {
		return inmajor;
	}

	public void setInmajor(String inmajor) {
		this.inmajor = inmajor;
	}

	public String getIncourseId() {
		return incourseId;
	}

	public void setIncourseId(String incourseId) {
		this.incourseId = incourseId;
	}
	//查询全部排课信息
	@Action(value = "Schedule_findAll", results = { @Result(name = "findAll", location = "/tables.jsp") })
	public String findAll() {
		//调用业务层查询方法
		List<Schedule> result = xkservices.getSchlist();
		//进行分页操作
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
		//保存排课信息
		ActionContext.getContext().getSession().put("slist", list);
		//保存学员信息
		List<College> list1 = xkservices.getColl();
		ActionContext.getContext().getSession().put("clist", list1);
		//保存班级基本信息
		List<ClassInfo> list3 = xkservices.getClInfo();
		ActionContext.getContext().getSession().put("cllist", list3);
		//保存教师信息
		List<Teacher> list4=xkservices.getTea();
		ActionContext.getContext().getSession().put("tealist", list4);
		return "findAll";
	}
	//排课信息的更新
	@Action(value = "Schedule_update", results = { @Result(name = "updateSch", type = "redirectAction", location = "Schedule_findAll.action") })
	public String updateSch() {
		//调用业务层获取单个排课信息
		Schedule s = xkservices.getSingleSch(Integer.parseInt(schId));
		ClassInfo c2=xkservices.getSingleClass(Integer.parseInt(classInfo));
		c2.setGrade(grade);
		xkservices.upClassInfo(c2);
		//修改课程
		Course c = new Course();
		c.setId(Integer.parseInt(courseId));
		s.setCourse(c);
		//修改班级
		ClassInfo c1 = new ClassInfo();
		c1.setClassid(Integer.parseInt(classInfo));
		//修改年级
		c1.setGrade(grade);
		s.setClassinfo(c1);
		//修改上课地点
		s.setClassroom(classroom);
		//修改上课时间
		String aa=schooltime.replaceAll("T", " ");
		s.setSchooltime(aa);
		//s.setSchooltime(schooltime);// 上课时间
		//修改专业
		Major m = new Major();
		m.setMajorid(Integer.parseInt(major1));
		s.setMajor(m);
		//修改授课老师
		Teacher t = new Teacher();
		t.setId(Integer.parseInt(teaId));
		s.setTeacher(t);
		//调用业务层更新方法
		xkservices.updateSch(s);
		return "updateSch";
	}
	//查询全部专业
	@Action(value = "Major_findAll", results = { @Result(name = "findAll", type = "json", params = {
			"root", "list2" }) })
	public String majorfindAll() {
		list2 = xkservices.getMaj(collId);
		return "findAll";
	}
	//查询专业对应的课程
	@Action(value = "Course_findByMajor", results = { @Result(name = "findByMajor", type = "json", params = {
			"root", "list4" }) })
	public String findByMajor() {
		list4 = xkservices.getCour(majorId1);
		return "findByMajor";
	}
	//删除排课信息
	@Action(value = "Schedule_delete", results = { @Result(name = "deleteSch", type = "redirectAction", location = "Schedule_findAll.action") })
	public String deleteSch() {
		System.out.println(id);
		xkservices.deleteSch(id);
		return "deleteSch";
	}
	//批量删除
	@Action(value = "Schedule_deleteAll", results = { @Result(name = "deleteSchAll", type = "json") })
	public String deleteSchAll() {
		xkservices.deleteSch(id);
		return "deleteSchAll";
	}

	/*@Action(value = "Schedule_findByCondition", results = {
			@Result(name = "findByCondition", location = "/tables.jsp") })
			public String findByCondition() {
//				System.out.println("ssss");
//				System.out.println(college);
//				System.out.println(major);
//				System.out.println(grade);
//				System.out.println(classroom);
//				System.out.println(classInfo);
//				System.out.println(courseName);
//				System.out.println(courseTeacher);
				//List<Schedule> list = xkservices.getSchlistByCon(college,major,grade,classroom,classInfo,courseName,courseTeacher);
				List<Schedule> list = xkservices.getSchlistBySomething(college,major,grade,classroom,classInfo,courseName,courseTeacher);
				ActionContext.getContext().getSession().put("slist", list);
				List<College> list1 = xkservices.getColl();
				ActionContext.getContext().getSession().put("clist", list1);
				List<ClassInfo> list3 = xkservices.getClInfo();
				ActionContext.getContext().getSession().put("cllist", list3);
				List<Teacher> list4=xkservices.getTea();
				ActionContext.getContext().getSession().put("tealist", list4);				
				return "findByCondition";
			}
*/
	//添加排课信息
	@Action(value = "Schedule_save", results = { @Result(name = "save", type = "redirectAction", location = "Schedule_findAll.action") })
	public String save() {
		Schedule s=new Schedule();
		Course c = new Course();
		c.setId(Integer.parseInt(incourseId));// 课程名
		s.setCourse(c);
		ClassInfo c1 = new ClassInfo();// 班级
		c1.setClassid(Integer.parseInt(classInfo));
		c1.setGrade(grade);
		s.setClassinfo(c1);
		s.setClassroom(classroom);// 上课地点
		String aa=schooltime.replaceAll("T", " ");
		s.setSchooltime(aa);
		//s.setSchooltime(aa);// 上课时间
		campus="西青区";
		s.setCampus(campus);
		Major m = new Major();
		m.setMajorid(Integer.parseInt(inmajor));// 专业
		s.setMajor(m);
		Teacher t = new Teacher();// 老师
		t.setId(Integer.parseInt(teaId));;
		s.setTeacher(t);
		xkservices.save(s);
		return "save";
	}
}
