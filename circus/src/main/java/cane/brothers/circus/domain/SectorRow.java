package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SECTOR_ROWS")
public class SectorRow extends BaseEntity {

	/**
	 * The short name of the sector row, may be a code such as ..., etc.
	 */
	private String name;

	private int capacity;

	@ManyToOne
	@JoinColumn(name = "SECTOR_ID")
	private Sector sector;

	public SectorRow() {
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public Sector getSector() {
		return sector;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
