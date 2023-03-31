package com.mathedu.mathedu.classinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassExamScoreSummaryDAO {
    @ApiModelProperty(name = "avgScore", example = "79", notes = "시험 평균 점수", required = true)
    private Integer avgScore;
    @ApiModelProperty(name = "maxScore", notes = "최고 점수 학생", required = true)
    private ClassExamStudentTinyInfoDAO maxScore;
    @ApiModelProperty(name = "minScore", notes = "최저 점수 학생", required = true)
    private ClassExamStudentTinyInfoDAO minScore;
    @ApiModelProperty(name = "areaData", notes = "점수 구간 별 인원 수 [100~80, 79~60, 59~40, 39~20, 20미만]", required = true)
    private List<Integer> areaData;
}
