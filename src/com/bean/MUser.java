package com.bean;

/*用户管理
 * 查找用户中显示的用户信息
 */
public class MUser 
{
	private String id,regname,name,nickname,email,regdate,logdate;
	public MUser(String id,String name,String regname,String nickname,String email,String regdate,String logdate)
	{
		this.id=id;
		this.regname=regname;
		this.name=name;
		this.nickname=nickname;
		this.email=email;
		this.regdate=regdate;
		this.logdate=logdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLogdate() {
		return logdate;
	}

	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}
	

}
