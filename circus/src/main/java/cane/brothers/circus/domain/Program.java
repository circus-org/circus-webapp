package cane.brothers.circus.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

@Entity
public class Program extends BaseEntity {
	
	private String title;
	private String description;
	
	// TODO ValueObject for time period
	// TODO LocalTime
	
	// Will be mapped as DATE (on MySQL), i.e. only date without timestamp
	// For JSON binding use the format: "1970-01-01" (yyyy-MM-dd)
	//private LocalTime date;
	
	// Will be mapped as DATETIME (on MySQL)
	// For JSON binding use the format: "1970-01-01T00:00:00.000+0000"
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDate;
	
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endDate;
	
	
	/**
	 * The troupe of circus performers
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="troupe_id", unique = true, nullable = false, updatable = false)
	private Troupe actorsGroup;


	public Program() {
	}


	public Program(String title, DateTime startDate, DateTime endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Program(Long id, String title, String description, DateTime startDate, DateTime endDate,
			Troupe actorsGroup) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.actorsGroup = actorsGroup;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public DateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}


	public DateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}


	public Troupe getActorsGroup() {
		return actorsGroup;
	}


	public void setActorsGroup(Troupe actorsGroup) {
		this.actorsGroup = actorsGroup;
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.title)
                .append(this.startDate)
                .append(this.endDate)
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
        final Program other = (Program) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj))
                .append(this.title, other.title)
                .append(this.startDate, other.startDate)
                .append(this.endDate, other.endDate)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("title", this.title)
                .append("startDate", this.startDate)
                .append("endDate", this.endDate)
                .append("actorsGroup", this.actorsGroup)
                .toString();
    }
}