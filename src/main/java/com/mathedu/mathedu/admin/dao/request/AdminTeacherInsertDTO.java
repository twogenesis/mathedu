package com.mathedu.mathedu.admin.dao.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminTeacherInsertDTO {
    private String id;
    private String pwd;
    private String name;
    private MultipartFile imageFile;
}
