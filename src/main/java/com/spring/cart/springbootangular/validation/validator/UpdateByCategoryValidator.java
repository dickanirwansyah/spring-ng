package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.request.UpdateByCategoryRequest;
import com.spring.cart.springbootangular.validation.UpdateByCategory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UpdateByCategoryValidator implements ConstraintValidator<UpdateByCategory, UpdateByCategoryRequest>{


    @Override
    public void initialize(UpdateByCategory constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateByCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getCategoryId() == null || value.getCategoryId().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("categoryId is null")
                    .addPropertyNode("categoryId").addConstraintViolation();
            return false;
        }

        if (value.getNameOfCategory() == null || value.getNameOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name of category is null")
                    .addPropertyNode("nameOfCategory").addConstraintViolation();
            return false;
        }

        return true;
    }
}
