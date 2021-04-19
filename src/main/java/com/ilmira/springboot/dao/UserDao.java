package com.ilmira.springboot.dao;

import com.ilmira.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("select r from User r where r.username = :username")
    UserDetails getUserByUsername(String username);
}
