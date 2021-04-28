package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface PostDao extends JpaRepository<Post,Integer>{
	
	@Query("SELECT p FROM Post p WHERE p.user = :user and p.course= null and isProject=0")
	List<Post> getUserPost(@Param("user") User user);
	
	@Query("SELECT p FROM Post p WHERE p.user in :user and p.course= null and isProject=0 order by p.timestamp")
	List<Post> getAllPost(@Param("user") List<User> user);
	
	
	@Query("SELECT p FROM Post p WHERE course= :course order by p.timestamp")
	List<Post> getAllCoursePost(@Param("course") Course course);
	
	

}
