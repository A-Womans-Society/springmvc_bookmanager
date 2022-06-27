package com.daeun.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daeun.springmvc.service.ReadService;
import com.daeun.springmvc.spring.BooksVo;

@Controller
public class ReadController {

	@Autowired
	private ReadService readService;

	public void setReadService(ReadService readService) {
		this.readService = readService;
	}

	@RequestMapping(value = "/books/read/{id}")
	public String readDetail(@PathVariable("id") Long Id, Model model) {
		BooksVo book = readService.selectById(Id);
		model.addAttribute("book", book);
		return "books/book_detail";
	}
}
