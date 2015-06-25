package voting.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import voting.annotations.PasswordMatches;
import voting.model.SignUpUser;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches annotation) {
		
	}

	@Override
	public boolean isValid(Object arg, ConstraintValidatorContext context) {
		SignUpUser user = (SignUpUser)arg; 
		return user.getPassword().equals(user.getPasswordConfirm());
	}

}
