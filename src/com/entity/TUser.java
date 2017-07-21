package com.entity;

import java.sql.Timestamp;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
public class TUser extends AbstractTUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(TRole TRole, String name, String regname, String nickname,
			String city, String telphone, String phone, String email,
			String content, String signature, Timestamp regdate,
			Timestamp logdate, Timestamp upddate, String showflag,
			Integer flag, Integer post, Integer watch, String operate,
			String password, Double point, String avatar,
			Set TMessagesForReceiveId, Set TPostsForReUserId,
			Set TMessagesForSendId, Set TUserExamQuestions, Set TUserExams,
			Set TUserCourses, Set TUserPosts, Set TPostsForUserId) {
		super(TRole, name, regname, nickname, city, telphone, phone, email,
				content, signature, regdate, logdate, upddate, showflag, flag,
				post, watch, operate, password, point, avatar,
				TMessagesForReceiveId, TPostsForReUserId, TMessagesForSendId,
				TUserExamQuestions, TUserExams, TUserCourses, TUserPosts,
				TPostsForUserId);
	}

}
