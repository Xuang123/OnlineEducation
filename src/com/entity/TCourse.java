package com.entity;

import java.sql.Timestamp;
import java.util.Set;

import net.sourceforge.jtds.jdbc.DateTime;

/**
 * TCourse entity. @author MyEclipse Persistence Tools
 */
public class TCourse extends AbstractTCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TCourse() {
	}

	/** minimal constructor */
	public TCourse(TCategory TCategory) {
		super(TCategory);
	}

	/** full constructor */
	public TCourse(TCategory TCategory, String name, String type,
			String content, String author, String company, Integer learnCount,
			Timestamp distributeDate, Integer loadCount, Integer flag,
			String dataurl, Set TUserCourses) {
		super(TCategory, name, type, content, author, company, learnCount,
				distributeDate, loadCount, flag, dataurl, TUserCourses);
	}
	
	public TCourse(String name, String type,String author, String company,Integer loadCount){
		super(name,  type, author,  company, loadCount);
	}
	
	public TCourse(String name, Integer id,String type,String author, String company,Integer loadCount){
		super(name, id, type, author,  company, loadCount);
	}
	
	public TCourse(String name, Integer id,String type,String author, String company,Integer loadCount,String dataurl){
		super(name, id, type, author,  company, loadCount,dataurl);
	}
	public TCourse(String name, Integer id,String type,String author, String company,Integer loadCount,String dataurl,String  distributeDate){
		super(name, id, type, author,  company, loadCount,dataurl,distributeDate);
	}
}
