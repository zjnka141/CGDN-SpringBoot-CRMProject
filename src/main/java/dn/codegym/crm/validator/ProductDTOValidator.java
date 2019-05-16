package dn.codegym.crm.validator;

import dn.codegym.crm.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == ProductDTO.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductDTO productDTO = (ProductDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "product.description");

        String regex = "[a-zA-Z]*";
        if (!productDTO.getName().matches(regex)) {
            errors.rejectValue("name", "product.name.pattern");
        }
    }
}
