package com.entity;

/**
 * TPaperQuestion entity. @author MyEclipse Persistence Tools
 */
public class TPaperQuestion extends AbstractTPaperQuestion implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPaperQuestion() {
	}

	/** full constructor */
	public TPaperQuestion(TPaper TPaper, TQuestion TQuestion) {
		super(TPaper, TQuestion);
	}

}
