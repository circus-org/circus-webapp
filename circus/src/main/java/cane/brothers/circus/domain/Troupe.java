package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Troupe {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String head;
	
	public Troupe() {
	}

	public Troupe(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	
	@Override
	public String toString() {
		return String.format("Troupe [id=%s, name=%s, head=%s]", id, name, head);
	}
}
