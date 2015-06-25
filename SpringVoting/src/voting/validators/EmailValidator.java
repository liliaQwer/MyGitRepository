package voting.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import voting.annotations.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{
	

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
	
	@Override
	public void initialize(Email email) {
			
	}

	@Override
	public boolean isValid(String arg, ConstraintValidatorContext context) {
		 pattern = Pattern.compile(EMAIL_PATTERN);
	     matcher = pattern.matcher(arg);
	     return matcher.matches();		
	}

}
