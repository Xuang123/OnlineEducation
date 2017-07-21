package com.entity;

import java.sql.Timestamp;

/**
 * TUserCourse entity. @author MyEclipse Persistence Tools
 */
public class TUserCourse extends AbstractTUserCourse implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUserCourse() {
	}

	/** full constructor */
	public TUserCourse(TCourse TCourse, TUser TUser, Integer loadCount,
			Integer learnCount, Timestamp learnDate) {
		super(TCourse, TUser, loadCount, learnCount, learnDate);
	}

}
