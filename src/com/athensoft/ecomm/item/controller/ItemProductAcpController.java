package com.athensoft.ecomm.item.controller;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.athensoft.content.event.controller.NewsAcpController;
import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.entity.News;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.service.ItemProductService;

@Controller
public class ItemProductAcpController {

	private static final Logger logger = Logger.getLogger(NewsAcpController.class);
	private static final String ACTION_EDIT = "Edit";
	private static final String ACTION_DELETE = "Delete";
	
	
	@Autowired
	public ItemProductService itemProductService;
	
	public void setItemProductService(ItemProductService itemProductService) {
		this.itemProductService = itemProductService;
	}


	/**
	 * get news objects in JSON data form
	 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value="/item/productListData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataProductList(){
		logger.info("entering /item/productListData");
		
		ModelAndView mav = new ModelAndView();
		
		//data
		List<ItemProduct> listProduct = itemProductService.findAllProduct();
		logger.info("Length of news entries: "+ listProduct.size());
		
		String[][] data = getData(listProduct, ACTION_EDIT);
		
		Map<String, Object> model = mav.getModel();
		
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus","OK");
		model.put("customActionMessage","Data loaded");
		
		logger.info("leaving /item/productListData");
		return model;
	}
	
	private String[][] getData(List<ItemProduct> listProduct, String actionName){
		int entryLength = listProduct.size();
		final int COLUMN_NUM = 10;
		String[][] data = new String[entryLength][COLUMN_NUM];
		
		String field0 = "";	//check box
		String field1 = "";	//product biz id
		String field2 = "";	//product sequence no
		String field3 = "";	//prodcut type
		String field4 = "";	//product Sale Type
		String field5 = "";	//post datetime
		String field6 = "";	//view num
		String field7 = "";	//event status
		String field8 = "";	//action
		//String field9 = "";
		
		for(int i=0; i<entryLength ; i++){			
			field0 = "<input type='checkbox' name='id[]' value="+listProduct.get(i).getProdBizId()+">";
			field1 = listProduct.get(i).getProdBizId()+"";
			field2 = listProduct.get(i).getProdSeqNo()+"";
			field3 = listProduct.get(i).getProdType()+"";
			field4 = listProduct.get(i).getProdSaleType()+"";
			field5 = listProduct.get(i).getItemProductI18n().getProdName()+""; 
			field6 = listProduct.get(i).getProdCreaterDatetime()+"";
			
		/*	int intProductStatus = listProduct.get(i).getProdStatus();*/
			String[] productStatus= getProductStatus(listProduct.get(i));
			String productStatu= productStatus[0];
			String productStatusKey=productStatus[1];
			
			field7 = "<span class='label label-sm label-"+productStatusKey+"'>"+productStatu+"</span>";
			
			
			field8 = "<a href='/acp/item/"+getAction(actionName)+"?prodId="+field1+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> "+actionName+"</a>";
			//field9 = "<a href='/acp/item/"+getAction(actionName)+"?prodBizId="+field1+"' '><i class='fa fa-pencil'></i> "+"test"+"</a>";
			
			//logger.info("field8="+field8);
			
			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
			data[i][8] = field8;
			//data[i][9] = field9;
			
		}
		
		return data;
	}
	
	/**
	 * goto product edit page with data for updating
	 * @param prodBizId the product business id  of  object selected
	 * @return data of product object,and target view
	 */
	@RequestMapping(value="/item/productEdit")
	public ModelAndView gotoProductEdit(@RequestParam String prodId){
		logger.info("entering /item/productEdit");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/item_product_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		//data - news
		ItemProduct product = itemProductService.getProductByProdBizId(prodId);	
		model.put("productObject", product);
		
		
		
		logger.info("leaving /item/product_edit");
		return mav;
	}
	
	
	private String getAction(String actionName){
		String action = "";
		switch(actionName){
		case ACTION_EDIT:
			action = "productEdit";
			break;
		case ACTION_DELETE:
			action = "deleteProduct";
			break;
		}
		return action;
	}
	
	private String[] getProductStatus(ItemProduct product){
	String[] productStatusPair=new String[2];
		
		String productStatus = "";
		String productStatusKey="";
		
		switch(product.getProdStatus()){
			case ItemProduct.NEWCREATED: 
				productStatus = "new";
				productStatusKey="warning";
				break;
			case ItemProduct.PUBLISHED:
				productStatus = "published";
				productStatusKey="success";

				break;
			case ItemProduct.UNPUBLISHED: 
				productStatus = "unpublished";
				productStatusKey="danger";
				break;
			case ItemProduct.DELETED: 
				productStatus = "deleted";
				productStatusKey="DEFAULT";
				break;
			default: 
				break;
		}
		productStatusPair[0]=productStatus;
		productStatusPair[1]=productStatusKey;

		return productStatusPair;
	}
}

