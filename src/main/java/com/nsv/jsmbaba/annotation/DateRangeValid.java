package com.nsv.jsmbaba.annotation;

import com.nsv.jsmbaba.validator.PersonCustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE , ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PersonCustomValidator.class})
public @interface DateRangeValid {

    String message() default "Date Range is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
