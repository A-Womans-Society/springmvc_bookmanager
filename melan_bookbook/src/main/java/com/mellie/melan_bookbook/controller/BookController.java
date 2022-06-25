package com.mellie.melan_bookbook.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mellie.melan_bookbook.domain.Book;
import com.mellie.melan_bookbook.domain.PageHandler;
import com.mellie.melan_bookbook.domain.SearchCondition;
import com.mellie.melan_bookbook.service.BookService;
import com.mellie.melan_bookbook.validator.BookValidator;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired BookService bookService;
	@Autowired BookValidator bookValidator;
	
	/* WebDataBinder에 Validator 추가(해당 컨트롤러에서 Validator 자동 적용 -> WebDataBinder가 @Validated 붙은 요소를 검증) */
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.addValidators(bookValidator);
//	}
	
	/* 도서목록 가져오기*/
    @GetMapping("/list")
    public String list(Model m, SearchCondition sc) {
    	logger.info("list mapping 성공");
        try {
            logger.info("sc : " + sc);
            
            // 총 게시물 갯수 담기
            int totalCnt = bookService.getSearchResultCnt(sc);
            logger.info("totalCnt : " + totalCnt);
            m.addAttribute("totalCnt", totalCnt);
            
            // 조건에 맞는 페이지핸들러 담기
            PageHandler pageHandler = new PageHandler(totalCnt, sc);
            m.addAttribute("ph", pageHandler);
            
            // 게시물 리스트 담기
            List<Book> bookList = bookService.getSearchResultPage(sc);
            m.addAttribute("bookList", bookList);

        } catch (Exception e) { // 예외 발생 시 에러메시지, 게시물 갯수 0개 담아서 보내기
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return "bookList"; 
    }	
	
    /* 도서 상세정보 가져오기*/
    @GetMapping("/read")
    public String read(Long num, SearchCondition sc, RedirectAttributes rattr, Model m) {
        try {
        	logger.info("num : " + num);
        	logger.info("sc : " + sc);
            Book book = bookService.read(num);
            m.addAttribute(book);
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/book/list"+sc.getQueryString();
        }

        return "bookDetail";
    }	
    
    /* 도서 등록폼 가져오기 */
    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");
        m.addAttribute("book", new Book());
        return "writeForm";
    }
    
    /* 도서 등록하기 */
    @PostMapping("/write")
    public String write(MultipartFile image, @ModelAttribute("book") @Valid Book book, Errors errors, RedirectAttributes rattr, Model m, HttpSession session) {
    	bookValidator.validate(book, errors);
    	// 검증 실패 시 다시 입력 폼으로 이동
        if (errors.hasErrors()) {
            logger.info("errors = {}", errors);
            return "writeForm";
        }
    	
    	try {
            if (bookService.write(book, image, session) != 1) { // 도서 등록 실패하면, 실패 예외 던지기
            	throw new Exception("Write failed.");            	
            }

            rattr.addFlashAttribute("msg", "WRT_OK"); // 도서 등록 성공 시, 성공메시지 담아서 list 보여주기
            return "redirect:/book/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(book);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "WRT_ERR"); // 등록 실패메시지 담아서 입력폼 보여주기
            return "writeForm";
        }
    }
    
    /* 도서 삭제하기 */
    @PostMapping("/remove")
    public String remove(Long num, SearchCondition sc, RedirectAttributes rattr, HttpSession session) {
        String msg = "DEL_OK"; // 일단 성공메시지 담아놓기

        try {
            if(bookService.remove(num)!=1) { // 도서 삭제 실패하면, 실패 예외 던지기
            	throw new Exception("Delete failed.");            	
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR"; // 삭제 실패메시지 담기
        }

        rattr.addFlashAttribute("msg", msg); // 성공이면 성공, 실패면 실패메시지 담아 list 보여주기
        return "redirect:/book/list"+sc.getQueryString();
    }
    
    /* 도서 수정하기 */
    @PostMapping("/modify")
    public String modify(Book book, @RequestPart(value="image",required=false) MultipartFile image, SearchCondition sc, RedirectAttributes rattr, Model m, HttpSession session) {
        int result = 0;
    	try {
    		logger.info("image : " + image);
        	// 첨부파일이 없다면
        	if (image.isEmpty() || image==null) {
        		result = bookService.modify(book);
        	// 첨부파일이 있다면	
        	} else {
        		result = bookService.modify(book, image, session);
        	}
        	logger.info("result : " + result);
        	if (result != 1) {
        		throw new Exception("Modify failed."); // 도서 수정 실패하면, 실패 예외 던지기
            }

            rattr.addFlashAttribute("msg", "MOD_OK"); // 수정 성공 시, 성공메시지 담아서 list 보여주기
            return "redirect:/book/list"+sc.getQueryString();
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(book);
            m.addAttribute("msg", "MOD_ERR"); // 수정 실패메시지 담아서 
            return "bookDetail";
        }
    }
    
}
