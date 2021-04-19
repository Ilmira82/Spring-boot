package com.ilmira.springboot.dao;

import com.ilmira.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = :name")
    Role getRoleByName(String name);
}
