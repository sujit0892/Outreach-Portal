package com.example.outreach_portal.bean;


import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table
public class Notification {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    
    @Column
    private String notification;
    
    @Column
    private String type;
    
    @Column 
    private int pid;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;

	public Notification(Integer id, User user, String notification, String type, int pid, Calendar timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.notification = notification;
		this.type = type;
		this.pid = pid;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}


    
    
    
	
	
	
	
	

}
