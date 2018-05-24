package com.spring.cart.springbootangular.repository;

import com.spring.cart.springbootangular.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByIdroleIn(String idrole);
    Role findByIdrole(String idrole);
}
