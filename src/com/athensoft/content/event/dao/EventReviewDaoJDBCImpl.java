package com.athensoft.content.event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import com.athensoft.content.event.entity.EventReview;

@Component
@Qualifier("eventReviewDaoJDBCImpl")
public class EventReviewDaoJDBCImpl implements EventReviewDao{
	
	private static final Logger logger = Logger.getLogger(EventReviewDaoJDBCImpl.class);
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<EventReview> findAll() {
		String sql = "select * from event_review";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		List<EventReview> x = new ArrayList<EventReview>();
		try{
			x = jdbc.query(sql, paramSource, new EventReviewRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public List<EventReview> findByFilter(String queryString) {
		final String TABLE1 = "event_review";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select * from "+TABLE1);
		sbf.append(" where 1=1 ");
		sbf.append(queryString);
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<EventReview> x = new ArrayList<EventReview>();
		try{
			x = jdbc.query(sql, paramSource, new EventReviewRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public List<EventReview> findByEventUUID(String eventUUID) {
		String sql = "select * from event_review where event_uuid = :event_uuid";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		List<EventReview> x = new ArrayList<EventReview>();
		try{
			x = jdbc.query(sql, paramSource, new EventReviewRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public EventReview findById(long globalId) {
		String sql = "select * from event_review where global_id = :global_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("global_id", globalId);
		EventReview x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new EventReviewRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public EventReview findByReviewUUID(String reviewUUID) {
		String sql = "select * from event_review where review_uuid = :review_uuid";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("review_uuid", reviewUUID);
		EventReview x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new EventReviewRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public void create(EventReview review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EventReview review) {
		final String TABLE1 = "event_review";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("customer_id = :customer_id, ");
		sbf.append("review_content = :review_content, ");
		sbf.append("review_datetime = :review_datetime ");
		sbf.append("where ");
		sbf.append("review_uuid = :review_uuid");
				
		String sql = sbf.toString();
		logger.info("sql ="+sql);
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("review_uuid",review.getReviewUUID());
		paramSource.addValue("review_content",review.getReviewContent());
		paramSource.addValue("review_datetime",review.getReviewDatetime());
		paramSource.addValue("customer_id",review.getCustomerId());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	private static class EventReviewRowMapper implements RowMapper<EventReview>{
		public EventReview mapRow(ResultSet rs, int rowNumber) throws SQLException {
			EventReview x = new EventReview();
			x.setGlobalId(rs.getLong("global_id"));
			x.setEventUUID(rs.getString("event_uuid"));
			x.setReviewUUID(rs.getString("review_uuid"));
			x.setCustomerId(rs.getLong("customer_id"));
			x.setReviewContent(rs.getString("review_content"));

			Timestamp ts = rs.getTimestamp("review_datetime");			
			x.setReviewDatetime(new Date(ts.getTime()));

			x.setReviewStatus(rs.getInt("review_status"));
			
            return x;
		}		
	}

}
