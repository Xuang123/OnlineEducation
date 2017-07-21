package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTUser entity provides the base persistence definition of the TUser
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TRole TRole;
	private String name;
	private String regname;
	private String nickname;
	private String city;
	private String telphone;
	private String phone;
	private String email;
	private String content;
	private String signature;
	private Timestamp regdate;
	private Timestamp logdate;
	private Timestamp upddate;
	private String showflag;
	private Integer flag;
	private Integer post;
	private Integer watch;
	private String operate;
	private String password;
	private Double point;
	private String avatar;
	private Set TMessagesForReceiveId = new HashSet(0);
	private Set TPostsForReUserId = new HashSet(0);
	private Set TMessagesForSendId = new HashSet(0);
	private Set TUserExamQuestions = new HashSet(0);
	private Set TUserExams = new HashSet(0);
	private Set TUserCourses = new HashSet(0);
	private Set TUserPosts = new HashSet(0);
	private Set TPostsForUserId = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTUser() {
	}

	/** full constructor */
	public AbstractTUser(TRole TRole, String name, String regname,
			String nickname, String city, String telphone, String phone,
			String email, String content, String signature, Timestamp regdate,
			Timestamp logdate, Timestamp upddate, String showflag,
			Integer flag, Integer post, Integer watch, String operate,
			String password, Double point, String avatar,
			Set TMessagesForReceiveId, Set TPostsForReUserId,
			Set TMessagesForSendId, Set TUserExamQuestions, Set TUserExams,
			Set TUserCourses, Set TUserPosts, Set TPostsForUserId) {
		this.TRole = TRole;
		this.name = name;
		this.regname = regname;
		this.nickname = nickname;
		this.city = city;
		this.telphone = telphone;
		this.phone = phone;
		this.email = email;
		this.content = content;
		this.signature = signature;
		this.regdate = regdate;
		this.logdate = logdate;
		this.upddate = upddate;
		this.showflag = showflag;
		this.flag = flag;
		this.post = post;
		this.watch = watch;
		this.operate = operate;
		this.password = password;
		this.point = point;
		this.avatar = avatar;
		this.TMessagesForReceiveId = TMessagesForReceiveId;
		this.TPostsForReUserId = TPostsForReUserId;
		this.TMessagesForSendId = TMessagesForSendId;
		this.TUserExamQuestions = TUserExamQuestions;
		this.TUserExams = TUserExams;
		this.TUserCourses = TUserCourses;
		this.TUserPosts = TUserPosts;
		this.TPostsForUserId = TPostsForUserId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegname() {
		return this.regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Timestamp getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getLogdate() {
		return this.logdate;
	}

	public void setLogdate(Timestamp logdate) {
		this.logdate = logdate;
	}

	public Timestamp getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}

	public String getShowflag() {
		return this.showflag;
	}

	public void setShowflag(String showflag) {
		this.showflag = showflag;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getPost() {
		return this.post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Integer getWatch() {
		return this.watch;
	}

	public void setWatch(Integer watch) {
		this.watch = watch;
	}

	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getPoint() {
		return this.point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set getTMessagesForReceiveId() {
		return this.TMessagesForReceiveId;
	}

	public void setTMessagesForReceiveId(Set TMessagesForReceiveId) {
		this.TMessagesForReceiveId = TMessagesForReceiveId;
	}

	public Set getTPostsForReUserId() {
		return this.TPostsForReUserId;
	}

	public void setTPostsForReUserId(Set TPostsForReUserId) {
		this.TPostsForReUserId = TPostsForReUserId;
	}

	public Set getTMessagesForSendId() {
		return this.TMessagesForSendId;
	}

	public void setTMessagesForSendId(Set TMessagesForSendId) {
		this.TMessagesForSendId = TMessagesForSendId;
	}

	public Set getTUserExamQuestions() {
		return this.TUserExamQuestions;
	}

	public void setTUserExamQuestions(Set TUserExamQuestions) {
		this.TUserExamQuestions = TUserExamQuestions;
	}

	public Set getTUserExams() {
		return this.TUserExams;
	}

	public void setTUserExams(Set TUserExams) {
		this.TUserExams = TUserExams;
	}

	public Set getTUserCourses() {
		return this.TUserCourses;
	}

	public void setTUserCourses(Set TUserCourses) {
		this.TUserCourses = TUserCourses;
	}

	public Set getTUserPosts() {
		return this.TUserPosts;
	}

	public void setTUserPosts(Set TUserPosts) {
		this.TUserPosts = TUserPosts;
	}

	public Set getTPostsForUserId() {
		return this.TPostsForUserId;
	}

	public void setTPostsForUserId(Set TPostsForUserId) {
		this.TPostsForUserId = TPostsForUserId;
	}

}