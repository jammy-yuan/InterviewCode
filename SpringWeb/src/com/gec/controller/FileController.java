package com.gec.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/File")
public class FileController {
	@RequestMapping("/upload")
	public String doUpload(@RequestParam("pdfFile") MultipartFile file) {
		String path="D:\\feiq\\";
		
		File targetFile=new File(path+file.getOriginalFilename());
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException|IOException e) {
			return "redirect:/jsp/up_fail.jsp";
		} 
		return "redirect:/jsp/up_success.jsp";
	}

}
