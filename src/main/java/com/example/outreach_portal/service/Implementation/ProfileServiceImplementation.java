package com.example.outreach_portal.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.JSONEntity.UpdateProfileJson;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.ProfileService;

@Service
public class ProfileServiceImplementation implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public boolean createProfile(User user) {
		
		profileDao.save(user);
		return true;
	}
	@Override
	public User getUser(int user_id)
	{
		return (User)profileDao.findById(user_id).get();
	}
	
	
	@Override
	public List<User> search(String key)
	{
		List<User> users = new ArrayList<>();
		User user = null;
		if(profileDao.retrieveByRoll(key)!=null)
		{
			user = profileDao.retrieveByRoll(key);
			users.add(user);
		}
		else if(profileDao.retrieveByEmail(key)!=null)
		{
			user = profileDao.retrieveByEmail(key);
			users.add(user);
		}
		else
			return profileDao.retrieveByName(key+'%');
		
		return users;
		
	}
	@Override
	public void updateProfile(UpdateProfileJson user) {
		
		profileDao.updateAbout(user.getAbout(), user.getUser_id());
		profileDao.updateInterest(user.getInterest(), user.getUser_id());
		profileDao.updateProfile_pic(user.getProfile_pic(), user.getUser_id());
		profileDao.updatePassword(user.getPassword(), user.getUser_id());
		
	}
	
	@Override
	public int login(LoginJson loginDetail)
	{
		return profileDao.login(loginDetail.getEmail(), loginDetail.getPassword());
	}
	
	
	

}
