package com.athensoft.content.event.entity;

/**
 * A concrete class of event, represents a piece of news
 * 
 * @author Athens
 * @version 1.0 
 */
/**
 * @author Athens
 *
 */
public class News extends Event {

	/**
	 * the status of event, constant value, PUBLISHED = 1
	 */
	public final static int PUBLISHED = 1;
	
	/**
	 * the status of event, constant value, WAIT_TO_POST = 2
	 */
	public final static int WAIT_TO_POST = 2;
	
	/**
	 * the status of event, constant value, DELETED = 3
	 */
	public final static int DELETED = 3;
	
	/**
	 * the status of event, constant value, OUT_OF_DATE = 4
	 */
	
	public final static int OUT_OF_DATE = 4;
	
	/**
	 * the status of event, constant value, SUSPENDED = 5
	 */
	public final static int SUSPENDED = 5;
	
	/**
	 * the category of news, constant value, CLASS_DEFAULT = 0
	 */
	public final static int CLASS_DEFAULT = 1;
	
	/**
	 * the category of news, constant value, CLASS_NEW = 1
	 */
	public final static int CLASS_NEW = 2;
	
	/**
	 * the category of news, constant value, CLASS_HOT = 2
	 */
	public final static int CLASS_HOT = 3;
	
	
	
	@Override
	public String toString() {
		return "News [toString()=" + super.toString() + "]";
	}
	
	
}
