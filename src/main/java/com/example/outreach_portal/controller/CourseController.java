package com.example.outreach_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.CourseJson;
import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.Implementation.CourseServiceImp;

@RestController
public class CourseController {
	
	
	
	@Autowired
	private CourseServiceImp courseService;
	
	@GetMapping(path="/course/{course_id}")
	public ResponseEntity<?> friendReq(@PathVariable String course_id)
	{
		try
		{
			Course course = this.courseService.getCourse(Integer.parseInt(course_id));
			
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/getCourseProject/{course_id}")
	public ResponseEntity<?> getCourseProject(@PathVariable String course_id)
	{
		try
		{
			List<Project> project = this.courseService.getCourseProject(Integer.parseInt(course_id));
			
			return new ResponseEntity<>(project,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/getCoursePost/{course_id}")
	public ResponseEntity<?> getCoursePost(@PathVariable String course_id)
	{
		try
		{
			List<Post> post = this.courseService.getCoursePost(Integer.parseInt(course_id));
			
			return new ResponseEntity<>(post,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/getCourseFollower/{course_id}")
	public ResponseEntity<?> getCourseFollower(@PathVariable String course_id)
	{
		try
		{
			List<User> user = this.courseService.getFollower(Integer.parseInt(course_id));
			
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/getCourseInstructor/{course_id}")
	public ResponseEntity<?> getCourseInstructor(@PathVariable String course_id)
	{
		try
		{
			List<User> user = this.courseService.getInstructor(Integer.parseInt(course_id));
			
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/getUserCourse/{user_id}")
	public ResponseEntity<?> getUserCourse(@PathVariable String user_id)
	{
		try
		{
			List<Course> course = this.courseService.getUserCourse(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/followCourse")
	public ResponseEntity<?> followCourse(@RequestBody CourseJson courseJson)
	{
		try
		{
			this.courseService.followCourse(courseJson);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
	
	
	

}
