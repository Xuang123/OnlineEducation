package com.action;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.Dao;
import com.opensymphony.xwork2.ActionSupport;


public class register2 {
	private String user;
	private String nickname;
	private String email;
	private String password;
	private String password1;
	private String name;
	private String telphone;
	private String phone;
	private String city;
	 
	
	public String execute()throws Exception
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());
		if(!password.equals(password1))
			return "ERROR";
		if(user==null||nickname==null||email==null||email==null)
			return "ERROR";		
		String sql1 = "select max(id) from t_user";
		ResultSet rset=Dao.executeQuery(sql1);
	    int id=0;
		String tmp="";
		while(rset.next()){
			tmp = rset.getString(1);
			id = Integer.parseInt(tmp)+1;
		}
		System.out.print(user);
		String sql2="insert into t_user(id,name,regname,nickname,city,telphone,phone,email,regdate,roleId) values('"+id+"','"+name+"','"+user+"','"+nickname+"','"+city+"','"+telphone+"','"+phone+"','"+email+"','"+date+"','1')";
		int rs=Dao.executeUpdate(sql2);
		if(rs == -1){
			Dao.close();
			return"ERROR";
		}
			
		else{
			Dao.close();
			return"SUCCESS";
		}
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword1() {
		return password1;
	}


	public void setPassword1(String password1) {
		this.password1 = password1;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelphone() {
		return telphone;
	}


	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}






	
	
	

}
