package com.example.demo.sample.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.FileDownloadView;
import com.example.demo.sample.mapper.SampleVO;
import com.example.demo.util.FileUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	@Value("${file.upload}")
	String path;
	
	@GetMapping("register")
	public String registerpage() {
		return "file/register";
	}
	
	@PostMapping("/register")
	public String register(MultipartFile file, SampleVO vo) throws IllegalStateException, IOException {
		log.info("filename:" + file.getOriginalFilename());
		log.info("filesize:" + file.getSize());
		String filename = FileUtils.uuidFilename(file.getOriginalFilename());
		file.transferTo(new File(path, filename));
		return "/sample"; //InternalResourceViewResolver (/template + "file" + ".html")
	}
	
	@GetMapping("/filelist")
	public String filelist(Model model) {
		model.addAttribute("list", new File(path).list(null) );
		return "file/list";
	}
	
	@Autowired 
	FileDownloadView fileDownloadView;
	
	
	@GetMapping("/download")
	public void downloadFile(String filename, HttpServletResponse response) throws IOException {
		Path filePath = Paths.get(path).resolve(filename).normalize();

		if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일이 존재하지 않습니다.");
			return;
		}

		// 파일명 한글/특수문자 처리
		String encodedFilename = URLEncoder.encode(filePath.getFileName().toString(), "UTF-8").replaceAll("\\+", "%20");

		// 응답 헤더 설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFilename + "\"");
		response.setContentLengthLong(Files.size(filePath));

		// 파일 스트림 전송
		try (InputStream is = Files.newInputStream(filePath); OutputStream os = response.getOutputStream()) {

			byte[] buffer = new byte[8192]; // 8KB 버퍼 씩 끊어서 받아옴
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
		}
	}
	

	@GetMapping("/downview")
	public ModelAndView download(String filename) {
	    ModelAndView mv = new ModelAndView(fileDownloadView);
	    mv.addObject("filename", filename);
	    mv.addObject("path", path);
	    return mv;
	}
	
	
}
