package com.entity;

import java.sql.Timestamp;
import java.util.Set;

/**
 * TExam entity. @author MyEclipse Persistence Tools
 */
public class TExam extends AbstractTExam implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TExam() {
	}

	/** full constructor */
	public TExam(TPaper TPaper, TCategory TCategory, String name,
			Timestamp startDate, String content, Integer mostCount,
			Timestamp endDate, Integer flag, String author, Integer examTime,
			String marker, Set TUserExams, Set TUserExamQuestions) {
		super(TPaper, TCategory, name, startDate, content, mostCount, endDate,
				flag, author, examTime, marker, TUserExams, TUserExamQuestions);
	}

}
