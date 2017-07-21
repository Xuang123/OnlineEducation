package com.entity;

/**
 * TPart entity. @author MyEclipse Persistence Tools
 */
public class TPart extends AbstractTPart implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPart() {
	}

	/** full constructor */
	public TPart(TQuestion TQuestion, String name, String content) {
		super(TQuestion, name, content);
	}

}
