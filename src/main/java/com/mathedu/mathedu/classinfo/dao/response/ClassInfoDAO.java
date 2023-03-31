package com.mathedu.mathedu.classinfo.dao.response;

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
public class ClassInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "name", example = "기초 강화 A반", notes = "반 이름", required = true)
    private String name;
    @ApiModelProperty(name = "grade", example = "3", notes = "학년", required = true)
    private Integer grade;
    @ApiModelProperty(name = "teacher", example = "김선생", notes = "담당선생님", required = true)
    private String teacher;
    @ApiModelProperty(name = "days", example = "화, 목", notes = "수업요일", required = true)
    private String days;
    @ApiModelProperty(name = "opendt", example = "2023-03-01 00:00:00", notes = "개강일", required = true)
    private Date opendt;
    @ApiModelProperty(name = "closedt", example = "2023-03-31 00:00:00", notes = "종강일", required = true)
    private Date closedt;
    @ApiModelProperty(name = "totaldate", example = "30", notes = "총 수업 기간 (일)", required = true)
    private Integer totaldate;
    @ApiModelProperty(name = "starttime", example = "18:30", notes = "시작시간", required = true)
    private String starttime;
    @ApiModelProperty(name = "endtime", example = "20:30", notes = "종료시간", required = true)
    private String endtime;
}
