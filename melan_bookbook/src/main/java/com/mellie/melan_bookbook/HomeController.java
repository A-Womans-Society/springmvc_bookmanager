package com.mellie.melan_bookbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mellie.melan_bookbook.service.BookService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("실행!");
		int cnt = 0;
		try {
			cnt = bookService.getCount();
		} catch (Exception e) {
			logger.info("레코드 수 반환 실패!");
			e.printStackTrace();
		}
		model.addAttribute("cnt", cnt);
		return "home";
	}
	
}
