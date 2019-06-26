package dn.codegym.crm.validator.validatorName;

import dn.codegym.crm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,String> {
    @Autowired
    ProductRepository productRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(productRepository==null){
            return true;
        }
        System.out.println("COUNT " + productRepository.countByName(s));
        return productRepository.countByName(s)<1;
    }
}
