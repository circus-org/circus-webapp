package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CIRCUS_ROWS")
public class CircusRow extends BaseEntity {

	/**
	 * The row number
	 */
	@Column(name = "ROW_NUM", nullable = false)
	private int number;

	/**
	 * Left or right side to which this row belongs
	 */
	@Column(nullable = false)
	private CircusSide side;

	/**
	 * Number of seats in row
	 */
	private int capacity;

	/**
	 * The layout to which this sector belongs
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LAYOUT_ID", nullable = false)
	private CircusLayout layout;

	/**
	 * Default constructor
	 */
	public CircusRow() {
	}

	public CircusRow(Integer number, CircusSide side, int capacity, CircusLayout layout) {
		super();
		this.number = number;
		this.side = side;
		this.capacity = capacity;
		this.layout = layout;
	}

	public int getNumber() {
		return number;
	}

	public CircusSide getSide() {
		return side;
	}

	public CircusLayout getLayout() {
		return layout;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSide(CircusSide side) {
		this.side = side;
	}

	public void setLayout(CircusLayout layout) {
		this.layout = layout;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
