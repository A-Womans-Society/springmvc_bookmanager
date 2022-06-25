package com.mellie.melan_bookbook.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mellie.melan_bookbook.dao.BookDao;
import com.mellie.melan_bookbook.domain.SearchCondition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BookServiceImplTest {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	@Test
//	public void testGetCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRead() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWrite() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModify() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetSearchResultCnt() throws Exception {
		SearchCondition sc = new SearchCondition(1, 10); // pageSize 10개짜리 중 1페이지 조건
		System.out.println("sc in searchResultCnt() = " + sc);
	    System.out.println("session = " + sqlSessionTemplate);
	    int result = bookDao.searchResultCnt(sc);
		assertTrue(result==5);
		
	}

//	@Test
//	public void testGetSearchResultPage() {
//		fail("Not yet implemented");
//	}

}
