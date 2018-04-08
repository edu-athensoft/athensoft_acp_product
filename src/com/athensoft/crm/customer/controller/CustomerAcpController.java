package com.athensoft.crm.customer.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.crm.customer.entity.BillToContact;
import com.athensoft.crm.customer.service.BillToContactService;

@Controller
public class CustomerAcpController {
	
	private static final Logger logger = Logger.getLogger(CustomerAcpController.class);
	
	
	
	/**
	 * go to the view of CRM dashboard
	 * @return the target view name
	 */
	@RequestMapping(value="/crm/dashboard")
	public String gotoDashboard(){
		String viewName = "crm/crm_dashborad";
		return viewName;
	}
	
	/**
	 * go to the view of customer contact listing
	 * @return the target view name 
	 */
	@RequestMapping(value="/crm/customerContactList")
	public String gotoCustomerContactList(){
		String viewName = "crm/customer_contact_list";
		return viewName;
	}
	
	@RequestMapping(value="/crm/billtoContactList")
	public String gotoBilltoContactList(){
		String viewName = "crm/billto_contact_list";
		return viewName;
	}
	
	@RequestMapping(value="/crm/shiptoContactList")
	public String gotoShiptoContactList(){
		String viewName = "crm/shipto_contact_list";
		return viewName;
	}
	
	
}
