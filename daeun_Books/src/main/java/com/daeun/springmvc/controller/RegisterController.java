package com.daeun.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.daeun.springmvc.exception.AlreadyExistingBookException;
import com.daeun.springmvc.service.RegisterService;
import com.daeun.springmvc.spring.RegisterRequest;
import com.daeun.springmvc.validator.RegisterRequestValidator;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerService;

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
	public String registerForm(@ModelAttribute("formData") RegisterRequest regReq) {
		logger.info("RegisterController(registerForm-get) 실행!!!");
		return "/books/book_reg_form";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String register(@ModelAttribute("formData") RegisterRequest regReq, Errors errors, MultipartFile image,
			HttpSession session) {
		logger.info("RegisterController(register-post) 실행!!!");
		
		new RegisterRequestValidator().validate(regReq, errors);
	
		

		if (!image.getOriginalFilename().equals("")) { //파일이 첨부되면
			String originFileName = image.getOriginalFilename(); //원래 파일 이름
			String saveFileName = regReq.getIsbn() + originFileName; //저장될 파일 이름
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/"); //저장 경로 설정 (session 이용)

			logger.info("fileName : " + saveFileName);
			logger.info("savePath : " + savePath);

			try {
				image.transferTo(new File(savePath + saveFileName)); //파일 저장
				regReq.setImage(originFileName); 
				regReq.setSaveFile(saveFileName);
				
				registerService.regist(regReq);
				if(errors.hasErrors()) {
					return "books/book_reg_form";
				}
				return "redirect:/books/list";
			} catch (AlreadyExistingBookException e) {
				errors.rejectValue("isbn", "exist");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "books/book_reg_form";

	}
}
