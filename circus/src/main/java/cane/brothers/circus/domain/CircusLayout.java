package cane.brothers.circus.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CIRCUS_LAYOUTS")
public class CircusLayout extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CIRCUS_ID", unique = true, nullable = false)
	private Circus circus;
	
	/**
	 * Circus layout name
	 */
	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	
	/**
	 * Circus arena capacity
	 */
	private int capacity;
	
	/**
	 * Constructor
	 */
	public CircusLayout() {
		super();
	}

	public CircusLayout(Circus circus, String name, int capacity) {
		super();
		this.circus = circus;
		this.name = name;
		this.capacity = capacity;
	}

	public Circus getCircus() {
		return circus;
	}

	public void setCircus(Circus circus) {
		this.circus = circus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
