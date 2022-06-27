package com.bookmanager.myapp.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmanager.myapp.common.RegisterRequest;
import com.bookmanager.myapp.common.SearchCommand;

@Repository
public class BooksDaoImpl implements BooksDao {

	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public BooksDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insert(RegisterRequest book) {
		sqlSessionTemplate.insert("insert", book);
	}

	@Override
	public List<Book> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public Book read(int no) {
		return sqlSessionTemplate.selectOne("read", no);
	}

	@Override
	public List<Book> search(SearchCommand sc) {
		return sqlSessionTemplate.selectList("search", sc);
	}
}
