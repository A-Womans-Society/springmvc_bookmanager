package kr.books.web.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.books.web.model.BookDao;
import kr.books.web.model.BookDto;

@Controller
public class SearchController {
	@Autowired
	private BookDao bookDao;	
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@RequestMapping(value="/books/search", method = RequestMethod.GET)
	public String selectByKeyword(@RequestParam("keyword")String keyword, Model model) {
		List<BookDto> list = bookDao.selectByKeyword(keyword);
		
		// 출력해보기
		Iterator<BookDto> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		model.addAttribute("list", list);
		return "/books/book_list";
	}
}
