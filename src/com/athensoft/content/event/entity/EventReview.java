package com.athensoft.content.event.entity;

import java.util.Date;

/**
 * A review object binding to an event object, which represents a review from web visitors
 * 
 * @author Athens
 * @version 1.0 
 */
public class EventReview {
	
	/**
	 * the status of review, constant value, APPROVED = 1
	 */
	public static final int APPROVED = 1;
	
	/**
	 * the status of review, constant value, PENDING = 2
	 */
	public static final int PENDING = 2;
	
	/**
	 * the status of review, constant value, REJECTED = 3
	 */
	public static final int REJECTED = 3;
	
	/**
	 * global id without business sense
	 */
	private long globalId;
	
	/**
	 * event UUID, the unique id for event objects
	 */
	private String eventUUID;
	
	/**
	 * review UUID, the unique id for review objects
	 */
	private String reviewUUID;
	
	/**
	 * the date-time when the review content is post
	 */
	private Date reviewDatetime;
	
	/**
	 * the id of customer who post the review
	 */
	private long customerId;
	
	/**
	 * the content of the review
	 */
	private String reviewContent;
	
	/**
	 * the status of the review, refer to the constant value
	 * {@link EventReview#APPROVED},{@link EventReview#PENDING},{@link EventReview#REJECTED}
	 * @see EventReview#APPROVED 
	 * @see EventReview#PENDING
	 * @see EventReview#REJECTED
	 */
	private int reviewStatus;
	
	public long getGlobalId() {
		return globalId;
	}
	public void setGlobalId(long globalId) {
		this.globalId = globalId;
	}
	public String getEventUUID() {
		return eventUUID;
	}
	public void setEventUUID(String eventUUID) {
		this.eventUUID = eventUUID;
	}
	public String getReviewUUID() {
		return reviewUUID;
	}
	public void setReviewUUID(String reviewUUID) {
		this.reviewUUID = reviewUUID;
	}
	public Date getReviewDatetime() {
		return reviewDatetime;
	}
	public void setReviewDatetime(Date reviewDatetime) {
		this.reviewDatetime = reviewDatetime;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Override
	public String toString() {
		return "EventReview [globalId=" + globalId + ", eventUUID=" + eventUUID
				+ ", reviewUUID=" + reviewUUID + ", reviewDatetime="
				+ reviewDatetime + ", customerId=" + customerId
				+ ", reviewContent=" + reviewContent + ", reviewStatus="
				+ reviewStatus + "]";
	}

}
