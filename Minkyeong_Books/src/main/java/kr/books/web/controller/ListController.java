package kr.books.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.books.web.model.BookDao;
import kr.books.web.model.BookDto;

@Controller
public class ListController {
	@Autowired
	private BookDao bookdao;
	// 도서전체목록	
	@RequestMapping(value="/books/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", bookdao.selectAll());
		return "/books/book_list";
	}
	
	
}
