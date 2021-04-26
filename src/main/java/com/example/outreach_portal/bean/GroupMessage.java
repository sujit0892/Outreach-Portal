package com.example.outreach_portal.bean;



import java.util.Calendar;

import javax.persistence.*;


@Entity
@Table
public class GroupMessage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reciever")
    private Group group;
    
    @Column(nullable=false)
    private String message;
    

    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar timestamp;



	public GroupMessage(Integer id, User user, Group group, String message, Calendar timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.group = group;
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



	public Calendar getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	
    
	
}
