package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.repository.CategoryRepository;
import com.spring.cart.springbootangular.request.CreateCategoryRequest;
import com.spring.cart.springbootangular.request.GetDetailsByCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public Category createNewCategory(CreateCategoryRequest requestCategory) {
        Category category = newCategory(requestCategory.getNameOfCategory());
        return categoryRepository.save(category);
    }

    private Category newCategory(String name){
        return Category.builder()
                .name(name)
                .build();
    }

    @Override
    public List<Category> listCategory() {
        List<Category> categoryList = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public Optional<Category> findByCategoryId(GetDetailsByCategoryRequest requestCategory) {
        return categoryRepository.findById(requestCategory.getCategoryId());
    }

}
