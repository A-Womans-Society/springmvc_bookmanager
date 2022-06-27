package com.bookmanager.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookmanager.myapp.common.RegisterRequest;
import com.bookmanager.myapp.common.RegisterRequestValidator;
import com.bookmanager.myapp.service.BookService;

@Controller
//@RequestMapping("/books/add")
public class AddController {
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
	public String form(@RequestParam(value = "formData", required = false) RegisterRequest regReq, Model model) {
		if (regReq == null) {
			model.addAttribute("formData", new RegisterRequest());
		} else {
			model.addAttribute("formData", regReq);
		}
		return "book_reg_form";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String register(@ModelAttribute("formData") RegisterRequest regReq, Errors error, MultipartFile img,
			HttpSession session) {

		new RegisterRequestValidator().validate(regReq, error);

		if (error.hasErrors()) {
			List<ObjectError> errList = error.getAllErrors();
			for (ObjectError oe : errList) {
				System.out.println(oe.getCode());
				System.out.println(oe.getDefaultMessage());
				System.out.println(oe.getObjectName());
			}

			System.out.println("img:" + img.getOriginalFilename());
			return "book_reg_form";

		} else if (!img.isEmpty()) {
			System.out.println("hihi");
			String fileName = regReq.getBookIsbn() + img.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			System.out.println(savePath);
			try {
				img.transferTo(new File(savePath + fileName));
				regReq.setImgFile(fileName);
				bookService.insert(regReq);
				return "redirect:/books/list";

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "book_reg_form";

	}

}
