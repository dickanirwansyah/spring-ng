package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.repository.CategoryRepository;
import com.spring.cart.springbootangular.request.CreateCategoryRequest;
import com.spring.cart.springbootangular.request.GetDetailsByCategoryRequest;
import com.spring.cart.springbootangular.request.UpdateByCategoryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    private final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public Category createNewCategory(CreateCategoryRequest requestCategory) {
        logger.info("create new category");
        Category category = newCategory(requestCategory.getNameOfCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UpdateByCategoryRequest requestCategory) {
        logger.info("update category by categoryId");
        Category category = editCategory(requestCategory.getCategoryId(),
                requestCategory.getNameOfCategory());
        return categoryRepository.save(category);
    }

    private Category newCategory(String name){
        return Category.builder()
                .name(name)
                .build();
    }

    private Category editCategory(String categoryId, String name){
        return Category.builder()
                .idcategory(categoryId)
                .name(name)
                .build();
    }

    @Override
    public List<Category> listCategory() {
        logger.info("list of category");
        List<Category> categoryList = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public Optional<Category> findByCategoryId(GetDetailsByCategoryRequest requestCategory) {
        logger.info("find by categoryId");
        return categoryRepository.findById(requestCategory.getCategoryId());
    }

}
