package com.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Message {
	private Integer id;
	private String sendname;
	private String receivename;
	private String name;
	private String content;
	private Timestamp senddate;
	
	public Message() {
	}
	
	public Message(Integer id, String sendname, String receivename, String name, String content, Timestamp senddate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.id = id;
		this.sendname = sendname;
		this.receivename = receivename;
		this.name = name;
		this.content = content;
		this.senddate = Timestamp.valueOf(df.format(senddate));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSenddate() {
		return senddate;
	}

	public void setSenddate(Timestamp senddate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.senddate = Timestamp.valueOf(df.format(senddate));
	}
	
}
