package kr.books.web.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoMybatis implements BookDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public BookDaoMybatis() {
	}

	public BookDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insert(BookDto BookDto) {
		sqlSessionTemplate.insert("book.dtd.insert", BookDto);
	}

	@Override
	public List<BookDto> selectAll() {
		return sqlSessionTemplate.selectList("book.dtd.list");
	}

	@Override
	public BookDto selectView(int idx) {
		return sqlSessionTemplate.selectOne("book.dtd.selectView", idx);
	}

	@Override
	public List<BookDto> selectByKeyword(String keyword) {
		Map<String, String> map = new HashMap<>();
		map.put("book", "%" + keyword + "%");
		map.put("writer", "%" + keyword + "%");
		System.out.println("map.get(\"book\") : " + map.get("book"));
		System.out.println("map.get(\"writer\") : " + map.get("writer"));		
		List<BookDto> list = sqlSessionTemplate.selectList("book.dtd.selectByKeyword", map);
		
		Iterator<BookDto> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		return list;
	}
}
