package com.example.UserRole_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserRole_service.repository.entity.UserRoleEntity;
import com.example.UserRole_service.service.UserRoleService;

@RestController  
@RequestMapping("/api/user-roles") 
public class UserRoleController {

	@Autowired
    private UserRoleService userRolesService;

    @GetMapping("/{userId}")
    public List<String> getRolesByUserId(@PathVariable int userId) {
        return userRolesService.getRolesByUserId(userId);
    }
    @PostMapping
    public UserRoleEntity createUserRole(@RequestBody UserRoleEntity entity)
    {
    	return userRolesService.createUserRole(entity);
    }
	
}
