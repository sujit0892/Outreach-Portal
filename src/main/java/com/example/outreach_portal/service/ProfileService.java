package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.JSONEntity.UpdateProfileJson;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;

public interface ProfileService {
	
	public boolean createProfile(User user);
	
	public User getUser(int user_id);
	
	public List<User> search(String Key);
	
	
	
	public int login(LoginJson loginDetail);
	
	public List<Notification> getNotifiaction(int user_id);
	
	public void updateNotification(int user_id);
	public int  getNotificationStat(int user_id);
	
	public void updateProfilePic(UpdateProfileJson data);
	public void updateAbout(UpdateProfileJson data);
	public void updateInterest(UpdateProfileJson data);
	public void updatePassword(UpdateProfileJson data);

}
