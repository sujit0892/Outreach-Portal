package com.example.outreach_portal.bean;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender")
    private User user1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reciever")
    private User user2;
    
    @Column(nullable=false)
    private String message;
    
    @Column(nullable=false)
    private int status;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    
    

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Message()
    {
    	
    }

	public Message( User user, User user2, String message,int status, Date timestamp) {
		super();
	
		this.user1 = user;
		this.user2 = user2;
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public User getUser1() {
		return user1;
	}



	public void setUser1(User user) {
		this.user1 = user;
	}



	public User getUser2() {
		return user2;
	}



	public void setUser2(User user2) {
		this.user2 = user2;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Date getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
    
	
}
