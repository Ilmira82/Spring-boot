package com.ilmira.springboot.service;

import com.ilmira.springboot.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();

    List<Role> findAllRoles();
}