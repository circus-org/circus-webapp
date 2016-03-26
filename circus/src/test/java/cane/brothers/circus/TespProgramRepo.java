package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Program;
import cane.brothers.circus.repository.ProgramRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TespProgramRepo {

	@Resource
	private ProgramRepository programRepo;
	
	@Test
	public void testGetProgramById() {
		Program program = programRepo.findOne(2L);
		assertThat(program, CoreMatchers.notNullValue());
		assertThat(program.getTitle(), CoreMatchers.is("Львы на арене"));
	}
	
	@Test
	public void testGetProgramSize() {
		List<Program> programs = programRepo.findAll();
		assertThat(programs, CoreMatchers.notNullValue());
		assertThat(programs.size(), CoreMatchers.is(2));
	}
}
