package cane.brothers.circus.data;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cane.brothers.circus.JpaConfig;
import cane.brothers.circus.domain.Circus;
import cane.brothers.circus.domain.CircusLayout;
import cane.brothers.circus.domain.CircusRow;
import cane.brothers.circus.domain.CircusSector;
import cane.brothers.circus.domain.CircusSide;
import cane.brothers.circus.domain.Program;
import cane.brothers.circus.domain.Troupe;
import cane.brothers.circus.repository.CircusLayoutRepository;
import cane.brothers.circus.repository.CircusRepository;
import cane.brothers.circus.repository.CircusRowRepository;
import cane.brothers.circus.repository.CircusSectorRepository;
import cane.brothers.circus.repository.ProgramRepository;
import cane.brothers.circus.repository.TroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestCreateCircusData {
	
	private static final Logger log = LoggerFactory.getLogger(TestCreateCircusData.class);
	
	
	@Resource
	private CircusRepository circusRepo;

	@Resource
	private CircusLayoutRepository layoutRepo;

	@Resource
	private CircusSectorRepository sectorRepo;

	@Resource
	private CircusRowRepository rowRepo;
	
	@Resource
	private TroupeRepository troupeRepo;
	
	@Resource
	private ProgramRepository programRepo;

	
	private Circus circus;
	private CircusLayout layout;
	
	private Troupe liones;
	private Troupe aquacircus;
	
	private Program lionesInArea;
	private Program waterShow;




	@Before
	public void createTestData() {
		// circus
		circus = new Circus("Воронежский цирк", 
				"94006, г. Воронеж, ул. 20-летия октября, 121", 
				"Воронежский государственный цирк им. А. Л. Дурова");
		circus = circusRepo.save(circus);
		
		// layout
		layout = new CircusLayout(circus, "Арена Воронежского цирка ", 2400);
		layout = layoutRepo.save(layout);
		
		// sectors
		CircusSector sector = new CircusSector("Сектор 1", null, 0, CircusSide.RIGHT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 2", null, 0, CircusSide.RIGHT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 3", null, 0, CircusSide.RIGHT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 4", null, 0, CircusSide.RIGHT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 1", null, 0, CircusSide.LEFT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 2", null, 0, CircusSide.LEFT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 3", null, 0, CircusSide.LEFT, layout);
		sector = sectorRepo.save(sector);
		
		sector = new CircusSector("Сектор 4", null, 0, CircusSide.LEFT, layout);
		sector = sectorRepo.save(sector);
		
		// rows
		// right side
		CircusRow row = new CircusRow(1, CircusSide.RIGHT, 29, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(2, CircusSide.RIGHT, 33, layout);
		row = rowRepo.save(row);

		row = new CircusRow(3, CircusSide.RIGHT, 40, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(4, CircusSide.RIGHT, 45, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(5, CircusSide.RIGHT, 50, layout);
		row = rowRepo.save(row);

		row = new CircusRow(6, CircusSide.RIGHT, 54, layout);
		row = rowRepo.save(row);

		row = new CircusRow(7, CircusSide.RIGHT, 63, layout);
		row = rowRepo.save(row);

		row = new CircusRow(8, CircusSide.RIGHT, 67, layout);
		row = rowRepo.save(row);

		row = new CircusRow(9, CircusSide.RIGHT, 71, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(10, CircusSide.RIGHT, 58, layout);
		row = rowRepo.save(row);

		row = new CircusRow(11, CircusSide.RIGHT, 61, layout);
		row = rowRepo.save(row);

		row = new CircusRow(12, CircusSide.RIGHT, 64, layout);
		row = rowRepo.save(row);

		row = new CircusRow(13, CircusSide.RIGHT, 60, layout);
		row = rowRepo.save(row);

		row = new CircusRow(14, CircusSide.RIGHT, 57, layout);
		row = rowRepo.save(row);

		row = new CircusRow(15, CircusSide.RIGHT, 57, layout);
		row = rowRepo.save(row);

		row = new CircusRow(16, CircusSide.RIGHT, 52, layout);
		row = rowRepo.save(row);

		row = new CircusRow(17, CircusSide.RIGHT, 47, layout);
		row = rowRepo.save(row);

		row = new CircusRow(18, CircusSide.RIGHT, 38, layout);
		row = rowRepo.save(row);

		row = new CircusRow(19, CircusSide.RIGHT, 28, layout);
		row = rowRepo.save(row);

		row = new CircusRow(20, CircusSide.RIGHT, 25, layout);
		row = rowRepo.save(row);

		row = new CircusRow(21, CircusSide.RIGHT, 6, layout);
		row = rowRepo.save(row);
		
		// left side
		row = new CircusRow(1, CircusSide.LEFT, 28, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(2, CircusSide.LEFT, 33, layout);
		row = rowRepo.save(row);

		row = new CircusRow(3, CircusSide.LEFT, 38, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(4, CircusSide.LEFT, 43, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(5, CircusSide.LEFT, 47, layout);
		row = rowRepo.save(row);

		row = new CircusRow(6, CircusSide.LEFT, 53, layout);
		row = rowRepo.save(row);

		row = new CircusRow(7, CircusSide.LEFT, 61, layout);
		row = rowRepo.save(row);

		row = new CircusRow(8, CircusSide.LEFT, 65, layout);
		row = rowRepo.save(row);

		row = new CircusRow(9, CircusSide.LEFT, 68, layout);
		row = rowRepo.save(row);
		
		row = new CircusRow(10, CircusSide.LEFT, 58, layout);
		row = rowRepo.save(row);

		row = new CircusRow(11, CircusSide.LEFT, 61, layout);
		row = rowRepo.save(row);

		row = new CircusRow(12, CircusSide.LEFT, 65, layout);
		row = rowRepo.save(row);

		row = new CircusRow(13, CircusSide.LEFT, 60, layout);
		row = rowRepo.save(row);

		row = new CircusRow(14, CircusSide.LEFT, 53, layout);
		row = rowRepo.save(row);

		row = new CircusRow(15, CircusSide.LEFT, 53, layout);
		row = rowRepo.save(row);

		row = new CircusRow(16, CircusSide.LEFT, 71, layout);
		row = rowRepo.save(row);

		row = new CircusRow(17, CircusSide.LEFT, 68, layout);
		row = rowRepo.save(row);

		row = new CircusRow(18, CircusSide.LEFT, 57, layout);
		row = rowRepo.save(row);

		row = new CircusRow(19, CircusSide.LEFT, 51, layout);
		row = rowRepo.save(row);

		row = new CircusRow(20, CircusSide.LEFT, 24, layout);
		row = rowRepo.save(row);

		row = new CircusRow(21, CircusSide.LEFT, 13, layout);
		row = rowRepo.save(row);
				
		// troupes
		liones = new Troupe("Канские Львы", "Михалков");
		liones = troupeRepo.save(liones);
		
		aquacircus = new Troupe("Цирк на воде", "Шевченко");
		aquacircus = troupeRepo.save(aquacircus);
		
		// programs
		DateTime firstDate = new DateTime(2015, 10, 1, 12, 0);
		DateTime lastDate = firstDate.plus(Period.months(3));
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		log.error(String.format("c %s по %s", firstDate.toString(fmt), lastDate.toString(fmt)));
		
		waterShow = new Program("Цирк на воде в Воронеже", "Незабываемое шоу", firstDate, lastDate, aquacircus);
		waterShow = programRepo.save(waterShow);
		
		firstDate = new DateTime(2016, 2, 1, 12, 0);
		lastDate = firstDate.plus(Period.months(3));
		log.error(String.format("c %s по %s", firstDate.toString(fmt), lastDate.toString(fmt)));
		
		lionesInArea =  new Program("Львы на арене", firstDate, lastDate, liones);
		lionesInArea = programRepo.save(lionesInArea);
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(lionesInArea);
	}

}
