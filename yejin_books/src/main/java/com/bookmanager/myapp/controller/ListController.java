package com.bookmanager.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookmanager.myapp.common.SearchCommand;
import com.bookmanager.myapp.service.BookService;

@Controller
public class ListController {
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("searchCommand", new SearchCommand());
		model.addAttribute("list", bookService.list());
		model.addAttribute("keyword", null);
		return "book_list";
	}

	@RequestMapping(value = "/books/list", method = RequestMethod.POST)
	public String list(SearchCommand sc, Model model) {
		System.out.println(sc.getCategory());
		System.out.println(sc.getKeyword());
	
		model.addAttribute("keyword", sc.getKeyword());
		model.addAttribute("list", bookService.search(sc));
		return "book_list";
	}
}
