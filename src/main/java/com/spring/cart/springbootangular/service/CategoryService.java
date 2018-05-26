package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.request.CreateCategoryRequest;
import com.spring.cart.springbootangular.request.GetDetailsByCategoryRequest;
import com.spring.cart.springbootangular.request.UpdateByCategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createNewCategory(CreateCategoryRequest requestCategory);
    Category updateCategory(UpdateByCategoryRequest requestCategory);
    List<Category> listCategory();
    Optional<Category> findByCategoryId(GetDetailsByCategoryRequest requestCategory);
}
