package com.entity;

import java.sql.Timestamp;
import java.util.Set;

/**
 * TPaper entity. @author MyEclipse Persistence Tools
 */
public class TPaper extends AbstractTPaper implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPaper() {
	}

	/** minimal constructor */
	public TPaper(TCategory TCategory) {
		super(TCategory);
	}

	/** full constructor */
	public TPaper(TCategory TCategory, String name, Double score,
			Timestamp addDate, String content, Integer flag, String author,
			Set TPaperQuestions, Set TExams) {
		super(TCategory, name, score, addDate, content, flag, author,
				TPaperQuestions, TExams);
	}

}
