package com.mellie.melan_bookbook.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.mellie.melan_bookbook.domain.Book;
import com.mellie.melan_bookbook.domain.SearchCondition;

public interface BookService {
	
    int getCount() throws Exception;
    
    List<Book> getList() throws Exception;
    List<Book> getPage(Map map) throws Exception;
    
    Book read(Long num) throws Exception;
    
    int write(Book book, MultipartFile image, HttpSession session) throws Exception;
    
    int remove(Long num) throws Exception;
    
    /* 수정(첨부파일이 없는 경우)*/
    int modify(Book book) throws Exception;
    /* 수정(첨부파일이 있는 경우)*/
    int modify(Book book, MultipartFile image, HttpSession session) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;
    List<Book> getSearchResultPage(SearchCondition sc) throws Exception;

}
