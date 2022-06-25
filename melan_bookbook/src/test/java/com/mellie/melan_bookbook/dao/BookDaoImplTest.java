package com.mellie.melan_bookbook.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mellie.melan_bookbook.domain.SearchCondition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BookDaoImplTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	@Test
//	public void testBookDaoImpl() {
//		fail("Not yet implemented");
//		
//	}
//
//	@Test
//	public void testBookDaoImplSqlSessionTemplate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByNum() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByIsbn() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByAuthor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByKeyword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectPage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testSearchResultCnt() {
		SearchCondition sc = new SearchCondition(1, 10); // pageSize 10개짜리 중 1페이지 조건
		System.out.println("sc in searchResultCnt() = " + sc);
	    System.out.println("session = " + sqlSessionTemplate);
	    int result = sqlSessionTemplate.selectOne("searchResultCnt", sc);
		assertTrue(result==5);
	}

//	@Test
//	public void testSearchSelectPage() {
//		fail("Not yet implemented");
//	}

}
