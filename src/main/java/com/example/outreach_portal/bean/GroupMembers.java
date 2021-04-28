package com.example.outreach_portal.bean;



import javax.persistence.*;


@Entity
@Table
public class GroupMembers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="group_id")
    private Group group;

    
    @Column(nullable=false)
    private int status;


    public GroupMembers()
    {
    	
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public GroupMembers(User user, Group group, int status) {
		super();
		this.user = user;
		this.group = group;
		this.status = status;
	}
    
    

	
}
