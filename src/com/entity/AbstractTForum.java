package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTForum entity provides the base persistence definition of the TForum
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTForum implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String topic;
	private Set TPosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTForum() {
	}

	/** full constructor */
	public AbstractTForum(String name, String topic, Set TPosts) {
		this.name = name;
		this.topic = topic;
		this.TPosts = TPosts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Set getTPosts() {
		return this.TPosts;
	}

	public void setTPosts(Set TPosts) {
		this.TPosts = TPosts;
	}

}