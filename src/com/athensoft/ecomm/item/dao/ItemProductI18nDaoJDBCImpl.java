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
@Qualifier("itemProductI18nDaoJDBCImpl")
public class ItemProductI18nDaoJDBCImpl implements ItemProductI18nDao{
	private static final Logger logger = Logger.getLogger(ItemCategoryDaoJDBCImpl.class);

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int deleteProductI18nByProdBizId(String prodId) {
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("delete from ");
		sbf.append( " item_product_i18n ");
		sbf.append( " where prod_id =:prod_id ");
		sbf.append("and  lang_no=:lang_no ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("lang_no", 1033);
		paramSource.addValue("prod_id", prodId);
		System.out.println(sbf.toString());
		String sql = sbf.toString();
		int result= jdbc.update(sql, paramSource);
		
		return result;
	}
	  
	

}
