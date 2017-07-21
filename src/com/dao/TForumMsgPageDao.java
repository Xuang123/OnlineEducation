package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bean.FMsgPage;

public class TForumMsgPageDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public FMsgPage sendmsgpage(int uid) {
		String hql = "from TMessage m where m.TUserBySendId.id="+ uid + " and m.status like '0_'";
		int size=sessionFactory.openSession().createQuery(hql).list().size();
		return new FMsgPage(size);
		
	}
	
	public FMsgPage receivemsgpage(int uid) {
		String hql = "from TMessage m where m.TUserByReceiveId.id="+ uid + " and m.status like '_0'";
		int size=sessionFactory.openSession().createQuery(hql).list().size();
		return new FMsgPage(size);
	}
}
