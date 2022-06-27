package com.bookmanager.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.myapp.common.RegisterRequest;
import com.bookmanager.myapp.common.SearchCommand;
import com.bookmanager.myapp.model.Book;
import com.bookmanager.myapp.model.BooksDao;

@Service
public class BookServiceImpl implements BookService {
	private BooksDao booksDao;

	public BooksDao getBooksDao() {
		return booksDao;
	}

	@Autowired
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	@Override
	public List<Book> list() {
		return booksDao.list();
	}

	@Override
	public void insert(RegisterRequest book) {
		this.booksDao.insert(book);
	}

	@Override
	public Book read(int no) {
		return booksDao.read(no);
	}

	@Override
	public List<Book> search(SearchCommand sc) {
		return booksDao.search(sc);
	}
}
