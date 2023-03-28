package com.mathedu.mathedu.admin.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminTeacherUpdateDAO {
    @ApiModelProperty(name = "pwd", example = "5678", notes = "선생님 비밀번호", required = true)
    private String pwd;
    @ApiModelProperty(name = "name", example = "선생님", notes = "선생님 이름", required = false)
    private String name;
    @ApiModelProperty(name = "imageFile", example = "이미지파일", notes = "이미지 파일(File 객체)", required = false)
    private MultipartFile imageFile;
}
