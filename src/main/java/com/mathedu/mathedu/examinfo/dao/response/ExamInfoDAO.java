package com.mathedu.mathedu.examinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamInfoDAO {
    @ApiModelProperty(name = "examNo", example = "1", notes = "시험의 DB상의 시퀀스 번호", required = true)
    private Integer examNo;
    @ApiModelProperty(name = "examName", example = "3월 1주차 주간 시험", notes = "시험 이름", required = true)
    private String examName;
    @ApiModelProperty(name = "attendCount", example = "9", notes = "시험 참석 자 수", required = true)
    private Integer attendCount;
    @ApiModelProperty(name = "missedCount", example = "1", notes = "결시자 수", required = true)
    private Integer missedCount;
    @ApiModelProperty(name = "totalStuCount", example = "10", notes = "반 총 인원", required = true)
    private Integer totalStuCount;
    @ApiModelProperty(name = "avgScore", example = "87", notes = "반 평균", required = true)
    private Integer avgScore;
    @ApiModelProperty(name = "examDt", example = "2023-03-07", notes = "시험 일", required = true)
    private String examDt;
    @ApiModelProperty(name = "examType", example = "weekly", notes = "시험타입 (weekly:주간, monthly:월간)", required = true)
    private String examType;
}
