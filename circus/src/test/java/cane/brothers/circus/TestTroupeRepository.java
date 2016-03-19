package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Troupe;
import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestTroupeRepository {

	@Resource
	private TroupeRepository troupeRepo;
	
	private Troupe liones;
	private Troupe aquacircus;
	
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
}
