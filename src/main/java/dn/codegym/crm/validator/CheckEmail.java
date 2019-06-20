package dn.codegym.crm.validator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckEmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
//annotation
public @interface CheckEmail {
    String message() default "Please try again because your email  is exist!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
