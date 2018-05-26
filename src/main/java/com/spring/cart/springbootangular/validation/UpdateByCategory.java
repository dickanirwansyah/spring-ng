package com.spring.cart.springbootangular.validation;

import com.spring.cart.springbootangular.validation.validator.UpdateByCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ANNOTATION_TYPE, TYPE, METHOD, PARAMETER})
@Constraint(validatedBy = {
        UpdateByCategoryValidator.class
})
@Retention(RUNTIME)
@Documented
public @interface UpdateByCategory {

    String message() default "UpdateByCategory";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
