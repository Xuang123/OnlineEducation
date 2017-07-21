package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTQuestion entity provides the base persistence definition of the
 * TQuestion entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private TCategory TCategory;
	private String name;
	private Integer level;
	private String answer;
	private String content;
	private Timestamp addDate;
	private String author;
	private String type;
	private Double score;
	private Set TUserExamQuestions = new HashSet(0);
	private Set TPaperQuestions = new HashSet(0);
	private Set TParts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTQuestion() {
	}

	/** minimal constructor */
	public AbstractTQuestion(TCategory TCategory, String type) {
		this.TCategory = TCategory;
		this.type = type;
	}

	/** full constructor */
	public AbstractTQuestion(TCategory TCategory, String name, Integer level,
			String answer, String content, Timestamp addDate, String author,
			String type, Double score, Set TUserExamQuestions,
			Set TPaperQuestions, Set TParts) {
		this.TCategory = TCategory;
		this.name = name;
		this.level = level;
		this.answer = answer;
		this.content = content;
		this.addDate = addDate;
		this.author = author;
		this.type = type;
		this.score = score;
		this.TUserExamQuestions = TUserExamQuestions;
		this.TPaperQuestions = TPaperQuestions;
		this.TParts = TParts;
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Set getTUserExamQuestions() {
		return this.TUserExamQuestions;
	}

	public void setTUserExamQuestions(Set TUserExamQuestions) {
		this.TUserExamQuestions = TUserExamQuestions;
	}

	public Set getTPaperQuestions() {
		return this.TPaperQuestions;
	}

	public void setTPaperQuestions(Set TPaperQuestions) {
		this.TPaperQuestions = TPaperQuestions;
	}

	public Set getTParts() {
		return this.TParts;
	}

	public void setTParts(Set TParts) {
		this.TParts = TParts;
	}

}