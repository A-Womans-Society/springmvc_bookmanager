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
	public String register(@ModelAttribute("formData") RegisterRequest regReq, Errors errors, HttpSession session) {
		logger.info("RegisterController(register-post) 실행!!!");
		
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			logger.info("에러 : " + errors.toString());
			return "books/book_reg_form";
		}

		if (!regReq.getImage().getOriginalFilename().equals("")) { //파일이 첨부되면
			String originFileName = regReq.getImage().getOriginalFilename(); //원래 파일 이름
			String saveFileName = regReq.getIsbn() + originFileName; //저장될 파일 이름
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/"); //저장 경로 설정 (session 이용)

			logger.info("fileName : " + saveFileName);
			logger.info("savePath : " + savePath);

			try {
				regReq.getImage().transferTo(new File(savePath + saveFileName)); //파일 저장
				regReq.setOriginFile(originFileName); 
				regReq.setSaveFile(saveFileName);
				
				 if (registerService.regist(regReq) != 1) { // 도서 등록 실패하면, 실패 예외 던지기
		            	throw new Exception("등록 실패!!!");            	
		         }
				 
				return "redirect:/books/list";
			} catch (AlreadyExistingBookException e) {
				errors.rejectValue("isbn", "exist");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "books/book_reg_form";

	}
}
