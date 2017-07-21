package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTPost entity provides the base persistence definition of the TPost
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPost implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUser TUserByReUserId;
	private TForum TForum;
	private TUser TUserByUserId;
	private Integer pid;
	private String name;
	private String content;
	private Timestamp publishDate;
	private Integer flag;
	private Integer viewcount;
	private Set TUserPosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTPost() {
	}

	/** minimal constructor */
	public AbstractTPost(TForum TForum) {
		this.TForum = TForum;
	}

	/** full constructor */
	public AbstractTPost(TUser TUserByReUserId, TForum TForum,
			TUser TUserByUserId, Integer pid, String name, String content,
			Timestamp publishDate, Integer flag, Integer viewcount,
			Set TUserPosts) {
		this.TUserByReUserId = TUserByReUserId;
		this.TForum = TForum;
		this.TUserByUserId = TUserByUserId;
		this.pid = pid;
		this.name = name;
		this.content = content;
		this.publishDate = publishDate;
		this.flag = flag;
		this.viewcount = viewcount;
		this.TUserPosts = TUserPosts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUser getTUserByReUserId() {
		return this.TUserByReUserId;
	}

	public void setTUserByReUserId(TUser TUserByReUserId) {
		this.TUserByReUserId = TUserByReUserId;
	}

	public TForum getTForum() {
		return this.TForum;
	}

	public void setTForum(TForum TForum) {
		this.TForum = TForum;
	}

	public TUser getTUserByUserId() {
		return this.TUserByUserId;
	}

	public void setTUserByUserId(TUser TUserByUserId) {
		this.TUserByUserId = TUserByUserId;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Timestamp getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getViewcount() {
		return this.viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Set getTUserPosts() {
		return this.TUserPosts;
	}

	public void setTUserPosts(Set TUserPosts) {
		this.TUserPosts = TUserPosts;
	}

}