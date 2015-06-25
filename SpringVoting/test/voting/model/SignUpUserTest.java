package voting.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import junit.framework.TestCase;

import org.junit.Test;

public class SignUpUserTest extends TestCase{

	@Test
	public void testEmailValidation() {
		SignUpUser user = new SignUpUser();
		user.setEmail("ligdfgfd");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<SignUpUser>> violationSet = validator.validateProperty(user, "email");
		assertEquals(1, violationSet.size());
		assertEquals("Invalid email", violationSet.iterator().next().getMessage());
	}

}
