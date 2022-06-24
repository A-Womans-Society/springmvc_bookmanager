package kr.books.web.model;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BookDao {
		public void insert(BookDto bookdto); // 등록
		public List<BookDto> selectAll();   // 전체목록
		public BookDto selectView(int idx); //상세보기
		List<BookDto> selectByKeyword(String keyword); // 책 제목, 출판사 검색

	
}
