package com.athensoft.ecomm.item.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.ecomm.item.entity.ItemProduct;
import com.athensoft.ecomm.item.service.ItemProductService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:WebContent/WEB-INF/acp-servlet.xml","classpath*:application-context.xml"
		})  
public class TestItemProduct {

	
	private MockHttpServletRequest request;  
    private MockHttpServletResponse response;  
    @Autowired  
    private ItemProductService itemProductService;   
    
	@Before  
    public void before(){                                                                     

        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();  
    }
	
	@Test
	@Transactional
	@Rollback(true)
	public void test() {
	/*	List<ItemProduct> productList = itemProductService.findAllProduct();
		for (ItemProduct itemProduct : productList) {
			System.out.println(itemProduct.getProdId());
		}*/
	}

}
