package com.spring.ksoolim_books.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegisterController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String form() {
		return "books/book_reg_form";
	}

	@Autowired
	private RegisterService regsvc;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submit(@ModelAttribute("formdata") RegisterCommand regcom, Errors error, MultipartFile image, HttpSession session) {

		if (!image.getOriginalFilename().equals("")) { // 클라이언트가 파일첨부를 했다면
			//String sfile = saveFile(image, session); // 파일 저장을 위한 메소드 아래에서 확인
			String ofile = regcom.getIsbn()+image.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/fileupload/");
			
			 try {
			        image.transferTo(new File(savePath + ofile));
			        // 트랜스펄투: 파일객체의 경로와 파일이름으로 업로드하기 위한 메소드
			        regcom.setImage(ofile);
			        regsvc.insert(regcom);
			    } catch (IllegalStateException | IOException e) {
			        e.printStackTrace();
			    }

			
		}
		

		return "redirect: list";
	}
/*	
	//파일을 저장하고 저장한 파일명을 반환해주는 메서드
	public String saveFile(MultipartFile image, HttpSession session) {
		String ofile = image.getOriginalFilename();
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0)); //현재시간
		int ranNum = (int)(Math.random() * 90000 + 10000); //5자리 랜덤값 (10000 ~ 90000 중에서)
		String ext = ofile.substring(ofile.lastIndexOf(".")); //확장자 (뒤에서부터 .기준으로 문자열찾기)
		
		String sfile = currentTime + ranNum + ext; //저장할 파일명 완성
		
		String savePath = session.getServletContext().getRealPath("/resources/fileupload/");
		
		//확인
		System.out.println("ofile:"+ofile);
		System.out.println("sfile:"+sfile);
		System.out.println("savePath:"+ savePath);
		
		  try {
		        image.transferTo(new File(savePath + sfile));
		        // 트랜스펄투: 파일객체의 경로와 체인지네임으로 실제 업로드하기 위한 메소드
		    } catch (IllegalStateException | IOException e) {
		        e.printStackTrace();
		    }

		    return sfile;
	}
	*/

}
