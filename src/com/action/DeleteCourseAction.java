package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.TCourse;
import com.opensymphony.xwork2.ActionContext;
import com.service.TCourseService;

public class DeleteCourseAction {
	TCourseService<TCourse> service;
	private Integer cid;
	
	public void setService(TCourseService<TCourse> service){
		this.service=service;
	}
	public TCourseService<TCourse>  getService(){
		return service;
	}
	public void setCid(Integer cid){
		this.cid=cid;
	}
	public int getCid(){
		return cid;
	}
	
	public String DeleteMyCourse(){
		ActionContext act = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)act.get(ServletActionContext.HTTP_REQUEST);
		cid = (Integer)request.getAttribute("cid");
		
		service.deleteMyCourse(cid);
//		System.out.println("cid "+cid);
		
		return "NOT";
	}
	
}
