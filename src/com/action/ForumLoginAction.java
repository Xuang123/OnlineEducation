package com.action;

import com.bean.FUser;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TForumUserService;

public class ForumLoginAction extends ActionSupport implements ModelDriven<TUser> {

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

	public void setService(TForumUserService<TUser> service) {
		this.service = service;
	}

	public TForumUserService<TUser> getService() {
		return service;
	}

	public String forumlogin() {

		FUser usertemp = new FUser();

		try {
			usertemp = service.searchPassword(user.getRegname());
			if (user.getPassword().equals(usertemp.getPassword())) {
				usertemp.setPassword(null);
				ActionContext.getContext().getSession().put("forumuser", usertemp);
				return "success";
			} else {
				this.addActionError("账号或密码有误");
				return "not";
			}
		} catch (Exception e) {
			// TODO: handle exception
			this.addActionError("账号或密码有误");
			return "not";
		}

	}

	public String loginout() {
		if (ActionContext.getContext().getSession().containsKey("forumuser")) {
			ActionContext.getContext().getSession().remove("forumuser");
		}
		return "success";
	}

	@Override
	public TUser getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
