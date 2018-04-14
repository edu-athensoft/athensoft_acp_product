package com.athensoft.ecomm.item.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.athensoft.content.event.controller.NewsAcpController;
import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.entity.News;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.entity.ItemProductI18n;
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
	 * go to product Creation page
	 * 
	 */
	@RequestMapping(value="/item/itemProductCreate")
	public ModelAndView gotoProductCreate(){
		
		logger.info("entering /item/itemProductCreate");
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("item/item_product_create");
		
		logger.info("leaving /item/itemProductCreate");
		
		return mav;
	}
	
	
	@RequestMapping(value="/item/newCreateProduct")
	@ResponseBody
	public Map<String, Object>  createProduct(@RequestBody ItemProduct itemProduct){
	
		logger.info("entering  /item/newCreateProduct");
		
		ModelAndView mav = new ModelAndView();
		System.out.println("biz id : "+itemProduct.getProdBizId());

		int result = itemProductService.createProduct(itemProduct);
		Map<String, Object> model=mav.getModel();
		
		if(result==1){
			model.put("success", true);
			model.put("msg","ok");
		}else{
			model.put("error", false);
			model.put("msg","no");
		}
		
		
		//view	
		/*String viewName = "item/productListData";
		mav.setViewName(viewName);
	
		
		/*
		//data
		Map<String, Object> model = mav.getModel();
		*/
		
		
		/*//data - news
		ItemProduct product = itemProductService.getProductByProdBizId(prodId);	
		model.put("productObject", product);*/

		logger.info("leaving /item/newCreateProduct");
	
		return model;
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
	
	@RequestMapping(value="/item/productUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateProduct(@RequestParam String itemJSONString){
		logger.info("entering /item/productUpdate");
		System.out.println(itemJSONString);
		
		ModelAndView mav = new ModelAndView();
		
		JSONObject ic_job= new JSONObject(itemJSONString);
		System.out.println(ic_job.getInt("prodId"));
		ItemProduct itemProduct  = new ItemProduct();
		itemProduct.setProdId(ic_job.getInt("prodId"));
		itemProduct.setProdBizId(ic_job.getInt("bizId"));
		itemProduct.setProdSeqNo(ic_job.getInt("prodSeqNo"));
		itemProduct.setProdStatus(ic_job.getInt("prodStatus"));
		itemProduct.setProdType(ic_job.getInt("prodType"));
		itemProduct.setProdSaleType(ic_job.getInt("prodSaleType"));
		ItemProductI18n i18n = new ItemProductI18n();
		i18n.setProdName(ic_job.getString("prodName"));
		i18n.setProdNameAlias(ic_job.getString("prodNameAlias"));
		i18n.setProdDesc(ic_job.getString("prodDesc"));
		i18n.setProdDescLong(ic_job.getString("prodDescLong"));
		
		
		itemProduct.setItemProductI18n(i18n);
		itemProductService.updateProduct(itemProduct);
		

		
		//view	
		/*String viewName = "item/productListData";
		mav.setViewName(viewName);
	
		
		/*
		//data
		Map<String, Object> model = mav.getModel();
		*/
		
		
		/*//data - news
		ItemProduct product = itemProductService.getProductByProdBizId(prodId);	
		model.put("productObject", product);*/

		logger.info("leaving /item/product_edit");
		Map<String,Object> map=new HashMap<String, Object>();
        map.put("success",true);
        map.put("msg","ok");
		return map;
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

