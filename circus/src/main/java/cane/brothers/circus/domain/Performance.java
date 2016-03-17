package cane.brothers.circus.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

public class Performance extends BaseEntity {
	
	/**
	 * время и дата начала сеанса
	 */
	private DateTime logOnTime;
	
	/**
	 * код представления
	 */
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="program_id", unique = true, nullable = false)	
	private Program program; 

	private PerformanceState state;

	public Performance() {
	}

	public Performance(DateTime logOnTime, Program program) {
		this.logOnTime = logOnTime;
		this.program = program;
	}

	public Performance(DateTime logOnTime, Program program, PerformanceState state) {
		this.logOnTime = logOnTime;
		this.program = program;
		this.state = state;
	}

	public DateTime getLogOnTime() {
		return logOnTime;
	}

	public void setLogOnTime(DateTime logOnTime) {
		this.logOnTime = logOnTime;
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
	
	
}
