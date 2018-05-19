package com.athensoft.ecomm.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ResizableByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athensoft.ecomm.item.dao.ItemProductDao;
import com.athensoft.ecomm.item.dao.ItemProductI18nDao;
import com.athensoft.ecomm.item.entity.ItemProduct;

@Service
public class ItemProductService {

	@Autowired
	@Qualifier("itemProductDaoJDBCImpl")
	public ItemProductDao itemProductDao;
	
	@Autowired
	@Qualifier("itemProductI18nDaoJDBCImpl")
	public ItemProductI18nDao itemProductI18nDao;
	
	
	public List<ItemProduct> findAllProduct(String localeStr){
		List<ItemProduct> findAll = itemProductDao.findAll(localeStr);
		return findAll;
		
	}

 
	public ItemProduct getProductByProdBizId(String prodId,String localeStr) {
		// TODO Auto-generated method stub
		ItemProduct product= itemProductDao.getProductByProdBizId(prodId,localeStr);
		return product;
	}


	public void updateProduct(ItemProduct itemProduct) {
		// TODO Auto-generated method stub
		itemProductDao.updateProduct(itemProduct);
	}


	public int createProduct(ItemProduct itemProduct) {
		// TODO Auto-generated method stub
		return itemProductDao.createProduct(itemProduct);
	}


	public List<ItemProduct>  getDataProductByFilter(ItemProduct itemProduct) {
		// TODO Auto-generated method stub
		return itemProductDao.findProductsByFilter(itemProduct);
	}


	public int deleteProductByProdBizId(String prodId) {
		// TODO Auto-generated method stub
		
		int result2= itemProductI18nDao.deleteProductI18nByProdBizId(prodId);
		int result1= itemProductDao.deleteProductByProdBizId(prodId);
	
		if(result1==1&&result2==1){
			return 1;
		}else {
			return 0;
		}
		
	}
	
}
