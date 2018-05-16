package com.athensoft.ecomm.item.dao;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryI18nDao {

	public int createCategoryI18n(ItemCategory itemCategory,int categoryId,String localeStr);

	public int deleteCategoryI18nByCategoryId(long categoryId);
}
