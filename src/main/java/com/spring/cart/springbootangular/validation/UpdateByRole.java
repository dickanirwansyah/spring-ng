package com.spring.cart.springbootangular.validation;

import com.spring.cart.springbootangular.validation.validator.UpdateByRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

@Target({METHOD, ANNOTATION_TYPE, FIELD, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {UpdateByRoleValidator.class})
@Documented
public @interface UpdateByRole {

    String message()
            default "UpdateByRole";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
