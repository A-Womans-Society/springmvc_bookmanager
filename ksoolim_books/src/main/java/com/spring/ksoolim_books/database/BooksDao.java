package com.spring.ksoolim_books.database;

import java.util.List;

import com.spring.ksoolim_books.controller.SearchCommand;

public interface BooksDao {
	public void insert(BooksDto booksDto);
	public List<BooksDto> list();
	public BooksDto detail(int num) throws Exception;
	public List<BooksDto> search(SearchCommand searchcmd);
	public void delete(int num);
	public void update(BooksDto booksDto);
}
