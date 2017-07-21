package com.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.FUser;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TForumUserService;

public class ForumUserAction extends ActionSupport implements ModelDriven<TUser> {

	private TUser user = new TUser();
	// private SessionFactory factory;
	private TForumUserService<TUser> service;
	// private Map<String, Object> session;
	// private Map<String,Object> request;

	// public void setFactory(SessionFactory factory){
	// this.factory=factory;
	// }
	// public SessionFactory getFactory(){
	// return factory;
	// }
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void setService(TForumUserService<TUser> service) {
		this.service = service;
	}

	public TForumUserService<TUser> getService() {
		return service;
	}

	public String searchinfo() {

		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			FUser usertemp = new FUser();
			usertemp = (FUser) ActionContext.getContext().getSession().get("forumuser");
			user = service.myInfo(usertemp.getId());
			ActionContext.getContext().getValueStack().set("fuserinfo", user);
		}
		return "success";
	}

	public String searchotherinfo() {
		try {
			int id = Integer.parseInt(request.getParameter("uid"));
			user = service.myInfo(id);
			ActionContext.getContext().getValueStack().set("fuserinfo", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	public String editinfo() {

		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			FUser ut = (FUser) ActionContext.getContext().getSession().get("forumuser");
			user = service.myInfo(ut.getId());
			ActionContext.getContext().getValueStack().set("fuserinfo", user);
			return "success";
		}else
			return null;
		
	}

	public String updateinfo() {

		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			FUser ut = (FUser) ActionContext.getContext().getSession().get("forumuser");
			user.setId(ut.getId());
			String sp = request.getParameter("showphone");
			String sc = request.getParameter("showcity");
			if (sp.equals("yes"))
				user.setShowflag("1");
			else
				user.setShowflag("0");

			if (sc.equals("yes"))
				user.setShowflag(user.getShowflag() + "1");
			else
				user.setShowflag(user.getShowflag() + "0");

			service.updateInfo(user);
			ActionContext.getContext().getValueStack().set("userinfo", user);
			System.out.println("0000");
			return "success";
		}else
			return null;
	}

	@Override
	public TUser getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
