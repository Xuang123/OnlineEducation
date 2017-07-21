package com.entity;

/**
 * AbstractTPart entity provides the base persistence definition of the TPart
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPart implements java.io.Serializable {

	// Fields

	private Integer id;
	private TQuestion TQuestion;
	private String name;
	private String content;

	// Constructors

	/** default constructor */
	public AbstractTPart() {
	}

	/** full constructor */
	public AbstractTPart(TQuestion TQuestion, String name, String content) {
		this.TQuestion = TQuestion;
		this.name = name;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TQuestion getTQuestion() {
		return this.TQuestion;
	}

	public void setTQuestion(TQuestion TQuestion) {
		this.TQuestion = TQuestion;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}