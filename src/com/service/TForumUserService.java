package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.FUser;
import com.dao.TForumUserDao;
import com.entity.TUser;

public class TForumUserService<T> {
	private TForumUserDao tforumuserdao;  

	public void setTForumUserDao(TForumUserDao tforumuserdao) {
		this.tforumuserdao = tforumuserdao;
	}

	public List<TUser> allUser(){
		return tforumuserdao.allUser();
	}
    
	public TUser myInfo(int id){
		return tforumuserdao.myInfo(id);
	}
	
	public FUser searchPassword(String regname){
		return tforumuserdao.searchPassword(regname);
	}
	
	public void updateInfo(TUser tuser) {
		tforumuserdao.updateInfo(tuser);
	}
	
	public int getIdByRegname(String regname) {
		return tforumuserdao.getIdByRegname(regname);
	}
}
