package com.example.outreach_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.bean.project_tag;
import com.example.outreach_portal.dao.ProfileDao;

@SpringBootApplication
public class OutreachPortalApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(OutreachPortalApplication.class, args);
		
	
		
	}

}
