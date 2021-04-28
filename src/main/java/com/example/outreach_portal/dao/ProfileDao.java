package com.example.outreach_portal.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.User;

public interface ProfileDao extends JpaRepository<User,Integer> {
	
	@Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
	User retrieveByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.roll_no) = LOWER(:roll_no)")
	User retrieveByRoll(@Param("roll_no") String roll_no);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.name) like LOWER(:name)")
	List<User> retrieveByName(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query("Update User set about= :about where user_id= :user_id")
	int updateAbout(@Param("about") String about, @Param("user_id") int user_id);
	
	@Transactional
	@Modifying
	@Query("Update User set interest= :interest where user_id= :user_id")
	int updateInterest(@Param("interest") String interest, @Param("user_id") int user_id);
	
	@Transactional
	@Modifying
	@Query("Update User set password= :password where user_id= :user_id")
	int updatePassword(@Param("password") String password, @Param("user_id") int user_id);
	
	@Transactional
	@Modifying
	@Query("Update User set profile_pic= :profile_pic where user_id= :user_id")
	int updateProfile_pic(@Param("profile_pic") String profile_pic, @Param("user_id") int user_id);
	
	@Query("SELECT u.user_id FROM User u WHERE u.email= :email and u.password=:password")
	int login(@Param("email") String email, @Param("password") String password);
	
	
	
	

}
