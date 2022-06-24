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
public class ReadController {
	@Autowired
	private BookDao bookdao;
	@Autowired
	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}
	// 도서 정보보기
	@RequestMapping(value="/books/read/{idx}", method=RequestMethod.GET)
	public Object selectView(Model model, @PathVariable("idx") int idx) { //변수 이름 매칭
		BookDto bookDto = bookdao.selectView(idx);
		model.addAttribute("bookDto", bookDto);
		return "/books/book_detail";
	}
}
