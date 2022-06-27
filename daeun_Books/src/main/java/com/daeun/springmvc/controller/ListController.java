package com.daeun.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daeun.springmvc.spring.BooksDao;
import com.daeun.springmvc.spring.BooksVo;
import com.daeun.springmvc.spring.RegisterRequest;

@Controller
public class ListController {
	
	@Autowired
	private BooksDao booksDao;
	
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	@RequestMapping(value = "/books/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("formData")RegisterRequest regReq, Model model) {
		List<BooksVo> books = booksDao.selectAll();
		model.addAttribute("books", books);
		return "books/book_list";
	}
}
