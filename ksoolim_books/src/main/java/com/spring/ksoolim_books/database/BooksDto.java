package com.spring.ksoolim_books.database;

public class BooksDto {
	private int num;
	private long isbn;
	private String subject;
	private String writer;
	private String publisher;
	private int price;
	private String image;
	private String comment;
	
	public BooksDto() {
		// TODO Auto-generated constructor stub
	}

	public BooksDto(int num, long isbn, String subject, String writer, String publisher, int price, String comment) {
		super();
		this.num = num;
		this.isbn = isbn;
		this.subject = subject;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.comment = comment;
	}

	public BooksDto(int num, long isbn, String subject, String writer, String publisher, int price, String image,
			String comment) {
		super();
		this.num = num;
		this.isbn = isbn;
		this.subject = subject;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.comment = comment;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	@Override
	public String toString() {
		return "BooksDto [num=" + num + ", isbn=" + isbn + ", subject=" + subject + ", writer=" + writer
				+ ", publisher=" + publisher + ", price=" + price + ", image=" + image + ", comment=" + comment + "]";
	}
	
	

}
