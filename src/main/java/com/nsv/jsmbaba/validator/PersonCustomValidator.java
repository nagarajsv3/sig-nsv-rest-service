package com.nsv.jsmbaba.validator;

import com.nsv.jsmbaba.annotation.DateRangeValid;
import com.nsv.jsmbaba.domain.Person;
import org.apache.commons.lang3.StringUtils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonCustomValidator implements ConstraintValidator<DateRangeValid, Person>{

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isNotEmpty(person.getStartDate()) && StringUtils.isEmpty(person.getEndDate())){
            return Boolean.FALSE;
        }else if(StringUtils.isEmpty(person.getStartDate()) && StringUtils.isNotEmpty(person.getEndDate())){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
