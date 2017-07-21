package com.entity;

/**
 * AbstractTUserPost entity provides the base persistence definition of the
 * TUserPost entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUserPost implements java.io.Serializable {

	// Fields

	private Integer id;
	private TPost TPost;
	private TUser TUser;

	// Constructors

	/** default constructor */
	public AbstractTUserPost() {
	}

	/** full constructor */
	public AbstractTUserPost(TPost TPost, TUser TUser) {
		this.TPost = TPost;
		this.TUser = TUser;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TPost getTPost() {
		return this.TPost;
	}

	public void setTPost(TPost TPost) {
		this.TPost = TPost;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

}