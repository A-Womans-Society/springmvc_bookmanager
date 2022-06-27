package com.daeun.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeun.springmvc.spring.BooksDao;
import com.daeun.springmvc.spring.BooksVo;

@Service
public class SearchService {
	private BooksDao booksDao;
	
	public SearchService() {}
	
	@Autowired
	public SearchService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	public List<BooksVo> searchByTitle(String key) {
		List<BooksVo> books = booksDao.selectByTitle(key);
		return books;
	}
	
	public List<BooksVo> searchByWriter(String key) {
		List<BooksVo> books = booksDao.selectByWriter(key);
		return books;
	}
}
