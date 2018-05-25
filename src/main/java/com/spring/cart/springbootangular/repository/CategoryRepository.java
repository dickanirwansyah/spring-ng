package com.spring.cart.springbootangular.repository;

import com.spring.cart.springbootangular.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
