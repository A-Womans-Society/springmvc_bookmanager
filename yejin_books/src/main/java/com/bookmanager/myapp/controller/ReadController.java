package com.bookmanager.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookmanager.myapp.model.Book;
import com.bookmanager.myapp.service.BookService;

@Controller
public class ReadController {
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books/read/{no}")
	public String detail(@PathVariable("no") int no, Model model) {
		System.out.println(no);
		Book book = bookService.read(no);
		model.addAttribute("book", book);
		return "book_detail";
	}
}
