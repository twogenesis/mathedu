package com.mathedu.mathedu.teacherinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherClassTinyInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "name", example = "샘플 반 1", notes = "반 이름", required = true)
    private String name;
}
