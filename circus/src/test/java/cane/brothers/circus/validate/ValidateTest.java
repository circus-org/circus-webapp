package cane.brothers.circus.validate;

import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import cane.brothers.circus.domain.Troupe;

public class ValidateTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}
	
	@Test
	public void testThatTroupeWithNullNameInvalid() {
		Troupe noname = new Troupe(null, "noname");
		
		Set<ConstraintViolation<Troupe>> constraintViolations = ValidateUtils.validate(noname, validator);

		//assertEquals(1, constraintViolations.size());
		assertThat(constraintViolations.size(), CoreMatchers.is(1));

		// assertThat(constraintViolations, CoreMatchers.notNullValue());
		// assertThat(constraintViolations.size(), CoreMatchers.is(1));
		// assertThat(troupes, CoreMatchers.hasItems(liones, aquacircus));
	}
}
