package com.athensoft.ecomm.item.entity;

import java.util.Date;

public class ItemProduct {
	

	private Long 		prodId;
	private Long 		prodBizId;
	private Integer 		brandId;
	private Integer			prodStatus;
	private Integer			prodType;
	private Integer			prodSaleType;
	private Integer			prodSeqNo;
	private Integer			prodCreaterId;
	private String		prodCreaterDatetime;	
	private String 		prodImgUrl;
	
	
	private Integer			prodModifierId;
	private Date		prodModifierDatetime;
	private Integer			prodPublisherId;
	private Date		prodPublisherDatetime;
	private Integer			prodUnPublisherId;
	private Date		prodUnPublisherDatetime;
	
	private ItemProductI18n itemProductI18n;
	
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getProdBizId() {
		return prodBizId;
	}

	public void setProdBizId(Long prodBizId) {
		this.prodBizId = prodBizId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}

	public Integer getProdType() {
		return prodType;
	}

	public void setProdType(Integer prodType) {
		this.prodType = prodType;
	}

	public Integer getProdSaleType() {
		return prodSaleType;
	}

	public void setProdSaleType(Integer prodSaleType) {
		this.prodSaleType = prodSaleType;
	}

	public Integer getProdSeqNo() {
		return prodSeqNo;
	}

	public void setProdSeqNo(Integer prodSeqNo) {
		this.prodSeqNo = prodSeqNo;
	}

	public Integer getProdCreaterId() {
		return prodCreaterId;
	}

	public void setProdCreaterId(Integer prodCreaterId) {
		this.prodCreaterId = prodCreaterId;
	}

	public String getProdCreaterDatetime() {
		return prodCreaterDatetime;
	}

	public void setProdCreaterDatetime(String prodCreaterDatetime) {
		this.prodCreaterDatetime = prodCreaterDatetime;
	}

	public String getProdImgUrl() {
		return prodImgUrl;
	}

	public void setProdImgUrl(String prodImgUrl) {
		this.prodImgUrl = prodImgUrl;
	}

	public Integer getProdModifierId() {
		return prodModifierId;
	}

	public void setProdModifierId(Integer prodModifierId) {
		this.prodModifierId = prodModifierId;
	}

	public Date getProdModifierDatetime() {
		return prodModifierDatetime;
	}

	public void setProdModifierDatetime(Date prodModifierDatetime) {
		this.prodModifierDatetime = prodModifierDatetime;
	}

	public Integer getProdPublisherId() {
		return prodPublisherId;
	}

	public void setProdPublisherId(Integer prodPublisherId) {
		this.prodPublisherId = prodPublisherId;
	}

	public Date getProdPublisherDatetime() {
		return prodPublisherDatetime;
	}

	public void setProdPublisherDatetime(Date prodPublisherDatetime) {
		this.prodPublisherDatetime = prodPublisherDatetime;
	}

	public Integer getProdUnPublisherId() {
		return prodUnPublisherId;
	}

	public void setProdUnPublisherId(Integer prodUnPublisherId) {
		this.prodUnPublisherId = prodUnPublisherId;
	}

	public Date getProdUnPublisherDatetime() {
		return prodUnPublisherDatetime;
	}

	public void setProdUnPublisherDatetime(Date prodUnPublisherDatetime) {
		this.prodUnPublisherDatetime = prodUnPublisherDatetime;
	}

	public ItemProductI18n getItemProductI18n() {
		return itemProductI18n;
	}

	public void setItemProductI18n(ItemProductI18n itemProductI18n) {
		this.itemProductI18n = itemProductI18n;
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
