package com.example.outreach_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.FriendService;

@CrossOrigin(origins="*")
@RestController
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@PostMapping(path="/friendReq")
	public ResponseEntity<?> friendReq(@RequestBody FriendJson friend)
	{
		try
		{
			this.friendService.friendRequestSend(friend);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/friendAcc")
	public ResponseEntity<?> friendAcc(@RequestBody FriendJson friend)
	{
		try
		{
			this.friendService.friendRequestAccept(friend);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/friends")
	public ResponseEntity<?> getFriend(@RequestBody String user_id)
	{
		try
		{
			List<User> users = this.friendService.getFriends(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/unfriend")
	public ResponseEntity<?> unFriend(@RequestBody FriendJson friend)
	{
		try
		{
			this.friendService.unfriend(friend);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/checkFriend")
	public ResponseEntity<?> checkfriend(@RequestBody FriendJson friend)
	{
	
			int status = this.friendService.checkStatus(friend);
			
			return new ResponseEntity<>(status,HttpStatus.OK);

	}
	
	
}
