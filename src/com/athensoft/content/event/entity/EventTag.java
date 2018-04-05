package com.athensoft.content.event.entity;

/**
 * A tag object binding to an event object, which represents a keyword
 * 
 * @author Athens
 * @version 1.0 
 */
public class EventTag {
	
	/**
	 * the id of event tag
	 */
	private long tagId;
	
	/**
	 * event UUID, the unique id for event objects
	 */
	private String eventUUID;
	
	/**
	 * the name of tag
	 */
	private String tagName;
	
	/**
	 * the description of tag
	 */
	private String tagDesc;
	
	public long getTagId() {
		return tagId;
	}
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	public String getEventUUID() {
		return eventUUID;
	}
	public void setEventUUID(String eventUUID) {
		this.eventUUID = eventUUID;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagDesc() {
		return tagDesc;
	}
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}
	@Override
	public String toString() {
		return "EventTag [tagId=" + tagId + ", eventUUID=" + eventUUID + ", tagName=" + tagName + ", tagDesc=" + tagDesc
				+ "]";
	}
	
	
}
