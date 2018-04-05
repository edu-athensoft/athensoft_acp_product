package com.athensoft.content.event.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athensoft.content.event.entity.News;
import com.athensoft.content.event.service.NewsServiceTest;

@Controller
public class NewsAcpControllerTest {
	private static final Logger logger = Logger.getLogger(NewsAcpControllerTest.class);
	
	/**
	 * News Service instance
	 */
	private NewsServiceTest newsServiceTest;
	
	@Autowired
	public void setNewsServiceTest(NewsServiceTest newsServiceTest) {
		this.newsServiceTest = newsServiceTest;
	}
	
	
	@RequestMapping(value="/test/tx1")
	public String testTx1(){
		
		logger.info("/test/tx1 for testUpdateTransaction");
		String viewName = "index";
		
		News n1 = new News();
		n1.setEventUUID("test-tx-1");
		
		News n2 = new News();
		n2.setEventUUID("test-tx-2");
		
		List<News> listNews = new ArrayList<News>();
		listNews.add(n1);
		listNews.add(n2);
		
		newsServiceTest.testTransaction(listNews);
		
		logger.info("end of /test/tx1 for testTransaction");
		return viewName;
	} 
	
	
}
