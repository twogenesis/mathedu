package com.mathedu.mathedu.classinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassExamScoreDAO {
    @ApiModelProperty(name = "stuno", example = "23030001", notes = "학생 아이디", required = true)
    private String stuno;
    @ApiModelProperty(name = "stuname", example = "김학생", notes = "학생 이름", required = true)
    private String stuname;
    @ApiModelProperty(name = "srank", example = "1", notes = "등수", required = true)
    private Integer srank;
    @ApiModelProperty(name = "score", example = "99", notes = "점수", required = true)
    private Integer score;
    @ApiModelProperty(name = "diff", example = "20", notes = "평균과의 점수 차이", required = true)
    private Integer diff;
}
