package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.CourseJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;

public interface CourseSercive {
	
	public Course getCourse(int course_id);
	public List<Project> getCourseProject(int coursid);
	public List<Post> getCoursePost(int courseid);
	public void followCourse(CourseJson coursJson);
	
	public List<User> getFollower(int course_id);
	public List<User> getInstructor(int course_id);
	public List<Course> getUserCourse(int user_id);
	

}
