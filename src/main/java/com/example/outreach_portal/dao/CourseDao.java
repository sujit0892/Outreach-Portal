package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;

public interface CourseDao extends JpaRepository<Course,Integer>{
	
	

}
