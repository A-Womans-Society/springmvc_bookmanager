package com.spring.ksoolim_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Controller
public class DetailController {
	
	@Autowired
	private BooksDaoImpl booksDaoImpl;
	
	public void setBooksDaoImpl(BooksDaoImpl booksDaoImpl) {
		this.booksDaoImpl = booksDaoImpl;
	}
	
	@RequestMapping(value="/read/{num}", method = RequestMethod.GET)
	public String detail(@PathVariable("num")int num, Model model) {
		//BooksDto booksDto = null;
		try {
			BooksDto booksDto = booksDaoImpl.detail(num);
			
			 model.addAttribute("books", booksDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "books/book_detail";
	
	}


}
