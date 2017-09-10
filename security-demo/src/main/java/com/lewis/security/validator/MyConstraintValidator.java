package com.lewis.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Administrator on 2017/9/10.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init.......");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("value: "+value);
        return false;
    }
}
