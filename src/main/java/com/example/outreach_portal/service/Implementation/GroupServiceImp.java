package com.example.outreach_portal.service.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.GroupMessageJson;
import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMembers;
import com.example.outreach_portal.bean.GroupMessage;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.GroupDao;
import com.example.outreach_portal.dao.GroupMemberDao;
import com.example.outreach_portal.dao.GroupMessageDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.GroupService;

@Service
public class GroupServiceImp implements GroupService{
	
	
	
	@Autowired
	GroupDao groupDao;
	
	@Autowired
	GroupMemberDao groupMemberDao;
	
	@Autowired
	GroupMessageDao groupMessageDao;
	
	@Autowired
	ProfileDao profileDao;

	@Override
	public Group getGroupInfo(int group_id) {
		
		return groupDao.findById(group_id).get();
	}

	@Override
	public List<Group> getUserGroup(int user_id) {
		// TODO Auto-generated method stub
		User user  = profileDao.findById(user_id).get();
		return groupMemberDao.getUserGroup(user);
	}

	@Override
	public List<User> getGroupMember(int group_id) {
		// TODO Auto-generated method stub
		Group group = groupDao.findById(group_id).get();
		return groupMemberDao.getGroupMember(group);
	}

	@Override
	public List<Group> getRecentGroup(int user_id) {
		// TODO Auto-generated method stub
		User user  = profileDao.findById(user_id).get();
		return groupMessageDao.getRecentGroup(user);
	}

	@Override
	public List<GroupMessage> getGroupMessage(GroupMessageJson groupJson) {
		// TODO Auto-generated method stub
		User user  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		return groupMessageDao.getGroupMessage(group, user);
	}

	@Override
	public void sendmessage(GroupMessageJson groupJson) {
		// TODO Auto-generated method stub
		User sender  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		List<User> recivers = groupMemberDao.getGroupMember(group);
		for(User rec:recivers)
		{
			if(rec.getUser_id()!=sender.getUser_id())
			{
				GroupMessage msg = new GroupMessage(sender,rec,group,groupJson.getMessage(),0,new Date());
				groupMessageDao.save(msg);
			}
		}
		
	}

	@Override
	public void recievemessage(GroupMessageJson groupJson) {
		
		User rec  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		groupMessageDao.recieveMsg(rec, group);
	}

	@Override
	public void addGroupMemeber(GroupMessageJson groupJson) {
		User rec  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		GroupMembers m = new GroupMembers(rec,group,1);
		groupMemberDao.save(m);
		sendmessage(groupJson);
		
		
	}

	@Override
	public void leaveGroup(GroupMessageJson groupJson) {
		// TODO Auto-generated method stub
		User rec  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		groupMemberDao.leaveGroup(rec, group);
		
	}

	@Override
	public int isMember(GroupMessageJson groupJson) {
		User rec  = profileDao.findById(groupJson.getUser_id()).get();
		Group group = groupDao.findById(groupJson.getGroup_id()).get();
		String r = groupMemberDao.isMember(group, rec);
		if(r==null)
			return 0;
		return 1;
	}

	

}
