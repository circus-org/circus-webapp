package cane.brothers.circus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

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
	
	@Test
	public void createTroupes() {
		Troupe liones = troupeRepo.save(new Troupe("Канские Львы", "Михаилков"));
		assertThat(troupeRepo.findOne(liones.getId()), is(liones));
	}
}
