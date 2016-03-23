package cane.brothers.circus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "PERFORMANCES")
public class Performance extends BaseEntity {

	/**
	 * время и дата начала сеанса
	 */
	private DateTime beginTime;

	/**
	 * код представления
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PROGRAM_ID", unique = true, nullable = false)
	private Program program;

	@Enumerated
	@Column(name = "STATE")
	private PerformanceState state;

	public Performance() {
	}

	public Performance(DateTime logOnTime, Program program) {
		this(logOnTime, program, PerformanceState.INACTIVE);
	}

	public Performance(DateTime logOnTime, Program program, PerformanceState state) {
		this.beginTime = logOnTime;
		this.program = program;
		this.state = state;
	}

	public DateTime getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(DateTime logOnTime) {
		this.beginTime = logOnTime;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public PerformanceState getState() {
		return state;
	}

	public void setState(PerformanceState state) {
		this.state = state;
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.beginTime)
                .append(this.program)
                .append(this.state)
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
        final Performance other = (Performance) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj))
                .append(this.beginTime, other.beginTime)
                .append(this.program, other.program)
                .append(this.state, other.state)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("beginTime", this.beginTime)
                .append("program", this.program)
                .append("state", this.state)
                .toString();
    }

}
