package com.example.outreach_portal.bean;



import java.util.Calendar;

import javax.persistence.*;


@Entity
@Table
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reciever")
    private User user2;
    
    @Column(nullable=false)
    private String message;
    

    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;



	public Message(Integer id, User user, User user2, String message, Calendar timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.user2 = user2;
		this.message = message;
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



	public Calendar getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	
    
	
}
