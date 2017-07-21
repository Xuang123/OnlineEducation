package com.action;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.*;

import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.NewTUserService;
public class UserAction {

	private NewTUserService<TUser> service;
	private String id,nickname,name,city,telephone,email,phone,signature,content,regname;
	private String password,newpassword,confirmpassword;
	public String searchUser()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("id");
		List<TUser> list=service.IDSearchUser(id);
		TUser tUser=null;
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{ 
			tUser=(TUser)iterator.next();
		}
		ActionContext.getContext().getValueStack().set("list", list);
		ActionContext.getContext().getValueStack().set("umcuser", tUser);
		System.out.println("success");
		System.out.println(tUser.getName());
		request.setAttribute("T_flag", "123");
		request.setAttribute("id", id);
		return "NOT";
	}
	
	public String ChangeUserMessage()
	{		
		Integer tid=Integer.valueOf(id);	    
		TUser user=new TUser();
		user.setId(tid);
		user.setCity(city);
		user.setContent(content);
		user.setEmail(email );
		user.setRegname(regname);
		user.setName(name);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setTelphone(telephone);
		user.setSignature(signature);
		service.ChangeUserMessage(user);
		return "NOT";
	}
	
	public String ChangePassword()
	{
		Integer tid=Integer.valueOf(id);
		System.out.println(password);
		System.out.println(newpassword);
		System.out.println(confirmpassword);
		if(!service.FindPassword(tid).equals(password)||!newpassword.equals(confirmpassword))
		{
			return "NOT";
		}
		service.ChangePassword(tid, newpassword);
		System.out.println("success");
		return "SUCCESS";
		
	}
	
	
	public NewTUserService<TUser> getService() {
		return service;
	}
	public void setService(NewTUserService<TUser> service) {
		this.service = service;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
