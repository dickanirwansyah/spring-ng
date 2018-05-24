package com.spring.cart.springbootangular.validation;

import com.spring.cart.springbootangular.validation.validator.CreateNewRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author dicka-cryptonizer
 * @springboot 2.0.2
 */

@Target({TYPE, METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CreateNewRoleValidator.class})
@Documented
public @interface CreateNewRole {

    String message() default "CreateNewRole";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
