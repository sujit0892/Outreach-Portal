package com.example.outreach_portal.bean;
import javax.persistence.*;

public class Course_Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course Course;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

   
	public Course_Followers(Integer id, com.example.outreach_portal.bean.Course course, User user) {
		super();
		this.id = id;
		Course = course;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return Course;
	}

	public void setCourse(Course course) {
		Course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
	
}
