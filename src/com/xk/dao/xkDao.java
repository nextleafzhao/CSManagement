package com.xk.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Major;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
import com.xk.util.HibernateUtil;
@Repository("xkdao") 
//默认hibernateCostDaoImpl为id
@Scope("singleton")
public class xkDao extends HibernateDaoSupport {
	//为Dao注入数据源
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	//查询全部排课信息
	public List<Schedule> getSchlist() {
		String hql = "from Schedule";
		String hql1 = " from College where collegeid=?";
		List<Schedule> list = this.getHibernateTemplate().find(hql);
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			List<College> list1 = this.getHibernateTemplate().find(hql1,collegeId);
			for (College c : list1) {
				System.out.println("c.getCollegename()" + c.getCollegename());
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
		return list;
	}
	//获取全部课程信息
	public List<Course> getCourlist() {
		String hql = "from Course";
		List<Course> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	//获取全部学院信息
	public List<College> getColl() {
		String hql = "from College";
		List<College> list = this.getHibernateTemplate().find(hql);
		System.out.println("collegeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		return list;
	}
	//获取全部班级基本信息
	public List<ClassInfo> getClInfo() {
		String hql = "from ClassInfo";
		String hql1 = " from College where collegeid=?";
		List<ClassInfo> list = this.getHibernateTemplate().find(hql);
		for (ClassInfo c : list) {
			int id = c.getMajor().getCollegeid();
			List<College> list1 =this.getHibernateTemplate().find(hql1,id);
			for (College c1 : list1) {
				c.setCollegename(c1.getCollegename());
			}
		}
		return list;
	}
	//删除排课信息
	public void deleteSch(int id) {
		Schedule s=new Schedule();
		s.setId(id);
		this.getHibernateTemplate().delete(s);
	}
	//条件查询排课信息
	public List<Schedule> getSchlistByCon(int grade) {
		String hql = "from Schedule where classId=?";
		List<Schedule> list = this.getHibernateTemplate().find(hql,grade);
		return list;
	}
	//新增排课信息
	public void save(Schedule s) {
		this.getHibernateTemplate().save(s); 
	}
	//获取单个排课信息
	public Schedule getSingleSch(int id) {
		return (Schedule)getHibernateTemplate().get(Schedule.class, id);
	}
	//获取单个班级基本信息
	public ClassInfo getSingleClass(int id) {
		return (ClassInfo)getHibernateTemplate().get(ClassInfo.class, id);
	}
	//获取专业信息
	public List<Major> getMaj(int id) {
		String hql = "from Major where collegeid=?";
		List<Major> list =getHibernateTemplate().find(hql,id);
		for (Major m : list) {
			System.out.println("m.getMajorname()" + m.getMajorname());
		}
		return list;
	}
	//获取课程信息
	public List<Course> getCour(int id) {
		String hql = "from Course where majorid=?";
		List<Course> list = getHibernateTemplate().find(hql,id);
		for (Course c : list) {
			System.out.println("c.getCoursename())" + c.getCoursename());
		}
		return list;
	}
	//更新班级基本信息
	public void upClassInfo(ClassInfo c) {
		this.getHibernateTemplate().update(c);
	}
	//更新排课信息
	public void updateSch(Schedule s) {
		this.getHibernateTemplate().update(s);
	}
	//获取全部老师信息
	public List<Teacher> getTea() {
		String hql = "from Teacher";
		List<Teacher> list = this.getHibernateTemplate().find(hql);
		for (Teacher c : list) {
			System.out.println(c.getTeaname());
		}
		return list;
	}
	//检查上课时间是否冲突
	public List<Schedule> checkSchooltime(String schooltime) {
		String hql = "from Schedule where schooltime=?";	
		List<Schedule> list = getHibernateTemplate().find(hql,schooltime);
		return list;
	}
	//按ID查询排课信息
	public List<Schedule> getSchByID(int id) {
		String hql = "from Schedule where  id=?";
		String hql1 = " from College where collegeid=?";
		List<Schedule> list = getHibernateTemplate().find(hql,id);
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			List<College> list1 = getHibernateTemplate().find(hql1,collegeId);
			for (College c : list1) {
				// s.setCollegeName(c.getCollegename());
				System.out.println("c.getCollegename()" + c.getCollegename());// 获取开设学院名称
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
		return list;
	}
	//查询课程信息
	public List<Course> getCouByID(int id) {
		String hql = "from Course where id=?";
		List<Course> list =  getHibernateTemplate().find(hql,id);
		return list;
	}
	//查询班级基本信息
	public List<ClassInfo> getClassByID(int id) {
		String hql = "from ClassInfo where classid=?";
		String hql1 = " from College where collegeid=?";
		List<ClassInfo> list =  getHibernateTemplate().find(hql,id);
		for (ClassInfo c : list) {
			int id1 = c.getMajor().getCollegeid();
			List<College> list1 =getHibernateTemplate().find(hql1,id1) ;
			for (College c1 : list1) {
				c.setCollegename(c1.getCollegename());
			}
		}
		return list;
	}
	//条件查询排课信息
	public List<Schedule> getSchlistBySomething(String college, String major,
			String grade, String classroom, String classInfo,
			String courseName, String courseTeacher) {
		System.out.println("xzzzzzzzzzzzzzz");
		String hql = "from Schedule";
		String hql1 = " from College where collegeid=?";
		
		List<Schedule> list = this.getHibernateTemplate().find(hql);
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			List<College> list1 = this.getHibernateTemplate().find(hql1,collegeId);
			for (College c : list1) {
				// s.setCollegeName(c.getCollegename());
				System.out.println("c.getCollegename()" + c.getCollegename());
																				
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
		System.out.println("xzzzzxxzzzzzzzz");
		Iterator<Schedule> it = list.iterator();
		while (it.hasNext()) {
			Schedule x = it.next();
			if (!"".equals(major) && null != major) {
				if (major.indexOf(x.getMajor().getMajorid() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(grade) && null != grade) {
				if (grade.indexOf(x.getClassinfo().getGrade() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(classroom) && null != classroom) {
				if (classroom.indexOf(x.getClassroom() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(classInfo) && null != classInfo) {
				if (classInfo.indexOf(x.getClassinfo().getClassid() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(courseName) && null != courseName) {
				if (courseName.indexOf(x.getCourse().getCoursename() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(courseTeacher) && null != courseTeacher) {
				if (courseTeacher.indexOf(x.getTeacher().getTeaname() + "") == -1) {
					it.remove();
					continue;
				}
			}
		}
		System.out.println("xzzzzxxzzzzxxzz");
		return list;
	}
	//条件查询课程信息
	public List<Course> getCourBySomething(String college, String major,
			String coursename, String courseTye, String credit) {
		String hql = "from Course";
		List<Course> list = this.getHibernateTemplate().find(hql);
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			if (!"".equals(college) && null != college) {
				if (college.indexOf(c.getCollege().getCollegeid() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(major) && null != major) {
				if (major.indexOf(c.getMajor().getCollegeid() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(coursename) && null != coursename) {
				if (coursename.indexOf(c.getId() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(courseTye) && null != courseTye) {
				if (courseTye.indexOf(c.getCredit() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(credit) && null != credit) {
				if (credit.indexOf(c.getCredit() + "") == -1) {
					it.remove();
					continue;
				}
			}
		}
		return list;
	}
	//条件查询班级基本信息
	public List<ClassInfo> getClassBySomething(String college, String major,
			String grade, String studyDirection, String teacher) {
		String hql = "from ClassInfo";
		String hql1 = " from College where collegeid=?";
		List<ClassInfo> list = this.getHibernateTemplate().find(hql);
		for (ClassInfo c : list) {
			int id = c.getMajor().getCollegeid();
			List<College> list1 = this.getHibernateTemplate().find(hql1,id);
			for (College c1 : list1) {
				c.setCollegename(c1.getCollegename());
			}
		}
		Iterator<ClassInfo> it = list.iterator();
		while (it.hasNext()) {
			ClassInfo cl = it.next();
			if (!"".equals(major) && null != major) {
				if (major.indexOf(cl.getMajor().getMajorid() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(grade) && null != grade) {
				if (grade.indexOf(cl.getGrade() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(studyDirection) && null != studyDirection) {
				if (studyDirection.indexOf(cl.getStudydirection() + "") == -1) {
					it.remove();
					continue;
				}
			}
			if (!"".equals(teacher) && null != teacher) {
				if (teacher.indexOf(cl.getTeacher().getTeaname() + "") == -1) {
					it.remove();
					continue;
				}
			}
		}
		return list;
	}
}
