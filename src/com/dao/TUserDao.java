package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.UExam;
import com.entity.TCourse;
import com.entity.TUser;
import com.entity.TUserCourse;

public class TUserDao {	
	private  SessionFactory sessionFactory;
	
	public  SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public  void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	//无参数查询
	public List<TUser> allUser(){
		String hql="from TUser";		
		return sessionFactory.openSession().createQuery(hql).list();
	}
	
	//单参数查询
	public List<TUser> searchNUser(String name){
		String hql="from TUser u where u.name=:name";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name",name);
		return query.list();
	}
	public List<TUser> searchRUser(String regname){
		String hql="from TUser u where regname=:regname";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("regname",regname);
		return query.list();
	}
	public List<TUser> searchNickUser(String nickname){
	String hql="from TUser u where nickname=:nickname";
	Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("nickname",nickname);
		return query.list();		
	}
	
	//两个参数查询
	public List<TUser> searchNRUser(String name,String regname){
		String hql="from TUser u where u.name=:name"+" and regname=:regname";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name",name);
		query.setParameter("regname",regname);
		return query.list();
	}
	public List<TUser> searchNNUser(String name,String nickname){
		String hql="from TUser u where u.name=:name"+" and nickname=:nickname";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name",name);
		query.setParameter("nickname",nickname);
		return query.list();
	}
	public List<TUser> searchRNUser(String regname,String nickname){
		String hql="from TUser u where regname=:regname"+" and nickname=:nickname";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("regname",regname);
		query.setParameter("nickname",nickname);
		return query.list();
	}
	
	
	//三个参数查询
	public List<TUser> searchUser(String name,String regname,String nickname){
		String hql="from TUser u where u.name=:name"+" and regname=:regname"+" and nickname=:nickname";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name",name);
		query.setParameter("regname",regname);
		query.setParameter("nickname",nickname);
		return query.list();
	}
	
	//ͨ用户ID查询
	public List<TUser> IDSearchUser(String id){
		String hql="from TUser u where u.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger("id",Integer.valueOf(id));
		return query.list();
	}
	
	
	//用户部分信息修改
	public void ChangeUserMessage(TUser tUser)
	{
		
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		TUser user=(TUser)session.get(TUser.class, tUser.getId());
		user.setCity(tUser.getCity());
		user.setContent(tUser.getContent());
		user.setEmail(tUser.getEmail());
		user.setName(tUser.getName());
		user.setNickname(tUser.getNickname());
		user.setLogdate(tUser.getLogdate());
		user.setRegdate(tUser.getRegdate());
		user.setPhone(tUser.getPhone());
		user.setPoint(tUser.getPoint());
		user.setPost(tUser.getPost());
		user.setTelphone(tUser.getTelphone());
		user.setWatch(tUser.getWatch());
		user.setSignature(tUser.getSignature());
		user.setRegname(tUser.getRegname());
		session.update(user);
		tx.commit();
	}
	
	public void ChangeUM(TUser tUser)
	{
		
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		TUser user=(TUser)session.get(TUser.class, tUser.getId());
		user.setCity(tUser.getCity());
		user.setContent(tUser.getContent());
		user.setEmail(tUser.getEmail());
		user.setName(tUser.getName());
		user.setNickname(tUser.getNickname());
		user.setPhone(tUser.getPhone());
		user.setTelphone(tUser.getTelphone());
		user.setSignature(tUser.getSignature());
		session.update(user);
		tx.commit();
	}
	
	
	//删除用户
	public void DeleteUser(Integer id)
	{
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		TUser user=(TUser)session.get(TUser.class,id);
		session.delete(user);
		tx.commit();		
	}
	
	//修改密码
	public String FindPassword(Integer id)
	{
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		TUser user=(TUser)session.get(TUser.class, id);
		return user.getPassword();
	}
	public void ChangePassword(Integer id,String password)
	{
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		TUser user=(TUser)session.get(TUser.class, id);
		user.setPassword(password);
		tx.commit();
	}
	
	//获取该用户的课程进行显示
	public List<TCourse> ShowUserCourse(Integer id)
	{
		String hql="select c from TCourse c,TUserCourse uc where uc.TUser.id=:id"+" and uc.TCourse=c";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger("id",id);
		return query.list();
	}
	
	//获取用户考试信息进行显示
	public List<UExam> ShowUserExam(Integer id)
	{
		String sql="select e.id,e.name,s.takeDate,s.kscore,s.zscore,s.count from t_exam e,t_user_exam s where s.userId="+id+" and s.examId=e.id";
		Query query =sessionFactory.openSession().createSQLQuery(sql).addScalar("ID").addScalar("NAME").addScalar("TAKEDATE").addScalar("KSCORE").addScalar("ZSCORE").addScalar("COUNT");
		List list=query.list();
		List<UExam> examBean = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
		UExam ue = new UExam();//把"裸"数据组装到自己的employee类

		Object[] object = (Object[]) list.get(i);
		ue.setId(object[0].toString());
		ue.setName(object[1].toString());
		ue.setTime(object[2].toString());
		Double pInteger=Double.valueOf(object[3].toString())+Double.valueOf(object[4].toString());
		ue.setPoint(pInteger+"");
		ue.setNumber(object[5].toString());
		examBean.add(ue);
		} 
		return examBean;
	}

}
