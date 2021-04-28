package com.example.outreach_portal.service.Implementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.CommentJson;
import com.example.outreach_portal.JSONEntity.LikeJson;
import com.example.outreach_portal.JSONEntity.PostJson;
import com.example.outreach_portal.bean.Comment;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Like;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.CommentDao;
import com.example.outreach_portal.dao.CourseDao;
import com.example.outreach_portal.dao.FriendDao;
import com.example.outreach_portal.dao.LikeDao;
import com.example.outreach_portal.dao.NotificationDao;
import com.example.outreach_portal.dao.PostDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.PostService;



@Service
public class PostServiceImp implements PostService {

	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private LikeDao likeDao;
	
	@Autowired
	private CommentDao commentDao;
	
	
	@Autowired
	private FriendDao friendDao;
	
	@Autowired
	private NotificationDao notificationDao;
	
	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	public void createPost(PostJson post) {
		try
		{
			Course course = null;
			if(post.getCourse_id()!=0)
				course= courseDao.findById(post.getCourse_id()).get();
			Post newPost = new Post(profileDao.findById(post.getUser_id()).get(),post.getPost(),post.getPic(),course,post.getIsProject(),new Date());
			
			
			postDao.save(newPost);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}


	@Override
	public void like(LikeJson likeJson) {
		// TODO Auto-generated method stub
		try {
			
			
			Post post = postDao.findById(likeJson.getPost_id()).get();
			User user = profileDao.findById(likeJson.getUser_id()).get();
			Like like = new Like(post,user
					,new Date());
			Notification notification = new Notification(post.getUser(),user.getName()+
					"like your post","post",likeJson.getPost_id(),new  Date());
			notificationDao.save(notification);
			likeDao.save(like);
		}
		catch(Exception e)
		{
			
		}
	}


	@Override
	public void comment(CommentJson commentJson) {
		// TODO Auto-generated method stub
		
		try
		{
			Post post = postDao.findById(commentJson.getPost_id()).get();
			User user = profileDao.findById(commentJson.getUser_id()).get();
			Comment comment = new Comment(post,
					user,commentJson.getComment(),new Date());
			
			Notification notification = new Notification(post.getUser(),user.getName()+
					"commented on your post","post",commentJson.getPost_id(),new  Date());
			notificationDao.save(notification);
			
			commentDao.save(comment);
		}catch(Exception e)
		{
			
		}
	}


	@Override
	public List<User> viewLike(int post_id) {
		
		
		return likeDao.viewLike(postDao.findById(post_id).get());
	}


	


	@Override
	public Post getPost(int post_id) {
		// TODO Auto-generated method stub
		return postDao.findById(post_id).get();
	}


	@Override
	public List<Comment> viewComment(int post_id) {
		
		return commentDao.viewComment(postDao.findById(post_id).get());
	}


	@Override
	public List<Post> viewPost(int user_id) {
		
		return postDao.getUserPost(profileDao.findById(user_id).get());
	}


	@Override
	public List<Post> viewFriendPost(int user_id) {
		List<User> friends = friendDao.getFriend(profileDao.findById(user_id).get());
		friends.add(profileDao.findById(user_id).get());
		return postDao.getAllPost(friends);
	}
	
	
	


}
