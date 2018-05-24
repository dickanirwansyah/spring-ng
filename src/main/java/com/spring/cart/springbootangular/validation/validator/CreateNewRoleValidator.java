package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.entity.Role;
import com.spring.cart.springbootangular.request.CreateRoleRequest;
import com.spring.cart.springbootangular.validation.CreateNewRole;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class CreateNewRoleValidator implements ConstraintValidator<CreateNewRole, CreateRoleRequest> {


    @Override
    public void initialize(CreateNewRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateRoleRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getRoleOfRole() == null || value.getRoleOfRole().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("role still null")
                    .addPropertyNode("roleOfRole").addConstraintViolation();
            return false;
        }

        if (value.getDescriptionOfRole() == null || value.getDescriptionOfRole().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("description still null")
                    .addPropertyNode("descriptionOfRole").addConstraintViolation();
            return false;
        }

        return true;
    }
}
