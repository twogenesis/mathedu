package com.mathedu.mathedu.studentinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRecentScoreDAO {
    @ApiModelProperty(name = "score", example = "95", notes = "점수", required = true)
    private Integer score;
    @ApiModelProperty(name = "srank", example = "1", notes = "석차", required = true)
    private Integer srank;
    @ApiModelProperty(name = "tieCnt", example = "2", notes = "동점자 수 (본인 제외 카운트)", required = true)
    private Integer tieCnt;
    @ApiModelProperty(name = "totalStudents", example = "10", notes = "총 학생 수", required = true)
    private Integer totalStudents;
    @ApiModelProperty(name = "testDt", example = "2023-03-07", notes = "시험 일", required = true)
    private String testDt;
}
