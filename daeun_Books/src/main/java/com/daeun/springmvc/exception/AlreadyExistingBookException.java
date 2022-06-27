package com.daeun.springmvc.exception;


@SuppressWarnings("serial")
public class AlreadyExistingBookException extends RuntimeException{
	public AlreadyExistingBookException(String message) {
		super(message);
	}
}
