package com.service;

import java.util.List;

import com.bean.FMsgPage;
import com.bean.Message;
import com.dao.TForumMsgDao;
import com.dao.TForumMsgPageDao;
import com.dao.TForumUserDao;
import com.entity.TMessage;
import com.entity.TUser;

public class TForumMsgService<T> {
	private TForumMsgDao tforummsgdao;  
	private TForumMsgPageDao tforummsgpagedao;

	public void setTForumMsgDao(TForumMsgDao tforummsgdao) {
		this.tforummsgdao = tforummsgdao;
	}
	
	public void setTForumMsgPageDao(TForumMsgPageDao tforummsgpagedao) {
		this.tforummsgpagedao = tforummsgpagedao;
	}

	public List<TMessage> allMsg(){
		return tforummsgdao.allMsg();
	}
    
	public List<TMessage> mySdMsg(int uid,int ye){
		return tforummsgdao.mySdMsg(uid,ye);
	}
	
	public List<TMessage> myReMsg(int uid,int ye){
		return tforummsgdao.myRdMsg(uid,ye);
	}
	
	public TMessage smsginfo(int id) {
		return tforummsgdao.smsginfo(id);
	}
	
	public TMessage rmsginfo(int id) {
		return tforummsgdao.rmsginfo(id);
	}
	
	public void sendmsg(TMessage msg) {
		tforummsgdao.sendmsg(msg);
	}
	
	public void deletemsg(int id,int wei) {
		tforummsgdao.deletemsg(id,wei);
	}
	
	public FMsgPage sendmsgpage(int uid) {
		return tforummsgpagedao.sendmsgpage(uid);
	}
	
	public FMsgPage receivemsgpage(int uid) {
		return tforummsgpagedao.receivemsgpage(uid);
	}
	
}
