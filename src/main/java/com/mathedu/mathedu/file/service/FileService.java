package com.mathedu.mathedu.file.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class FileService {
    @Value("${mathedu.filepath.teacher}") private String teacherImgPath;
    @Value("${mathedu.filepath.student}") private String studentImgPath;
    @Value("${mathedu.filepath.notice}") private String noticeFilePath;
    @Value("${mathedu.filepath.bbs}") private String bbsFilePath;

    public String saveImageFile(String type, MultipartFile img) throws Exception {
        Path targetLocation = null;
        if (type.equals("student")) {
            targetLocation = Paths.get(studentImgPath);
        }
        else if (type.equals("teacher")) {
            targetLocation = Paths.get(teacherImgPath);
        }
        else {
            return null;
        }
        String fileName = img.getOriginalFilename();
        String[] split = fileName.split("\\.");
        String ext = split[split.length-1];
        fileName = generateRandomStr() + "." + ext;
        targetLocation = targetLocation.resolve(fileName);
        Files.copy(img.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    public List<String> saveBoardFiles(String type, MultipartFile[] files) throws Exception {
        Path targetLocation = null;
        List<String> fileList = new ArrayList<>();
        if (type.equals("bbs")) {
            targetLocation = Paths.get(bbsFilePath);
        }
        else if (type.equals("notice")) {
            targetLocation = Paths.get(noticeFilePath);
        }
        else {
            return null;
        }
        for(MultipartFile file: files) {
            String fileName = file.getOriginalFilename();
            String[] split = fileName.split("\\.");
            String ext = split[split.length - 1];
            fileName = generateRandomStr() + "." + ext;
            targetLocation = targetLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fileList.add(fileName);
        }
        return fileList;
    }
    public static String generateRandomStr() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = (int)Math.floor(Math.random()*5)+6;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit+1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Date dt = new Date();
        generatedString += dt.getTime();
        return generatedString;
    }

    public ResponseEntity<Resource> getFile(String type, String filename) throws Exception {
        Path targetLocation = null;
        if(type.equals("teacher")) {
            targetLocation = Paths.get(teacherImgPath);
        }
        else if(type.equals("student")) {
            targetLocation = Paths.get(studentImgPath);
        }
        else if(type.equals("bbs")) {
            targetLocation = Paths.get(bbsFilePath);
        }
        else if(type.equals("notice")) {
            targetLocation = Paths.get(noticeFilePath);
        }
        else {return null;}
        targetLocation = targetLocation.resolve(filename);
        Resource r = new UrlResource(targetLocation.toUri());
        String contentType = "application/octet-stream";
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+ URLEncoder.encode(r.getFilename(),"UTF-8"))
                .body(r);
    }
}
