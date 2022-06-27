package com.bookmanager.myapp.service;

import java.util.List;
import com.bookmanager.myapp.common.RegisterRequest;
import com.bookmanager.myapp.common.SearchCommand;
import com.bookmanager.myapp.model.Book;

public interface BookService {
	public abstract List<Book> list();

	public abstract void insert(RegisterRequest book);

	public abstract Book read(int no);

	public abstract List<Book> search(SearchCommand sc);

}
