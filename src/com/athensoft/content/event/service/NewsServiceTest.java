package com.athensoft.content.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.content.event.dao.NewsDao;
import com.athensoft.content.event.entity.News;

/**
 * News Service
 * @author Athens
 * @version 1.0
 */
@Service
public class NewsServiceTest {
	
	/**
	 * DAO of News
	 */
	@Autowired
	@Qualifier("newsDaoJDBCImpl")
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	

	
	@Transactional
	public void testTransaction(List<News> listNews){
		if(listNews!=null){
			if(listNews.size()>=2){
				//try{ 
					this.newsDao.create(listNews.get(0)); 
					if(true)throw new RuntimeException("");
				//catch(Exception e){System.out.println("my interrupt1");}
				
				try{ 
					this.newsDao.create(listNews.get(1)); 
					throw new RuntimeException("");}
				catch(Exception e){System.out.println("my interrupt2");}
			}
			
		}
	}
	
}
