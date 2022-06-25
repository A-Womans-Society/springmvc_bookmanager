package com.mellie.melan_bookbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mellie.melan_bookbook.domain.Book;
import com.mellie.melan_bookbook.domain.SearchCondition;

@Repository
public class BookDaoImpl implements BookDao {
	
	private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BookDaoImpl() {	}
	
	public BookDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<Book> selectAll() {
		return sqlSessionTemplate.selectList("book.dtd.selectAll");
	}

	@Override
	public Book selectByNum(Long num) {
		List<Book> results = sqlSessionTemplate.selectList("book.dtd.selectByNum", num);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public Book selectByIsbn(String isbn) {
		List<Book> results = sqlSessionTemplate.selectList("book.dtd.selectByIsbn", isbn);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public Book selectByName(String name) {
		List<Book> results = sqlSessionTemplate.selectList("book.dtd.selectByName", name);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<Book> selectByAuthor(String author) {
		return sqlSessionTemplate.selectList("book.dtd.selectByAuthor", author);
	}
	
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("book.dtd.count");
	}

	@Override
	public int insert(Book book) {
		return sqlSessionTemplate.insert("book.dtd.insert", book);
	}

//	@Override
//	public List<Book> selectByKeyword(String keyword) {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "%" + keyword +"%");
//		map.put("author", "%" + keyword +"%");
//		return sqlSessionTemplate.selectList("book.dtd.selectByKeyword", map);
//	}

	@Override
	public List<Book> selectPage(Map map) throws Exception {
		return sqlSessionTemplate.selectList("book.dtd.selectPage", map);
	}

	@Override
	public int delete(Long num) throws Exception {
        Map<String, Long> map = new HashMap<>();
        map.put("num", num);
        return sqlSessionTemplate.delete("book.dtd.delete", map);
	}
	 /* 수정(첨부파일이 없는 경우)*/
	@Override
	public int updateWoFile(Book book) throws Exception {
		return sqlSessionTemplate.update("book.dtd.updateWoFile", book);
	}
	 /* 수정(첨부파일이 있는 경우)*/
	@Override
	public int update(Book book) throws Exception {
		return sqlSessionTemplate.update("book.dtd.update", book);
	}
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        System.out.println("sc in searchResultCnt() = " + sc);
        System.out.println("session = " + sqlSessionTemplate);
        return sqlSessionTemplate.selectOne("book.dtd.searchResultCnt", sc);
	}

	@Override
	public List<Book> searchSelectPage(SearchCondition sc) throws Exception {
		Map<String, Object> map = new HashMap<>();
		int offset = sc.getOffset();
		int lastNum = offset + sc.getPageSize();
		String keyword = sc.getKeyword();
		String option = sc.getOption();
		logger.info("offset : " + offset);
		logger.info("lastNum : " + lastNum);
		logger.info("keyword : " + keyword);
		logger.info("option : " + option);
		
		map.put("offsetNext", offset+1);
		map.put("lastNum", lastNum);
		map.put("keyword", keyword);
		map.put("option", option);
		return sqlSessionTemplate.selectList("book.dtd.searchSelectPage", map);
	}

	
}
