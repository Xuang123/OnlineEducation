package com.action;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TUserService;

public class UMChange extends ActionSupport 
{
	private String userid;
	private String id,regname,nickname,name,city,telephone,email,phone,signature,content,regdate,logdate,point,post,watch;
	private TUserService<TUser> service;
	public String IDSearch()
	{
		if(!"".equals(id))
		{
			List<TUser> list = service.IDSearchUser(id);
			TUser tUser=null;
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{ 
				tUser=(TUser)iterator.next();
			}
			ActionContext.getContext().getValueStack().set("umclist", list);
			ActionContext.getContext().getValueStack().set("umcuser", tUser);
		}
		return "NOT";
	}
	
	public String ChangeUserMessage()
	{
		Timestamp tregdate = new Timestamp(System.currentTimeMillis());
	    tregdate = Timestamp.valueOf(regdate);
	    Timestamp tlogdate = new Timestamp(System.currentTimeMillis());
	    tlogdate = Timestamp.valueOf(logdate);
	    Integer tid=Integer.valueOf(userid);	    
	    Integer tpost=Integer.valueOf(post);
	    Integer twatch=Integer.valueOf(watch);
	    double tpoint=Double.parseDouble(point);
		TUser user=new TUser();
		user.setId(tid);
		user.setCity(city);
		user.setContent(content);
		user.setEmail(email );
		user.setName(name);
		user.setNickname(nickname);
		user.setLogdate(tlogdate);
		user.setRegdate(tregdate);
		user.setPhone(phone);
		user.setPoint(tpoint);
		user.setPost(tpost);
		user.setTelphone(telephone);
		user.setWatch(twatch);
		user.setSignature(signature);
		user.setRegname(regname);
		service.ChangeUserMessage(user);
		return "SUCCESS";
	}
	
	
	
	
	
	//数据获取方法	
	public String getRegname() {
		return regname;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLogdate() {
		return logdate;
	}
	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getWatch() {
		return watch;
	}
	public void setWatch(String watch) {
		this.watch = watch;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TUserService<TUser> getService() {
		return service;
	}
	public void setService(TUserService<TUser> service) {
		this.service = service;
	}
	
	

}
