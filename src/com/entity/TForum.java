package com.entity;

import java.util.Set;

/**
 * TForum entity. @author MyEclipse Persistence Tools
 */
public class TForum extends AbstractTForum implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TForum() {
	}

	/** full constructor */
	public TForum(String name, String topic, Set TPosts) {
		super(name, topic, TPosts);
	}

}
