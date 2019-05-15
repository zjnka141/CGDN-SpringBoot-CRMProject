package dn.codegym.crm.validator;

import dn.codegym.crm.dto.CourseDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CourseDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == CourseDTO.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        CourseDTO courseDTO = (CourseDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "course.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDay", "course.startDay");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDay", "course.endDay");

        if (!courseDTO.getStartDay().isEmpty() && !courseDTO.getEndDay().isEmpty()) {
            String[] startDay = courseDTO.getStartDay().split("-");
            String[] endDay = courseDTO.getEndDay().split("-");
            for (int i = 0; i < startDay.length; i++) {
                if (Integer.parseInt(endDay[i]) < Integer.parseInt(startDay[i])) {
                    errors.rejectValue("startDay", "course.startDay");
                    errors.rejectValue("endDay", "course.endDay");
                    break;
                }
            }
        }
    }
}
