package com.entity;

import java.sql.Timestamp;

/**
 * TMessage entity. @author MyEclipse Persistence Tools
 */
public class TMessage extends AbstractTMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMessage() {
	}

	/** minimal constructor */
	public TMessage(TUser TUserByReceiveId, TUser TUserBySendId) {
		super(TUserByReceiveId, TUserBySendId);
	}

	/** full constructor */
	public TMessage(TUser TUserByReceiveId, TUser TUserBySendId, String name,
			String content, Integer flag, Timestamp senddate, String status) {
		super(TUserByReceiveId, TUserBySendId, name, content, flag, senddate,
				status);
	}

}
