package com.example.outreach_portal.service;

import java.util.List;

import com.example.outreach_portal.JSONEntity.ProjectJson;
import com.example.outreach_portal.bean.Project;

public interface ProjectService {
	
	public List<Project> getProject();
	public void createProject(ProjectJson projectJson);

}
