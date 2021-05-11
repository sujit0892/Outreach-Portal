package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Comment;
import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface CommentDao extends JpaRepository<Comment,Integer>{

	@Query("SELECT l FROM Comment l WHERE l.post = :post order by l.timestamp")
	List<Comment> viewComment(@Param("post") Post post);
}
