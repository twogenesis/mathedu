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
public class ClassExamStudentTinyInfoDAO {
    @ApiModelProperty(name = "name", example = "김학생", notes = "학생 이름", required = true)
    private String name;
    @ApiModelProperty(name = "score", example = "99", notes = "점수", required = true)
    private Integer score;
}
