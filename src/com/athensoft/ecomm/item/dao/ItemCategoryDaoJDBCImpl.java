package com.athensoft.ecomm.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.ecomm.item.entity.ItemCategory;
import com.athensoft.ecomm.item.entity.ItemCategoryStatus;
import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.util.id.UUIDHelper;

@Component
@Qualifier("itemCategoryDaoJDBCImpl")
public class ItemCategoryDaoJDBCImpl implements ItemCategoryDao {

	private static final Logger logger = Logger.getLogger(ItemCategoryDaoJDBCImpl.class);

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ItemCategory> findAll() {
		StringBuffer sbf = new StringBuffer();
		sbf.append( "select item_category.category_id ,item_category.parent_id,item_category.category_code,");
	    sbf.append("item_category.category_level,item_category.category_status,");
	    sbf.append("item_category_i18n.category_name,item_category_i18n.category_desc ");
	    sbf.append( " from item_category, item_category_i18n where category_level > 0 ");
		sbf.append(" and item_category.category_id = item_category_i18n.category_id ");
		sbf.append(" and item_category_i18n.lang_no='1033' ");
		sbf.append( " order by category_level, category_code");
		 
		String sql= sbf.toString();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		// paramSource.addValue("global_id", globalId);
		List<ItemCategory> x = new ArrayList<ItemCategory>();
		try {
			x = jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		} 
		return x;
	}

	@Override
	public List<ItemCategory> findByFilter(String queryString) {
		final String TABLE1 = "item_category ic, item_category_i18n ici";

		StringBuffer sbf = new StringBuffer();
		sbf.append(" SELECT  ");
		sbf.append("ic.category_id,");
		sbf.append("parent_id,");
		sbf.append("category_code,");
		sbf.append("ici.category_name,");
		sbf.append("ici.category_desc,");
		sbf.append("category_level,");
		sbf.append("category_status");
		sbf.append(" FROM " + TABLE1);
		sbf.append(" where lang_no=1033 ");
		sbf.append(" AND ic.category_id = ici.category_id ");
		sbf.append(queryString);   
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<ItemCategory> x = new ArrayList<ItemCategory>();
		try {
			x = jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}
 
	public List<ItemCategory> findCategoryTreeByCategoryId(int categoryId) {
		final String TABLE1 = "item_category ,item_category_i18n ";
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT distinct ");
		sbf.append("item_category.category_id,");
		sbf.append("parent_id,");
		sbf.append("category_code,");
		sbf.append("item_category_i18n.category_name,");
		sbf.append("item_category_i18n.category_desc,");
		sbf.append("category_level,");
		sbf.append("category_status,");
		sbf.append("tree_ui_id ");
		sbf.append("FROM " + TABLE1 + " ");
		sbf.append("WHERE 1=1 ");
		sbf.append("AND item_category_i18n.lang_no = 1033 ");
		sbf.append("AND item_category_i18n.category_id = item_category.category_id ");
		/*
		 * sbf.
		 * append("AND FIND_IN_SET(item_category.category_id, getChildList(:category_id)) "
		 * );
		 */
		sbf.append("AND category_status = " + ItemCategoryStatus.AVAILABLE + " ");
		sbf.append("ORDER BY category_code ");

		String sql = sbf.toString();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id", categoryId);
		logger.info(sql);
		return jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
	}

	@Override
	public ItemCategory findByCategoryId(long categoryId) {
		final String TABLE1 = "view_item_category_i18n";

		StringBuffer sbf = new StringBuffer();
	
		sbf.append("select ");
				sbf.append("item_category.category_id,");
				sbf.append("parent_id,");
				sbf.append("category_code,");
				sbf.append("item_category_i18n.category_name,");
				sbf.append("item_category_i18n.category_desc,");
				sbf.append("category_level,");
				sbf.append("category_status,");
				sbf.append("tree_ui_id ");
	
		sbf.append("from item_category, item_category_i18n where item_category.category_id =:category_id");
		sbf.append(" and item_category_i18n.category_id=item_category.category_id");

		sbf.append(" and item_category_i18n.lang_no=:lang_no");
  
		String sql = sbf.toString();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id", categoryId);
		paramSource.addValue("lang_no", 1033);
		
		ItemCategory x = null;
		try {
			x = jdbc.queryForObject(sql, paramSource, new ItemCategoryRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}
 
	@Override
	public ItemCategory findByCategoryCode(String categoryCode) {
		String sql = "select * from item_category ic,item_category_i18n ici where category_code =:categoryCode and ic.category_id=ici.category_id and lang_no=1033";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("categoryCode", categoryCode);
		ItemCategory x = null;
		try { 
			x = jdbc.queryForObject(sql, paramSource, new ItemCategoryRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public List<ItemCategory> getChildren(long categoryId) {
		String sql = "select * from item_category where parent_id=:categoryId";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("categoryId", categoryId);
		// paramSource.addValue("global_id", globalId);
		List<ItemCategory> x = new ArrayList<ItemCategory>();
		try {
			x = jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public void dragAndDropResultSaved(String orig, String dest) {
		logger.info("dragAndDropResultSaved called in ItemCategoryJDBCImpl");
		logger.info("orig=" + orig + " dest=" + dest);
	}

	@Override
	public void renameResultSaved(String key, String newText) {
		String sql = "update item_category_i18n set category_name =:newText "
				+ " where category_id = (select category_id from item_category "
				+ " where category_code=:key)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("newText", newText);
		paramSource.addValue("key", key);

		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;

	}

	@Override
	public String createResultSaved(long parentId, String text, int parentLevel) {

		final String TABLE1 = "item_category ic, item_category_i18n ici";
		// String newCategoryCode = this.getBiggestCategoryNo()+1;
		String newCategoryCode = UUIDHelper.getUUID();

		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into " + TABLE1);
		sbf.append("(category_code,category_name,parent_id,category_level) ");
		sbf.append("values(:category_code,:category_name,:parent_id,:category_level)");
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_code", newCategoryCode);
		paramSource.addValue("category_name", text);
		paramSource.addValue("parent_id", parentId);
		paramSource.addValue("category_level", parentLevel + 1);

		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return newCategoryCode;
	}

	@Override
	public void updateItemCategoryParent(long categoryId, long parentId, int level) {
		final String TABLE1 = "item_category";

		StringBuffer sbf = new StringBuffer();
		sbf.append("update " + TABLE1 + " ");
		sbf.append("set ");
		sbf.append("parent_id = :parent_id, ");
		sbf.append("category_level = :category_level ");

		sbf.append("where ");
		sbf.append("category_id = :category_id");

		String sql = sbf.toString();

		// final Date dateCreate = new Date();
		// final Date dateLastModified = dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		// paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("category_id", categoryId);
		paramSource.addValue("parent_id", parentId);
		paramSource.addValue("category_level", level);

		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
	}

	@Override
	public int deleteItemCategoryByCategoryId(long categoryId) {
		String sql = "delete from item_category where category_id =:category_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id", categoryId);

		KeyHolder keyholder = new GeneratedKeyHolder();
		return jdbc.update(sql, paramSource, keyholder);
	
	}

	private static class ItemCategoryRowMapper implements RowMapper<ItemCategory> {
		public ItemCategory mapRow(ResultSet rs, int rowNumber) throws SQLException {
			ItemCategory x = new ItemCategory();
			x.setCategoryId(rs.getLong("category_id"));
			x.setParentId(rs.getLong("parent_id"));
			x.setCategoryCode(rs.getString("category_code"));
			x.setCategoryName(rs.getString("category_name"));
			x.setCategoryDesc(rs.getString("category_desc"));
			x.setCategoryLevel(rs.getInt("category_level"));
			x.setCategoryStatus(rs.getInt("category_status"));
			System.out.println(x.toString());;
			return x;
		}
	}

	@SuppressWarnings("deprecation")
	private long getBiggestCategoryNo() {
		String sql = "select category_code from item_category order by category_code desc limit 1";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		long x;
		try {
			x = jdbc.queryForLong(sql, paramSource);
		} catch (EmptyResultDataAccessException ex) {
			x = 0;
		}
		return x;
	}

	@Override
	public List<ItemCategory> findAllParentCategories() {

		String sql = "select distinct category_id, category_name,parent_id, category_code from item_category order by category_id ";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		List<ItemCategory> listCategoryName = (List<ItemCategory>) jdbc.query(sql,
				new ResultSetExtractor<List<ItemCategory>>() {

					@Override
					public List<ItemCategory> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub

						List<ItemCategory> listString = new ArrayList<ItemCategory>();
						while (rs.next()) {
							ItemCategory x = new ItemCategory();
							x.setCategoryCode(rs.getString("category_code"));
							x.setParentId(rs.getLong("parent_id"));
							x.setCategoryName(rs.getString("category_name"));
							x.setCategoryId(rs.getLong("category_id"));

							listString.add(x);
						}
						return listString;
					}
				});
		for (ItemCategory items : listCategoryName) {
			System.out.println(items.getParentId());
		}

		return listCategoryName;
	}

	@Override
	public int createCategory(ItemCategory itemCategory) {
		final String TABLE1 = "item_category";
		StringBuffer sbf = new StringBuffer();

		sbf.append("insert into " + TABLE1 + "(category_code");
		sbf.append(",parent_id,");
		sbf.append("category_status,");
		sbf.append("category_level) values(");
		sbf.append(":category_code,");
		sbf.append(":parent_id,");
		sbf.append(":category_status,");
		sbf.append(":category_level)");

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_code", itemCategory.getCategoryCode());
		paramSource.addValue("category_status", itemCategory.getCategoryStatus());
		paramSource.addValue("category_level", itemCategory.getCategoryLevel());
		paramSource.addValue("parent_id", itemCategory.getParentId());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = sbf.toString();
		jdbc.update(sql, paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public String getInsertedCateCode(String categoryCode,int childCategoryLevel) {
		final String TABLE1 = "item_category";
		StringBuffer sbf = new StringBuffer();

		sbf.append("select max(category_code) from "+TABLE1) ;
		sbf.append(" where category_code like '"+categoryCode+"%' ");
		sbf.append(" and category_level = "+childCategoryLevel);
		String sql = sbf.toString();
		String newCategoryCode = jdbc.queryForObject(sql, EmptySqlParameterSource.INSTANCE, String.class); 
		return newCategoryCode;
	}
	
	@Override
	public String getInsertedCateCode(int cateLevel) {
		final String TABLE1 = "item_category";
		StringBuffer sbf = new StringBuffer();

		sbf.append("select max(category_code) from "+TABLE1) ;
		sbf.append(" where category_level = "+cateLevel);
		String sql = sbf.toString();
		String newCategoryCode = jdbc.queryForObject(sql, EmptySqlParameterSource.INSTANCE, String.class); 
		return newCategoryCode;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean ifisParent(String categoryCode,int childCategoryLevel) {
		final String TABLE1 = "item_category";
		StringBuffer sbf = new StringBuffer();
		//select count(*) from item_category where category_code = (select MAX(category_code)
		//from item_category where category_code like '08-002%' ORDER BY category_code desc);
		sbf.append("select count(*) from "+TABLE1) ;
		sbf.append(" where category_code like '"+categoryCode+"%' ");
		sbf.append(" and category_level = "+childCategoryLevel);

		String sql = sbf.toString();
		System.out.println("sql :   "+sql);
		int resultNumber = jdbc.queryForInt(sql, EmptySqlParameterSource.INSTANCE); 
		System.out.println("result "+resultNumber);
		if(resultNumber>0){
			return true;
		}
		return false;
	}

	@Override
	public void updateCategory(ItemCategory itemCategory) {
	final String TABLE1 = "item_category ic, item_category_i18n ici";
	System.out.println("ID = "+itemCategory.getCategoryName());
	StringBuffer sbf = new StringBuffer();
	
	sbf.append("update "+TABLE1+" ");
	sbf.append("set ");
	sbf.append("category_code = :category_code, ");
	sbf.append("category_status = :category_status, ");
	sbf.append("parent_id = :parent_id, ");
	sbf.append("category_level = :category_level, ");
	sbf.append("ici.category_name = :category_name ,");
	sbf.append("ici.category_desc = :category_desc ");
	sbf.append("where ic.category_id = ici.category_id  ");
	sbf.append("and ic.category_id = :category_id  ");
	sbf.append("and ici.lang_no = :lang_no");
			
	String sql = sbf.toString();
	
//	final Date dateCreate 			= new Date();
//	final Date dateLastModified 	= dateCreate;
	MapSqlParameterSource paramSource = new MapSqlParameterSource();
//	paramSource.addValue("global_id", news.getGlobalId());
	paramSource.addValue("category_code", itemCategory.getCategoryCode());
	paramSource.addValue("category_status", itemCategory.getCategoryStatus());
	paramSource.addValue("parent_id",itemCategory.getParentId());
	paramSource.addValue("category_level",itemCategory.getCategoryLevel());
	paramSource.addValue("category_name",itemCategory.getCategoryName());
	paramSource.addValue("category_desc", itemCategory.getCategoryDesc());
	paramSource.addValue("category_id", itemCategory.getCategoryId());
	
	paramSource.addValue("lang_no", 1033);
	
	KeyHolder keyholder = new GeneratedKeyHolder();
	int update = jdbc.update(sql, paramSource, keyholder);
	System.out.println("update result "+update);
	System.out.println(sql);

	}
 
	@Override
	public String getCategoryCodeByParentId(long parentId) {
		final String TABLE1 = "item_category";
		StringBuffer sbf = new StringBuffer();

		sbf.append("select category_code from "+TABLE1) ;
		sbf.append(" where category_id = "+parentId);
		String sql = sbf.toString();
		String categoryCode = jdbc.queryForObject(sql, EmptySqlParameterSource.INSTANCE, String.class); 
		return categoryCode;
	}

	

}
