package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Role;
import com.spring.cart.springbootangular.repository.RoleRepository;
import com.spring.cart.springbootangular.request.CreateRoleRequest;
import com.spring.cart.springbootangular.request.GetDetailsByRoleRequest;
import com.spring.cart.springbootangular.request.UpdateByRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dicka-spring
 * @editor INTELIJ-IDEA
 */

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createNewRole(CreateRoleRequest roleRequest) {
        Role role = newRole(
                roleRequest.getRoleOfRole(),
                roleRequest.getDescriptionOfRole());
        return roleRepository.save(role);
    }

    @Override
    public Role updateByRole(UpdateByRoleRequest roleRequest) {
        Role role = updateRole(roleRequest.getIdOfRole(),
                roleRequest.getRoleOfRole(), roleRequest.getDescriptionOfRole());
        return roleRepository.save(role);
    }

    @Override
    public Role getDetailByRole(GetDetailsByRoleRequest roleRequest) {
        return roleRepository.findByIdrole(roleRequest.getIdOfRole());
    }

    private Role newRole(String role, String description){
       return Role.builder()
               .role(role)
               .description(description)
               .build();
    }

    private Role updateRole(String idrole, String role, String description){
        return Role.builder()
                .idrole(idrole)
                .role(role)
                .description(description)
                .build();
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        for (Role role : roleRepository.findAll()){
            roles.add(role);
        }
        return roles;
    }
}
