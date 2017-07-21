package com.entity;

import java.sql.Timestamp;

/**
 * AbstractTest entity provides the base persistence definition of the Test
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTest implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String content;
	private Timestamp testtime;

	// Constructors

	/** default constructor */
	public AbstractTest() {
	}

	/** full constructor */
	public AbstractTest(String name, String content, Timestamp testtime) {
		this.name = name;
		this.content = content;
		this.testtime = testtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getTesttime() {
		return this.testtime;
	}

	public void setTesttime(Timestamp testtime) {
		this.testtime = testtime;
	}

}