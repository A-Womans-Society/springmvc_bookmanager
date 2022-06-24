package com.spring.ksoolim_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ksoolim_books.database.BooksDaoImpl;

@Service
public class DeleteService {

	@Autowired
	private BooksDaoImpl booksDaoImpl;

	public void delete(int num) {
		booksDaoImpl.delete(num);
	}
}
