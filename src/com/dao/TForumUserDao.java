package com.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.FUser;
import com.entity.TUser;

public class TForumUserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<TUser> allUser() {
		String hql = "from TUser";

		return sessionFactory.openSession().createQuery(hql).list();
	}

	public TUser myInfo(int id) {
		String hql = "from TUser u where u.id=" + id;
		List<TUser> list = sessionFactory.openSession().createQuery(hql).list();
		return (TUser)list.get(0);
	}

	public FUser searchPassword(String regname) {
		String hql = "select new com.bean.FUser(u.id,u.regname,u.nickname,u.password) " + "from TUser u where u.regname='"
				+ regname + "'";
		List<FUser> list = sessionFactory.openSession().createQuery(hql).list();
		return (FUser)list.get(0);
	}

	public void updateInfo(TUser tuser) {
		
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		TUser userup = (TUser) session.get(TUser.class, tuser.getId());
		System.out.println(tuser.getNickname()+"\t"+tuser.getName());
		userup.setNickname(tuser.getNickname());
		userup.setName(tuser.getName());
		userup.setEmail(tuser.getEmail());
		userup.setTelphone(tuser.getTelphone());
		userup.setPhone(tuser.getPhone());
		userup.setCity(tuser.getCity());
		userup.setSignature(tuser.getSignature());
		userup.setContent(tuser.getContent());
		userup.setShowflag(tuser.getShowflag());
		userup.setUpddate(Timestamp.valueOf(df.format(System.currentTimeMillis())));
		userup.setOperate("更新资料");
		session.update(userup);
		tx.commit();

	}
	
	public int getIdByRegname(String regname) {
		String hql = "select new com.bean.FUser(u.id,u.regname)" + "from TUser u where u.regname='"
				+ regname + "'";
		List<FUser> list = sessionFactory.openSession().createQuery(hql).list();
		FUser user=(FUser)list.get(0);
		return user.getId();
	}

}
