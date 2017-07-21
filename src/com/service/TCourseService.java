package com.service;



import java.util.List;

import com.dao.TCourseDao;
import com.entity.TCourse;
import com.entity.TUserCourse;


public class TCourseService<T> {
	private TCourseDao tcoursedao;  
    
	public void setTCourseDao(TCourseDao tcoursedao){
		this.tcoursedao=tcoursedao;
	}

	public List<TCourse> allCourse(){
		return tcoursedao.allCourse();
	}
    
	public List<TCourse> myCourse(){
		return tcoursedao.myCourse();
	}
	
	public boolean deleteMyCourse(Integer cid){
		return tcoursedao.deleteMyCourse(cid);
	}
	
	public boolean addMyCourse(Integer cid){
		return tcoursedao.addMyCourse(cid);
	}
	
	public List<TCourse> SearchCourse(String name,String company,String type){
		
		return tcoursedao.searchCourse(name,company,type);
	}
	public List<TCourse> SearchMyCourse(String name,String company,String type){
		return tcoursedao.searchMyCourse(name,company,type);
	}
	
	public boolean courseExist(Integer cid){
		return tcoursedao.courseExist(cid);
	}
	
	public String getHQL(){
		return tcoursedao.getHQL();
	}
}
