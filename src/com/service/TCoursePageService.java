package com.service;

import java.util.List;

import com.dao.PageDao;
import com.entity.TCourse;
import com.util.Page;

public class TCoursePageService {
	private PageDao pagedao;
	
	public void setPageDao(PageDao pagedao){
		this.pagedao=pagedao;
	}
	public PageDao getPageDao(){
		return pagedao;
	}
	public Page getPage(){
		return pagedao.getPage();
	}
	public List<TCourse> getCurrentPage(){
		return (List<TCourse>)pagedao.getPage().getList();
	}
	
	public void init(int pageno){
		String tablename="TCourse";
		pagedao.init(pageno, tablename);
	}
	
	public int getTotalPage(){
		return pagedao.getPage().getTotalPage();
	}
	
	public void setHQL(int start,String hql){
		pagedao.setHql(start,hql);
	}
}
