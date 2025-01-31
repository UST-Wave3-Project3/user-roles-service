package com.example.UserRole_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.UserRole_service.dto.RoleDto;

@FeignClient(name = "role-service", url = "http://localhost:5555/api/roles")

public interface RoleFeignClient {
	
	@GetMapping
    List<RoleDto> getAllRoles();
	
}
