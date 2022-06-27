package com.bookmanager.myapp.common;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;

		if (regReq.getAuthor() == null || regReq.getAuthor().trim().isEmpty()) {
			errors.rejectValue("author", "required");
		}
		
		if (regReq.getBookIsbn() == null || regReq.getBookIsbn().trim().isEmpty()) {
			errors.rejectValue("bookIsbn", "required");
		}
		
		if (regReq.getContent() == null || regReq.getContent().trim().isEmpty()) {
			errors.rejectValue("content", "required");
		}

		if (regReq.getPublisher() == null || regReq.getPublisher().trim().isEmpty()) {
			errors.rejectValue("publisher", "required");
		}

		if (regReq.getTitle() == null || regReq.getTitle().trim().isEmpty()) {
			errors.rejectValue("title", "required");
		}

		if (regReq.getPrice() == null || regReq.getPrice().trim().isEmpty()) {
			errors.rejectValue("price", "required");
		}
//		else {
//			Matcher matcher = pattern.matcher(regReq.getEmail());
//			if (!matcher.matches()) {
//				errors.rejectValue("email", "bad");
//			}
//		}
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
//		ValidationUtils.rejectIfEmpty(errors, "password", "required");
//		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");

		// empty�� �ƴ�
//		if (!regReq.getPassword().isEmpty()) {
//			// ��й�ȣ�� ��й�ȣ Ȯ���� �ٸ�
//			if (!regReq.isPasswordEqualsToConfirmPassword()) {
//				errors.rejectValue("confirmPassword", "nomatch");
//			}
//		}

	}
}
