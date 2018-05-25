package com.spring.cart.springbootangular.validation;

import com.spring.cart.springbootangular.validation.validator.CreateNewCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ANNOTATION_TYPE, METHOD, TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CreateNewCategoryValidator.class})
@Documented
public @interface CreateNewCategory {

    String message() default "CreateNewCategory";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
