package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SECTORS")
public class Sector extends BaseEntity {

	/**
	 * The short name of the sector, may be a code such as S1, S2, etc.
	 */
	private String name;

	/**
	 * The description of the section, such as 'Rear Balcony', etc.
	 */
	private String description;

	/**
	 * The total seating capacity of the sector
	 */
	private int capacity;

	/**
	 * Left or right side to which this sector belongs
	 */	
	private Side side;

	/**
	 * The layout to which this sector belongs
	 */
	private CircusLayout layout;

	public Sector() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getCapacity() {
		return capacity;
	}

	public Side getSide() {
		return side;
	}

	public CircusLayout getLayout() {
		return layout;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public void setLayout(CircusLayout layout) {
		this.layout = layout;
	}

}
