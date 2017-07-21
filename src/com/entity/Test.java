package com.entity;

import java.sql.Timestamp;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */
public class Test extends AbstractTest implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(String name, String content, Timestamp testtime) {
		super(name, content, testtime);
	}

}
