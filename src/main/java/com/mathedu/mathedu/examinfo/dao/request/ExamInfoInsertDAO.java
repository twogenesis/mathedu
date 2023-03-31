package com.mathedu.mathedu.examinfo.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamInfoInsertDAO {
    @ApiModelProperty(name = "name", example = "3월 1주차 주간 시험", notes = "시험 이름", required = true)
    private String name;
    @ApiModelProperty(name = "date", example = "2023-03-03", notes = "시험 일", required = true)
    private String date;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "type", example = "weekly", notes = "주간/월간 (weekly/monthly)", required = true)
    private String type;
}
