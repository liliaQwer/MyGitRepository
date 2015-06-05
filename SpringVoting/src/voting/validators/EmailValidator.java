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
	public void initialize(Email arg0) {
			
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		 pattern = Pattern.compile(EMAIL_PATTERN);
	     matcher = pattern.matcher(arg0);
	     return matcher.matches();		
	}

}
