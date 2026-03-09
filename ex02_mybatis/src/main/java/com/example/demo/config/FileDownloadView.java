package com.example.demo.config;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = (String) model.get("path");
		String filename = (String) model.get("filename");

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

}