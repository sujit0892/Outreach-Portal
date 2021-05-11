package com.example.outreach_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.JSONEntity.MessageJson;
import com.example.outreach_portal.JSONEntity.RecentMessageJson;
import com.example.outreach_portal.bean.Message;
import com.example.outreach_portal.service.MessageService;

@CrossOrigin(origins="*")
@RestController
public class MessageController {

	@Autowired
	private MessageService msgService;
	
	@GetMapping(path="/getMsg")
	public ResponseEntity<?> getMsg(@RequestBody FriendJson friend)
	{
		try
		{
			List<Message> msg = this.msgService.getMsg(friend);
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/getRecentMsg/{user_id}")
	public ResponseEntity<?> getRecentMsg(@PathVariable String user_id)
	{
		try
		{
			List<RecentMessageJson> msg = this.msgService.getRecentMsg(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/sendMessage")
	public ResponseEntity<?> friendReq(@RequestBody MessageJson msg)
	{
		try
		{
			this.msgService.sendMessage(msg);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/recieveMessage")
	public ResponseEntity<?> recieveMessage(@RequestBody FriendJson friend)
	{
		try
		{
			this.msgService.recieveMessgae(friend);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
}
