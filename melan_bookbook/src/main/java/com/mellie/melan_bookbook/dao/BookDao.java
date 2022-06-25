package com.mellie.melan_bookbook.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mellie.melan_bookbook.domain.Book;
import com.mellie.melan_bookbook.domain.SearchCondition;

@Repository
public interface BookDao {
	
	int count() throws Exception;
	
	
	List<Book> selectAll() throws Exception;
		
	List<Book> selectByAuthor(String author) throws Exception;
	
//	List<Book> selectByKeyword(String keyword) throws Exception;
	
	List<Book> selectPage(Map map) throws Exception;
	
	
	Book selectByNum(Long num) throws Exception;
	
	Book selectByIsbn(String isbn) throws Exception;

	Book selectByName(String name) throws Exception;
	
	
	int insert(Book book) throws Exception;
	
	int delete(Long num) throws Exception;
	
	/* 수정(첨부파일이 없는 경우)*/
	int updateWoFile(Book book) throws Exception;
	/* 수정(첨부파일이 있는 경우)*/
	int update(Book book) throws Exception;
	
	int searchResultCnt(SearchCondition sc) throws Exception;
	
    List<Book> searchSelectPage(SearchCondition sc) throws Exception;
	
	
}
