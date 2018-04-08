package com.athensoft.content.event.entity;

import java.util.Date;

/**
 * A media object binding to an event object, which contains such media as picture,audio,video
 * 
 * @author Athens
 * @version 1.0 
 */
public class EventMedia {
	/**
	 * the global media id without business sense
	 */
	private long mediaId;
	
	/**
	 * event UUID, the unique id for event objects
	 */
	private String eventUUID;
	
	/**
	 * the URL string of media object
	 * pattern: /{eventUUID}/{mediaFileName}
	 */
	private String mediaURL;
	
	/**
	 * the media file name of media object
	 */
	private String mediaName;
	
	/**
	 * the label or title of the media object
	 */
	private String mediaLabel;
	
	/**
	 * the sort number of media object, ascending
	 */
	private int sortNumber;
	
	/**
	 * the flag of primary media which is taken as cover media
	 */
	private boolean primaryMedia;
	
	/**
	 * the type of media indicating the format of media file
	 * the type could be {jpg,png,video link,audio link,...}
	 */
	private int mediaType;
	
	/**
	 * the date-time when the media binding to the event content is post
	 */
	private Date postTimestamp;
	
	//private boolean flag;
		
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
	public String getEventUUID() {
		return eventUUID;
	}
	public void setEventUUID(String eventUUID) {
		this.eventUUID = eventUUID;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public int getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}
	public boolean isPrimaryMedia() {
		return primaryMedia;
	}
	public void setPrimaryMedia(boolean isPrimaryMedia) {
		this.primaryMedia = isPrimaryMedia;
	}
	public int getMediaType() {
		return mediaType;
	}
	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}
	public Date getPostTimestamp() {
		return postTimestamp;
	}
	public void setPostTimestamp(Date postTimestamp) {
		this.postTimestamp = postTimestamp;
	}
	public String getMediaLabel() {
		return mediaLabel;
	}
	public void setMediaLabel(String mediaLabel) {
		this.mediaLabel = mediaLabel;
	}
	
	@Override
	public String toString() {
		return "EventMedia [mediaId=" + mediaId + ", eventUUID=" + eventUUID + ", mediaURL=" + mediaURL + ", mediaName="
				+ mediaName + ", mediaLabel=" + mediaLabel + ", sortNumber=" + sortNumber + ", primaryMedia="
				+ primaryMedia + ", mediaType=" + mediaType + ", postTimestamp=" + postTimestamp + "]";
	}
}
