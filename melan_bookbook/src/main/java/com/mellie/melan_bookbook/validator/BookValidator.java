package com.mellie.melan_bookbook.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mellie.melan_bookbook.domain.Book;

@Component
public class BookValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(BookValidator.class);


	/*  인자로 넘어온 클래스가 이 검증 클래스를 지원하는지 체크 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}
	
	/* 검증 */
	@Override
	public void validate(Object target, Errors errors) {
		Book book = (Book)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required.isbn");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name=");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required.publisher");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required.price");
		
		logger.info("book.getIsbn().getClass() : " + book.getIsbn().getClass());
		String isbn = book.getIsbn();
		boolean isNumeric =  isbn.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) { // isbn이 숫자가 아니면 에러 추가
			errors.rejectValue("isbn", "typemismatch.isbn");
		}
		
		
	}
	
	
	
	
}
