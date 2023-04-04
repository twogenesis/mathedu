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
public class StudentLoginInfoDAO {
    @ApiModelProperty(name = "no", example = "true", notes = "학생 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "id", example = "true", notes = "학생 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "name", example = "true", notes = "학생 이름", required = true)
    private String name;
    @ApiModelProperty(name = "classNo", example = "1", notes = "학생 반의 DB상의 시퀀스", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "teacherNo", example = "1", notes = "학생 반의 DB상의 시퀀스", required = true)
    private Integer teacherNo;

}
