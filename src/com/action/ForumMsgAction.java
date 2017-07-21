package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.FMsgPage;
import com.bean.Message;
import com.bean.FUser;
import com.entity.TMessage;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TForumMsgService;
import com.service.TForumUserService;

public class ForumMsgAction extends ActionSupport implements ModelDriven<Message> {

	private TMessage msg = new TMessage();
	private Message mmsg = new Message();
	// private SessionFactory factory;
	private TForumMsgService<TMessage> service;
	private TForumUserService<TUser> tuserservice;
	// private Map<String, Object> session;
	// private Map<String,Object> request;

	// public void setFactory(SessionFactory factory){
	// this.factory=factory;
	// }
	// public SessionFactory getFactory(){
	// return factory;
	// }
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void setService(TForumMsgService<TMessage> service) {
		this.service = service;
	}

	public TForumMsgService<TMessage> getService() {
		return service;
	}
	
	public TForumUserService<TUser> getTuserservice() {
		return tuserservice;
	}

	public void setTuserservice(TForumUserService<TUser> tuserservice) {
		this.tuserservice = tuserservice;
	}

	public String sendedmsg() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {

			FUser usertemp = new FUser();
			usertemp = (FUser) ActionContext.getContext().getSession().get("forumuser");
			FMsgPage page = service.sendmsgpage(usertemp.getId());
			page.setNowye(1);
			try {
				int my = Integer.parseInt(request.getParameter("nowye"));
				int con = Integer.parseInt(request.getParameter("con"));
				if (my > 1 || my < page.getYe()) {
					if (con == 0)
						my--;
					if (con == 1)
						my++;
				}
				page.setNowye(my);
			} catch (Exception e) {
				// TODO: handle exception
			}
			List<TMessage> list = service.mySdMsg(usertemp.getId(), page.getNowye());

			ActionContext.getContext().getValueStack().set("list", list);
			ActionContext.getContext().getValueStack().set("page", page);
		}
		return "success";
	}

	public String receivedmsg() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			FUser usertemp = new FUser();
			usertemp = (FUser) ActionContext.getContext().getSession().get("forumuser");
			FMsgPage page = service.receivemsgpage(usertemp.getId());
			page.setNowye(1);
			try {
				int my = Integer.parseInt(request.getParameter("nowye"));
				int con = Integer.parseInt(request.getParameter("con"));
				if (my > 1 || my < page.getYe()) {
					if (con == 0)
						my--;
					if (con == 1)
						my++;
				}
				page.setNowye(my);
			} catch (Exception e) {
				// TODO: handle exception
			}
			List<TMessage> list = service.myReMsg(usertemp.getId(), page.getNowye());

			ActionContext.getContext().getValueStack().set("list", list);
			ActionContext.getContext().getValueStack().set("page", page);
		}

		return "success";
	}

	public String sendmsginfo() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			int id = Integer.parseInt(request.getParameter("msgid"));
			TMessage rmsg = service.smsginfo(id);
			ActionContext.getContext().getValueStack().set("fmsginfo", rmsg);
		}
		return "success";
	}

	public String receivemsginfo() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			int id = Integer.parseInt(request.getParameter("msgid"));
			TMessage rmsg = service.rmsginfo(id);
			ActionContext.getContext().getValueStack().set("fmsginfo", rmsg);

		}
		return "success";
	}

	public String fmsgdelete() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int wei = Integer.parseInt(request.getParameter("wei"));
			service.deletemsg(id,wei);
		}
		return "success";
	}

	public String fmsgsend() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			TUser tus=new TUser();
			TUser tur=new TUser();
			try {
				int iid=tuserservice.getIdByRegname(mmsg.getReceivename());
				tur.setId(iid);
				msg.setTUserByReceiveId(tur);
				FUser usertemp = (FUser) ActionContext.getContext().getSession().get("forumuser");
				tus.setId(usertemp.getId());
				msg.setTUserBySendId(tus);
				msg.setName(mmsg.getName());
				msg.setContent(mmsg.getContent());
				msg.setFlag(0);
				msg.setStatus("00");
				service.sendmsg(msg);
			} catch (Exception e) {
				// TODO: handle exception
				this.addActionError("收信人不存在");
				ActionContext.getContext().getValueStack().set("msginfo", mmsg);
				return "not";
			}
			
		}
		return "success";
	}

	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return mmsg;
	}

}
