package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Product;
import com.spring.cart.springbootangular.request.CreateProductRequest;
import com.spring.cart.springbootangular.request.GetDetailsByProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listProduct();
    Product createdProduct(CreateProductRequest requestProduct);
    Optional<Product> getDetailProduct(GetDetailsByProductRequest requestProduct);
}
