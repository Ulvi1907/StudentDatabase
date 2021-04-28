package ga.alili.validator;

import ga.alili.register.RequestForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegisterFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(RequestForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RequestForm form = (RequestForm) o;
        System.out.println("Request form validator isledi");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "requestForm.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "requestForm.surname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "student_id", "requestForm.student_id.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "requestForm.password.empty");
    }
}
