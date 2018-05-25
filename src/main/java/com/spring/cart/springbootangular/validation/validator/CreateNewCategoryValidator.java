package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.request.CreateCategoryRequest;
import com.spring.cart.springbootangular.validation.CreateNewCategory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CreateNewCategoryValidator implements ConstraintValidator<CreateNewCategory, CreateCategoryRequest>{


    @Override
    public void initialize(CreateNewCategory constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getNameOfCategory() == null || value.getNameOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name still null")
                    .addPropertyNode("nameOfCategory").addConstraintViolation();
            return false;
        }

        return true;
    }
}
