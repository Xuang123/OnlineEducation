package com.entity;

import java.sql.Timestamp;
import java.util.Set;

/**
 * TQuestion entity. @author MyEclipse Persistence Tools
 */
public class TQuestion extends AbstractTQuestion implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TQuestion() {
	}

	/** minimal constructor */
	public TQuestion(TCategory TCategory, String type) {
		super(TCategory, type);
	}

	/** full constructor */
	public TQuestion(TCategory TCategory, String name, Integer level,
			String answer, String content, Timestamp addDate, String author,
			String type, Double score, Set TUserExamQuestions,
			Set TPaperQuestions, Set TParts) {
		super(TCategory, name, level, answer, content, addDate, author, type,
				score, TUserExamQuestions, TPaperQuestions, TParts);
	}

}
