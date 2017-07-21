package com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.UExam;

import com.dao.TUserDao;
import com.entity.TCourse;
import com.entity.TUser;
import com.entity.TUserCourse;

public class TUserService<T> 
{
    private TUserDao tuserdao;  
    
	

	public TUserDao getTuserdao() {
		return tuserdao;
	}

	public void setTuserdao(TUserDao tuserdao) {
		this.tuserdao = tuserdao;
	}

	
	public List<TUser> allUser(){
		return tuserdao.allUser();
	}
    
	//单参数查询
		public List<TUser> searchNUser(String name){
			return tuserdao.searchNUser(name);
		}
		public List<TUser> searchRUser(String regname){
			return tuserdao.searchRUser(regname);
		}
		public List<TUser> searchNickUser(String nickname){
			return tuserdao.searchNickUser(nickname);
		}
		
		//双参数查新
		public List<TUser> searchNRUser(String name,String regname){
			return tuserdao.searchNRUser(name,regname);
		}
		public List<TUser> searchNNUser(String name,String nickname){
			return tuserdao.searchNNUser(name,nickname);
		}
		public List<TUser> searchRNUser(String regname,String nickname){
			return tuserdao.searchRNUser(regname,nickname);
		}
				
		//三参数查询
		public List<TUser> searchUser(String name,String regname,String nickname){
			return tuserdao.searchUser(name,regname,nickname);
		}
	
	
		//ͨID查询
		public List<TUser> IDSearchUser(String id){
			return tuserdao.IDSearchUser(id);
		}
		
		//用户部分信息修改
		public void ChangeUserMessage(TUser tUser)
		{
			tuserdao.ChangeUserMessage(tUser);
		}
		
		public void ChangeUM(TUser tUser)
		{
			tuserdao.ChangeUM(tUser);
		}
		//删除用户
		public void DeleteUser(Integer id)
		{
			tuserdao.DeleteUser(id);
		}
		
		//修改密码
		public String FindPassword(Integer id)
		{			
			return tuserdao.FindPassword(id);
		}
		public void ChangePassword(Integer id,String password)
		{
			tuserdao.ChangePassword(id, password);
		}
		
		
		//获取该用户的课程进行显示
		public List<TCourse> ShowUserCourse(Integer id)
		{
			return tuserdao.ShowUserCourse(id);
		}

		
		//获取用户考试信息进行显示
		public List<UExam> ShowUserExam(Integer id)
		{
			return tuserdao.ShowUserExam(id);
		}


}
