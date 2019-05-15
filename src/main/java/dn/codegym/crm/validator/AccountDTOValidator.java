package dn.codegym.crm.validator;

import dn.codegym.crm.dto.AccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccountDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == AccountDTO.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "account.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "account.password");
    }
}
