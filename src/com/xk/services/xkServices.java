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
	//��Servicesע������Դ
	@Resource(name="xkdao")
	private xkDao xkdao;
	//��ѯȫ���ſ���Ϣ
	public List<Schedule> getSchlist() {
		return xkdao.getSchlist();
	};
	//��ȡȫ���γ���Ϣ
	public List<Course> getCourlist(){
		return xkdao.getCourlist();
	}
	//ɾ���ſ���Ϣ
	public void deleteSch(int id) {
		xkdao.deleteSch(id);
	}
	//������ѯ�ſ���Ϣ
	public List<Schedule> getSchlistByCon(int grade) {
		return xkdao.getSchlistByCon(grade);
	}
	//�����ſ���Ϣ
	public void save(Schedule s) {
		xkdao.save(s);
	}
	//��ȡ�����ſ���Ϣ
	public Schedule getSingleSch(int id) {
		return xkdao.getSingleSch(id);
	}
	//�����ſ���Ϣ
	public void updateSch(Schedule s) {
		xkdao.updateSch(s);
	}
	//��ȡȫ��ѧԺ��Ϣ
	public List<College> getColl() {
		return xkdao.getColl();
	}
	//��ȡרҵ��Ϣ
	public List<Major> getMaj(int id) {
		return xkdao.getMaj(id);
	}
	//��ȡ�γ���Ϣ
	public List<Course> getCour(int id){
		return xkdao.getCour(id);
	}
	//��ѯ�༶������Ϣ
	public List<ClassInfo> getClInfo() {
		return xkdao.getClInfo();
	}
	//��ȡȫ����ʦ��Ϣ
	public List<Teacher> getTea(){
		return xkdao.getTea();
	}
	//��ѯ�����༶������Ϣ
	public ClassInfo getSingleClass(int id){
		return xkdao.getSingleClass(id);
	}
	//���°༶������Ϣ
	public void upClassInfo(ClassInfo c){
		xkdao.upClassInfo(c);
	}
	//����Ͽ�ʱ���Ƿ��ͻ
	public List<Schedule> checkSchooltime(String schooltime){
		return xkdao.checkSchooltime(schooltime);
	}
	//��ID��ѯ�ſ���Ϣ
	public List<Schedule> getSchByID(int id){
		return xkdao.getSchByID(id);
	}
	//��ѯ�γ���Ϣ
	public List<Course> getCouByID(int id){
		return xkdao.getCouByID(id);
	}
	//��ѯ�༶������Ϣ
	public List<ClassInfo> getClassByID(int id){
		return xkdao.getClassByID(id);
	}
	//������ѯ�ſ���Ϣ
	public List<Schedule> getSchlistBySomething(String college,String major,String grade,String classroom,String classInfo,String courseName,String courseTeacher) {
		return xkdao.getSchlistBySomething(college,major,grade,classroom,classInfo,courseName,courseTeacher);
	}
	//������ѯ�γ���Ϣ
	public List<Course> getCourBySomething(String college,String major,String coursename,String courseTye,String credit){
		return xkdao.getCourBySomething(college,major,coursename,courseTye,credit);
	}
	//������ѯ�༶������Ϣ
	public List<ClassInfo> getClassBySomething(String college,String major,String grade,String studyDirection,String teacher){
		return xkdao.getClassBySomething(college,major,grade,studyDirection,teacher);
	}
}