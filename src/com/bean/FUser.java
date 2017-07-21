package com.bean;

public class FUser {
	private int id;
	private String regname;
	private String nickname;
	private String password;
	
	public FUser() {
	}

	public FUser(int id, String regname, String nickname, String password) {
		this.id = id;
		this.regname = regname;
		this.nickname = nickname;
		this.password = password;
	}
	
	public FUser(int id, String regname) {
		this.id = id;
		this.regname = regname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
