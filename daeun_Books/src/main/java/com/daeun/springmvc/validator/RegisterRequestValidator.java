package com.daeun.springmvc.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.daeun.springmvc.spring.RegisterRequest;

@Component
public class RegisterRequestValidator implements Validator{
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "isbn.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "publisher.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "introduce", "introduce.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");
		
		String isbn = regReq.getIsbn();
		boolean isNumeric =  isbn.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) { // isbn이 숫자가 아니면 에러 추가
			errors.rejectValue("isbn", "typemismatch.isbn");
		}
		
		
	}

}
