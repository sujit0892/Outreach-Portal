package com.example.outreach_portal.JSONEntity;

import java.util.Date;


public class PostJson {

    
    
    private String post;
    
    
    private String pic;
    
    private int isProject;
    
 
    private int course_id;
    private int user_id;
    
	public String getPost() {
		return post;
	}
	public int getIsProject() {
		return isProject;
	}
	public void setIsProject(int isProject) {
		this.isProject = isProject;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
    
    
  
}
