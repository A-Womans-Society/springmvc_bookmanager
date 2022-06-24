package com.spring.ksoolim_books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Controller
public class ListController {
	@Autowired
	private BooksDaoImpl booksDaoImpl;

	@RequestMapping("/list")
	public String list(ListCommand listCmd, Model model) {

		List<BooksDto> books = booksDaoImpl.list();
		model.addAttribute("books", books);

		return "books/book_list";
	}

}
