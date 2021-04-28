package com.example.outreach_portal.controller;

import org.springframework.web.bind.annotation.*;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.ProfileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



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
			System.out.println(user.getUser_id());
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
	
	@PutMapping("/updateProfile")
	public ResponseEntity<?> UpdateProfile(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			
			this.profileService.updateProfile(user);
			
			return new ResponseEntity<>(HttpStatus.OK);
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
			
			return new ResponseEntity<>(1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
