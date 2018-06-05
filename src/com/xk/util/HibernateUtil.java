package com.xk.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * 
 * @author SPL
 * ʹ��Hibernate��ȡ���ӵĹ�����
 *
 */
public class HibernateUtil {
       private static SessionFactory sf;
       private static ThreadLocal<Session> tl=new ThreadLocal<Session>();
       static{
    		//�����������ļ���ӳ���ϵ�ļ���ֻ�����һ�Σ�
   		    Configuration conf=new Configuration();
   		    conf.configure("/hibernate.cfg.xml");
   		    //��ȡsession����
   		    sf=conf.buildSessionFactory();
       }
       /**
        * ��ȡ����
        * @return
        */
       public static Session getSession(){
    	   //ȡ����ǰ�̵߳�session
    	   Session session=tl.get();
    	   if(session==null){
    		  //���ȡ����sessionΪ�գ����ʼ��
    		  session=sf.openSession();
    		  //����ʼ����session����ThreadLocal��
    		  //keyĬ���ǵ�ǰ���߳�����value��session
    		  tl.set(session);
    	  }
    	  return session;
       }
       /**
        * �ر�����
        */
       public static void close(){
    	   //ȡ����ǰ�̵߳�session
    	   Session session=tl.get();
    	   if(session!=null){
    		   //�ر�����
    		   session.close();
    		   //�����Ӵ�ThreadLocal���Ƴ�
    		   tl.remove();
    	   }
       }
       public static void main(String[] args) {
	       Session session=HibernateUtil.getSession();
	       System.out.println(session);
	       HibernateUtil.close();
	}
}
