package com.mellie.melan_bookbook.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mellie.melan_bookbook.dao.BookDao;
import com.mellie.melan_bookbook.domain.Book;
import com.mellie.melan_bookbook.domain.SearchCondition;

@Service
public class BookServiceImpl implements BookService{
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
	BookDao bookDao;
	
	/* 게시물 갯수 세는 서비스 */
    @Override
    public int getCount() throws Exception {
        return bookDao.count();
    }
    
    /* 게시물 리스트 세는 서비스 */
	@Override
	public List<Book> getList() throws Exception {
		return bookDao.selectAll();
	}

	/* 게시물 페이지 세는 서비스 */
	@Override
	public List<Book> getPage(Map map) throws Exception {
		return bookDao.selectPage(map);
	}
	
	/* 게시물 페이지 읽어오는 서비스 */
	@Override
	public Book read(Long num) throws Exception {
		Book book = bookDao.selectByNum(num);

        return book;
	}
	
	/* 게시물 등록 */
	@Override
	public int write(Book book, MultipartFile image, HttpSession session) throws Exception {
		logger.info("image.getOriginalFilename() : " + image.getOriginalFilename());
		if(!image.getOriginalFilename().equals("")) { // image 첨부를 했다면
			String sfile = saveFile(image, session); // 저장하고 저장한 파일명 반환
			
			book.setOfile(image.getOriginalFilename());
			book.setSfile("resources/uploadFiles/" + sfile); // 경로 + 저장할 파일명 붙이기
		}
		
		return bookDao.insert(book);
	}
	
	// 파일을 저장하고 저장한 파일명을 반환해주는 메서드
	public String saveFile(MultipartFile image, HttpSession session) {
		String ofile = image.getOriginalFilename(); // 원래 파일 이름
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // 현재 시간
	    int ranNum = (int)(Math.random() * 90000 + 10000); // 5자리랜덤값 (10000부터 90000개, 즉 10000~99999 중 랜덤값)
	    String ext = ofile.substring(ofile.lastIndexOf(".")); // 확장자 (뒤에서부터 .기준으로 문자열찾기)

	    String sfile = currentTime + ranNum + ext; // 저장할 파일명 완성

	    String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/"); // 저장할 물리적 경로
	    
	    // 출력해서 확인해보기
	    logger.info("ofile : " + ofile);
	    logger.info("sfile : " + sfile);
	    logger.info("savePath : " + savePath);
	    
	    try {
	        image.transferTo(new File(savePath + sfile));
	        // 트랜스펄투: 파일객체의 경로와 체인지네임으로 실제 업로드하기 위한 메소드
	    } catch (IllegalStateException | IOException e) {
	        e.printStackTrace();
	    }

	    return sfile;
	}
	
	/* 수정(첨부파일이 없는 경우) */
	@Override
	public int modify(Book book) throws Exception {
		return bookDao.updateWoFile(book);
	}
	/* 수정(첨부파일이 있는 경우) */
	@Override
	public int modify(Book book, MultipartFile image, HttpSession session) throws Exception {
		if(!image.getOriginalFilename().equals("")) { // image 첨부를 했다면
			//bookDao.delete(book.getNum()); // 원래 있던 정보 지우기
			
			String sfile = saveFile(image, session); // 저장하고 저장한 파일명 반환
			
			book.setOfile(image.getOriginalFilename());
			book.setSfile("resources/uploadFiles/" + sfile); // 경로 + 저장할 파일명 붙이기
		}
		
		return bookDao.update(book);
	}
	
	/* 게시물 삭제 */
	@Override
	public int remove(Long num) throws Exception {
		return bookDao.delete(num);
	}
	
	/* 검색한 게시물 갯수 반환 */
	@Override
	public int getSearchResultCnt(SearchCondition sc) throws Exception {
		return bookDao.searchResultCnt(sc);
	}
	
	/* 검색한 게시물 페이지 반환 */
	@Override
	public List<Book> getSearchResultPage(SearchCondition sc) throws Exception {
		return bookDao.searchSelectPage(sc);
	}

}
