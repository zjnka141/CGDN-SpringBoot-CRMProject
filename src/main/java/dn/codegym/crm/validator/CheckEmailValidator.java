package dn.codegym.crm.validator;


import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String>{
    @Autowired
    StudentService studentService;
    @Override
    public void initialize(CheckEmail checkEmail){
    }

    @Override
    public boolean isValid(String accountField,
                           ConstraintValidatorContext cxt) {
//can't  customerList with charge to check elements in an array has empty ?
        // opposite when i check parameter accountField
        if (studentService == null) {
            return true;
        }
        List<Student> customerList = studentService.findAllByEmail(accountField);
        return (accountField != null && customerList.isEmpty())
                || accountField != null && customerList.isEmpty();
    }
}
