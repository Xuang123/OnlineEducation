package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTPaper entity provides the base persistence definition of the TPaper
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPaper implements java.io.Serializable {

	// Fields

	private Integer id;
	private TCategory TCategory;
	private String name;
	private Double score;
	private Timestamp addDate;
	private String content;
	private Integer flag;
	private String author;
	private Set TPaperQuestions = new HashSet(0);
	private Set TExams = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTPaper() {
	}

	/** minimal constructor */
	public AbstractTPaper(TCategory TCategory) {
		this.TCategory = TCategory;
	}

	/** full constructor */
	public AbstractTPaper(TCategory TCategory, String name, Double score,
			Timestamp addDate, String content, Integer flag, String author,
			Set TPaperQuestions, Set TExams) {
		this.TCategory = TCategory;
		this.name = name;
		this.score = score;
		this.addDate = addDate;
		this.content = content;
		this.flag = flag;
		this.author = author;
		this.TPaperQuestions = TPaperQuestions;
		this.TExams = TExams;
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

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Set getTPaperQuestions() {
		return this.TPaperQuestions;
	}

	public void setTPaperQuestions(Set TPaperQuestions) {
		this.TPaperQuestions = TPaperQuestions;
	}

	public Set getTExams() {
		return this.TExams;
	}

	public void setTExams(Set TExams) {
		this.TExams = TExams;
	}

}