package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.bean.User;

public interface FriendService {
	
	
	public boolean friendRequestSend(FriendJson friend);
	public boolean friendRequestAccept(FriendJson friend);
	public int checkStatus(FriendJson friend);
	public List<User> getFriends(int user_id);
	public boolean unfriend(FriendJson friend);

}
