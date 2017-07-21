package com.entity;

/**
 * TUserExamQuestion entity. @author MyEclipse Persistence Tools
 */
public class TUserExamQuestion extends AbstractTUserExamQuestion implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUserExamQuestion() {
	}

	/** minimal constructor */
	public TUserExamQuestion(TExam TExam, TQuestion TQuestion, TUser TUser) {
		super(TExam, TQuestion, TUser);
	}

	/** full constructor */
	public TUserExamQuestion(TExam TExam, TQuestion TQuestion, TUser TUser,
			String answer, Double score) {
		super(TExam, TQuestion, TUser, answer, score);
	}

}
