package com.example.outreach_portal.bean;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table
public class GroupMessage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender")
    private User user1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Reciever_user")
    private User user2;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reciever")
    private Group group;
    
    @Column(nullable=false)
    private String message;
    
    @Column
    private int status;
    

    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timestamp;


    public GroupMessage()
    {
    	
    }


	public GroupMessage(User user1, User user2, Group group, String message, int status,Date timestamp) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.group = group;
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


	public void setUser1(User user1) {
		this.user1 = user1;
	}


	public User getUser2() {
		return user2;
	}


	public void setUser2(User user2) {
		this.user2 = user2;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
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
