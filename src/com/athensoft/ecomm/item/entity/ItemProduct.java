package com.athensoft.ecomm.item.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemProduct {
	
	public static final String NEWCREATED = "1";
	public static final String PUBLISHED = "2";
	public static final String UNPUBLISHED = "3";
	public static final String DELETED = "4";
	
	private String 		prodId;
	private String 		prodBizId;
	private int 		brandId;
	private String			prodStatus;
	private String			prodType;
	private String			prodSaleType;
	private String			prodSeqNo;
	private int			prodCreaterId;
	private String		prodCreaterDatetime;
	
	private int			prodModifierId;
	private Date		prodModifierDatetime;
	private int			prodPublisherId;
	private Date		prodPublisherDatetime;
	private int			prodUnPublisherId;
	private Date		prodUnPublisherDatetime;
	
	private ItemProductI18n itemProductI18n;
	public ItemProductI18n getItemProductI18n() {
		return itemProductI18n;
	}


	public void setItemProductI18n(ItemProductI18n itemProductI18n) {
		this.itemProductI18n = itemProductI18n;
	}


	public String getProdId() {
		return prodId;
	}


	public void setProdId(String prodId) {
		this.prodId = prodId;
	}


	public String getProdBizId() {
		return prodBizId;
	}


	public void setProdBizId(String prodBizId) {
		this.prodBizId = prodBizId;
	}


	public int getBrandId() {
		return brandId;
	}


	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public String getProdStatus() {
		return prodStatus;
	}


	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}


	public String getProdType() {
		return prodType;
	}


	public void setProdType(String prodType) {
		this.prodType = prodType;
	}


	public String getProdSaleType() {
		return prodSaleType;
	}


	public void setProdSaleType(String prodSaleType) {
		this.prodSaleType = prodSaleType;
	}


	public String getProdSeqNo() {
		return prodSeqNo;
	}


	public void setProdSeqNo(String prodSeqNo) {
		this.prodSeqNo = prodSeqNo;
	}


	public int getProdCreaterId() {
		return prodCreaterId;
	}


	public void setProdCreaterId(int prodCreaterId) {
		this.prodCreaterId = prodCreaterId;
	}


	public String getProdCreaterDatetime() {
		return prodCreaterDatetime;
	}


	public void setProdCreaterDatetime(String prodCreaterDatetime) {
		this.prodCreaterDatetime = prodCreaterDatetime;
	}


	public int getProdModifierId() {
		return prodModifierId;
	}


	public void setProdModifierId(int prodModifierId) {
		this.prodModifierId = prodModifierId;
	}


	public Date getProdModifierDatetime() {
		return prodModifierDatetime;
	}


	public void setProdModifierDatetime(Date prodModifierDatetime) {
		this.prodModifierDatetime = prodModifierDatetime;
	}


	public int getProdPublisherId() {
		return prodPublisherId;
	}


	public void setProdPublisherId(int prodPublisherId) {
		this.prodPublisherId = prodPublisherId;
	}


	public Date getProdPublisherDatetime() {
		return prodPublisherDatetime;
	}


	public void setProdPublisherDatetime(Date prodPublisherDatetime) {
		this.prodPublisherDatetime = prodPublisherDatetime;
	}


	public int getProdUnPublisherId() {
		return prodUnPublisherId;
	}


	public void setProdUnPublisherId(int prodUnPublisherId) {
		this.prodUnPublisherId = prodUnPublisherId;
	}


	public Date getProdUnPublisherDatetime() {
		return prodUnPublisherDatetime;
	}


	public void setProdUnPublisherDatetime(Date prodUnPublisherDatetime) {
		this.prodUnPublisherDatetime = prodUnPublisherDatetime;
	}


	@Override
	public String toString() {
		return "ItemProduct [prodId=" + prodId + ", prodBizId=" + prodBizId + ", brandId=" + brandId + ", prodStatus="
				+ prodStatus + ", prodType=" + prodType + ", prodSaleType=" + prodSaleType + ", prodSeqNo=" + prodSeqNo
				+ ", prodCreaterId=" + prodCreaterId + ", prodCreaterDatetime=" + prodCreaterDatetime
				+ ", prodModifierId=" + prodModifierId + ", prodModifierDatetime=" + prodModifierDatetime
				+ ", prodPublisherId=" + prodPublisherId + ", prodPublisherDatetime=" + prodPublisherDatetime
				+ ", prodUnPublisherId=" + prodUnPublisherId + ", prodUnPublisherDatetime=" + prodUnPublisherDatetime
				+ "]";
	}





	
	
	
}
