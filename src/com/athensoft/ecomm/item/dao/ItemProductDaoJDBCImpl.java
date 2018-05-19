package com.athensoft.ecomm.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
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
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.content.event.entity.Event;
import com.athensoft.ecomm.item.entity.ItemCategory;
import com.athensoft.ecomm.item.entity.ItemCategoryStatus;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.entity.ItemProductI18n;
import com.athensoft.util.id.UUIDHelper;
import com.athensoft.util.locale.LocaleHelper;

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
	public List<ItemProduct> findAll(String localeStr) {
		String sql = "select * from"
				+ " item_product i ,"
				+ "item_product_i18n ip, "
				+ "info_language il "
				+ "where i.prod_id=ip.prod_id "
				+ "and ip.lang_no = il.lang_no "
				+ "and ip.lang_no=:lang_no";
		
		//near 'i.prod_id=ip.prod_id where ip.lang_no = il.lang_no and ip.lang_no=1033
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		paramSource.addValue("lang_no",localeStr );
		List<ItemProduct> x = new ArrayList<ItemProduct>();
		try{
			x = jdbc.query(sql, paramSource, new ItemProductRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public ItemProduct getProductByProdBizId(String prodId,String localeStr) {
		String sql = "select * from"
				+ " item_product i ,"
				+ "item_product_i18n ip, "
				+ "info_language il "
				+ "where i.prod_id =:prod_id "
				+ "and i.prod_id = ip.prod_id "
				+ "and ip.lang_no = il.lang_no "
				+ "and ip.lang_no=:lang_no";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("prod_id", prodId);
		paramSource.addValue("lang_no",localeStr );

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
		String localeStr=LocaleHelper.getLocaleStr();
		localeStr=LocaleHelper.localToLangNo(localeStr);
		ItemProduct x= new ItemProduct();
		ItemProductI18n i18n= new ItemProductI18n();
		x.setProdId(rs.getLong("prod_id"));
		x.setProdBizId(rs.getLong("prod_biz_id"));
		x.setBrandId(rs.getInt("brand_id"));
		x.setProdStatus(rs.getInt("prod_status"));
		x.setProdType(rs.getInt("prod_type"));
		x.setProdSaleType(rs.getInt("prod_sale_type"));
		x.setProdSeqNo(rs.getInt("prod_seqno"));
		x.setCategoryName(rs.getString("prod_category_name"));
		x.setCategoryCode(rs.getString("prod_category_code"));
		x.setProdCreaterId(rs.getInt("prod_creater_id"));
		x.setProdCreaterDatetime(rs.getString("prod_create_datetime"));
		x.setProdImgUrl(rs.getString("prod_img_url"));
		x.setProdModifierId(rs.getInt("prod_modifier_id"));
		x.setProdModifierDatetime(rs.getDate("prod_modify_datetime"));
		x.setProdPublisherId(rs.getInt("prod_publisher_id"));
		x.setProdPublisherDatetime(rs.getDate("prod_publish_datetime"));
		x.setProdUnPublisherId(rs.getInt("prod_unpublisher_id"));
		x.setProdUnPublisherDatetime(rs.getDate("prod_unpublish_datetime"));
		i18n.setLangNo(Integer.parseInt(localeStr));
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

@Override
public void updateProduct(ItemProduct itemProduct) {
	// TODO Auto-generated method stub
	final String TABLE1 = "item_product ip, item_product_i18n ipi";
	System.out.println("ID = "+itemProduct.getProdType());
	StringBuffer sbf = new StringBuffer();
	sbf.append("update "+TABLE1+" ");
	sbf.append("set ");
	sbf.append("prod_type = :prod_type, ");
	sbf.append("prod_status = :prod_status, ");
	sbf.append("prod_sale_type = :prod_sale_type, ");
	sbf.append("prod_desc = :prod_desc, ");
	sbf.append("prod_desc_long = :prod_desc_long ,");
	sbf.append("prod_name = :prod_name, ");
	sbf.append("prod_img_url = :prod_img_url, ");
	sbf.append("prod_name_alias = :prod_name_alias ");
	sbf.append("where ip.prod_id = ipi.prod_id  ");
	sbf.append("and ip.prod_id = :prod_id ");
	sbf.append("and ipi.lang_no = :lang_no");
			
			/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
	
	String sql = sbf.toString();
	
//	final Date dateCreate 			= new Date();
//	final Date dateLastModified 	= dateCreate;
	MapSqlParameterSource paramSource = new MapSqlParameterSource();
//	paramSource.addValue("global_id", news.getGlobalId());
	paramSource.addValue("prod_id", itemProduct.getProdId());
	paramSource.addValue("prod_type", itemProduct.getProdType());
	paramSource.addValue("prod_img_url", itemProduct.getProdImgUrl());
	paramSource.addValue("prod_status",itemProduct.getProdStatus());
	paramSource.addValue("prod_sale_type",itemProduct.getProdSaleType());
	paramSource.addValue("prod_desc",itemProduct.getItemProductI18n().getProdDesc());
	paramSource.addValue("prod_desc_long", itemProduct.getItemProductI18n().getProdDescLong());
	paramSource.addValue("prod_name", itemProduct.getItemProductI18n().getProdName());
	paramSource.addValue("prod_name_alias", itemProduct.getItemProductI18n().getProdNameAlias());
	paramSource.addValue("lang_no", 1033);
	
	KeyHolder keyholder = new GeneratedKeyHolder();
	jdbc.update(sql, paramSource, keyholder);
	System.out.println(sql);
	return;
	
	
	
}

@Override
@Transactional(rollbackFor=Exception.class)
public int createProduct(ItemProduct itemProduct) {
	// TODO Auto-generated method stub
		final String TABLE1 = "item_product";
		System.out.println("ID = "+itemProduct.getProdType());
		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into "+TABLE1+" (prod_biz_id, prod_seqno, prod_type,prod_img_url, prod_status,prod_category_code,prod_category_name,");
		sbf.append("prod_sale_type , prod_creater_id, prod_create_datetime) ");
		sbf.append(" values( :prod_biz_id, :prod_seqno, :prod_type, :prod_img_url,:prod_status,:prod_category_code,:prod_category_name, :prod_sale_type, :prod_creater_id,sysdate()) ;");
		
		
		// prod_desc, prod_desc_long, prod_name, prod_name_alias, 
		final String TABLE2 = "item_product_i18n";
		StringBuffer sbf2 = new StringBuffer();
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		sbf2.append("insert into "+TABLE2+" (prod_id,prod_desc, prod_desc_long, prod_name, prod_name_alias,lang_no) ");
		sbf2.append(" values(:prod_id,:prod_desc, :prod_desc_long, :prod_name, :prod_name_alias, :lang_no)");
		
		String sql = sbf.toString();
		String sql2 = sbf2.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("prod_biz_id", itemProduct.getProdBizId());
		paramSource.addValue("prod_seqno", itemProduct.getProdSeqNo());
		paramSource.addValue("prod_type", itemProduct.getProdType());
		paramSource.addValue("prod_img_url", itemProduct.getProdImgUrl());
		paramSource.addValue("prod_status",itemProduct.getProdStatus());
		paramSource.addValue("prod_category_code",itemProduct.getCategoryCode());
		paramSource.addValue("prod_category_name",itemProduct.getCategoryName());
		
		paramSource.addValue("prod_sale_type",itemProduct.getProdSaleType());
		paramSource.addValue("prod_creater_id",1);
		
		

		paramSource.addValue("prod_desc",itemProduct.getItemProductI18n().getProdDesc());
		paramSource.addValue("prod_desc_long", itemProduct.getItemProductI18n().getProdDescLong());
		paramSource.addValue("prod_name", itemProduct.getItemProductI18n().getProdName());
		paramSource.addValue("prod_name_alias", itemProduct.getItemProductI18n().getProdNameAlias());
		paramSource.addValue("lang_no", itemProduct.getLangNo());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		System.out.println(sql);
	
			int result =jdbc.update(sql, paramSource, keyholder);
			System.out.println("key1 :"+keyholder.getKey().intValue());
			paramSource.addValue("prod_id", keyholder.getKey().intValue());

			int result2 = jdbc.update(sql2, paramSource, keyholder);
		 
			if(result==1 && result2==1){
			
				return 1;
		 	
			}else {
		
				return 0;
			
			
			}
		 
			
		}

@Override
public List<ItemProduct> findProductsByFilter(ItemProduct itemProduct) {
	StringBuffer sbf = new StringBuffer();
	System.out.println(itemProduct.toString());
	sbf.append("select * from");
	sbf.append( " item_product ip,");
	sbf.append("item_product_i18n ipi, ");
	sbf.append("info_language il where ");
	if(itemProduct.getProdBizId()!= null){
		sbf.append(" prod_biz_id like '%"+itemProduct.getProdBizId()+"%' and ");
	}
	if(itemProduct.getProdSeqNo()!=null){
		sbf.append("  prod_seqno like '%"+itemProduct.getProdSeqNo()+"%' and ");
	}
	if(itemProduct.getProdSaleType()!=0){
		sbf.append("  prod_sale_type like '%"+itemProduct.getProdSaleType()+"%' and ");
	}
	if(itemProduct.getProdType()!=0){
		sbf.append("  prod_type like '%"+itemProduct.getProdType()+"%' and ");
	}
	if(itemProduct.getProdStatus()!=0){
		sbf.append("  prod_status like '%"+itemProduct.getProdStatus()+"%' and ");
	}
	if(itemProduct.getCategoryName()!=null){
		sbf.append("  prod_category_name like '%"+itemProduct.getCategoryName()+"%' and ");
	}
	if( !"".equals(itemProduct.getItemProductI18n().getProdName().trim())){
		sbf.append("  prod_name like '%"+itemProduct.getItemProductI18n().getProdName()+"%' and ");
	}
	if( null!=(itemProduct.getProdCreaterDatetime())){
		if(itemProduct.getProdCreaterDatetime().contains(",")){
			String[] datetimes= itemProduct.getProdCreaterDatetime().split(",");
			//System.out.println(datetimes[0]+", "+datetimes[1]);
			//  7,8  ,8  7,  0,0
		
		
			if(datetimes.length==1){
				sbf.append("  prod_create_datetime >= ");
				sbf.append(" '"+ datetimes[0]+"' and ");
			}else if(datetimes.length==2){
				sbf.append("  prod_create_datetime between ");
				sbf.append(" '"+ datetimes[0]+"' and ");
				sbf.append(" '"+ datetimes[1]+"' and ");
			}
			
		}
		//String datetime =sdf.format(itemProduct.getProdCreaterDatetime());
		
		//System.out.println(datetime);
		
	}
	sbf.append(" ip.prod_id = ipi.prod_id  ");

	sbf.append("and il.lang_no = :lang_no ");
	sbf.append("and il.lang_no = ipi.lang_no");
	
	MapSqlParameterSource paramSource = new MapSqlParameterSource();
	paramSource.addValue("lang_no", 1033);
	
	System.out.println(sbf.toString());
	
	List<ItemProduct> x = new ArrayList<ItemProduct>();
	try{
		x = jdbc.query(sbf.toString(), paramSource, new ItemProductRowMapper());
		
	}catch(EmptyResultDataAccessException ex){
		x = null;
	}
	return x;
}

@Override
public int deleteProductByProdBizId(String prodId) {
	StringBuffer sbf = new StringBuffer();
	sbf.append("delete from ");
	sbf.append( " item_product ");
	//sbf.append("item_product_i18n ipi  ");
	sbf.append( " where prod_id =:prod_id ");
	//sbf.append("and  ip.prod_id = ipi.prod_id ");
	//sbf.append("and  ipi.lang_no=:lang_no ");
	MapSqlParameterSource paramSource = new MapSqlParameterSource();
	//paramSource.addValue("lang_no", 1033);
	paramSource.addValue("prod_id", prodId);
	System.out.println(sbf.toString());
	String sql = sbf.toString();
	int result= jdbc.update(sql, paramSource);
	
	return result; 
	 
}
		 
		

}
