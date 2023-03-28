package com.mathedu.mathedu.admin.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminTeacherInsertDAO {
    @ApiModelProperty(name = "id;", example = "teacher001", notes = "선생님 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "pwd", example = "1234", notes = "선생님 비밀번호", required = true)
    private String pwd;
    @ApiModelProperty(name = "name", example = "선생님", notes = "선생님 이름", required = true)
    private String name;
    @ApiModelProperty(name = "imageFile", example = "이미지파일", notes = "이미지 파일(File 객체)", required = true)
    private MultipartFile imageFile;
}
