package com.spring.cart.springbootangular.validation;

import com.spring.cart.springbootangular.validation.validator.FindCategoryIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ANNOTATION_TYPE, METHOD, TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {FindCategoryIdValidator.class})
@Documented
public @interface FindCategoryId {

    String message() default "FindCategoryId";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};


}




