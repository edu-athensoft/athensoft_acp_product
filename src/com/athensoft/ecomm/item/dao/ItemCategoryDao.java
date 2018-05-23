package com.athensoft.ecomm.item.dao;

import java.util.ArrayList;
import java.util.List;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryDao {
	
	/**
	 * @return
	 * @author Fangze Sun
	 * @param localeStr 
	 */
	public List<ItemCategory> findAll(String localeStr);
	
	/**
	 * @param queryString
	 * @return
	 * @author Athens
	 */
	public List<ItemCategory> findByFilter(String queryString,String localeStr);
	
	/** 
	 * @param categoryId
	 * @return
	 * @author Athens
	 */
	public List<ItemCategory> findCategoryTreeByCategoryId(String localeStr,int categoryId);
	
	/**
	 * @param categoryId
	 * @return
	 * @author Fangze Sun
	 */
	public ItemCategory findByCategoryId(long categoryId,String localeStr);
	
	/**
	 * @param categoryCode
	 * @return
	 * @author Fangze Sun
	 */
	public ItemCategory findByCategoryCode(String categoryCode);
	
	/**
	 * @param orig
	 * @param dest
	 * @author Fangze Sun
	 */
	void dragAndDropResultSaved(String orig, String dest);

	/**
	 * @param key
	 * @param newText
	 * @author Fangze Sun
	 */
	void renameResultSaved(String key, String newText,String localeStrd);

	/**
	 * @param parentId
	 * @param text
	 * @param parentLevel
	 * @return
	 * @author Fangze Sun
	 */
	public String createResultSaved(long parentId, String text, int parentLevel);

	/**
	 * @param categoryId
	 * @return
	 * @author Fangze Sun
	 */
	public List<ItemCategory> getChildren(long categoryId);

	/**
	 * @param categoryId
	 * @param parentId
	 * @param level
	 * @author Fangze Sun
	 */
	public void updateItemCategoryParent(long categoryId, long parentId, int level);

	/**
	 * @param categoryId
	 * @author Fangze Sun
	 * @return 
	 */
	public int deleteItemCategoryByCategoryId(long categoryId);

	public List<ItemCategory> findAllParentCategories();

	public int createCategory(ItemCategory itemCategory);



	public boolean ifisParent(String categoryCode, int categoryLevel);

	public String getInsertedCateCode(String categoryCode, int childCategoryLevel);

	public String getInsertedCateCode(int childLevel);

	public void updateCategory(ItemCategory itemCategory,String localeStr);

	public String getCategoryCodeByParentId(long parentId);

	public void batchUpdateCategory(ArrayList<ItemCategory> cateList);

	

}
