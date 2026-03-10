package com.example.springedu.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class UploadController {
	@GetMapping("/")
	public ModelAndView main() {
		return new ModelAndView("hello");
	}
	
	@RequestMapping(value="/canvasupload",
			 produces="text/plain; charset=utf-8")	
	public String saveFile(@RequestPart(name = "mfile") MultipartFile mfile) {	    
	     String fileName =  mfile.getOriginalFilename();	  
	     byte[] content = null;
	     String result="OK";
		 String path = "/uploadtest";
		 File isDir = new File(path);
		 if (!isDir.isDirectory()) {
			isDir.mkdirs();
		 }
	     try {
	    	 content =  mfile.getBytes();
	    	 File f = new File("/uploadtest/"+fileName);
	   		 FileOutputStream fos = new FileOutputStream(f);
	   		 fos.write(content);
	   		 fos.close();	   		 
	     } catch (IOException e) {
	    	 e.printStackTrace();
	    	 result="FAIL";
	     }	 
	     log.info("memo upload");
	    return result;
	}
	@RequestMapping(value="/canvasdownload",
			 produces="text/plain; charset=utf-8")	
	public String downloadFile() {	    
		String path = "/uploadtest/";
		char[] buffer =  null;		
		try {
			FileReader reader = new FileReader(path+"test.png");
			buffer = new 
					char[(int)(new File(path+"test.png").length())];
			reader.read(buffer);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	    return new String(buffer);
	}
}
