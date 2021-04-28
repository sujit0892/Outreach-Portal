package com.example.outreach_portal.JSONEntity;

import com.example.outreach_portal.bean.Message;
import com.example.outreach_portal.bean.User;

public class RecentMessageJson {
	
	private User user;
	private Message msg;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Message getMsg() {
		return msg;
	}
	public void setMsg(Message msg) {
		this.msg = msg;
	}
	public RecentMessageJson(User user, Message msg) {
		super();
		this.user = user;
		this.msg = msg;
	}
	
	
	
}
