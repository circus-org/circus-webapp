package cane.brothers.circus.domain;

public enum PerformanceState {
	/** 
	 * на сеанс можно купить билеты
	 */
	ACTIVE, 
	
	/**
	 * сеанс уже начался
	 */
	IMPLEMENTED, 
	
	/**
	 * сеанс уже закончился
	 */
	FINISHED, 
	
	/**
	 * сеанс отменили
	 */
	CANCELED,
	
	/**
	 * сеанс перенесли на другое время
	 */
	DEFFERD
}
