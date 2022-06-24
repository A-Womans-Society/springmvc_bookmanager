package com.spring.ksoolim_books.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.ksoolim_books.database.BooksDaoImpl;
import com.spring.ksoolim_books.database.BooksDto;

@Controller
public class UpdateController {

	@Autowired
	private UpdateService updatesvc;

	@Autowired
	private BooksDaoImpl booksDaoImpl;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getupdate(int num, Model model) {
		try {
			BooksDto getupdate = booksDaoImpl.detail(num);
			model.addAttribute("num", num);
			model.addAttribute("books", getupdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "books/book_update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postupdate(@ModelAttribute("updatedata") UpdateCommand updatecmd, Errors error, MultipartFile image,
			HttpSession session) {

//		if (!image.getOriginalFilename().equals("")) { // 클라이언트가 파일첨부를 했다면
//			// String sfile = saveFile(image, session); // 파일 저장을 위한 메소드 아래에서 확인
//			String ofile = updatecmd.getIsbn() + image.getOriginalFilename();
//			String savePath = session.getServletContext().getRealPath("/resources/fileupload/");
//			System.out.println(ofile);
//
//			try {
//				image.transferTo(new File(savePath + ofile));
//				// 트랜스펄투: 파일객체의 경로와 파일이름으로 업로드하기 위한 메소드
//
//				updatecmd.setImage(ofile);
//				updatesvc.update(updatecmd);
//				System.out.println(updatecmd.getNum());
//				return "redirect: read/" + updatecmd.getNum();
//
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
		try {

			updatesvc.update(updatecmd);
			System.out.println(updatecmd.getNum());
			return "redirect: read/" + updatecmd.getNum();
		} catch (Exception e) {

		}

		return "books/book_update_fail";
	}

}
