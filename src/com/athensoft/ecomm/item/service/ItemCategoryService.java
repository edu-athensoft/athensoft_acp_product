package com.athensoft.ecomm.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.ecomm.item.dao.ItemCategoryDao;
import com.athensoft.ecomm.item.dao.ItemCategoryI18nDao;
import com.athensoft.ecomm.item.entity.ItemCategory;

/**
 * @author Athens
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ItemCategoryService {
	
	@Autowired
	@Qualifier("itemCategoryDaoJDBCImpl")
	private ItemCategoryDao itemCategoryDao;

	@Autowired
	@Qualifier("itemCategoryI18nDaoJDBCImpl")
	private ItemCategoryI18nDao itemCategoryI18nDao;
	
	

	public void setItemCategoryDao(ItemCategoryDao itemCategoryDao) {
		this.itemCategoryDao = itemCategoryDao;
	}

	public void dragAndDropResultSaved(String orig, String dest) {
		this.itemCategoryDao.dragAndDropResultSaved(orig, dest);
	}

	public void renameResultSaved(String key, String newText) {
		this.itemCategoryDao.renameResultSaved(key, newText);
	}

	public List<ItemCategory> findAll() {
		return this.itemCategoryDao.findAll();
	}
	
	public ItemCategory findByCategoryId(long categoryId) {
		return this.itemCategoryDao.findByCategoryId(categoryId);
	}
	
	//findTreeByCategoryId
	public List<ItemCategory> findCategoryTreeByCategoryId(int categoryId) { 
		
		return this.itemCategoryDao.findCategoryTreeByCategoryId(categoryId);
	}

	public ItemCategory findByCategoryCode(String categoryCode) {
		return this.itemCategoryDao.findByCategoryCode(categoryCode);
	}
	
	
	/**
	 * @return
	 * @author Athens
	 */
	public List<ItemCategory> getCategoryByFilter(String queryString){
		return this.itemCategoryDao.findByFilter(queryString);
	}

	public String createResultSaved(long parentId, String text, int parentLevel) {
		return this.itemCategoryDao.createResultSaved(parentId, text, parentLevel);
	}

	public List<ItemCategory> getChildren(long categoryId) {
		return this.itemCategoryDao.getChildren(categoryId);
	}

	public void updateItemCategoryParent(long categoryId, long parentId, int level) {
		this.itemCategoryDao.updateItemCategoryParent(categoryId, parentId, level);
	}

	public void deleteItemCategoryByCategoryId(long categoryId) {
		this.itemCategoryDao.deleteItemCategoryByCategoryId(categoryId);
	}

	public List<ItemCategory> findAllParentCategories() {
		// TODO Auto-generated method stub
		return this.itemCategoryDao.findAllParentCategories();
	}

	public int createCategory(ItemCategory itemCategory) {
		// TODO Auto-generated method stub
		int result1 = this.itemCategoryDao.createCategory(itemCategory);
		int result2 = this.itemCategoryI18nDao.createCategoryI18n(itemCategory,result1);
		
		if(result1==1&&result2==1){
			return 1;
		}else{
			return 2;
		}
		
		
	}

}
