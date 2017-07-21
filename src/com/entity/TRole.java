package com.entity;

import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */
public class TRole extends AbstractTRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** full constructor */
	public TRole(String name, String content, Set TUsers) {
		super(name, content, TUsers);
	}

}
