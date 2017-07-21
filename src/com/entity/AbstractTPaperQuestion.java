package com.entity;

/**
 * AbstractTPaperQuestion entity provides the base persistence definition of the
 * TPaperQuestion entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPaperQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private TPaper TPaper;
	private TQuestion TQuestion;

	// Constructors

	/** default constructor */
	public AbstractTPaperQuestion() {
	}

	/** full constructor */
	public AbstractTPaperQuestion(TPaper TPaper, TQuestion TQuestion) {
		this.TPaper = TPaper;
		this.TQuestion = TQuestion;
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

	public TQuestion getTQuestion() {
		return this.TQuestion;
	}

	public void setTQuestion(TQuestion TQuestion) {
		this.TQuestion = TQuestion;
	}

}