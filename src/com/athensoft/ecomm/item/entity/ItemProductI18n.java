package com.athensoft.ecomm.item.entity;

public class ItemProductI18n {
	
	private int prodI18nId;
	private String prodId;
	private int langNo;
	private String prodName;
	private String prodNameAlias;
	private String prodDesc;
	private String prodDescLong;
	
	
	public int getProdI18nId() {
		return prodI18nId;
	}
	public void setProdI18nId(int prodI18nId) {
		this.prodI18nId = prodI18nId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String string) {
		this.prodId = string;
	}
	public int getLangNo() {
		return langNo;
	}
	public void setLangNo(int langNo) {
		this.langNo = langNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdNameAlias() {
		return prodNameAlias;
	}
	public void setProdNameAlias(String prodNameAlias) {
		this.prodNameAlias = prodNameAlias;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getProdDescLong() {
		return prodDescLong;
	}
	public void setProdDescLong(String prodDescLong) {
		this.prodDescLong = prodDescLong;
	}
	
	
	
}
