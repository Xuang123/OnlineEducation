package com.entity;

import java.sql.Timestamp;

/**
 * AbstractTUserCourse entity provides the base persistence definition of the
 * TUserCourse entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUserCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private TCourse TCourse;
	private TUser TUser;
	private Integer loadCount;
	private Integer learnCount;
	private Timestamp learnDate;

	// Constructors

	/** default constructor */
	public AbstractTUserCourse() {
	}

	/** full constructor */
	public AbstractTUserCourse(TCourse TCourse, TUser TUser, Integer loadCount,
			Integer learnCount, Timestamp learnDate) {
		this.TCourse = TCourse;
		this.TUser = TUser;
		this.loadCount = loadCount;
		this.learnCount = learnCount;
		this.learnDate = learnDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TCourse getTCourse() {
		return this.TCourse;
	}

	public void setTCourse(TCourse TCourse) {
		this.TCourse = TCourse;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Integer getLoadCount() {
		return this.loadCount;
	}

	public void setLoadCount(Integer loadCount) {
		this.loadCount = loadCount;
	}

	public Integer getLearnCount() {
		return this.learnCount;
	}

	public void setLearnCount(Integer learnCount) {
		this.learnCount = learnCount;
	}

	public Timestamp getLearnDate() {
		return this.learnDate;
	}

	public void setLearnDate(Timestamp learnDate) {
		this.learnDate = learnDate;
	}

}