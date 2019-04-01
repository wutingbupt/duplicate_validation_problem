package com.tim.wu.test.boundary.external;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicateBeanValidator implements ConstraintValidator<HelloValidator, String> {

    @Override
    public void initialize(HelloValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("hello world");
        Thread.dumpStack();
        return true;
    }
}
