package com.daeun.springmvc.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDaoImpl implements BooksDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public BooksDaoImpl() { }
	
	public BooksDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int insert(BooksVo vo) {
		return sqlSessionTemplate.insert("book.dtd.insert", vo);
	}

	@Override
	public List<BooksVo> selectAll() {
		return sqlSessionTemplate.selectList("book.dtd.list");
	}

	@Override
	public BooksVo selectById(Long id) {
		return sqlSessionTemplate.selectOne("book.dtd.selectById", id);
	}

	@Override
	public List<BooksVo> selectByTitle(String key) {
		List<BooksVo> results = sqlSessionTemplate.selectList("book.dtd.selectByTitle", key);
		return results.isEmpty() ? null : results;
	}
	
	@Override
	public List<BooksVo> selectByWriter(String key) {
		List<BooksVo> results = sqlSessionTemplate.selectList("book.dtd.selectByWriter", key);
		return results.isEmpty() ? null : results;
	}

	@Override
	public List<BooksVo> selectByPublisher(String key) {
		List<BooksVo> results = sqlSessionTemplate.selectList("book.dtd.selectByPublisher", key);
		return results.isEmpty() ? null : results;
	}
	
	@Override
	public BooksVo selectByIsbn(String isbn) {
		return sqlSessionTemplate.selectOne("book.dtd.selectByIsbn", isbn);
	}


}
