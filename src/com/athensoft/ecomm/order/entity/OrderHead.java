package com.athensoft.ecomm.order.entity;

public class OrderHead {
	private long 	orderId;			//auto-generated using UUID		
	private String 	orderNo;			//defined by customer's business rules, by default using orderId
	private String 	orderDateTime;		//the date and time when the order is created
	private int 	orderStatus;		
	private double 	grandTotalAmount;
	private int 	paymentMethod;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getGrandTotalAmount() {
		return grandTotalAmount;
	}
	public void setGrandTotalAmount(double grandTotalAmount) {
		this.grandTotalAmount = grandTotalAmount;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
