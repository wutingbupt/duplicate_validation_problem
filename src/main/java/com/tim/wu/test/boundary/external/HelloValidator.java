package com.tim.wu.test.boundary.external;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.ws.rs.core.Response;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DuplicateBeanValidator.class)
@Documented
public @interface HelloValidator {

    int ERROR_CODE = 2020;

    String message() default "Mandatory string is missing.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int errorCode() default ERROR_CODE;

    Response.Status status() default Response.Status.BAD_REQUEST;
}