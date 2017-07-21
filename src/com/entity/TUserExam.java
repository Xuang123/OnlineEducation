package com.entity;

import java.sql.Timestamp;

/**
 * TUserExam entity. @author MyEclipse Persistence Tools
 */
public class TUserExam extends AbstractTUserExam implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUserExam() {
	}

	/** minimal constructor */
	public TUserExam(TExam TExam, TUser TUser) {
		super(TExam, TUser);
	}

	/** full constructor */
	public TUserExam(TExam TExam, TUser TUser, Double zscore, Integer count,
			Timestamp takeDate, Double kscore) {
		super(TExam, TUser, zscore, count, takeDate, kscore);
	}

}
