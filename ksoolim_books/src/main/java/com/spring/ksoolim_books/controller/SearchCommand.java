package com.spring.ksoolim_books.controller;

public class SearchCommand {
	private String keyword;
	private String type;
	
	public SearchCommand() { // 검색안했을때 공백 처리
		this.keyword = "";
		this.type = "";
	}
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
