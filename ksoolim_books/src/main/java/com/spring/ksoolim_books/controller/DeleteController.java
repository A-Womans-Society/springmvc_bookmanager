package com.spring.ksoolim_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteController {

	@Autowired
	private DeleteService delsvc;
	
	@RequestMapping("/delete")
	public String delete(int num) {
			delsvc.delete(num);
			
		return "redirect: list";
	
	}
}
