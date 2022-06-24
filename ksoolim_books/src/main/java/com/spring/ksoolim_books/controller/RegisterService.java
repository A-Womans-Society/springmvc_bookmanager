package com.spring.ksoolim_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Service
public class RegisterService {
	
	@Autowired
	private BooksDaoImpl booksDaoImpl;

	
	public void insert(RegisterCommand regcom) {
		BooksDto booksDto =new BooksDto(
				regcom.getNum(),
				regcom.getIsbn(),
				regcom.getSubject(),
				regcom.getWriter(),
				regcom.getPublisher(),
				regcom.getPrice(),
				regcom.getImage(),
				regcom.getComment());
		
		System.out.println(booksDto);
		booksDaoImpl.insert(booksDto);
				
	}
	
}
