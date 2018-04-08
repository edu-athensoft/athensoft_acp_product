package com.athensoft.ecomm.order.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	public static final int TRANS_STATUS_CREATED = 20;
	public static final int TRANS_STATUS_PROCESSING = 21;	
	public static final int TRANS_STATUS_COMPLETED = 22;
	public static final int TRANS_STATUS_PENDING = 23;
	public static final int TRANS_STATUS_CANCELED = 24;
	public static final int TRANS_STATUS_FRAUD = 25;
	
	
	/* general info of order*/
	private long 	orderId;			//auto-generated using UUID		
	private String 	orderNo;			//defined by customer's business rules, by default using orderId
	private String 	custNo;
	private String 	orderDateTime;		//the date and time when the order is created
	private int 	orderStatus;		
	private double 	grandTotalAmount;
	private int 	paymentMethod;		
	
	/* customer info */
	private Contact customerContact;
	private Contact billingToContact;
	private Contact shippingToContact;
	
	/* billing address */
	private Address billAddr;
	
	/* billing address */
	private Address shippingAddr;
	
	private List<OrderItem> orderItems;

	public Order(){
		this.orderItems = new ArrayList<OrderItem>();
	}
	
	
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

	public Contact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(Contact customerContact) {
		this.customerContact = customerContact;
	}

	public Contact getBillingToContact() {
		return billingToContact;
	}

	public void setBillingToContact(Contact billingToContact) {
		this.billingToContact = billingToContact;
	}

	public Contact getShippingToContact() {
		return shippingToContact;
	}

	public void setShippingToContact(Contact shippingToContact) {
		this.shippingToContact = shippingToContact;
	}

	public Address getBillAddr() {
		return billAddr;
	}

	public void setBillAddr(Address billAddr) {
		this.billAddr = billAddr;
	}

	public Address getShippingAddr() {
		return shippingAddr;
	}

	public void setShippingAddr(Address shippingAddr) {
		this.shippingAddr = shippingAddr;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNo=" + orderNo + ", custNo=" + custNo + ", orderDateTime="
				+ orderDateTime + ", orderStatus=" + orderStatus + ", grandTotalAmount=" + grandTotalAmount
				+ ", paymentMethod=" + paymentMethod + ", customerContact=" + customerContact + ", billingToContact="
				+ billingToContact + ", shippingToContact=" + shippingToContact + ", billAddr=" + billAddr
				+ ", shippingAddr=" + shippingAddr + ", orderItems=" + orderItems + "]";
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	
	
	
	
}
