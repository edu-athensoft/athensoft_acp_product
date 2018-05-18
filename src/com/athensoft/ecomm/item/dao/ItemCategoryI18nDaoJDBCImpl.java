package com.athensoft.ecomm.item.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.ecomm.item.entity.ItemCategory;

@Component
@Qualifier("itemCategoryI18nDaoJDBCImpl")
public class ItemCategoryI18nDaoJDBCImpl implements ItemCategoryI18nDao{
	private static final Logger logger = Logger.getLogger(ItemCategoryDaoJDBCImpl.class);

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public int createCategoryI18n(ItemCategory itemCategory,int categoryId,String localeStr) {

		final String TABLE1 = "item_category_i18n";
		StringBuffer sbf = new StringBuffer();
		
		sbf.append("insert into " + TABLE1 + "(category_id");
		sbf.append(",category_name,");
		sbf.append("category_desc,");
		sbf.append("lang_no) values(");
		sbf.append(":category_id,");
		sbf.append(":category_name,");
		sbf.append(":category_desc,");
		sbf.append(":lang_no)");

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id",categoryId );
		paramSource.addValue("category_name", itemCategory.getCategoryName());
		paramSource.addValue("category_desc", itemCategory.getCategoryDesc());
		paramSource.addValue("lang_no", localeStr);
		
		String sql = sbf.toString();

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(sql, paramSource, keyHolder);

		return 1;
	} 

	@Override
	public int createCategoryI18n(ItemCategory itemCategory,int categoryId) {

		final String TABLE1 = "item_category_i18n";
		StringBuffer sbf = new StringBuffer();
		
		sbf.append("insert into " + TABLE1 + "(category_id");
		sbf.append(",category_name,");
		sbf.append("category_desc,");
		sbf.append("lang_no) values(");
		sbf.append(":category_id,");
		sbf.append(":category_name,");
		sbf.append(":category_desc,");
		sbf.append(":lang_no)");

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id",categoryId );
		paramSource.addValue("category_name", itemCategory.getCategoryName().split(",")[1]);
		paramSource.addValue("category_desc", itemCategory.getCategoryDesc().split(",")[1]);
		paramSource.addValue("lang_no", 1033);
		
		String sql = sbf.toString();

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(sql, paramSource, keyHolder);

		
		StringBuffer sbf2 = new StringBuffer();

		sbf2.append("insert into " + TABLE1 + "(category_id");
		sbf2.append(",category_name,");
		sbf2.append("category_desc,");
		sbf2.append("lang_no) values(");
		sbf2.append(":category_id,");
		sbf2.append(":category_name,");
		sbf2.append(":category_desc,");
		sbf2.append(":lang_no)");

		MapSqlParameterSource paramSource2 = new MapSqlParameterSource();
		paramSource2.addValue("category_id",categoryId );
		paramSource2.addValue("category_name", itemCategory.getCategoryName().split(",")[0]);
		paramSource2.addValue("category_desc", itemCategory.getCategoryDesc().split(",")[0]);
		paramSource2.addValue("lang_no", 2052);
		
		KeyHolder keyHolder2 = new GeneratedKeyHolder();

		String sql2 = sbf2.toString();
		jdbc.update(sql2, paramSource2, keyHolder2);
		
		
		StringBuffer sbf3 = new StringBuffer();

		sbf3.append("insert into " + TABLE1 + "(category_id");
		sbf3.append(",category_name,");
		sbf3.append("category_desc,");
		sbf3.append("lang_no) values(");
		sbf3.append(":category_id,");
		sbf3.append(":category_name,");
		sbf3.append(":category_desc,");
		sbf3.append(":lang_no)");

		MapSqlParameterSource paramSource3 = new MapSqlParameterSource();
		paramSource3.addValue("category_id",categoryId );
		paramSource3.addValue("category_name", itemCategory.getCategoryName().split(",")[2]);
		paramSource3.addValue("category_desc", itemCategory.getCategoryDesc().split(",")[2]);
		paramSource3.addValue("lang_no", 3084);
		KeyHolder keyHolder3 = new GeneratedKeyHolder();

		String sql3 = sbf3.toString();
		jdbc.update(sql3, paramSource3, keyHolder3);
		
		return 1;
	} 
	@Override
	public int deleteCategoryI18nByCategoryId(long categoryId) {
 
		String sql = "delete from item_category_i18n where category_id =:category_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id", categoryId);

		KeyHolder keyholder = new GeneratedKeyHolder();
		return jdbc.update(sql, paramSource, keyholder);
		
	}

}
