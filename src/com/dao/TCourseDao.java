package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.TCourse;
import com.entity.TUser;
import com.entity.TUserCourse;


public class TCourseDao {
	private SessionFactory sessionFactory;
	private String daoHQL;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<TCourse> allCourse(){
		String hql="from TCourse";
		
		List<TCourse> list;
		Session session=sessionFactory.openSession();
		list= session.createQuery(hql).list();
		session.close();
		
		return list;
	}
	
	public boolean courseExist(Integer cid){
		boolean course_isExist=true;
		String hql="select new com.entity.TCourse(c.name,c.id,c.type,c.author,c.company,c.loadCount) from TCourse c,TUserCourse uc where uc.TUser.id="+30+" and uc.TCourse="+cid;
		Session session =sessionFactory.openSession();
		Query query =session.createQuery(hql);
//		query.setInteger(0, 30);
//		query.setInteger(1, cid);
//		query.executeUpdate();
		List list=query.list();
		session.close();
	
		if(list.isEmpty()) course_isExist=false;
		return course_isExist;
	}
	
	@SuppressWarnings("unchecked")
	public List<TCourse> myCourse(){
		String hql="select new com.entity.TCourse(c.name,c.id,c.type,c.author,c.company,c.loadCount,c.dataurl,date_format(c.distributeDate,'%Y-%m-%d %H:%i:%s')) from TCourse c,TUserCourse uc where uc.TUser.id=30 and uc.TCourse=c";
		daoHQL=hql;
		
		List<TCourse> list;
		Session session=sessionFactory.openSession();
		list= session.createQuery(hql).list();
		session.close();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<TCourse> searchMyCourse(String name,String company,String type){
		String hql="select new com.entity.TCourse(c.name,c.id,c.type,c.author,c.company,c.loadCount,c.dataurl,date_format(c.distributeDate,'%Y-%m-%d %H:%i:%s')) from TCourse c,TUserCourse uc where uc.TUser.id=30 and uc.TCourse=c and";
		int originalLen=hql.length();
		if("".equals(name)==false){
			hql+=" c.name like '%";
			hql+=name;
			hql+="%'";
		}
		if("".equals(company)==false){
			if(hql.length()!=originalLen) hql+=" and";
			hql+=" c.company like '%";
			hql+=company;
			hql+="%'";
		}
		if("".equals(type)==false){
			if(hql.length()!=originalLen) hql+=" and";
			hql+=" c.type like '%";
			hql+=type;
			hql+="%'";
		}
		daoHQL=hql;
		List<TCourse> mylist;
		Session session=sessionFactory.openSession();
		mylist= session.createQuery(hql).list();
		session.close();
		
		return mylist;
	}
	
	@SuppressWarnings("unchecked")
	public List<TCourse> searchCourse(String name,String company,String type){
		System.out.println("\n\n\n@searchCourse #TCourseDao"+name+" "+company+" "+type+"\n\n\n");
		String hql="from TCourse c where";
		int originalLen=hql.length();
		if("".equals(name)==false){
			hql+=" c.name like '%";
			hql+=name;
			hql+="%'";
		}
		if("".equals(company)==false){
			if(hql.length()!=originalLen) hql+=" and";
			hql+=" c.company like '%";
			hql+=company;
			hql+="%'";
		}
		if("".equals(type)==false){
			if(hql.length()!=originalLen) hql+=" and";
			hql+=" c.type like '%";
			hql+=type;
			hql+="%'";
		}
		daoHQL=hql;
		
		List<TCourse> list;
		Session session=sessionFactory.openSession();
		list= session.createQuery(hql).list();
		session.close();
		
		return list;
		
	}
	
	public boolean deleteMyCourse(Integer cid){
		String hql="delete from TUserCourse uc where uc.TCourse.id=? and uc.TUser.id=?";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		query.setInteger(0, cid);
		query.setInteger(1, 30);
		query.executeUpdate();
		
		session.close();
		return true;
	}
	
	public boolean addMyCourse(Integer cid){//HQL can not execute "insert" operation, so we choose SQL to finish it.(maybe)
//		String sql="insert into t_user_course values()";
		Session session=sessionFactory.openSession();
		TUserCourse tusercourse=new TUserCourse();
		TCourse tcourse=new TCourse();
		TUser tuser=new TUser();
		
		tcourse.setId(cid);
		tuser.setId(30);
		
		tusercourse.setTCourse(tcourse);
		tusercourse.setTUser(tuser);
		tusercourse.setLearnCount(0);
		tusercourse.setLoadCount(0);
		
		session.save(tusercourse);
		session.close();
		
		return true;
	}
	
	public String getHQL(){
		return daoHQL;
	}
	
	
}
