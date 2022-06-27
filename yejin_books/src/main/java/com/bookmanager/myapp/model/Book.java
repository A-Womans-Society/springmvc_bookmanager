package com.bookmanager.myapp.model;

public class Book {
	private String no;
	private String bookIsbn;
	private String title;
	private String author;
	private String publisher;
	private String price;
	private String img;
	private String content;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book() {
	}

	public Book(String no, String bookIsbn, String title, String author, String publisher, String price, String img,
			String content) {
		super();
		this.no = no;
		this.bookIsbn = bookIsbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.img = img;
		this.content = content;
	}

	public Book(String bookIsbn, String title, String author, String publisher, String price, String img,
			String content) {
		super();
		this.bookIsbn = bookIsbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.img = img;
		this.content = content;
	}

}
