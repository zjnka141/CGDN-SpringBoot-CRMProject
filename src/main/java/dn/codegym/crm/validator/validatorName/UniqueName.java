package dn.codegym.crm.validator.validatorName;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {
//    String message() default "This name already exists";
    String message() default "This name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
