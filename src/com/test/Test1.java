package com.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xk.entity.ClassInfo;
import com.xk.entity.College;
import com.xk.entity.Course;
import com.xk.entity.Major;
import com.xk.entity.Schedule;
import com.xk.entity.Teacher;
import com.xk.util.HibernateUtil;

public class Test1 {
	/*@Test
	public void test() {
		// 模拟新增的数据
		Schedule  sd=new Schedule();
		sd.setCampus("西青区");
		sd.setClassroom("B309");
		sd.setSchooltime("2018-02-05");
		sd.getTeacher().setId(1);;
		sd.getMajor().setCollegeid(1);;
		// 获取session
		Session session = HibernateUtil.getSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		try {
			session.save(sd);
			// 提交事务
			ts.commit();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ts.rollback();
		} finally {
			// 关闭连接
			HibernateUtil.close();
		}
	}*/
	/*
	 * 删除员工信息
	 
	@Test
	public void delete() {
		Schedule sde = new Schedule();
		sde.setArrtabid(1);
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
	}*/
	
	 
	/*@Test
	public void findAll() {
		String hql = "from Schedule";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Schedule> list = query.list();
		for(Schedule e:list){
	        	System.out.println(e.getSchooltime());      	
	        }
	}*/
	@Test
	public void findAll1() {
		String hql = "from Course";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Course> list = query.list();
		for(Course e:list){
	        	System.out.println(e.getCoursename());      	
	    }
	}
	/*@Test
	public void findById() {
		Session session = HibernateUtil.getSession();
		Schedule sde = (Schedule) session.load(Schedule.class, 2);
		System.out.println("----------延迟加载----------");
		System.out.println(sde.getSchooltime()+" "+sde.getMajorid());
		HibernateUtil.close();
	};
	
	@Test
	public void test2() {
		// 先取出要修改的数据
		Session session = HibernateUtil.getSession();
		Schedule sde = (Schedule) session.get(Schedule.class, 2);
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 模拟对数据的修改
        sde.setClassroom("B301");
		try {
			session.update(sde);
			ts.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	@Test
	public void test1(){
	  String hql="from Schedule where classroom=?";
	  Session session=HibernateUtil.getSession();
	  Query query=session.createQuery(hql);
	  query.setString(0, "B301");
	  List<Schedule> list=query.list();
	  for(Schedule e:list){
		  System.out.println(e.getClassroom()+" "+e.getSchooltime());		  
	  }
	  HibernateUtil.close();
    }	
	@Test
	public void test3(){
		Session session=HibernateUtil.getSession();
		String hql="select arrtabid,classroom,schooltime from Schedule where arrtabid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, 2);
		List<Object[]> list=query.list();
		for(Object[] objs:list){
			System.out.println(objs[0]+""+objs[1]+""+objs[2]);									
		} 	
	}*/
	/*@Test
	   public void test0(){
		   //查询service时关联查询出Account
		   Session session=HibernateUtil.getSession();
		   Schedule s=(Schedule)session.get(Schedule.class, 1);
		   System.out.println(s.getSchooltime());
		   System.out.println("---------------------");
		   Course c=s.getCourse();
		   System.out.println(c.getCoursename());
		  Teacher a=s.getTeacher();
		   System.out.println(a.getTeaname());
		   Major m=s.getMajor();
		   System.out.println(m.getMajorname());
		   ClassInfo c=s.getClassinfo();
		   System.out.println(c.getClassname());
		   HibernateUtil.close();
	   }*/
	/*@Test
	public void delete() {
		Schedule sde = new Schedule();
		sde.setArrtabid(1);
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
	}*/
	@Test
	public void findAll() {
		String hql = "from Course";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Course> list = query.list();
		/*for(ClassInfo c:list){
			System.out.println(c.getMajor().getCollegeid());
		}*/
		System.out.println(list.size());
	}
	
}
