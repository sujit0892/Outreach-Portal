package com.example.outreach_portal.bean;



import javax.persistence.*;


@Entity
@Table
public class GroupMembers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id1")
    private User user;

    
    @Column(nullable=false)
    private int status;


	public GroupMembers(Integer id, User user, int status) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
    
    

}
