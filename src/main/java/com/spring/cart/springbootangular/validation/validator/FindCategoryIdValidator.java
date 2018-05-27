package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.repository.CategoryRepository;
import com.spring.cart.springbootangular.request.CreateProductRequest;
import com.spring.cart.springbootangular.validation.FindCategoryId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class FindCategoryIdValidator implements ConstraintValidator<FindCategoryId, String>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(FindCategoryId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null){
            return true;
        }

        Category category = categoryRepository.findByIdcategory(value);
        return category != null;
    }

}
