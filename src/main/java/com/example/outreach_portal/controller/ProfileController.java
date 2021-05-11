package com.example.outreach_portal.controller;

import org.springframework.web.bind.annotation.*;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.ProfileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins="*")
@RestController
public class ProfileController {

	
	@Autowired
	public ProfileService profileService;
	
	
	@PostMapping(path="/Profile")
	public ResponseEntity<?> getUser(@RequestBody String user_id)
	{
		try
		{
			
			User user = this.profileService.getUser(Integer.parseInt(user_id));
		
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/Search/{key}")
	public ResponseEntity<?> search(@PathVariable String key)
	{
		try
		{
			
			List<User> user = this.profileService.search(key);
			
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	

	
	@PostMapping(path="/createUser",consumes = "application/JSON")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user)
	{
		try
		{

			this.profileService.createProfile(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/login",consumes = "application/JSON")
	public ResponseEntity<?> login(@RequestBody LoginJson loginDetail)
	{
		try
		{

			int user_id = this.profileService.login(loginDetail);
			return new ResponseEntity<>(user_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			
			return new ResponseEntity<>(-1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/notification")
	public ResponseEntity<?> notification(@RequestBody String user_id)
	{
		try
		{
			
			List<Notification> notification = this.profileService.getNotifiaction(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(notification,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/uodateNotification")
	public ResponseEntity<?> updatenotification(@RequestBody String user_id)
	{
		try
		{
			
			this.profileService.updateNotification(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(path="/getNotificationStat")
	public ResponseEntity<?> getNotificationStat(@RequestBody String user_id)
	{
		try
		{
			
			int stat = this.profileService.getNotificationStat(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(stat,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/updateProfilePic")
	public ResponseEntity<?> UpdateProfilePic(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			
			this.profileService.updateProfilePic(user);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			
			this.profileService.updatePassword(user);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateAbout")
	public ResponseEntity<?> updateAbout(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			
			this.profileService.updateAbout(user);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateInterest")
	public ResponseEntity<?> updateInterest(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			
			this.profileService.updateInterest(user);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
