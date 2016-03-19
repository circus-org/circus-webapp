package cane.brothers.circus;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.domain.Program;
import cane.brothers.circus.domain.Troupe;
import cane.brothers.circus.repository.ProgramRepository;
import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestCreateCircusData {
	
	private static final Logger log = LoggerFactory.getLogger(TestCreateCircusData.class);
	
	@Resource
	private TroupeRepository troupeRepo;
	
	@Resource
	private ProgramRepository programRepo;

	private Troupe liones;
	private Troupe aquacircus;
	
	private Program lionesInArea;


	@Before
	public void createTestData() {
		// troupes
		liones = troupeRepo.save(new Troupe("Канские Львы", "Михаилков"));
		aquacircus = troupeRepo.save(new Troupe("Цирк на воде", "Шевченко"));
		
		// programs
		DateTime firstJan = new DateTime(2016, 1, 1, 12, 0);
		DateTime firstApr = firstJan.plus(Period.months(3));
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		log.error(String.format("c %s по %s", firstJan.toString(fmt), firstApr.toString(fmt)));
		
		lionesInArea = programRepo.save( new Program("Львы на арене", firstJan, firstApr, liones));
	}

	@Test
	public void testThatTroupesCanBeFound() {
		List<Troupe> troupes = troupeRepo.findAll();
		assertThat(troupes, CoreMatchers.notNullValue());
		assertThat(troupes, CoreMatchers.hasItems(liones, aquacircus));
	}
	
	@Test
	public void testThatProgramsCanBeFound() {
		List<Program> programs = programRepo.findAll();
		assertThat(programs, CoreMatchers.notNullValue());
		assertThat(programs, CoreMatchers.hasItems(lionesInArea));
	}

}
