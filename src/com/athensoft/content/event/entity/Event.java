package com.athensoft.content.event.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A high-level class of event, may have multiple subclasses, represents a message to publish
 * 
 * @author Athens
 * @version 1.0 
 */
public class Event {
	/**
	 * global id without business sense
	 */
	private long 		globalId;
	
	/**
	 * event UUID, the unique id for event objects
	 */
	private String 		eventUUID;
	
	/**
	 * event title, could be shown at front end pages
	 */
	private String 		title;
	
	/**
	 * event author who composites the content of event
	 */
	private String 		author;
	
	/**
	 * the date-time when the event content is post
	 */
	private Date 		postDatetime;
	
	/**
	 * the number of views on the event, a statistics indicator
	 */
	private int 		viewNum;
	
	/**
	 * the short description, short content of event
	 */
	private String 		descShort;
	
	/**
	 * the long description, long content of event
	 */
	private String 		descLong;
	
	/**
	 * the class(category) of event
	 */
	private String 		eventClass;
	
	/**
	 * the status of event
	 */
	private int 		eventStatus;	
	
	/**
	 * the primary media object which is binding to the event
	 */
	private EventMedia 	primaryEventMedia;
	
	/**
	 * the list of event tag objects which are binding to the event
	 */
	private List<EventTag> listEventTag = new ArrayList<EventTag>();
	
	/**
	 * the list of event media objects which are binding to the event
	 */
	private List<EventMedia> listEventMedia = new ArrayList<EventMedia>();
	
	/**
	 * the list of event review objects which are binding to the event
	 */
	private List<EventReview> listEventReview = new ArrayList<EventReview>();
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPostDatetime() {
		return postDatetime;
	}
	public void setPostDatetime(Date postDatetime) {
		this.postDatetime = postDatetime;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public String getDescShort() {
		return descShort;
	}
	public void setDescShort(String descShort) {
		this.descShort = descShort;
	}
	public String getDescLong() {
		return descLong;
	}
	public void setDescLong(String descLong) {
		this.descLong = descLong;
	}
	public String getEventClass() {
		return eventClass;
	}
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}
	public int getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(int eventStatus) {
		this.eventStatus = eventStatus;
	}
	
	public EventMedia getPrimaryEventMedia() {
		return this.primaryEventMedia;
	}
	
	public void setPrimaryEventMedia() {
		EventMedia em = null;
		int size = this.listEventMedia.size();
		if(size>0){
			for(int i=0; i<size; i++){
				EventMedia tmpEm = listEventMedia.get(i);
				if(tmpEm.isPrimaryMedia()){
					em = tmpEm;
					break;
				}
			}
		}else{
			System.out.println("WARNING: "+this.getClass().getName()+" - no eventmedia object in the list");
			em = new EventMedia();
			em.setMediaName("default media");
			em.setMediaURL("event-default.png");
		}
		
		this.primaryEventMedia = em;
	}
	
	public List<EventTag> getListEventTag() {
		return listEventTag;
	}
	public void setListEventTag(List<EventTag> listEventTag) {
		this.listEventTag = listEventTag;
	}
	public List<EventMedia> getListEventMedia() {
		return listEventMedia;
	}
	public void setListEventMedia(List<EventMedia> listEventMedia) {
		this.listEventMedia = listEventMedia;
	}

	public List<EventReview> getListEventReview() {
		return listEventReview;
	}
	public void setListEventReview(List<EventReview> listEventReview) {
		this.listEventReview = listEventReview;
	}
	
	@Override
	public String toString() {
		return "Event [globalId=" + globalId + ", eventUUID=" + eventUUID + ", title=" + title + ", author=" + author
				+ ", postDatetime=" + postDatetime + ", viewNum=" + viewNum + ", descShort=" + descShort + ", descLong="
				+ descLong + ", eventClass=" + eventClass + ", eventStatus=" + eventStatus + "]";
	}
}
