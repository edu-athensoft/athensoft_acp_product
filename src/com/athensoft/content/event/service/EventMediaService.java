package com.athensoft.content.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.content.event.dao.EventMediaDao;
import com.athensoft.content.event.entity.EventMedia;

/**
 * EventMedia Service
 * @author Athens
 * @version 1.0
 */
@Service
public class EventMediaService {
	/**
	 * DAO of EventMedia
	 */
	@Autowired
	@Qualifier("eventMediaDaoJDBCImpl")
	private EventMediaDao eventMediaDao;

	public void setEventMediaDao(EventMediaDao eventMediaDao) {
		this.eventMediaDao = eventMediaDao;
	}
	
	/**
	 * get eventMedia objects by its eventUUID
	 * @param eventUUID the eventUUID of eventMedia objects
	 * @return the list of eventMedia objects
	 */
	public List<EventMedia> getEventMediaByEventUUID(String eventUUID){
		return eventMediaDao.findByEventUUID(eventUUID);
	}
	
	/**
	 * get an eventMedia object by its mediaId
	 * @param mediaId the mediaId of eventMedia object
	 * @return the target eventMedia object
	 */
	public EventMedia getEventMediaByMediaId(long mediaId) {
		return eventMediaDao.findById(mediaId);
	}
	
	/**
	 * get the primary eventMedia object from the ones by their eventUUID
	 * @param eventUUID the eventUUID of eventMedia objects
	 * @return the primary eventMedia object
	 */
	public EventMedia getPrimaryMediaByEventUUID(String eventUUID) {
		return eventMediaDao.findPrimaryMediaByEventUUID(eventUUID);
	}
	
	/**
	 * get all eventMedia object<p>
	 * WARNING: DO NOT USE THIS METHOD IN PRODUCT. JUST FOR TEST.
	 * @return the list of eventMedia objects
	 */
	public List<EventMedia> getAllEventMedia() {
		return eventMediaDao.findAll();
	}
	
	/**
	 * create mediaMedia object and persist it
	 * @param media the eventMedia object to persist
	 */
	public void creatEventMedia(EventMedia media) {
		this.eventMediaDao.create(media);
	}
	
	/**
	 * update mediaMedia object and persist it
	 * @param media the eventMedia object to persist
	 */
	public void updateEventMedia(EventMedia media) {
		this.eventMediaDao.update(media);
	}

	/**
	 * @param mediaId
	 * @param eventUUID
	 * @param sortNumber
	 */
	public void changeSortNumber(String mediaId, String eventUUID, String sortNumber) {
		this.eventMediaDao.changeSortNumber(mediaId, eventUUID, sortNumber);		
	}

	/**
	 * @param mediaId
	 * @param eventUUID
	 * @param mediaName
	 */
	public void changeMediaName(String mediaId, String eventUUID, String mediaName) {
		this.eventMediaDao.changeMediaName(mediaId, eventUUID, mediaName);
	}
	
	/**
	 * @param mediaId
	 * @param eventUUID
	 * @param mediaLabel
	 */
	public void changeMediaLabel(String mediaId, String eventUUID, String mediaLabel) {
		this.eventMediaDao.changeMediaLabel(mediaId, eventUUID, mediaLabel);
	}
}
