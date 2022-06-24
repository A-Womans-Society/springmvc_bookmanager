package com.spring.ksoolim_books.database;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.ksoolim_books.controller.SearchCommand;

@Repository
public class BooksDaoImpl implements BooksDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BooksDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void insert(BooksDto booksDto) {
		sqlSessionTemplate.insert("insert", booksDto);
	}
	
	public List<BooksDto> list() {
		return sqlSessionTemplate.selectList("list");
	}
	
	public BooksDto detail(int num) {
		return sqlSessionTemplate.selectOne("detail", num);
	
	}

	public List<BooksDto> search(SearchCommand searchcmd){
		return sqlSessionTemplate.selectList("search", searchcmd);
	}

	public void delete(int num) {
		sqlSessionTemplate.delete("delete", num);
	
	}
	
	public void update(BooksDto booksDto) {
		sqlSessionTemplate.update("update", booksDto);
		
	}
}
