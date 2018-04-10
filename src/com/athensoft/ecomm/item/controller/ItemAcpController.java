package com.athensoft.ecomm.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemAcpController {
	
	
	@RequestMapping(value="/item/dashboard")
	public String gotoDashboard(){
		String viewName = "item/item_dashboard";
		return viewName;
	}
	
	
	
	@RequestMapping(value="/item/productList")
	public String gotoProductList(){
		System.out.println("asdasddddddddddddddddd");
		String viewName = "item/item_products_list";
		return viewName;
	}
	
/*	@RequestMapping(value="/item/productEdit")
	public String gotoProductEdit(){
		String viewName = "item/item_product_edit";
		return viewName;
	}
	*/
	
	
}

	

