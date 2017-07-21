package com.bean;

public class FMsgPage {
	private int ye;
	private int totel;
	private int nowye;
	
	public FMsgPage() {
	}

	public FMsgPage(int totel) {
		this.totel = totel;
		this.ye=(int) Math.ceil((double)totel/10);
	}

	public int getYe() {
		return ye;
	}

	public void setYe(int ye) {
		this.ye = ye;
	}

	public int getTotel() {
		return totel;
	}

	public void setTotel(int totel) {
		this.totel = totel;
	}

	public int getNowye() {
		return nowye;
	}

	public void setNowye(int nowye) {
		this.nowye = nowye;
	}
	
}
