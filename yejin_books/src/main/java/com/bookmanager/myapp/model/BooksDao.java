package com.bookmanager.myapp.model;

import java.util.List;

import com.bookmanager.myapp.common.RegisterRequest;
import com.bookmanager.myapp.common.SearchCommand;

public interface BooksDao {
	public abstract List<Book> list();

	public abstract void insert(RegisterRequest book);

	public abstract Book read(int no);

	public abstract List<Book> search(SearchCommand sc);
}
