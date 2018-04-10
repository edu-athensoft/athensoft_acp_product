package com.athensoft.ecomm.item.entity;

import java.util.Date;

public class ItemProduct {
	
	private long 		prodId;
	private long 		prodBizId;
	private int 		brandId;
	private int			prodStatus;
	private int			prodType;
	private int			prodSaleType;
	private int			prodSeqNo;
	private int			prodCreaterId;
	private Date		prodCreaterDatetime;
	
	private int			prodModifierId;
	private Date		prodModifierDatetime;
	private int			prodPublisherId;
	private Date		prodPublisherDatetime;
	private int			prodUnPublisherId;
	private Date		prodUnPublisherDatetime;
	
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public long getProdBizId() {
		return prodBizId;
	}
	public void setProdBizId(long prodBizId) {
		this.prodBizId = prodBizId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(int prodStatus) {
		this.prodStatus = prodStatus;
	}
	public int getProdType() {
		return prodType;
	}
	public void setProdType(int prodType) {
		this.prodType = prodType;
	}
	public int getProdSaleType() {
		return prodSaleType;
	}
	public void setProdSaleType(int prodSaleType) {
		this.prodSaleType = prodSaleType;
	}
	public int getProdSeqNo() {
		return prodSeqNo;
	}
	public void setProdSeqNo(int prodSeqNo) {
		this.prodSeqNo = prodSeqNo;
	}
	public int getProdCreaterId() {
		return prodCreaterId;
	}
	public void setProdCreaterId(int prodCreaterId) {
		this.prodCreaterId = prodCreaterId;
	}
	public Date getProdCreaterDatetime() {
		return prodCreaterDatetime;
	}
	public void setProdCreaterDatetime(Date prodCreaterDatetime) {
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
