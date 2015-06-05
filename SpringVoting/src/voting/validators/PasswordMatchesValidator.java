package voting.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import voting.annotations.PasswordMatches;
import voting.model.SignUpUser;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches arg0) {
		
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		SignUpUser user = (SignUpUser)arg0; 
		return user.getPassword().equals(user.getPasswordConfirm());
	}

}
