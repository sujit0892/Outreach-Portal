package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.JSONEntity.UpdateProfileJson;
import com.example.outreach_portal.bean.User;

public interface ProfileService {
	
	public boolean createProfile(User user);
	
	public User getUser(int user_id);
	
	public List<User> search(String Key);
	
	public void updateProfile(UpdateProfileJson user);
	
	public int login(LoginJson loginDetail);

}
