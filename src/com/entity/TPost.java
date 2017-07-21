package com.entity;

import java.sql.Timestamp;
import java.util.Set;

/**
 * TPost entity. @author MyEclipse Persistence Tools
 */
public class TPost extends AbstractTPost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPost() {
	}

	/** minimal constructor */
	public TPost(TForum TForum) {
		super(TForum);
	}

	/** full constructor */
	public TPost(TUser TUserByReUserId, TForum TForum, TUser TUserByUserId,
			Integer pid, String name, String content, Timestamp publishDate,
			Integer flag, Integer viewcount, Set TUserPosts) {
		super(TUserByReUserId, TForum, TUserByUserId, pid, name, content,
				publishDate, flag, viewcount, TUserPosts);
	}

}
