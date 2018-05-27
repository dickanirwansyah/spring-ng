package com.spring.cart.springbootangular.repository;

import com.spring.cart.springbootangular.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposory extends JpaRepository<Product, String>{


}
