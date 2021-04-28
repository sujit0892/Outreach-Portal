package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Course_Followers;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface CourseFollowerDao extends JpaRepository<Course_Followers,Integer>{

	@Query("SELECT c.user from Course_Followers c where c.Course=:course")
	List<User> getFollower(@Param("course") Course course);
	
	
	@Query("SELECT c.Course FROM Course_Followers c WHERE c.user= :user")
	List<Course> getUserCourse(@Param("user") User user);
}
