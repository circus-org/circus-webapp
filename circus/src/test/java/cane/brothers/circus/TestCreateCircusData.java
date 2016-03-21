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
	private Program waterShow;


	@Before
	public void createTestData() {
		// troupes
		liones = troupeRepo.save(new Troupe("Канские Львы", "Михалков"));
		aquacircus = troupeRepo.save(new Troupe("Цирк на воде", "Шевченко"));
		
		// programs
		DateTime firstDate = new DateTime(2015, 10, 1, 12, 0);
		DateTime lastDate = firstDate.plus(Period.months(3));
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		log.error(String.format("c %s по %s", firstDate.toString(fmt), lastDate.toString(fmt)));
		
		waterShow = programRepo.save( new Program("Цирк на воде в Воронеже", "Незабываемое шоу", firstDate, lastDate, aquacircus));
		
		firstDate = new DateTime(2016, 2, 1, 12, 0);
		lastDate = firstDate.plus(Period.months(3));
		log.error(String.format("c %s по %s", firstDate.toString(fmt), lastDate.toString(fmt)));
		
		lionesInArea = programRepo.save( new Program("Львы на арене", firstDate, lastDate, liones));
	}

	@Test
	public void testThatEntitiesCanBeFound() {
		testThatTroupesCanBeFound();
		testThatProgramsCanBeFound();
	}
	
	private void testThatTroupesCanBeFound() {
		List<Troupe> troupes = troupeRepo.findAll();
		log.error(String.format("!!! Есть труппы %s", troupes));
		assertThat(troupes, CoreMatchers.notNullValue());
		assertThat(troupes, CoreMatchers.hasItems(liones, aquacircus));
	}
	
	private void testThatProgramsCanBeFound() {
		List<Program> programs = programRepo.findAll();
		if(programs != null) {
			for(Program p: programs) {
				//Hibernate.initialize(p);
				log.error(String.format("!!! Есть программа: %s", p));
			}
		}
		assertThat(programs, CoreMatchers.notNullValue());
		assertThat(programs, CoreMatchers.hasItems(lionesInArea, waterShow));
	}

}
