package com.entity;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.sourceforge.jtds.jdbc.DateTime;

/**
 * AbstractTCourse entity provides the base persistence definition of the
 * TCourse entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private TCategory TCategory;
	private String name;
	private String type;
	private String content;
	private String author;
	private String company;
	private Integer learnCount;
	private Timestamp distributeDate;
	private Integer loadCount;
	private Integer flag;
	private String dataurl;
	private Set TUserCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTCourse() {
	}

	/** minimal constructor */
	public AbstractTCourse(TCategory TCategory) {
		this.TCategory = TCategory;
	}

	/** full constructor */
	public AbstractTCourse(TCategory TCategory, String name, String type,
			String content, String author, String company, Integer learnCount,
			Timestamp distributeDate, Integer loadCount, Integer flag,
			String dataurl, Set TUserCourses) {
		this.TCategory = TCategory;
		this.name = name;
		this.type = type;
		this.content = content;
		this.author = author;
		this.company = company;
		this.learnCount = learnCount;
		this.distributeDate = distributeDate;
		this.loadCount = loadCount;
		this.flag = flag;
		this.dataurl = dataurl;
		this.TUserCourses = TUserCourses;
	}
	
	public AbstractTCourse(String name,Integer id,String type,String author, String company,Integer loadCount){
		this.name = name;
		this.id=id;
		this.type = type;
		this.author = author;
		this.company = company;
		this.loadCount = loadCount;
	}
	
	public AbstractTCourse(String name,String type,String author, String company,Integer loadCount){
		this.name = name;
		this.type = type;
		this.author = author;
		this.company = company;
		this.loadCount = loadCount;
	}
	
	public AbstractTCourse(String name,Integer id,String type,String author, String company,Integer loadCount,String dataurl){
		this.name = name;
		this.id=id;
		this.type = type;
		this.author = author;
		this.company = company;
		this.loadCount = loadCount;
		this.dataurl=dataurl;
	}
	
	public AbstractTCourse(String name,Integer id,String type,String author, String company,Integer loadCount,String dataurl,String distributeDate){
		this.name = name;
		this.id=id;
		this.type = type;
		this.author = author;
		this.company = company;
		this.loadCount = loadCount;
		this.dataurl=dataurl;
		
//		DateFormat fomatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date disdate=new Date();
//		try {
//			disdate =  fomatDate.parse(distributeDate);
//			System.out.println(" date : "+distributeDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String distributeTimeStr=df.format(disdate);
		this.distributeDate=Timestamp.valueOf(distributeDate);
	}
	
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TCategory getTCategory() {
		return this.TCategory;
	}

	public void setTCategory(TCategory TCategory) {
		this.TCategory = TCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getLearnCount() {
		return this.learnCount;
	}

	public void setLearnCount(Integer learnCount) {
		this.learnCount = learnCount;
	}

	public Timestamp getDistributeDate() {
		return this.distributeDate;
	}

	public void setDistributeDate(Timestamp distributeDate) {
		this.distributeDate = distributeDate;
	}

	public Integer getLoadCount() {
		return this.loadCount;
	}

	public void setLoadCount(Integer loadCount) {
		this.loadCount = loadCount;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getDataurl() {
		return this.dataurl;
	}

	public void setDataurl(String dataurl) {
		this.dataurl = dataurl;
	}

	public Set getTUserCourses() {
		return this.TUserCourses;
	}

	public void setTUserCourses(Set TUserCourses) {
		this.TUserCourses = TUserCourses;
	}

}