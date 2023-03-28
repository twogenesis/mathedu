package com.mathedu.mathedu.admin.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AdminClassInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "title", example = "수학 기초 A반", notes = "반 이름", required = true)
    private String title;
    @ApiModelProperty(name = "days", example = "월, 수, 금", notes = "수업요일", required = true)
    private String days;
    @ApiModelProperty(name = "grade", example = "3", notes = "학년", required = true)
    private Integer grade;
    @ApiModelProperty(name = "teacher", example = "1", notes = "선생님의 DB상의 시퀀스 번호", required = true)
    private Integer teacher;
    @ApiModelProperty(name = "studentCnt", example = "10", notes = "반의 전체 학생 수", required = true)
    private Integer studentCnt;
    @ApiModelProperty(name = "opendt", example = "2023-03-01 00:00:00", notes = "개강일", required = true)
    private Date opendt;
    @ApiModelProperty(name = "closedt", example = "2023-03-31 00:00:00", notes = "종강일", required = true)
    private Date closedt;
}
