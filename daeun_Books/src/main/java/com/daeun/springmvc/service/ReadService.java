package com.daeun.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeun.springmvc.spring.BooksDao;
import com.daeun.springmvc.spring.BooksVo;

@Service
public class ReadService {
	private BooksDao booksDao;
	
	public ReadService() {}
	
	@Autowired
	public ReadService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	public BooksVo selectById(Long id) {
		BooksVo book = booksDao.selectById(id);
		return book;
	}
}
