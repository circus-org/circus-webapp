package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.CircusRow;
import cane.brothers.circus.repository.CircusRowRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestRowRepo {

	@Resource
	private CircusRowRepository rowRepo;
	
	@Test
	public void testGetRowById() {
		CircusRow row = rowRepo.findOne(1L);
		assertThat(row, CoreMatchers.notNullValue());
		assertThat(row.getCapacity(), CoreMatchers.is(29));
	}
	
	@Test
	public void testGetRowSize() {
		List<CircusRow> rows = rowRepo.findAll();
		assertThat(rows, CoreMatchers.notNullValue());
		assertThat(rows.size(), CoreMatchers.is(42));
	}
	
	@Test
	public void testGetFullRowCapacity() {
		List<CircusRow> rows = rowRepo.findAll();
		int c = 0;
		assertThat(rows, CoreMatchers.notNullValue());
		for(CircusRow r: rows) {
			c += r.getCapacity();
		}
		//assertThat(c, CoreMatchers.is(2400));
		assertThat(c, CoreMatchers.is(2075));
	}
}
