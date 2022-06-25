package com.mellie.melan_bookbook.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mellie.melan_bookbook.HomeController;

@ControllerAdvice
public class MyAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public String handleException(Exception ex, Model m) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		m.addAttribute("msg", "잠시 후 다시 시도해주세요!");
		
		return "error/error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model m) {
		logger.error("404에러 발생", ex.getRequestURL());
		m.addAttribute("msg", "요청하신 페이지를 찾을 수 없습니다.");
		
		return "error/error";
	}	
}
