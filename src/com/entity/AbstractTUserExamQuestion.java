package com.entity;

/**
 * AbstractTUserExamQuestion entity provides the base persistence definition of
 * the TUserExamQuestion entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUserExamQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private TQuestion TQuestion;
	private TUser TUser;
	private String answer;
	private Double score;

	// Constructors

	/** default constructor */
	public AbstractTUserExamQuestion() {
	}

	/** minimal constructor */
	public AbstractTUserExamQuestion(TExam TExam, TQuestion TQuestion,
			TUser TUser) {
		this.TExam = TExam;
		this.TQuestion = TQuestion;
		this.TUser = TUser;
	}

	/** full constructor */
	public AbstractTUserExamQuestion(TExam TExam, TQuestion TQuestion,
			TUser TUser, String answer, Double score) {
		this.TExam = TExam;
		this.TQuestion = TQuestion;
		this.TUser = TUser;
		this.answer = answer;
		this.score = score;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TExam getTExam() {
		return this.TExam;
	}

	public void setTExam(TExam TExam) {
		this.TExam = TExam;
	}

	public TQuestion getTQuestion() {
		return this.TQuestion;
	}

	public void setTQuestion(TQuestion TQuestion) {
		this.TQuestion = TQuestion;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}