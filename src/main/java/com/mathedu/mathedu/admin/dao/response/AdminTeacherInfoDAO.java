package com.mathedu.mathedu.admin.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AdminTeacherInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "선생님의 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "id", example = "teacher001", notes = "선생님 ID", required = true)
    private String id;
    @ApiModelProperty(name = "name", example = "선생님", notes = "선생님 이름", required = true)
    private String name;
    @ApiModelProperty(name = "imageFile", example = "/file/teacher/asljdkhgwe32587234.jpg", notes = "선생님 사진 URI", required = true)
    private String imageFile;
    @ApiModelProperty(name = "status", example = "1", notes = "계정 상태 값", required = true)
    private Integer status;
    @ApiModelProperty(name = "regDt", example = "2023-03-01 00:00:00", notes = "등록일", required = true)
    private Date regDt;
}
