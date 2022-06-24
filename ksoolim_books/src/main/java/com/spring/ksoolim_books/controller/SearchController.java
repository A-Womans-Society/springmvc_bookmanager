package com.spring.ksoolim_books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService schsvc;
		
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(@ModelAttribute("searchdata")SearchCommand searchcmd, Model model) {
		//확인작업 
		String type = searchcmd.getType();
		String keyword = searchcmd.getKeyword();
		System.out.println("type:"+type);
		System.out.println("keyword:"+keyword);
				
		if(searchcmd.getType().equals("subject")) {
			List<BooksDto> searchlist = schsvc.search(searchcmd);
			model.addAttribute("books", searchlist);
		} else if (searchcmd.getType().equals("writer")){
		List<BooksDto> searchlist = schsvc.search(searchcmd);
		model.addAttribute("books", searchlist);
		} else {
			List<BooksDto> searchlist = null;
			model.addAttribute("books", searchlist);
		}
			
		
		return "books/book_search_list";
	
	}


}
