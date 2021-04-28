package com.example.outreach_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.ProjectJson;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/project")
	public ResponseEntity<?> getProject()
	{
		try
		{
			
			List<Project> project = this.projectService.getProject();
			
			return new ResponseEntity<>(project,HttpStatus.OK);
		}
		catch(Exception e)
		{
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/project")
	public ResponseEntity<?> createProject(@RequestBody ProjectJson projectJson)
	{
		try
		{
			
			this.projectService.createProject(projectJson);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	

}
