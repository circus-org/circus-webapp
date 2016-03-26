package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CIRCUS_SECTORS")
public class CircusSector extends BaseEntity {

	/**
	 * The short name of the sector, may be a code such as S1, S2, etc.
	 */
	@Column(nullable = false)
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
	@Column(nullable = false)
	private CircusSide side;

	/**
	 * The layout to which this sector belongs
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LAYOUT_ID", nullable = false)
	private CircusLayout layout;

	/**
	 * Default constructor
	 */
	public CircusSector() {
	}

	public CircusSector(String name, String description, int capacity, CircusSide side, CircusLayout layout) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.side = side;
		this.layout = layout;
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

	public CircusSide getSide() {
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

	public void setSide(CircusSide side) {
		this.side = side;
	}

	public void setLayout(CircusLayout layout) {
		this.layout = layout;
	}

}
