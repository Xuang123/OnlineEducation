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

import com.entity.TCourse;
import com.entity.TUser;
public class NewTUserDao {

	private  SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<TUser> IDSearchUser(String id){
		String hql="from TUser u where u.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger("id",Integer.valueOf(id));
		return query.list();
	}
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
		user.setPhone(tUser.getPhone());
		user.setTelphone(tUser.getTelphone());
		user.setSignature(tUser.getSignature());
		user.setRegname(tUser.getRegname());
		user.setContent(tUser.getContent());
		session.update(user);
		tx.commit();
	}
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
}
