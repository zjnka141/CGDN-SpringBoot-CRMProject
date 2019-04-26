package dn.codegym.crm.validator;

import dn.codegym.crm.dto.CourseDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == CourseDTO.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDTO courseDTO = (CourseDTO) target;

    }
}
