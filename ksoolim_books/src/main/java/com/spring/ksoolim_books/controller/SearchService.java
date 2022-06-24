package com.spring.ksoolim_books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Service
public class SearchService {
	
	@Autowired
	private BooksDaoImpl booksDaoImpl;
	
	public SearchService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<BooksDto> search(SearchCommand searchcmd){
		List<BooksDto> searchbooks = booksDaoImpl.search(searchcmd);
		
		return searchbooks;		
	}

	

}
