package com.daeun.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.daeun.springmvc.spring.RegisterRequest;

public class RegisterRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		
		if(regReq.getIsbn() == null || regReq.getIsbn().trim().isEmpty()) {
			errors.rejectValue("isbn", "required");
		} 
		if(regReq.getTitle() == null || regReq.getTitle().trim().isEmpty()) {
			errors.rejectValue("title", "required");
		} 
		if(regReq.getWriter() == null || regReq.getWriter().trim().isEmpty()) {
			errors.rejectValue("writer", "required");
		} 
		if(regReq.getPublisher() == null || regReq.getPublisher().trim().isEmpty()) {
			errors.rejectValue("publisher", "required");
		} 
		if(regReq.getPrice() == 0) {
			errors.rejectValue("price", "required");
		} 
		
		if(regReq.getIntroduce() == null || regReq.getIntroduce().trim().isEmpty()) {
			errors.rejectValue("introduce", "required");
		} 
		
	}

}
