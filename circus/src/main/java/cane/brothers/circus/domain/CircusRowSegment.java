package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO value object ??
@Entity
@Table(name = "CIRCUS_ROW_SEGMENTS")
public class CircusRowSegment extends BaseEntity {

	// TODO pk [row, sector]
	@ManyToOne
	@JoinColumn(name = "ROW_ID", nullable = false)
	private CircusRow row;

	@ManyToOne
	@JoinColumn(name = "SECTOR_ID", nullable = false)
	private CircusSector sector;

	/**
	 * first seat number in row segment. Could be 1, etc.
	 */
	@Column(name = "FIRST_SEAT", nullable = false)
	private Short firstSeat;

	/**
	 * last seat number in row segment. Could be 15, etc. Always should be more
	 * than firstSeat.
	 */
	@Column(name = "LAST_SEAT", nullable = false)
	private Short lastSeat;

	/**
	 * Default constructor
	 */
	public CircusRowSegment() {
	}

	public CircusRowSegment(CircusRow row, CircusSector sector, Short firstSeat, Short lastSeat) {
		this.row = row;
		this.sector = sector;
		this.firstSeat = firstSeat;
		this.lastSeat = lastSeat;
	}

	public CircusRow getRow() {
		return row;
	}

	public CircusSector getSector() {
		return sector;
	}

	public Short getFirstSeat() {
		return firstSeat;
	}

	public Short getLastSeat() {
		return lastSeat;
	}

	public void setRow(CircusRow row) {
		this.row = row;
	}

	public void setFirstSeat(Short firstSeat) {
		this.firstSeat = firstSeat;
	}

	public void setLastSeat(Short lastSeat) {
		this.lastSeat = lastSeat;
	}

	public void setSector(CircusSector sector) {
		this.sector = sector;
	}
}
