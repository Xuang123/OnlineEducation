package com.entity;

import java.sql.Timestamp;

/**
 * AbstractTUserExam entity provides the base persistence definition of the
 * TUserExam entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUserExam implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private TUser TUser;
	private Double zscore;
	private Integer count;
	private Timestamp takeDate;
	private Double kscore;

	// Constructors

	/** default constructor */
	public AbstractTUserExam() {
	}

	/** minimal constructor */
	public AbstractTUserExam(TExam TExam, TUser TUser) {
		this.TExam = TExam;
		this.TUser = TUser;
	}

	/** full constructor */
	public AbstractTUserExam(TExam TExam, TUser TUser, Double zscore,
			Integer count, Timestamp takeDate, Double kscore) {
		this.TExam = TExam;
		this.TUser = TUser;
		this.zscore = zscore;
		this.count = count;
		this.takeDate = takeDate;
		this.kscore = kscore;
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

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Double getZscore() {
		return this.zscore;
	}

	public void setZscore(Double zscore) {
		this.zscore = zscore;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getTakeDate() {
		return this.takeDate;
	}

	public void setTakeDate(Timestamp takeDate) {
		this.takeDate = takeDate;
	}

	public Double getKscore() {
		return this.kscore;
	}

	public void setKscore(Double kscore) {
		this.kscore = kscore;
	}

}