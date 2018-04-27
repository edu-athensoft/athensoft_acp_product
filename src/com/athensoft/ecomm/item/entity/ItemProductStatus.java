package com.athensoft.ecomm.item.entity;

import java.util.Date;

public class ItemProductStatus {
	
	public static final int NEWCREATED = 1;
	public static final int PUBLISHED = 2;
	public static final int UNPUBLISHED = 3;
	public static final int DELETED = 4;
		
	public static int getNewcreated() {
		return NEWCREATED;
	}
	public static int getPublished() {
		return PUBLISHED;
	}
	public static int getUnpublished() {
		return UNPUBLISHED;
	}
	public static int getDeleted() {
		return DELETED;
	}
	
}
