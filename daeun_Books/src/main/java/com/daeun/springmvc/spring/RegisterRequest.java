package com.daeun.springmvc.spring;

import org.springframework.stereotype.Component;

@Component
public class RegisterRequest {
	private String isbn;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private String image;
	private String introduce;
	private String saveFile;
	
	public RegisterRequest() {
		
	}
	
	public RegisterRequest(String isbn, String title, String writer, String publisher, int price, String image,
			String introduce) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.introduce = introduce;
	}
	
	public RegisterRequest(String isbn, String title, String writer, String publisher, int price, String image,
			String introduce, String saveFile) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.introduce = introduce;
		this.saveFile = saveFile;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	
}
