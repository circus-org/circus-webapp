package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

/**
 * Represents a root element in the circus.
 * 
 * @author cane
 */
@Entity
@Table(name = "CIRCUS")
public class Circus extends BaseEntity {

	private String name;
	
	private String address;
	
	private String descr;
	
	//private Map<String, String> tels;
	
	/**
	 * Head of the venue.
	 */
	@Column(name = "HEAD_OF")
	private String head;
	
	@Column(name = "FOUNDATION_DATE")
	private DateTime foundationDate;
	
	/**
	 * Default constructor
	 */
	public Circus() {
	}

	public Circus(String name, String address, String descr) {
		super();
		this.name = name;
		this.address = address;
		this.descr = descr;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getDescr() {
		return descr;
	}

	public String getHead() {
		return head;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public void setHead(String head) {
		this.head = head;
	}

}
