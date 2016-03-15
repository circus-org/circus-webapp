package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.DateTime;

@Entity
public class Program {

	//TODO GenerationType
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String description;
	
	// TODO LocalTime
	// Will be mapped as DATE (on MySQL), i.e. only date without timestamp
	// For JSON binding use the format: "1970-01-01" (yyyy-MM-dd)
	//private LocalTime date;
	
	// Will be mapped as DATETIME (on MySQL)
	// For JSON binding use the format: "1970-01-01T00:00:00.000+0000"
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDate;
	
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endDate;
	
	
	private Troupe actorsGroup;
	
}
