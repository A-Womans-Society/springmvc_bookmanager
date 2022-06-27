package com.daeun.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daeun.springmvc.spring.BooksDao;
import com.daeun.springmvc.spring.BooksVo;

@Controller
public class SearchController {

	@Autowired
	private BooksDao booksDao;

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	@RequestMapping(value = "/books/search", method = RequestMethod.GET)
	public String search(HttpServletRequest req, Model model) {
		String type = req.getParameter("type");
		String key = req.getParameter("keyword");
		List<BooksVo> books = null;

		if (type.equals("title")) {

			books = booksDao.selectByTitle(key);
		} else if (type.equals("writer")) {
			books = booksDao.selectByWriter(key);
		} else if (type.equals("publisher")) {
			books = booksDao.selectByPublisher(key);
		}
		model.addAttribute("books", books);
		return "books/book_list";

	}
}
