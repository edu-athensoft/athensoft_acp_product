package com.athensoft.ecomm.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.content.event.entity.Event;
import com.athensoft.ecomm.item.entity.ItemCategory;
import com.athensoft.ecomm.item.entity.ItemCategoryStatus;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.entity.ItemProductI18n;
import com.athensoft.util.id.UUIDHelper;

@Component
@Qualifier("itemProductDaoJDBCImpl")
public class ItemProductDaoJDBCImpl implements ItemProductDao{
	
	private static final Logger logger = Logger.getLogger(ItemProductDaoJDBCImpl.class);
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ItemProduct> findAll() {
		String sql = "select * from"
				+ " item_product i ,"
				+ "item_product_i18n ip, "
				+ "info_language il "
				+ "where i.prod_id=ip.prod_id "
				+ "and ip.lang_no = il.lang_no "
				+ "and ip.lang_no=:lang_no";
		
		//near 'i.prod_id=ip.prod_id where ip.lang_no = il.lang_no and ip.lang_no=1052
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		paramSource.addValue("lang_no",1052 );
		List<ItemProduct> x = new ArrayList<ItemProduct>();
		try{
			x = jdbc.query(sql, paramSource, new ItemProductRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public ItemProduct getProductByProdBizId(String prodId) {
		String sql = "select * from"
				+ " item_product i ,"
				+ "item_product_i18n ip, "
				+ "info_language il "
				+ "where i.prod_id =:prod_id "
				+ "and ip.lang_no = il.lang_no "
				+ "and ip.lang_no=:lang_no";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("prod_id", prodId);
		paramSource.addValue("lang_no",1052 );

		ItemProduct x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new ItemProductRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
		
	
}

class ItemProductRowMapper implements RowMapper<ItemProduct>{

	@Override
	public ItemProduct mapRow(ResultSet rs, int rowNumber) throws SQLException {
		// TODO Auto-generated method stub
		ItemProduct x= new ItemProduct();
		ItemProductI18n i18n= new ItemProductI18n();
		x.setProdId(rs.getLong("prod_id"));
		x.setProdBizId(rs.getInt("prod_biz_id"));
		x.setBrandId(rs.getInt("brand_id"));
		x.setProdStatus(rs.getInt("prod_status"));
		x.setProdType(rs.getInt("prod_type"));
		x.setProdSaleType(rs.getInt("prod_sale_type"));
		x.setProdSeqNo(rs.getInt("prod_seqno"));
		x.setProdCreaterId(rs.getInt("prod_creater_id"));
		x.setProdCreaterDatetime(rs.getDate("prod_create_datetime"));
		x.setProdModifierId(rs.getInt("prod_modifier_id"));
		x.setProdModifierDatetime(rs.getDate("prod_modify_datetime"));
		x.setProdPublisherId(rs.getInt("prod_publisher_id"));
		x.setProdPublisherDatetime(rs.getDate("prod_publish_datetime"));
		x.setProdUnPublisherId(rs.getInt("prod_unpublisher_id"));
		x.setProdUnPublisherDatetime(rs.getDate("prod_unpublish_datetime"));
		i18n.setLangNo(1052);
		i18n.setProdDesc(rs.getString("prod_desc"));
		i18n.setProdId(x.getProdId());
		i18n.setProdDescLong(rs.getString("prod_desc_long"));
		i18n.setProdName(rs.getString("prod_name"));
		i18n.setProdNameAlias(rs.getString("prod_name_alias"));
		i18n.setProdI18nId(rs.getInt("prod_i18n_id"));
		x.setItemProductI18n(i18n);
		
		return x;
	}
	
}
}
