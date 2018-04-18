package com.athensoft.ecomm.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athensoft.ecomm.item.dao.ItemProductDao;
import com.athensoft.ecomm.item.entity.ItemProduct;

@Service
public class ItemProductService {

	@Autowired
	@Qualifier("itemProductDaoJDBCImpl")
	public ItemProductDao itemProductDao;
	
	
	public List<ItemProduct> findAllProduct(){
		List<ItemProduct> findAll = itemProductDao.findAll();
		return findAll;
		
	}

 
	public ItemProduct getProductByProdBizId(String prodId) {
		// TODO Auto-generated method stub
		ItemProduct product= itemProductDao.getProductByProdBizId(prodId);
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
	
}
