package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Course_Instructor;
import com.example.outreach_portal.bean.User;

public interface CourseInstructorDao extends JpaRepository<Course_Instructor,Integer>{
	
	@Query("SELECT c.user from Course_Instructor c where c.Course=:course")
	List<User> getInstructor(@Param("course") Course course);

}
