package com.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TUserService;

public class SearchUserAction extends ActionSupport{
	
	private TUser user= new TUser();
	private TUserService<TUser> service;
	private String regname,nickname,name;

	
	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setService(TUserService<TUser> service){
		this.service=service;
	}
	
	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUserService<TUser>  getService(){
		return service;
	}
	
	public String search(){		
		if("".equals(regname)&&"".equals(nickname)&&"".equals(name))
		{
			List<TUser> list = service.allUser();
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(nickname)&&"".equals(name)){
			List<TUser> list = service.searchRUser(regname);
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(regname)&&"".equals(name)){
			List<TUser> list = service.searchNickUser(nickname);
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(nickname)&&"".equals(regname)){
			List<TUser> list = service.searchNUser(name);
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(regname)){
			List<TUser> list = service.searchNNUser(name, nickname);
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(nickname)){
			List<TUser> list = service.searchNRUser(name, regname);
			ActionContext.getContext().getValueStack().set("list", list);
		}else if("".equals(name)){
			List<TUser> list = service.searchRNUser(regname, nickname);
			ActionContext.getContext().getValueStack().set("list", list);
		}else{
			List<TUser> list = service.searchUser(name, regname, nickname);
			ActionContext.getContext().getValueStack().set("list", list);
		}		
		return "NOT";
	}
	

}
