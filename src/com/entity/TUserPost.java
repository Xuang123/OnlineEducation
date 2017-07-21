package com.entity;

/**
 * TUserPost entity. @author MyEclipse Persistence Tools
 */
public class TUserPost extends AbstractTUserPost implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUserPost() {
	}

	/** full constructor */
	public TUserPost(TPost TPost, TUser TUser) {
		super(TPost, TUser);
	}

}
