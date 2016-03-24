package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO
//@Entity
@Table(name = "TICKETS")
public class Ticket extends BaseEntity {

	/**
	 * Show id
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PERFORMANCE_ID", unique = true, nullable = false)
	private Performance performance;
	
	public Ticket() {
	}

}
