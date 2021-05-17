package com.example.outreach_portal.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.GroupJson;
import com.example.outreach_portal.JSONEntity.GroupMessageJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMessage;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.GroupService;

@CrossOrigin(origins="*")
@RestController
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping(path="/group/{group_id}")
	public ResponseEntity<?> getGroupInfo(@PathVariable String group_id)
	{
		try
		{
			Group group = this.groupService.getGroupInfo(Integer.parseInt(group_id));
			
			return new ResponseEntity<>(group,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/getUserGroup/{user_id}")
	public ResponseEntity<?> getUsergroup(@PathVariable String user_id)
	{
		try
		{
			List<Group> group = this.groupService.getUserGroup(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(group,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/groupMember/{group_id}")
	public ResponseEntity<?> getGroupMembers(@PathVariable String group_id)
	{
		try
		{
			List<User> user = this.groupService.getGroupMember(Integer.parseInt(group_id));
			
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/recentGroup/{user_id}")
	public ResponseEntity<?> getRecentGroup(@PathVariable String user_id)
	{
		try
		{
			Set<Group>group = this.groupService.getRecentGroup(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(group,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/getGroupMessage")
	public ResponseEntity<?> getGroupMessage(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			List<GroupMessage> group = this.groupService.getGroupMessage(groupJson);
			
			return new ResponseEntity<>(group,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/sendGroupMessage")
	public ResponseEntity<?> sendMessage(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			this.groupService.sendmessage(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/recieveGroupMessage")
	public ResponseEntity<?> recieveMessage(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			this.groupService.recievemessage(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/addGroupMemebr")
	public ResponseEntity<?> addGroupMemebr(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			this.groupService.addGroupMemeber(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/leaveGroup")
	public ResponseEntity<?> leaveGroup(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			this.groupService.leaveGroup(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/isMemebr")
	public ResponseEntity<?> isMemebr(@RequestBody GroupMessageJson groupJson)
	{
		try
		{
			this.groupService.isMember(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/createGrp")
	public ResponseEntity<?> createGrp(@RequestBody GroupJson groupJson)
	{
		try
		{
			this.groupService.createGroup(groupJson);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	
	
	
	
	

}
