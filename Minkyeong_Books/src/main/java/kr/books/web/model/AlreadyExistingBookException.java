package kr.books.web.model;

@SuppressWarnings("serial")
public class AlreadyExistingBookException extends Exception {
	public AlreadyExistingBookException(String message) {
		super(message);
	}
}
