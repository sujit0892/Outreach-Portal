package com.example.outreach_portal.service.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.FriendDao;
import com.example.outreach_portal.dao.NotificationDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.FriendService;

@Service
public class FriendServiceImp implements FriendService {

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private FriendDao friendDao;
	
	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public boolean friendRequestSend(FriendJson friend) {
		try {
		User user1 = profileDao.findById(friend.getUser_id1()).get();
		User user2 = profileDao.findById(friend.getUser_id2()).get();
		Notification notification = new Notification(user2,user1.getName()+
				" sent you friend Request","request",new Date());
		notificationDao.save(notification);
		friendDao.save(new Friends(user1,user2,0));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}




	@Override
	public boolean friendRequestAccept(FriendJson friend) {
		try {
			User user1 = profileDao.findById(friend.getUser_id1()).get();
			User user2 = profileDao.findById(friend.getUser_id2()).get();
			
			Notification notification = new Notification(user2,user1.getName()+
					" accepted your friend Request","accept",new Date());
			notificationDao.save(notification);
			
			friendDao.save(new Friends(user1,user2,1));
			friendDao.acceptFriendreq(1, user2, user1);
			}
			catch(Exception e)
			{
				return false;
			}
			return true;
		
	}

	@Override
	public int checkStatus(FriendJson friend) {
		/*0-friendrequest send
		 * 1-friend 
		 * 3-friend pending
		 * -1 
	
		 */
		User user1 = profileDao.findById(friend.getUser_id1()).get();
		User user2 = profileDao.findById(friend.getUser_id2()).get();
		String status = friendDao.checkFriend(user1, user2);
		if(status==null)
		{
			status = friendDao.checkFriend(user2, user1);
			if(status==null)
					return -1;
			return 3;
		}
		return Integer.parseInt(status);
	}

	@Override
	public List<User> getFriends(int user_id) {
		User user1 = profileDao.findById(user_id).get();
	
		List<User> friends = friendDao.getFriend(user1);

		return friends;
	}

	@Override
	public boolean unfriend(FriendJson friend) {
		
		User user1 = profileDao.findById(friend.getUser_id1()).get();
		User user2 = profileDao.findById(friend.getUser_id2()).get();
		try
		{
			friendDao.unFriend(user1,user2);
			friendDao.unFriend(user2,user1);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	




	

}
