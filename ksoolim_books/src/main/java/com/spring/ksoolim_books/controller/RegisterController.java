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

		if (!image.getOriginalFilename().equals("")) { // Ŭ���̾�Ʈ�� ����÷�θ� �ߴٸ�
			//String sfile = saveFile(image, session); // ���� ������ ���� �޼ҵ� �Ʒ����� Ȯ��
			String ofile = regcom.getIsbn()+image.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/fileupload/");
			
			 try {
			        image.transferTo(new File(savePath + ofile));
			        // Ʈ��������: ���ϰ�ü�� ��ο� �����̸����� ���ε��ϱ� ���� �޼ҵ�
			        regcom.setImage(ofile);
			        regsvc.insert(regcom);
			    } catch (IllegalStateException | IOException e) {
			        e.printStackTrace();
			    }

			
		}
		

		return "redirect: list";
	}
/*	
	//������ �����ϰ� ������ ���ϸ��� ��ȯ���ִ� �޼���
	public String saveFile(MultipartFile image, HttpSession session) {
		String ofile = image.getOriginalFilename();
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0)); //����ð�
		int ranNum = (int)(Math.random() * 90000 + 10000); //5�ڸ� ������ (10000 ~ 90000 �߿���)
		String ext = ofile.substring(ofile.lastIndexOf(".")); //Ȯ���� (�ڿ������� .�������� ���ڿ�ã��)
		
		String sfile = currentTime + ranNum + ext; //������ ���ϸ� �ϼ�
		
		String savePath = session.getServletContext().getRealPath("/resources/fileupload/");
		
		//Ȯ��
		System.out.println("ofile:"+ofile);
		System.out.println("sfile:"+sfile);
		System.out.println("savePath:"+ savePath);
		
		  try {
		        image.transferTo(new File(savePath + sfile));
		        // Ʈ��������: ���ϰ�ü�� ��ο� ü������������ ���� ���ε��ϱ� ���� �޼ҵ�
		    } catch (IllegalStateException | IOException e) {
		        e.printStackTrace();
		    }

		    return sfile;
	}
	*/

}
