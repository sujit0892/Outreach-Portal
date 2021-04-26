package com.example.outreach_portal.bean;

import java.util.Calendar;

import javax.persistence.*;


@Entity
@Table(name="likes")
public class Like {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    private Post post;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;


	public Like(Integer id, Post post, User user, Calendar timestamp) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
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


	public Calendar getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
    
    
    
}
