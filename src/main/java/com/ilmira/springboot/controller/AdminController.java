package com.ilmira.springboot.controller;

import com.ilmira.springboot.model.Role;
import com.ilmira.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ilmira.springboot.service.RoleService;
import com.ilmira.springboot.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller

public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String welcome() {
        return "redirect:/admin/all";
    }

    @GetMapping(value = "admin/all")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping(value = "admin/add")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("allRoles", roleService.findAllRoles());
        return "add";
    }

    @PostMapping(value = "admin/add")
    public String postAddUser(@ModelAttribute("user") User user,
                              @ModelAttribute("allRoles") Role roles) {

        roleService.findAllRoles();
        userService.addUser(user);

        return "redirect:/admin";
    }

    @GetMapping(value = "admin/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roles);
        return "edit";
    }

    @PostMapping(value = "admin/edit")
    public String postEditUser(@ModelAttribute("user") User user, @RequestParam("roleIds") Long[] roleIds) {
        user.getRoles().clear();
        for (Long roleId : roleIds) {
            Role role = roleService.getRoleById(roleId);
            user.getRoles().add(role);
        }
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}