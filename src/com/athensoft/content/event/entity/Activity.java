package com.athensoft.content.event.entity;

import java.util.Date;

/**
 * A concrete class of event, represents an activity
 * 
 * @author Athens
 * @version 1.0 
 */
public class Activity extends Event {
	
	/**
	 * the start date of the activity, a timestamp
	 */
	private Date activityStartDate;
	
	/**
	 * the end date of the activity, a timestamp
	 */
	private Date activityEndDate;
	
	/**
	 * the location of the activity
	 */
	private String activityLocation;
	
	
	public Date getActivityStartDate() {
		return activityStartDate;
	}
	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}
	public Date getActivityEndDate() {
		return activityEndDate;
	}
	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}
	public String getActivityLocation() {
		return activityLocation;
	}
	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}
	
	@Override
	public String toString() {
		return "Activity [activityStartDate=" + activityStartDate + ", activityEndDate=" + activityEndDate
				+ ", activityLocation=" + activityLocation + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
