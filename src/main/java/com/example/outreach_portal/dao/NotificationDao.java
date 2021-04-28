package com.example.outreach_portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Notification;

public interface NotificationDao extends JpaRepository<Notification,Integer>{

}
