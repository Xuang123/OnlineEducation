package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.entity.TCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TCourseService;

public class AddCourseAction extends ActionSupport implements ServletRequestAware {
	TCourseService<TCourse> service;
	private Integer cid;
	private String result="";
	private HttpServletRequest request;
	/*
	 * Service
	 */
	public void setService(TCourseService<TCourse> service){
		this.service=service;
	}
	public TCourseService<TCourse>  getService(){
		return service;
	}
	/*
	 * Cid
	 */
	public void setCid(Integer cid){
		this.cid=cid;
	}
	public int getCid(){
		return cid;
	}
	/*
	 * Result
	 */
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String AddMyCourse(){
		ActionContext act = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)act.get(ServletActionContext.HTTP_REQUEST);
		cid = (Integer)request.getAttribute("cid");
		
		service.addMyCourse(cid);
		
		return "NOT";
//		boolean course_isExist=service.courseExist(cid);
//		if(course_isExist){
//			request.setAttribute("course_isExist", "1");
//		
//			return "NOT";
//		}else{
//			request.setAttribute("Course_isExist", "0");
//
//			service.addMyCourse(cid);
//			System.out.println("cid "+cid);
//
//			return "NOT";
//		}
	}
	
	public String AddCourseConfirm(){
//		System.out.println("cid "+cid);
		result=null;
		boolean course_isExist=service.courseExist(cid);
		System.out.println("cid "+cid+" course_isExist "+course_isExist);
		if(course_isExist)
			result="exist";

		return SUCCESS;
	}
	
}
