package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTRole entity provides the base persistence definition of the TRole
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String content;
	private Set TUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTRole() {
	}

	/** full constructor */
	public AbstractTRole(String name, String content, Set TUsers) {
		this.name = name;
		this.content = content;
		this.TUsers = TUsers;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set TUsers) {
		this.TUsers = TUsers;
	}

}