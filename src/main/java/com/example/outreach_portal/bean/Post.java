package com.example.outreach_portal.bean;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="uid")
    private User user;
    
    @Column(length=3000)
    private String post;
    
    @Column
    private String pic;
    
    @Column
    private int isProject;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course course;
    
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    
    @OneToMany(mappedBy="post")
    private List<Comment> comments = new ArrayList<>();
    
    @OneToMany(mappedBy="post")
    private List<Like> likes = new ArrayList<>();

    public Post()
    {
    	
    }
    
	public Post( User user, String post, String pic, Course course,int isProject,Date timestamp
			) {
		super();

		this.user = user;
		this.post = post;
		this.pic = pic;
		this.course = course;
		this.isProject = isProject;
		this.timestamp = timestamp;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPost() {
		return post;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
    
    
    
    
}
