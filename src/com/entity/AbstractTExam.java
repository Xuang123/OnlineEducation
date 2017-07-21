package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTExam entity provides the base persistence definition of the TExam
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTExam implements java.io.Serializable {

	// Fields

	private Integer id;
	private TPaper TPaper;
	private TCategory TCategory;
	private String name;
	private Timestamp startDate;
	private String content;
	private Integer mostCount;
	private Timestamp endDate;
	private Integer flag;
	private String author;
	private Integer examTime;
	private String marker;
	private Set TUserExams = new HashSet(0);
	private Set TUserExamQuestions = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTExam() {
	}

	/** full constructor */
	public AbstractTExam(TPaper TPaper, TCategory TCategory, String name,
			Timestamp startDate, String content, Integer mostCount,
			Timestamp endDate, Integer flag, String author, Integer examTime,
			String marker, Set TUserExams, Set TUserExamQuestions) {
		this.TPaper = TPaper;
		this.TCategory = TCategory;
		this.name = name;
		this.startDate = startDate;
		this.content = content;
		this.mostCount = mostCount;
		this.endDate = endDate;
		this.flag = flag;
		this.author = author;
		this.examTime = examTime;
		this.marker = marker;
		this.TUserExams = TUserExams;
		this.TUserExamQuestions = TUserExamQuestions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TPaper getTPaper() {
		return this.TPaper;
	}

	public void setTPaper(TPaper TPaper) {
		this.TPaper = TPaper;
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

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getMostCount() {
		return this.mostCount;
	}

	public void setMostCount(Integer mostCount) {
		this.mostCount = mostCount;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getExamTime() {
		return this.examTime;
	}

	public void setExamTime(Integer examTime) {
		this.examTime = examTime;
	}

	public String getMarker() {
		return this.marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public Set getTUserExams() {
		return this.TUserExams;
	}

	public void setTUserExams(Set TUserExams) {
		this.TUserExams = TUserExams;
	}

	public Set getTUserExamQuestions() {
		return this.TUserExamQuestions;
	}

	public void setTUserExamQuestions(Set TUserExamQuestions) {
		this.TUserExamQuestions = TUserExamQuestions;
	}

}