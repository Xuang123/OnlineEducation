package com.entity;

import java.sql.Timestamp;

/**
 * AbstractTMessage entity provides the base persistence definition of the
 * TMessage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUser TUserByReceiveId;
	private TUser TUserBySendId;
	private String name;
	private String content;
	private Integer flag;
	private Timestamp senddate;
	private String status;

	// Constructors

	/** default constructor */
	public AbstractTMessage() {
	}

	/** minimal constructor */
	public AbstractTMessage(TUser TUserByReceiveId, TUser TUserBySendId) {
		this.TUserByReceiveId = TUserByReceiveId;
		this.TUserBySendId = TUserBySendId;
	}

	/** full constructor */
	public AbstractTMessage(TUser TUserByReceiveId, TUser TUserBySendId,
			String name, String content, Integer flag, Timestamp senddate,
			String status) {
		this.TUserByReceiveId = TUserByReceiveId;
		this.TUserBySendId = TUserBySendId;
		this.name = name;
		this.content = content;
		this.flag = flag;
		this.senddate = senddate;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUser getTUserByReceiveId() {
		return this.TUserByReceiveId;
	}

	public void setTUserByReceiveId(TUser TUserByReceiveId) {
		this.TUserByReceiveId = TUserByReceiveId;
	}

	public TUser getTUserBySendId() {
		return this.TUserBySendId;
	}

	public void setTUserBySendId(TUser TUserBySendId) {
		this.TUserBySendId = TUserBySendId;
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

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Timestamp getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Timestamp senddate) {
		this.senddate = senddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}