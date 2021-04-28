package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.JSONEntity.MessageJson;
import com.example.outreach_portal.JSONEntity.RecentMessageJson;
import com.example.outreach_portal.bean.Message;
import com.example.outreach_portal.bean.User;

public interface MessageService {
	public List<Message>getMsg(FriendJson friend);
	public List<RecentMessageJson> getRecentMsg(int user_id);
	
	public void sendMessage(MessageJson msg);
	public void recieveMessgae(FriendJson friend);
}
