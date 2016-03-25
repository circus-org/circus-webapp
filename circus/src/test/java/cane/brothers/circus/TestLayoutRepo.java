package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.CircusLayout;
import cane.brothers.circus.repository.CircusLayoutRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestLayoutRepo {

	@Resource
	private CircusLayoutRepository layoutRepo;
	
	@Test
	public void testGetLayoutById() {
		CircusLayout layout = layoutRepo.findOne(1L);
		assertThat(layout, CoreMatchers.notNullValue());
	}
	
	@Test
	public void testGetLayoutSize() {
		List<CircusLayout> layouts = layoutRepo.findAll();
		assertThat(1, CoreMatchers.is(layouts.size()));
	}
}
