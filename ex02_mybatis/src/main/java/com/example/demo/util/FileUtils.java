package com.example.demo.util;

import java.util.UUID;

public final class FileUtils {
    public static String uuidFilename(String originalFilename) {
    // 확장자 추출
    String extension = "";
    if (originalFilename != null && originalFilename.contains(".")) {
      extension = originalFilename.substring(originalFilename.lastIndexOf("."));
    }

    // UUID로 새로운 파일명 생성
    String savedFilename = UUID.randomUUID().toString() + extension;
      return savedFilename;
    }
}