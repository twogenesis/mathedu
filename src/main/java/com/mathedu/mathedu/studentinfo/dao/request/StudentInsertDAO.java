package com.mathedu.mathedu.studentinfo.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInsertDAO {
    @ApiModelProperty(name = "name", example = "김학생", notes = "학생 이름", required = true)
    private String name;
    @ApiModelProperty(name = "id", example = "23030001", notes = "학생아이디 8자리 (yyMM0001~9999)", required = true)
    private String id;
    @ApiModelProperty(name = "pwd", example = "1234", notes = "비밀번호", required = true)
    private String pwd;
    @ApiModelProperty(name = "birthYear", example = "2014", notes = "생년", required = true)
    private Integer birthYear;
    @ApiModelProperty(name = "birthMonth", example = "3", notes = "생월", required = true)
    private Integer birthMonth;
    @ApiModelProperty(name = "birthDate", example = "1", notes = "생일", required = true)
    private Integer birthDate;
    @ApiModelProperty(name = "schoolNo", example = "1", notes = "학교 DB상의 시퀀스 번호", required = true)
    private Integer schoolNo;
    @ApiModelProperty(name = "schoolGrade", example = "3", notes = "학년", required = true)
    private Integer schoolGrade;
    @ApiModelProperty(name = "phoneNo", example = "010-1234-5678", notes = "전화번호", required = true)
    private String phoneNo;
    @ApiModelProperty(name = "alternatePhone", example = "010-3254-4423", notes = "보호자 전화번호", required = true)
    private String alternatePhone;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "imagefile", example = "adgwehsdh3124.jpg", notes = "이미지 파일 명 (입력 X)", required = false)
    private String imagefile;
    @ApiModelProperty(name = "address", example = "대구광역시 중구 중앙대로 394", notes = "학생 주소", required = true)
    private String address;
    @ApiModelProperty(name = "image", notes = "이미지 파일 객체", required = true)
    private MultipartFile image;
}
