package com.example.outreach_portal.bean;

import javax.persistence.*;


@Entity
@Table(name="tag")
public class Tag {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable=false)
	private String tag;

	public Tag() {
		
	}
	
	public Tag(Integer id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
