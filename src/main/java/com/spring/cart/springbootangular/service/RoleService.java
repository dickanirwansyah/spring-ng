package com.spring.cart.springbootangular.service;


import com.spring.cart.springbootangular.entity.Role;
import com.spring.cart.springbootangular.request.CreateRoleRequest;
import com.spring.cart.springbootangular.request.GetDetailsByRoleRequest;
import com.spring.cart.springbootangular.request.UpdateByRoleRequest;

import java.util.List;

public interface RoleService {

    Role createNewRole(CreateRoleRequest roleRequest);
    Role updateByRole(UpdateByRoleRequest roleRequest);
    Role getDetailByRole(GetDetailsByRoleRequest roleRequest);
    List<Role> findAll();
}
