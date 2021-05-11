package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.CommentJson;
import com.example.outreach_portal.JSONEntity.LikeJson;
import com.example.outreach_portal.JSONEntity.PostJson;
import com.example.outreach_portal.bean.Comment;
import com.example.outreach_portal.bean.Like;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface PostService {
	
	public int createPost(PostJson post);
	public void like(LikeJson likeJson);
	public void comment(CommentJson commentJson);
	public List<User> viewLike(int post_id);
	public List<Comment> viewComment(int post_id);
	public List<Post> viewPost(int user_id);
	public List<Post> viewAllPost();
	
	public Post getPost(int post_id);
	
}
