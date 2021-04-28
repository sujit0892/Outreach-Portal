package com.example.outreach_portal.bean;


import java.util.Calendar;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course Course;
    
    public Project()
    {
    	
    }
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course getCourse() {
		return Course;
	}

	public void setCourse(Course course) {
		Course = course;
	}

	public Project(String title,Post post, Date timestamp) {
		super();
		this.title = title;
		this.post = post;
		this.timestamp = timestamp;
	}

	public Project(String title, Post post, Date timestamp, com.example.outreach_portal.bean.Course course) {
		super();
		this.title = title;
		this.post = post;
		this.timestamp = timestamp;
		Course = course;
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
    

}
