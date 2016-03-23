package cane.brothers.circus.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LAYOUTS")
public class CircusLayout extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CIRCUS_ID", unique = true, nullable = false)
	private Circus circus;
	
	public CircusLayout() {
	}

}
