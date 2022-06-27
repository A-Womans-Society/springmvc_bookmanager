package com.daeun.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeun.springmvc.exception.AlreadyExistingBookException;
import com.daeun.springmvc.spring.BooksDao;
import com.daeun.springmvc.spring.BooksVo;
import com.daeun.springmvc.spring.RegisterRequest;

@Service
public class RegisterService {
	private BooksDao booksDao;

	public RegisterService() {
	}

	@Autowired
	public RegisterService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public void regist(RegisterRequest req) {
		BooksVo book = booksDao.selectByIsbn(req.getIsbn());
		if (book != null) {
			throw new AlreadyExistingBookException("이미 존재하는 책입니다.");
		}
		BooksVo newBook = 
				new BooksVo(
					req.getIsbn(), 
					req.getTitle(), 
					req.getWriter(), 
					req.getPublisher(),
					req.getPrice(), 
					req.getImage(), 
					req.getIntroduce(),
					req.getSaveFile());
		
		booksDao.insert(newBook);

	}
}
