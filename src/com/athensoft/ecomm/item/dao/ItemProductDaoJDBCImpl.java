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
		String sql = "select * from item_product order by prod_create_datetime desc";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		List<ItemProduct> x = new ArrayList<ItemProduct>();
		try{
			x = jdbc.query(sql, paramSource, new ItemProductRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public ItemProduct getProductByProdBizId(String proBizId) {
		String sql = "select * from item_product where prod_biz_id =:prod_biz_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("prod_biz_id", proBizId);
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
		
		return x;
	}
	
}
}
