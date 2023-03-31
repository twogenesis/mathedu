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
public class StudentExamTableDataDAO {
    @ApiModelProperty(name = "examDt", example = "2023-03-07", notes = "시험 일", required = true)
    private String examDt;
    @ApiModelProperty(name = "score", example = "72", notes = "학생 점수", required = true)
    private Integer score;
    @ApiModelProperty(name = "classAvg", example = "77", notes = "반 평균 점수", required = true)
    private Integer classAvg;
    @ApiModelProperty(name = "top30pAvg", example = "95", notes = "상위 30% 평균 점수", required = true)
    private Integer top30pAvg;
    @ApiModelProperty(name = "attend", example = "10", notes = "응시자 수", required = true)
    private Integer attend;
}
