package com.example.outreach_portal.bean;


import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable=false)
	private String title;
	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id",unique = true)
    private Post post;
	
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;

    
	public Project(Integer id, Post post, Calendar timestamp) {
		super();
		this.id = id;
		this.post = post;
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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	
    

}
