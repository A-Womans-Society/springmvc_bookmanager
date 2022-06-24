package kr.books.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.books.web.model.AlreadyExistingBookException;
import kr.books.web.model.BookDao;
import kr.books.web.model.BookDto;

@Controller
public class AddController {
	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	// 새글 작성
	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("bookDto", new BookDto());
		return "/books/book_reg_form";
	}

	// 새글 등록 후 목록으로 리다이렉트
//	@RequestMapping(value="/books/add", method=RequestMethod.POST)
//	public String insert(@ModelAttribute("formData")BookDto BookDto, BindingResult bindingResult){
//		if(bindingResult.hasErrors()) {
//			return "/books/book_reg_form";
//		}		
//		bookDao.insert(BookDto);
//		return "redirect:/books/list";
//	}
	
	// 새글 등록 파일 업로드
	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String insert(@ModelAttribute("formData") BookDto BookDto, Errors error, MultipartFile image,
			HttpSession session) throws AlreadyExistingBookException {
		if (!image.getOriginalFilename().equals("")) {
			String fileName = image.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/upload/");
			try {
				image.transferTo(new File(savePath + fileName));
			} catch (IllegalStateException | IOException e) {
				error.rejectValue("bookisbn", "exist", e.getMessage());
				e.printStackTrace();
			}
			BookDto.setImage(image.getOriginalFilename());
		}
		bookDao.insert(BookDto);
		return "redirect:/books/list";
	}
}
