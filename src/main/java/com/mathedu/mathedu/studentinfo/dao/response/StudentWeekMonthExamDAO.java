package com.mathedu.mathedu.studentinfo.dao.response;

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
public class StudentWeekMonthExamDAO {

    @ApiModelProperty(name = "personalScores", example = "", notes = "개인 점수 리스트", required = true)
    private List<Integer> personalScores;
    @ApiModelProperty(name = "classAvgScores", example = "", notes = "반 평균 점수 리스트", required = true)
    private List<Integer> classAvgScores;
    @ApiModelProperty(name = "top30pAvgScores", example = "", notes = "상위 30% 평균 점수 리스트", required = true)
    private List<Integer> top30pAvgScores;
    @ApiModelProperty(name = "tableData", example = "", notes = "학생 점수 데이터 리스트", required = true)
    private List<StudentExamTableDataDAO> tableData;
}
