package com.athensoft.ecomm.item.dao;

import java.util.List;

import com.athensoft.ecomm.item.entity.ItemProduct;


public interface ItemProductDao {
	
	/**
	 * @return
	 * @author Yang Liu
	 */
	public List<ItemProduct> findAll();

	
	/**
	 * @param proBizId
	 * @return ItemProduct
	 * @author Yang Liu
	 */
	public ItemProduct getProductByProdBizId(String proBizId);


	public void updateProduct(ItemProduct itemProduct);


	public int createProduct(ItemProduct itemProduct);


	
	/**
	 * @param queryString
	 * @return
	 * @author Athens
	 */
	/*public List<ItemCategory> findByFilter(String queryString);
	
	*//**
	 * @param categoryId
	 * @return
	 * @author Athens
	 *//*
	public List<ItemCategory> findTreeByCategoryId(int categoryId);
	
	*//**
	 * @param categoryId
	 * @return
	 * @author Yang Liu
	 *//*
	public ItemCategory findByCategoryId(long categoryId);
	
	*//**
	 * @param categoryCode
	 * @return
	 * @author Yang Liu
	 *//*
	public ItemCategory findByCategoryCode(String categoryCode);
	
	*//**
	 * @param orig
	 * @param dest
	 * @author Yang Liu
	 *//*
	void dragAndDropResultSaved(String orig, String dest);

	*//**
	 * @param key
	 * @param newText
	 * @author Yang Liu
	 *//*
	void renameResultSaved(String key, String newText);

	*//**
	 * @param parentId
	 * @param text
	 * @param parentLevel
	 * @return
	 * @author Yang Liu
	 *//*
	public String createResultSaved(long parentId, String text, int parentLevel);

	*//**
	 * @param categoryId
	 * @return
	 * @author Yang Liu
	 *//*
	public List<ItemCategory> getChildren(long categoryId);

	*//**
	 * @param categoryId
	 * @param parentId
	 * @param level
	 * @author Yang Liu
	 *//*
	public void updateItemCategoryParent(long categoryId, long parentId, int level);

	*//**
	 * @param categoryId
	 * @author Yang Liu
	 *//*
	public void deleteItemCategoryByCategoryId(long categoryId);
	*/

}
