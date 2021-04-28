package com.example.outreach_portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMembers;

public interface GroupDao extends JpaRepository<Group,Integer>{

}
