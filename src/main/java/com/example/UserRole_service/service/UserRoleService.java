package com.example.UserRole_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserRole_service.client.RoleFeignClient;
import com.example.UserRole_service.dto.RoleDto;
import com.example.UserRole_service.repository.UserRoleRepository;
import com.example.UserRole_service.repository.entity.UserRoleEntity;

@Service
public class UserRoleService {
	
	@Autowired
    private UserRoleRepository userRolesRepository;

    @Autowired
    private RoleFeignClient roleFeignClient;

 
    public List<String> getRolesByUserId(Integer userId) {
    
        List<UserRoleEntity> userRoles = userRolesRepository.findByUserId(userId);
        List<Integer> allRoleIds = userRoles.stream()
                                         .map(UserRoleEntity::getRoleId)
                                         .collect(Collectors.toList());

        
        List<RoleDto> allRoleDto = roleFeignClient.getAllRoles();

        List<String> allRoles = new ArrayList<String>();
       for(RoleDto eachRole: allRoleDto) {
    	   for(int roleId: allRoleIds) {
    		   if(roleId == eachRole.getRoleId()) {
    			   allRoles.add(eachRole.getRoleName());
    			   break;
    		   }
    	   }
       }
        
        return allRoles;
    }


	public UserRoleEntity createUserRole(UserRoleEntity entity) {
		UserRoleEntity saved=userRolesRepository.saveAndFlush(entity);
		return saved;
	}


}
