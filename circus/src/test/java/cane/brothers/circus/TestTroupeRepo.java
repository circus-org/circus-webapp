package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Troupe;
import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestTroupeRepo {

	@Resource
	private TroupeRepository troupeRepo;
	
	@Test
	public void testGetTroupesById() {
		Troupe lines = troupeRepo.findOne(1L);
		assertThat(lines, CoreMatchers.notNullValue());
		assertThat(lines.getName(), CoreMatchers.is("Канские Львы"));
	}
	
	@Test
	public void testGetTroupesSize() {
		List<Troupe> troupes = troupeRepo.findAll();
		assertThat(troupes, CoreMatchers.notNullValue());
		assertThat(troupes.size(), CoreMatchers.is(2));
	}
	
//	@Test
//	public void testGetTroupesByName() {
//	}
	
}
