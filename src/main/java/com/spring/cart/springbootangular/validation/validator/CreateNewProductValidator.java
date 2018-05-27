package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.repository.CategoryRepository;
import com.spring.cart.springbootangular.request.CreateProductRequest;
import com.spring.cart.springbootangular.validation.CreateNewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CreateNewProductValidator implements ConstraintValidator<CreateNewProduct, CreateProductRequest>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(CreateNewProduct constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateProductRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getNameOfProduct() == null || value.getNameOfProduct().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name of product still null")
                    .addPropertyNode("nameOfProduct")
                    .addConstraintViolation();
            return false;
        }

        if (value.getStockOfProduct() == null || value.getStockOfProduct() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("stock of product still null")
                    .addPropertyNode("stockOfProduct")
                    .addConstraintViolation();
            return false;
        }

        if (value.getPriceOfProduct() == null || value.getPriceOfProduct() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("price of product still null")
                    .addPropertyNode("priceOfProduct")
                    .addConstraintViolation();
            return false;
        }

        if (value.getCategoryOfProduct() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("category of product still null")
                    .addPropertyNode("categoryOfProduct")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
