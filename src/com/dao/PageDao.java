package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.Page;

public class PageDao {
	private String hql="";
	private SessionFactory sessionFactory;
	public Page page;
	public int start = 1;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void init(int start, String tableName) { 
		page = new Page();
		hql = "from " + tableName;
		this.start = start;
		setRowCount();
		setTotalPage();
		setCurrentPage();
		setPrePage();
		setNextPage();
		setPreOrNextBoolean();
	}
	
	public void setHql(int start,String hql){
		this.hql=hql;
		page = new Page();
		this.start = start;
		setRowCount();
		setTotalPage();
		setCurrentPage();
		setPrePage();
		setNextPage();
		setPreOrNextBoolean();
	}

	public int getRowCount() {
		Session session=sessionFactory.openSession();
		List list = session.createQuery(hql).list();
		session.close();
		if (list.isEmpty()) {
			return 0;
		}
		return list.size();
	}

	public Page getPage() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(getStartIndex());
		query.setMaxResults(page.getPageSize());
		List list = query.list();
		page.setList(list);
		session.close();
		return page;
	}

	public void setPreOrNextBoolean() {
		if (page.getCurrentPage() <= 1) {
			page.setHasPreviousPage(false);
		} else {
			page.setHasPreviousPage(true);
		}
		if (page.getCurrentPage() >= page.getTotalPage()) {
			page.setHasNextPage(false);
		} else {
			page.setHasNextPage(true);
		}
	}

	public void setCurrentPage() {
		if (start < 1) {
			page.setCurrentPage(1);
		}
		if (start > page.getTotalPage()) {
			page.setCurrentPage(page.getTotalPage());
		}
		page.setCurrentPage(start);
	}

	public void setPrePage() {
		page.setPrePage(page.getCurrentPage() - 1);
	}

	public void setNextPage() {
		page.setNextPage(page.getCurrentPage() + 1);
	}

	public void setTotalPage() {
		int rowCount = getRowCount();
		int pageSize = page.getPageSize();
		if (rowCount > pageSize) {
			if (rowCount % pageSize == 0) {
				page.setTotalPage(rowCount / pageSize);
			} else {
				page.setTotalPage(1 + (rowCount / pageSize));
			}
		} else {
			page.setTotalPage(1);
		}
	}

	public void setRowCount() {
		page.setRowCount(getRowCount());
	}

	public int getStartIndex() {
		int startIndex = 0;
		if (start < 0) {
			startIndex = 0;
		} else {
			if (start > page.getTotalPage()) {
				startIndex = page.getPageSize() * (page.getTotalPage() - 1);
			} else {
				startIndex = page.getPageSize() * (start - 1);
			}
		}
		return startIndex;
	}

}
