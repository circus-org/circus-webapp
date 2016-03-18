package cane.brothers.circus;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestTroupeRepository {

	@Resource
	private TroupeRepository troupeRepo;
	
	@Before
	public void createTroupes() {
		// TODO
	}
}
