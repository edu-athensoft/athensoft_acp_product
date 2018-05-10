package com.athensoft.ecomm.item.dao;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryI18nDao {

	public int createCategoryI18n(ItemCategory itemCategory,int categoryId);

	public void deleteCategoryI18nByCategoryId(long categoryId);
}
