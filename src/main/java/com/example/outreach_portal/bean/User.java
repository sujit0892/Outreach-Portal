package com.example.outreach_portal.bean;

import javax.persistence.*;


@Entity
@Table(name="User")
public class User {


	@Id
	@Column(nullable=false,unique=true)
	private int user_id;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private boolean role;
	
	@Column
	private String profile_pic;
	
	@Column(nullable=false)
	private String name;

	@Column
	private String program;
	
	@Column
	private String roll_no;
	@Column
	private String batch;


	@Column(length=2000)
	private String about;
	
	@Column(length=1000)
	private String interest;
	
	
	
	@Column 
	private int status;
	
	public User()
	{
		
	}

	public User(int user_id, String email, String password, boolean role, String profile_pic, String name,
			String program, String roll_no, String batch, String about, String interest, int status) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.profile_pic = profile_pic;
		this.name = name;
		this.program = program;
		this.roll_no = roll_no;
		this.batch = batch;
		this.about = about;
		this.interest = interest;
		this.status = status;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isRole() {
		return role;
	}



	public void setRole(boolean role) {
		this.role = role;
	}



	public String getProfile_pic() {
		return profile_pic;
	}



	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getProgram() {
		return program;
	}



	public void setProgram(String program) {
		this.program = program;
	}



	public String getRoll_no() {
		return roll_no;
	}



	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}



	public String getBatch() {
		return batch;
	}



	public void setBatch(String batch) {
		this.batch = batch;
	}



	public String getAbout() {
		return about;
	}



	public void setAbout(String about) {
		this.about = about;
	}



	public String getInterest() {
		return interest;
	}



	public void setInterest(String interest) {
		this.interest = interest;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}




	
	
}
