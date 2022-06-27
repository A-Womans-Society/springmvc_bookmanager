package com.daeun.springmvc.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class RegisterRequest {
	private String isbn;
	private String title;
	private String writer;
	private String publisher;
	private Integer price;
	private String originFile;
	private String introduce;
	private String saveFile;
	private MultipartFile image;
	
	public RegisterRequest() {
		
	}

	public RegisterRequest(String isbn, String title, String writer, String publisher, Integer price, String originFile,
			String introduce, String saveFile, MultipartFile image) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.originFile = originFile;
		this.introduce = introduce;
		this.saveFile = saveFile;
		this.image = image;
	}

	public RegisterRequest(String isbn, String title, String writer, String publisher, Integer price, String originFile,
			String introduce) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.originFile = originFile;
		this.introduce = introduce;
	}
	
	public RegisterRequest(String isbn, String title, String writer, String publisher, Integer price, String originFile,
			String introduce, String saveFile) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.originFile = originFile;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getOriginFile() {
		return originFile;
	}

	public void setOriginFile(String originFile) {
		this.originFile = originFile;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
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
