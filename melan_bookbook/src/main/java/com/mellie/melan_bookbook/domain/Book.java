package com.mellie.melan_bookbook.domain;

public class Book {
	
	private Long num; // 도서 고유번호
	private String isbn; // 도서 ISBN
	private String name; // 도서명
	private String author; // 저자명
	private String publisher; // 출판사
	private Integer price; // 도서가격
	private String ofile; // 원본 파일명
	private String sfile; // 저장된 파일명
	private String content; // 도서 소개글
	
	public Book() {}
	
	public Book(Long num, String isbn, String name, String author, String publisher, Integer price, String ofile,
			String sfile, String content) {
		super();
		this.num = num;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.ofile = ofile;
		this.sfile = sfile;
		this.content = content;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getOfile() {
		return ofile;
	}

	public void setOfile(String ofile) {
		this.ofile = ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Book [num=" + num + ", isbn=" + isbn + ", name=" + name + ", author=" + author + ", publisher="
				+ publisher + ", price=" + price + ", ofile=" + ofile + ", sfile=" + sfile + ", content=" + content
				+ "]";
	}

}
