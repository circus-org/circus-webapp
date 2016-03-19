package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Troupe;
import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestTroupeRepository {

	// @Resource
	private static Validator validator;
	
	private static final Logger log = LoggerFactory.getLogger(TestTroupeRepository.class);
	
	@Resource
	private TroupeRepository troupeRepo;

	private Troupe liones;
	private Troupe aquacircus;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@Before
	public void createTestTroupes() {
		liones = troupeRepo.save(new Troupe("Канские Львы", "Михаилков"));
		aquacircus = troupeRepo.save(new Troupe("Цирк на воде", "Шевченко"));
	}

	@Test
	public void testThatTroupesCanBeFound() {
		List<Troupe> troupes = troupeRepo.findAll();
		assertThat(troupes, CoreMatchers.notNullValue());
		assertThat(troupes, CoreMatchers.hasItems(liones, aquacircus));
	}

	@Test
	public void testThatTroupeWithNullNameInvalid() {
		Troupe noname = new Troupe(null, "noname");
		// troupeRepo.save();
		
		Set<ConstraintViolation<Troupe>> constraintViolations = validator.validate(noname);

		//assertEquals(1, constraintViolations.size());
		assertThat(constraintViolations.size(), CoreMatchers.is(1));
		
		for(ConstraintViolation<Troupe> c : constraintViolations) {
			//log.error(c.getInvalidValue().toString());
			log.error(c.getMessage());
		}
//		assertEquals("Troupe name may not be null", constraintViolations.iterator().next().getMessage());

		// assertThat(constraintViolations, CoreMatchers.notNullValue());
		// assertThat(constraintViolations.size(), CoreMatchers.is(1));
		// assertThat(troupes, CoreMatchers.hasItems(liones, aquacircus));
	}
}
