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

import com.entity.TMessage;

public class TForumMsgDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<TMessage> allMsg() {
		String hql = "from TMessage";
		return sessionFactory.openSession().createQuery(hql).list();
	}

	public List<TMessage> mySdMsg(int uid,int ye) {
		String hql = "from TMessage m where m.TUserBySendId.id="+ uid + " and m.status like '0_' order by senddate desc";
		Query query= sessionFactory.openSession().createQuery(hql);
		query.setFirstResult((ye-1)*10);
		query.setMaxResults(10);
		return query.list();
	}

	public List<TMessage> myRdMsg(int uid,int ye) {
		String hql = "from TMessage m where m.TUserByReceiveId.id="+ uid + " and m.status like '_0' order by flag asc,senddate desc";
		Query query= sessionFactory.openSession().createQuery(hql);
		query.setFirstResult((ye-1)*10);
		query.setMaxResults(10);
		return query.list();
	}

	public TMessage smsginfo(int id) {
		String hql = "from TMessage m where m.id="+ id;
		List<TMessage> list = sessionFactory.openSession().createQuery(hql).list();
		return (TMessage)list.get(0);

	}
	
	public TMessage rmsginfo(int id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		String hql = "from TMessage m where m.id="+ id;
		List<TMessage> list = session.createQuery(hql).list();
		hql="update TMessage set flag=1 where id="+id;
		Query q=session.createQuery(hql);
		q.executeUpdate();
		tx.commit();
		return (TMessage)list.get(0);
	}
	
	public void sendmsg(TMessage tmsg) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		tmsg.setSenddate(Timestamp.valueOf(df.format(System.currentTimeMillis())));
		session.save(tmsg);
		tx.commit();
	}
	
	public void deletemsg(int id,int wei) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		TMessage msg=(TMessage) session.get(TMessage.class, id);
		String sta=msg.getStatus();
		if(wei==0) {
			msg.setStatus("1"+String.valueOf(sta.charAt(1)));
		}
		if(wei==1) {
			msg.setStatus(String.valueOf(sta.charAt(0))+"1");
		}
		session.update(msg);
		tx.commit();
	}
		
}
