package com.example.outreach_portal.bean;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    private Post post;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    
    @Column
    private String comment;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;

	public Comment(Integer id, Post post, User user, String comment, Calendar timestamp) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.comment = comment;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
    
    
}
