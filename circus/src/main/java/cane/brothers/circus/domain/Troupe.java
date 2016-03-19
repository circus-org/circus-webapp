package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "TROUPES"
// ,uniqueConstraints = { @UniqueConstraint(name = "UK_NAME", columnNames = "NAME") }
// org.springframework.dao.DataIntegrityViolationException: could not execute statement;
// nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
)
public class Troupe extends BaseEntity {

	/**
	 * brand name of the troupe.
	 */
	@NotNull(message = "{empty.troupe.name}")
	@Column(name = "NAME", nullable = false)
	//, unique = true)
	private String name;

	/**
	 * Head of the troupe - responsible person.
	 */
	@Column(name = "HEAD_OF")
	private String head;

	public Troupe() {
	}

	public Troupe(String name) {
		this.name = name;
	}

	public Troupe(String name, String head) {
		this.name = name;
		this.head = head;
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
	public int hashCode() {
		return new HashCodeBuilder()
				.appendSuper(super.hashCode())
				.append(this.name)
				.append(this.head)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Troupe other = (Troupe) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(this.name, other.name)
				.append(this.head, other.head)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", this.getId())
				.append("name", this.name)
				.append("head", this.head)
				.toString();
	}
}
