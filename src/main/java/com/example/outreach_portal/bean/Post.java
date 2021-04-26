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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course course;
    
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;
    
    @OneToMany(mappedBy="post")
    private List<Comment> comments = new ArrayList<>();
    
    @OneToMany(mappedBy="post")
    private List<Like> likes = new ArrayList<>();

    
    
	public Post(Integer post_id, User user, String post, String pic, Course course, Calendar timestamp,
			List<Comment> comments, List<Like> likes) {
		super();
		this.post_id = post_id;
		this.user = user;
		this.post = post;
		this.pic = pic;
		this.course = course;
		this.timestamp = timestamp;
		this.comments = comments;
		this.likes = likes;
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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
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
