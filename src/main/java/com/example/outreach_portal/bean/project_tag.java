package com.example.outreach_portal.bean;

import javax.persistence.*;


@Entity
@Table(name="project_tag")
public class project_tag {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pid")
    private Project project;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tid")
    private  Tag tag;

	public project_tag(Integer id, Project project, Tag tag) {
		super();
		this.id = id;
		this.project = project;
		this.tag = tag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
    
    
}
