package com.daeun.springmvc.spring;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BooksDao {
	void insert(BooksVo vo);
	List<BooksVo> selectAll();
	BooksVo selectById(Long id); 
	List<BooksVo> selectByTitle(String key);
	List<BooksVo> selectByWriter(String key);
	List<BooksVo> selectByPublisher(String key);	
	BooksVo selectByIsbn(String isbn);
}
