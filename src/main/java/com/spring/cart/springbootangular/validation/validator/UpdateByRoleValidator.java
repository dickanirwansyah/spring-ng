package com.spring.cart.springbootangular.validation.validator;

import com.spring.cart.springbootangular.entity.Role;
import com.spring.cart.springbootangular.request.UpdateByRoleRequest;
import com.spring.cart.springbootangular.validation.UpdateByRole;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UpdateByRoleValidator implements ConstraintValidator<UpdateByRole, UpdateByRoleRequest> {

    @Override
    public void initialize(UpdateByRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateByRoleRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getIdOfRole() == null || value.getIdOfRole().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("idrole must exist")
                    .addPropertyNode("idOfRole").addConstraintViolation();
            return false;
        }

        if (value.getRoleOfRole() == null || value.getRoleOfRole().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("role must exist")
                    .addPropertyNode("roleOfRole").addConstraintViolation();
            return false;
        }

        if (value.getDescriptionOfRole() == null || value.getDescriptionOfRole().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("description must exist")
                    .addPropertyNode("descriptionOfRole").addConstraintViolation();
            return false;
        }

        return true;
    }
}
