package com.service;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.TCourseDao;
import com.dao.NewTUserDao;
import com.entity.TCourse;
import com.entity.TUser;
public class NewTUserService<T>{

private NewTUserDao newtuserdao;  
    
	

	public NewTUserDao getNewtuserdao() {
	return newtuserdao;
}
public void setNewtuserdao(NewTUserDao newtuserdao) {
	this.newtuserdao = newtuserdao;
}
	public List<TUser> searchNUser(String id){
		return newtuserdao.IDSearchUser(id);
	}
	public void ChangeUserMessage(TUser tUser)
	{
		newtuserdao.ChangeUserMessage(tUser);
	}
	public List<TUser> IDSearchUser(String id){
		return newtuserdao.IDSearchUser(id);
	}
	public String FindPassword(Integer id)
	{			
		return newtuserdao.FindPassword(id);
	}
	public void ChangePassword(Integer id,String password)
	{
		newtuserdao.ChangePassword(id, password);
	}
	
	
}
