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
		paramSource.addValue("category_name", itemCategory.getCategoryName());
		paramSource.addValue("category_desc", itemCategory.getCategoryDesc());
		paramSource.addValue("lang_no", 1033);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = sbf.toString();
		return jdbc.update(sql, paramSource, keyHolder);
	}

}
