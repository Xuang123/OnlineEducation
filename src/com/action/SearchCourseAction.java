package com.action;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.entity.TCourse;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TCoursePageService;
import com.service.TCourseService;

public class SearchCourseAction extends ActionSupport implements ModelDriven<TCourse> {

	private TCourse course= new TCourse();
//	private SessionFactory factory;
	private TCourseService<TCourse> service;
	private TCoursePageService pageservice;
	private Integer pno;
	private static String CourseName,CourseCompany,CourseType;
	private static final int MAX_PAGE_NUMBER = 7;

	
	public void setService(TCourseService<TCourse> service){
		this.service=service;
	}
	public TCourseService<TCourse>  getService(){
		return service;
	}
	
	public void setPageService(TCoursePageService pageservice){
		this.pageservice=pageservice;
	}
	public TCoursePageService  getPageService(){
		return pageservice;
	}
	
	public void setPno(Integer pno){
		this.pno=pno;
	}
	public int getPno(){
		return pno;
	}
	
	//distributeTime exchange
	public void TimeExchange(List<TCourse> courselist){

		for(int i=0;i<courselist.size();++i){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String distributeTime = df.format(courselist.get(i).getDistributeDate());
			System.out.println("DistributeTime : "+distributeTime);
			courselist.get(i).setDistributeDate(Timestamp.valueOf(distributeTime));
		}
	}
	
	public String search(){
		//System.out.println(course.getName()+" "+course.getCompany()+" "+course.getType());
//		List<TCourse> allcourselist = service.allCourse();
		
		/*
		 * get Course list of Search Results & send it to JSP
		 */
		CourseName = course.getName();
		CourseCompany = course.getCompany();
		CourseType = course.getType();
		
		List<TCourse> courselist;
		if("".equals(course.getName())&&"".equals(course.getCompany())&&"".equals(course.getType())){//all course
			
			System.out.println(course.getName()+"-name "+course.getCompany()+" "+course.getType());
			
			CourseName = "";
			CourseCompany = "";
			CourseType = "";
			
			pno=1;
			
			pageservice.init(pno);
			courselist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
//			TimeExchange(courselist);
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("list", courselist);
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
			
		}else if((CourseName!=null)||(CourseCompany!=null)||(CourseType!=null)){//search course
			
			pno=1;
			
			courselist=service.SearchCourse(course.getName(),course.getCompany(),course.getType());
			
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			courselist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
//			TimeExchange(courselist);
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("list", courselist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}
		else{//click "Search Courses" on the list
			CourseName = "";
			CourseCompany = "";
			CourseType = "";
			pno=1;
			pageservice.init(pno);
			courselist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
//			TimeExchange(courselist);
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("list", courselist);
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}
		
		List<TCourse> mylist = service.myCourse();
		ActionContext.getContext().getValueStack().set("mylist", mylist);
		
		return "NOT";
	}
	
	public String PageChange(){
		ActionContext act = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)act.get(ServletActionContext.HTTP_REQUEST);
		pno = (Integer)request.getAttribute("pno");
		
//		pageservice.init(pno);
		List<TCourse> courselist;
		
		if("".equals(CourseName)&&"".equals(CourseCompany)&&"".equals(CourseType)){
			System.out.println("\n\n\npageChange #all\n\n\n");
			
			pageservice.init(pno);
			courselist = pageservice.getCurrentPage();
			ActionContext.getContext().getValueStack().set("list", courselist);
			
			int totalpage = pageservice.getTotalPage();
			List<Integer> pagelist= new ArrayList<Integer>();
			for(int i=1;i<=totalpage;++i) {pagelist.add(i);}
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}else{
			System.out.println("\n\n\npageChange #Search\n\n\n");
			
			courselist=service.SearchCourse(CourseName,CourseCompany,CourseType);
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			courselist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("list", courselist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
			
			
//			ActionContext.getContext().getValueStack().set("list", courselist);
		}
		
//		int totalpage = pageservice.getTotalPage();
//		List<Integer> pagelist= new ArrayList<Integer>();
//		for(int i=1;i<=totalpage;++i) {pagelist.add(i);System.out.println(i);}
//		ActionContext.getContext().getValueStack().set("pagelist", pagelist);
//		
//		Integer currentPage = pageservice.getPage().getCurrentPage();
//		ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		
		System.out.println("pno "+pno);
		
		return "NOT";
	}
	
	@Override
	public TCourse getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	
	

}
