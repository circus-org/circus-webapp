package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Circus;
import cane.brothers.circus.repository.CircusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestCircusRepo {

	@Resource
	private CircusRepository circusRepo;
	
	@Test
	public void testGetCircusById() {
		Circus c = circusRepo.findOne(1L);
		assertThat(c, CoreMatchers.notNullValue());
	}
	
	@Test
	public void testGetCircusSize() {
		List<Circus> circus = circusRepo.findAll();
		assertThat(circus.size(), CoreMatchers.is(1));
	}

}
