package com.spring.ksoolim_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Service
public class UpdateService {
	
	@Autowired
	private BooksDaoImpl booksDaoImpl;

	
	public void update(UpdateCommand updatecmd) {
		BooksDto booksDto =new BooksDto(
				updatecmd.getNum(),
				updatecmd.getIsbn(),
				updatecmd.getSubject(),
				updatecmd.getWriter(),
				updatecmd.getPublisher(),
				updatecmd.getPrice(),
//				updatecmd.getImage(),
				updatecmd.getComment());
		System.out.println(booksDto);
		booksDaoImpl.update(booksDto);
				
	}
	
}
