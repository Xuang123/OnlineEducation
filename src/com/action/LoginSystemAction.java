package com.action;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.Dao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginSystemAction extends ActionSupport
{
	private String username;
	private String password;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String execute()throws Exception
	{
		String sql="select * from t_user where regname='"+username+"'";
		ResultSet rs=Dao.executeQuery(sql);
		ServletActionContext.getRequest().getSession().setAttribute("username", username);
		String p="",t="";
		while(rs.next())
		{
			p=rs.getString("password");
			t=rs.getString("roleId");
		}
		Dao.close();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String date=df.format(new Date());
		if(p.equals(password)&&"dtef".equals(code)&&t.equals("1"))
		{
			String newdate="update t_user set logdate='"+date+"'"+"where regname='"+username+"'";
			Dao.executeUpdate(newdate);
			Dao.close();
			return "USER";
		}else if(p.equals(password)&&"dtef".equals(code)&&t.equals("2")){
			String newdate="update t_user set logdate='"+date+"'"+"where regname='"+username+"'";
			Dao.executeUpdate(newdate);
			String sql3="select id from t_user where regname='"+username+"'";
			ResultSet rs1 = Dao.executeQuery(sql3);
			int id =0;
			while(rs1.next()){
				id = rs1.getInt("id");
			}
			Dao.close();
			ActionContext.getContext().getValueStack().set("userId", id);
			HttpServletRequest request = ServletActionContext.getRequest();;
			request.setAttribute("userId", id);
		    return "SUCCESS";
		}else{
		    return "ERROR";
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
