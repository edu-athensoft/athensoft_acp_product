package com.athensoft.ecomm.item.entity;

public class ItemCategory {
	
	private Long 		categoryId;
	private Long 		parentId;
	private String 		categoryName;
	private String 		categoryDesc;
	private String 		categoryCode;
	private Integer			categoryLevel;
	private Integer			categoryStatus;
	
	/*
	 * 
	 * itemCat£º{"parentId":"2---Security System"
	 * ,"categoryName":"1"
	 * ,"categoryDesc":"1"
	 * ,"categoryLevel":"1"
	 * ,"categoryStatus":"0"
	 * ,"categoryId":"",
	 * "categoryCode":""}
	 * 
	 * */
	
	





	@Override
	public String toString() {
		return "ItemCategory [categoryId=" + categoryId + ", parentId=" + parentId + ", categoryName=" + categoryName
				+ ", categoryDesc=" + categoryDesc + ", categoryCode=" + categoryCode + ", categoryLevel="
				+ categoryLevel + ", categoryStatus=" + categoryStatus + "]";
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public Integer getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(Integer categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	
	
	
}
