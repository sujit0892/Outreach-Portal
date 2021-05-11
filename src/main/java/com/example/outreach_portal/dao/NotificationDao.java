package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;

public interface NotificationDao extends JpaRepository<Notification,Integer>{

	
	@Query("Select n from Notification n where user=:user")
	List<Notification> getNotification(@Param("user") User user);
	
	@Query("Select n from Notification n where user=:user and stat=0")
	List<Notification> getNotificationStat(@Param("user") User user);
	
	@Transactional
	@Modifying
	@Query("Update Notification set stat=1 where user=:user")
	void updateNotification(@Param("user") User user);
}
