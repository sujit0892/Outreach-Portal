package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Like;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface LikeDao extends JpaRepository<Like,Integer>{

	@Query("SELECT l.user FROM Like l WHERE l.post = :post")
	List<User> viewLike(@Param("post") Post post);
}
