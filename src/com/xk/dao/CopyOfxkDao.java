package com.xk.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Major;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.services.xkServices;
import com.xk.util.HibernateUtil;

public class CopyOfxkDao {
	//获取全部班级课表信息
	public List<Schedule> getSchlist() {
		String hql = "from Schedule";
		String hql1 = " from College where collegeid=?";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Schedule> list = query.list();
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			query = session.createQuery(hql1);
			query.setInteger(0, collegeId);
			List<College> list1 = query.list();
			for (College c : list1) {
				System.out.println("c.getCollegename()" + c.getCollegename());
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
		return list;
	}
    //单个删除班级课表信息
	public void deleteSch(int id) {
		Schedule sde = new Schedule();
		sde.setId(id);
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(sde);
			ts.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
    //添加班级课表信息
	public void save(Schedule s) {
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			System.out.println("hhhhh" + s.getCourse().getId());
			session.save(s);
			ts.commit();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	//获取指定排课编号的课表信息
	public Schedule getSingleSch(int id) {
		String hql = "from Schedule where id=?";
		Session session = HibernateUtil.getSession();
		Schedule s = (Schedule) session.get(Schedule.class, id);
		System.out.println(s.getClassroom());
		HibernateUtil.close();
		return s;
	}
	//更新班级课表信息
	public void updateSch(Schedule s) {
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(s);
			ts.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	//检查上课时间是否冲突
	public List<Schedule> checkSchooltime(String schooltime) {
		String hql = "from Schedule where schooltime=?";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setString(0, schooltime);
		List<Schedule> list = query.list();
		HibernateUtil.close();
		return list;
	}
	//按排课编号查询班级课表信息
	public List<Schedule> getSchByID(int id) {
		String hql = "from Schedule where  id=?";
		String hql1 = " from College where collegeid=?";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		List<Schedule> list = query.list();
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			query = session.createQuery(hql1);
			query.setInteger(0, collegeId);
			List<College> list1 = query.list();
			for (College c : list1) {
				// s.setCollegeName(c.getCollegename());
				System.out.println("c.getCollegename()" + c.getCollegename());
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
		HibernateUtil.close();
		return list;
	}
	//条件查询班级课表信息
	public List<Schedule> getSchlistBySomething(String college, String major,
			String grade, String classroom, String classInfo,
			String courseName, String courseTeacher) {
		String hql = "from Schedule";
		String hql1 = " from College where collegeid=?";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Schedule> list = query.list();
		for (Schedule s : list) {
			System.out.println(s.getClassinfo().getGrade());
			int collegeId = s.getMajor().getCollegeid();
			System.out.println("collegeId" + collegeId);
			query = session.createQuery(hql1);
			query.setInteger(0, collegeId);
			List<College> list1 = query.list();
			for (College c : list1) {
				// s.setCollegeName(c.getCollegename());
				System.out.println("c.getCollegename()" + c.getCollegename());// ȡ
																				// ѧԺ
				String name = c.getCollegename();
				s.setCollegeName(name);
			}
		}
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
		HibernateUtil.close();
		return list;
	}
}
