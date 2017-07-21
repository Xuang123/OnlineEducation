package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.TCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TCoursePageService;
import com.service.TCourseService;

public class SearchMyCourseAction extends ActionSupport implements ModelDriven<TCourse>{
	private TCourse course = new TCourse();
	private TCourseService<TCourse> service;
	private TCoursePageService pageservice;
	private Integer pno;
	private static String CourseName="",CourseCompany="",CourseType="";
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

	public String search(){
		
		
		List<TCourse> mylist;
//		ActionContext.getContext().getValueStack().set("mylist", mylist);
		
		CourseName = course.getName();
		CourseCompany = course.getCompany();
		CourseType = course.getType();
		if("".equals(course.getName())&&"".equals(course.getCompany())&&"".equals(course.getType())){
			CourseName = "";
			CourseCompany = "";
			CourseType = "";
			pno=1;
			
			mylist=service.myCourse();
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			mylist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("mylist", mylist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}else if((CourseName!=null)||(CourseCompany!=null)||(CourseType!=null)){
			pno=1;
			
			mylist=service.SearchMyCourse(course.getName(),course.getCompany(),course.getType());
			
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			
			mylist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("mylist", mylist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}else{
			CourseName = "";
			CourseCompany = "";
			CourseType = "";
			pno=1;
			
			mylist=service.myCourse();
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			mylist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("mylist", mylist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}
		
		return "NOT";
	}
	
	public String PageChange(){
		ActionContext act = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)act.get(ServletActionContext.HTTP_REQUEST);
		pno = (Integer)request.getAttribute("pno");
		
		List<TCourse> mylist;
		
		if("".equals(CourseName)&&"".equals(CourseCompany)&&"".equals(CourseType)){
//			System.out.println("\n\n\npageChange #all\n\n\n");
			
			mylist=service.myCourse();
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			
			mylist = pageservice.getCurrentPage();
			ActionContext.getContext().getValueStack().set("mylist", mylist);
			
			int totalpage = pageservice.getTotalPage();
			List<Integer> pagelist= new ArrayList<Integer>();
			for(int i=1;i<=totalpage;++i) {pagelist.add(i);}
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
		}else{
			System.out.println("\n\n\npageChange #Search\n\n\n");
			
			mylist=service.SearchMyCourse(CourseName,CourseCompany,CourseType);
			String hql = service.getHQL();
			pageservice.setHQL(pno, hql);
			
			mylist = pageservice.getCurrentPage();
			int totalpage = pageservice.getTotalPage();
			
			List<Integer> pagelist=new ArrayList<Integer>();
			for(int i=1;i<=Math.min(totalpage,MAX_PAGE_NUMBER);++i) {pagelist.add(i);}
			
			ActionContext.getContext().getValueStack().set("pagelist", pagelist);
			ActionContext.getContext().getValueStack().set("mylist", mylist);
			
			
			Integer currentPage = pageservice.getPage().getCurrentPage();
			ActionContext.getContext().getValueStack().set("currentPage", currentPage);
			
			
//			ActionContext.getContext().getValueStack().set("list", courselist);
		}
		
		return "NOT";
	}
	
	@Override
	public TCourse getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	
}
