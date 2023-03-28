package com.mathedu.mathedu.admin.dao.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
public class AdminClassInsertDAO {
    @ApiModelProperty(name = "name", example = "기초 수학 A반", notes = "반 이름", required = true)
    private String name;
    @ApiModelProperty(name = "grade", example = "3", notes = "학년", required = true)
    private Integer grade;
    @ApiModelProperty(name = "days", example = "월, 수, 금", notes = "수업 요일", required = true)
    private String days;
    @ApiModelProperty(name = "opendt", example = "2023-03-01", notes = "개강일", required = true)
    private String opendt;
    @ApiModelProperty(name = "closedt", example = "2023-03-31", notes = "종강일", required = true)
    private String closedt;
    @ApiModelProperty(name = "starttime", example = "18:30", notes = "수업 시작 시간", required = true)
    private String starttime;
    @ApiModelProperty(name = "endtime", example = "20:30", notes = "수업 종료 시간", required = true)
    private String endtime;
    @ApiModelProperty(name = "teacherNo", example = "1", notes = "선생님의 DB상의 번호", required = false)
    private Integer teacherNo;
}
