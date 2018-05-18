package com.athensoft.ecomm.item.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;
/*import org.json.JSONObject;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.entity.ItemProductStatus;
import com.athensoft.ecomm.item.service.ItemProductService;
import com.athensoft.util.excel.ExcelExport;
import com.athensoft.util.locale.LocaleHelper;

@Controller
public class ItemProductAcpController {

	private static final Logger logger = Logger.getLogger(ItemProductAcpController.class);
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
	
	@RequestMapping(value="/item/exportProductExcel",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView exportProductExcel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
			String fileName="item_product_list";
			HttpSession session = request.getSession();
			List<ItemProduct> listProduct =(	List<ItemProduct>) session.getAttribute("listProductByFilter");
			
			if(null==listProduct){
				String localeStr=(String)session.getAttribute("localeStr");
				listProduct = itemProductService.findAllProduct(localeStr);
				
			}
		
			
			
	        List<Map<String,Object>> list=createExcelRecord(listProduct);
	        String columnNames[]={"Product ID","Business ID","Sequence Number","Description",
	        					"Description Long","Product Name "," Product Name alias","Product Type",
	        					"Product Status","Product Sale Type","Creater ID","Create Date"};
	        String keys[]    =     {"id","prod_biz_id","prod_seqno","prod_desc","prod_desc_long","prod_name"
	        		,"prod_name_alias","prod_type","prod_status","prod_sale_type","prod_creater_id","prod_create_date"};
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        try {
	        	ExcelExport.createWorkBook(list,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "utf-8"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	            bis = new BufferedInputStream(is);
	            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	 
		
		@RequestMapping(value="/item/getDataProductByFilter",method=RequestMethod.POST)
		@ResponseBody
		public Map<String, Object>  getDataProductByFilter(@RequestParam String itemJSONString,HttpServletRequest request){
			 Map<String, Object> model = new HashMap<String, Object>();
			logger.info("enterying /item/getDataProductByFilter");
			
			JSONObject jsonObject= new JSONObject();
			ItemProduct itemProduct = jsonObject.parseObject(itemJSONString, ItemProduct.class);
			
			System.out.println(itemProduct.toString());
			
			List<ItemProduct> listProduct=itemProductService.getDataProductByFilter(itemProduct);

			HttpSession session = request.getSession();
			session.setAttribute("listProductByFilter", listProduct);
			
			
			logger.info("length of entries of product "+ listProduct.size());
			
			String[][] data = getData(listProduct, ACTION_EDIT);
			
			model.put("draw", new Integer(1));
			model.put("recordsTotal", new Integer(5));
			model.put("recordsFiltered", new Integer(5));
			model.put("data", data);
			model.put("customActionStatus","OK");
			model.put("customActionMessage","OK");
			
			logger.info("leaving /item/getDataProductByFilter");
			
			return model;
			
		}
		
		
	    private List<Map<String, Object>> createExcelRecord(List<ItemProduct> listProduct) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        ItemProduct itemProduct=null;
	        for (int j = 0; j < listProduct.size(); j++) {
	        	itemProduct=listProduct.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("id", itemProduct.getProdId());
	            mapValue.put("prod_biz_id", itemProduct.getProdBizId());
	            mapValue.put("prod_seqno", itemProduct.getProdSeqNo());
	            mapValue.put("prod_type", itemProduct.getProdType());
	            mapValue.put("prod_status",itemProduct.getProdStatus());
	            mapValue.put("prod_sale_type",itemProduct.getProdSaleType());
	            mapValue.put("prod_creater_id",1);
	            mapValue.put("prod_desc",itemProduct.getItemProductI18n().getProdDesc());
	            mapValue.put("prod_desc_long", itemProduct.getItemProductI18n().getProdDescLong());
	            mapValue.put("prod_name", itemProduct.getItemProductI18n().getProdName());
	            mapValue.put("prod_name_alias", itemProduct.getItemProductI18n().getProdNameAlias());
	            mapValue.put("prod_create_date", itemProduct.getProdCreaterDatetime());
	            listmap.add(mapValue);
	        }
	        return listmap;
	    
	}
	    
	    @RequestMapping(value = "item/uploadProductImg", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, String> upload(HttpServletRequest request) throws Exception {
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
	        ///assets/pages/
	        String rootDir = request.getRealPath("/");
	        String relatDir = File.separator+"assets"+File.separator+"pages"
	                +File.separator+"img"+File.separator+"uploadImg";  

	        File fdir = new File(rootDir+relatDir);
	        if (!fdir.exists()) { fdir.mkdirs(); }

	        String oriName = file.getOriginalFilename();
	        String newName = new Date().getTime()+"_"+oriName;
	        File tempFile = new File(fdir.getPath()+File.separator+newName);
	        file.transferTo(tempFile);

	        Map<String, String> model = new HashMap<>();
	        model.put("oriName", oriName);
	        model.put("realName", tempFile.getName());
	        model.put("relatPath", relatDir+File.separator+newName); 
	        return model;
	    }
	
	@RequestMapping(value="/item/newCreateProduct")
	@ResponseBody
	public Map<String, Object>  createProduct(@RequestBody ItemProduct itemProduct){
	
		logger.info("entering  /item/newCreateProduct");
		itemProduct.setLang_no(LocaleHelper.localToLangNo(itemProduct.getLangNo()));
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
		

		logger.info("leaving /item/newCreateProduct");
	
		return model;
	}

	/**
	 * get product objects in JSON data form
	 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value="/item/productListData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataProductList(HttpServletRequest request){
		logger.info("entering /item/productListData");
		String localeStr = LocaleHelper.getLocaleStr();
		localeStr=LocaleHelper.localToLangNo(localeStr);
		System.out.println("localeStr = "+localeStr);
		HttpSession session = request.getSession();
		session.invalidate();
		//session.setAttribute("localeStr", localeStr);
		ModelAndView mav = new ModelAndView();
		
		//data
		List<ItemProduct> listProduct = itemProductService.findAllProduct(localeStr);
		logger.info("Length of product entries: "+ listProduct.size());
		
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
		String field9 = "";
		 
		for(int i=0; i<entryLength ; i++){			
			field0 = "<input type='checkbox' name='id[]' value="+listProduct.get(i).getProdId()+">";
			field1 = listProduct.get(i).getProdBizId()+"";
			field2 = listProduct.get(i).getProdSeqNo()+"";
			field3 = listProduct.get(i).getProdType()==1?"Product":
				listProduct.get(i).getProdType()==2?"Digital":listProduct.get(i).getProdType()==3?"Service":"n/a"+"";

			field4 =listProduct.get(i).getProdSaleType()==1?"Online":
				listProduct.get(i).getProdSaleType()==2?"Outlet":listProduct.get(i).getProdSaleType()==3?"Both":"n/a"+"";

			field5 = listProduct.get(i).getItemProductI18n().getProdName()+""; 
			field6 =  listProduct.get(i).getCategoryName()+"";

			field7 = listProduct.get(i).getProdCreaterDatetime()+"";
			
		/*	int intProductStatus = listProduct.get(i).getProdStatus();*/
			String[] productStatus= getProductStatus(listProduct.get(i));
			String productStatu= productStatus[0];
			String productStatusKey=productStatus[1];
			
			field8 = "<span class='label label-sm label-"+productStatusKey+"'>"+productStatu+"</span>";
			
			
			field9 = "<a href='/acp/item/"+getAction(actionName)+"?prodId="+listProduct.get(i).getProdId()+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> "+actionName+"</a><button onclick='deleteProduct("+listProduct.get(i).getProdId()+")' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> "+"Delete"+"</button>";
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
			data[i][9] = field9;
			
		}
		
		return data;
	}
	
	/**
	 * goto product edit page with data for updating
	 * @param prodId the product  id  of  object selected
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
	@RequestMapping(value="/item/deleteProduct")
	@ResponseBody
	public Map<String,Object> deleteProduct(@RequestParam String prodId){
		logger.info("entering /item/deleteProduct");
		
		Map<String,Object> model= new HashMap<String,Object> ();
		int result =itemProductService.deleteProductByProdBizId(prodId);	
		if(result==1){
			model.put("success", true);
		}else{
			model.put("success", false);
		}
		
		
		logger.info("leaving /item/deleteProduct");
		return model;
	}
	
	@RequestMapping(value="/item/productUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateProduct(@RequestParam String itemJSONString){
		logger.info("entering /item/productUpdate");
		System.out.println(itemJSONString);
		
		ModelAndView mav = new ModelAndView();
		JSONObject ic_job= new JSONObject();
		ItemProduct itemProduct = ic_job.parseObject(itemJSONString, ItemProduct.class);
		 
		itemProductService.updateProduct(itemProduct);
		
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
			case ItemProductStatus.NEWCREATED: 
				productStatus = "new";
				productStatusKey="warning";
				break;
			case ItemProductStatus.PUBLISHED:
				productStatus = "published";
				productStatusKey="success";

				break;
			case ItemProductStatus.UNPUBLISHED: 
				productStatus = "unpublished";
				productStatusKey="danger";
				break;
			case ItemProductStatus.DELETED: 
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

