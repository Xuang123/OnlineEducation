package com.entity;

import java.util.Set;

/**
 * TCategory entity. @author MyEclipse Persistence Tools
 */
public class TCategory extends AbstractTCategory implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TCategory() {
	}

	/** full constructor */
	public TCategory(String name, Integer level, Integer pid, Set TExams,
			Set TQuestions, Set TCourses, Set TPapers) {
		super(name, level, pid, TExams, TQuestions, TCourses, TPapers);
	}

}
